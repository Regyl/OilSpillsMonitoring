package com.rosatom.oilspills.service;

import com.rosatom.oilspills.entity.Location;
import com.rosatom.oilspills.repository.LocationRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Log
@Service
public class LocationService {

    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    public Mono<Location> findByCoordinates(Long latitude, Long longitude) {
        return repository.findByLatitudeAndLongitude(latitude, longitude);
    }

    public Mono<Location> save(Location location) {
        return repository.save(location);
    }

    public Flux<Location> findAll() {
        return repository.findAll();
    }

    public Mono<Void> deleteById(UUID id) {
        return repository.deleteById(id);
    }

    public Mono<UUID> getMiddlePoint(UUID startLocId, UUID endLocId) {
        Mono<Location> startLoc = repository.findById(startLocId);
        Mono<Location> endLoc = repository.findById(endLocId);

        Mono<Location> middleLoc = Mono.just(new Location());

        return middleLoc.map(middle -> {
            startLoc.subscribe(start ->
                    endLoc.subscribe(end -> {
                middle.setLatitude((start.getLatitude()+end.getLatitude())/2);
                middle.setLongitude((start.getLongitude()+end.getLongitude())/2);
                repository.save(middle).map(entity -> {
                    middle.setId(entity.getId());
                    return entity;
                }).subscribe();

            }));
            return middle.getId();
        });
    }

    public Mono<Location> findById(UUID id) {
        return repository.findById(id);
    }
}

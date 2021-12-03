package com.rosatom.oilspills.service;

import com.rosatom.oilspills.entity.Location;
import com.rosatom.oilspills.repository.LocationRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

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

    public Mono<Location> findById(UUID id) {
        return repository.findById(id);
    }
}

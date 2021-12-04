package com.rosatom.oilspills.service;

import com.rosatom.oilspills.entity.UavRoute;
import com.rosatom.oilspills.entity.UavRouteLocation;
import com.rosatom.oilspills.repository.UavRouteLocationRepository;
import com.rosatom.oilspills.repository.UavRouteRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@Log
public class UavRouteService {

    private final UavRouteRepository repository;
    private final LocationService locationService;
    private final UavRouteLocationRepository uavRouteLocationRepository;

    public UavRouteService(UavRouteRepository repository, LocationService locationService,
                           UavRouteLocationRepository uavRouteLocationRepository) {
        this.repository = repository;
        this.locationService = locationService;
        this.uavRouteLocationRepository = uavRouteLocationRepository;
    }

    public Mono<Void> deleteById(UUID id) {
        return repository.deleteById(id);
    }

    public Flux<UavRoute> findAll() {
        return repository.findAll()
                .map(route -> {
                    Flux<UavRouteLocation> locationFlux = uavRouteLocationRepository.findAllByUavRouteId(route.getId());
                    locationFlux.subscribe(route::addLocation);
                    return route;
                });
    }

    public Disposable generate(UUID startLocId, UUID endLocId) {
        UavRoute uavRoute = new UavRoute();
        uavRoute.setFlightAltitude(1000L);
        Mono<UavRoute> uavRouteMono = repository.save(uavRoute);


        return uavRouteMono.subscribe(entity -> {
            UavRouteLocation startLoc = new UavRouteLocation(entity.getId(), startLocId);
            UavRouteLocation endLoc = new UavRouteLocation(entity.getId(), endLocId);


            uavRouteLocationRepository.save(startLoc)
                    .subscribe(entity::addLocation);

            locationService.getMiddlePoint(startLocId, endLocId).subscribe(id -> {
                UavRouteLocation middleLoc = new UavRouteLocation(id, entity.getId());
                uavRouteLocationRepository.save(middleLoc)
                        .subscribe(entity::addLocation);
            });


            uavRouteLocationRepository.save(endLoc)
                    .subscribe(entity::addLocation);
        });
    }
}

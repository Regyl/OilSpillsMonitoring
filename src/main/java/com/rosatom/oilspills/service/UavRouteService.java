package com.rosatom.oilspills.service;

import com.rosatom.oilspills.entity.UavRoute;
import com.rosatom.oilspills.entity.UavRouteLocation;
import com.rosatom.oilspills.repository.UavRouteLocationRepository;
import com.rosatom.oilspills.repository.UavRouteRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
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

    public Flux<UavRoute> findAll() {
        return repository.findAll();
    }

    public Mono<UavRoute> generate(UUID startLocId, UUID endLocId) {
        UavRoute uavRoute = new UavRoute();
        uavRoute.setFlightAltitude(1000L);
        Mono<UavRoute> uavRouteMono = repository.save(uavRoute);
        UavRouteLocation startLoc = new UavRouteLocation(startLocId);
        UavRouteLocation endLoc = new UavRouteLocation(endLocId);

        return uavRouteMono.map(entity -> {
            startLoc.setUavRouteId(entity.getId());
            endLoc.setUavRouteId(entity.getId());
            uavRouteLocationRepository.save(startLoc)
                    .publish(p -> uavRouteLocationRepository.save(endLoc));
            return entity;
        });
    }
}

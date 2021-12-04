package com.rosatom.oilspills.repository;

import com.rosatom.oilspills.entity.UavRouteLocation;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface UavRouteLocationRepository extends ReactiveSortingRepository<UavRouteLocation, UUID> {

    Flux<UavRouteLocation> findAllByUavRouteId(UUID id);
}

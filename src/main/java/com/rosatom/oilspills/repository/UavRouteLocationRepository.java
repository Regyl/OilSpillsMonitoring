package com.rosatom.oilspills.repository;

import com.rosatom.oilspills.entity.UavRouteLocation;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UavRouteLocationRepository extends ReactiveSortingRepository<UavRouteLocation, UUID> {
}

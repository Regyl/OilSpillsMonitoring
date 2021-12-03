package com.rosatom.oilspills.repository;

import com.rosatom.oilspills.entity.UavRoute;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UavRouteRepository extends ReactiveSortingRepository<UavRoute, UUID> {
}

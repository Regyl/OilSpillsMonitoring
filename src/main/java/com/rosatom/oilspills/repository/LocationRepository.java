package com.rosatom.oilspills.repository;

import com.rosatom.oilspills.entity.Location;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface LocationRepository extends ReactiveSortingRepository<Location, UUID> {

    Mono<Location> findByLatitudeAndLongitude(Long latitude, Long longitude);
}

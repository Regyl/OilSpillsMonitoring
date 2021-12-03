package com.rosatom.oilspills.repository;

import com.rosatom.oilspills.entity.Pollution;
import org.apache.tomcat.jni.Poll;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface PollutionRepository extends ReactiveSortingRepository<Pollution, UUID> {
}

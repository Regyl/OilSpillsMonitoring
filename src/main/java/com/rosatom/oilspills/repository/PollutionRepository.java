package com.rosatom.oilspills.repository;

import com.rosatom.oilspills.entity.Pollution;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PollutionRepository extends ReactiveSortingRepository<Pollution, UUID> {
}

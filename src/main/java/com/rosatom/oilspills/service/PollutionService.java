package com.rosatom.oilspills.service;

import com.rosatom.oilspills.entity.Pollution;
import com.rosatom.oilspills.repository.PollutionRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
public class PollutionService {

    private final PollutionRepository repository;

    public PollutionService(PollutionRepository repository) {
        this.repository = repository;
    }

    public Flux<Pollution> findAll() {
        return repository.findAll();
    }

    public Mono<Pollution> save(Pollution pollution) {
        return repository.save(pollution);
    }

    public Mono<Pollution> findById(UUID id) {
        return repository.findById(id)
                .doOnError(throwable -> {throw new RuntimeException("idk");});
    }

    public Mono<Void> deleteById(UUID id) {
        return repository.deleteById(id);
    }
}

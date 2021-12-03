package com.rosatom.oilspills.service;

import com.rosatom.oilspills.entity.UavRoute;
import com.rosatom.oilspills.repository.UavRouteRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class UavRouteService {

    private final UavRouteRepository repository;

    public UavRouteService(UavRouteRepository repository) {
        this.repository = repository;
    }

    public Flux<UavRoute> findAll() {
        return repository.findAll();
    }
}

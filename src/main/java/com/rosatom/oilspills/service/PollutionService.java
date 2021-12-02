package com.rosatom.oilspills.service;

import com.rosatom.oilspills.repository.PollutionRepository;
import org.springframework.stereotype.Service;

@Service
public class PollutionService {

    private final PollutionRepository repository;

    public PollutionService(PollutionRepository repository) {
        this.repository = repository;
    }
}

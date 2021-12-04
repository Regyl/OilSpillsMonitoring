package com.rosatom.oilspills.service;

import com.rosatom.oilspills.api.controller.dto.response.ReportResponse;
import com.rosatom.oilspills.entity.Pollution;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReportService {

    private final PollutionService pollutionService;

    public ReportService(PollutionService pollutionService) {
        this.pollutionService = pollutionService;
    }

    public ReportResponse generate() {
        Flux<Pollution> pollutions = pollutionService.findAll();
        ReportResponse response = new ReportResponse();
        pollutions.collectList().subscribe(entities -> response.setTotalAccident(entities.size()));

        return response;
    }
}

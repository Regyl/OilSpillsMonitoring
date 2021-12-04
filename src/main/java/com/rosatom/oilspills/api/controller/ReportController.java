package com.rosatom.oilspills.api.controller;

import com.rosatom.oilspills.api.controller.dto.response.ReportResponse;
import com.rosatom.oilspills.service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Tag(name = "Отчеты")

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @GetMapping("/")
    @Operation(summary = "Сформировать отчет")
    public Mono<ReportResponse> buildReport() {
        return Mono.just(service.generate());
    }
}

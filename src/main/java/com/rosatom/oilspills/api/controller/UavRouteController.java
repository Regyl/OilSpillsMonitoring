package com.rosatom.oilspills.api.controller;

import com.rosatom.oilspills.api.controller.dto.response.UavRouteDtoResponse;
import com.rosatom.oilspills.api.mapper.UavRouteMapper;
import com.rosatom.oilspills.service.UavRouteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Tag(name = "UAV routes")

@RestController
@RequestMapping("/uav-routes")
public class UavRouteController {

    private final UavRouteService service;
    private final UavRouteMapper mapper;

    public UavRouteController(UavRouteService service, UavRouteMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/")
    @Operation(summary = "Get all UAV routes")
    public Flux<UavRouteDtoResponse> findAll() {
        return service.findAll()
                .map(mapper::toDto);
    }
}

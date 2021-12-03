package com.rosatom.oilspills.api.controller;

import com.rosatom.oilspills.api.controller.dto.request.LocationDto;
import com.rosatom.oilspills.api.controller.dto.response.LocationDtoResponse;
import com.rosatom.oilspills.api.mapper.LocationMapper;
import com.rosatom.oilspills.entity.Location;
import com.rosatom.oilspills.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Tag(name = "Locations")

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService service;
    private final LocationMapper mapper;

    public LocationController(LocationService service, LocationMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/coordinates")
    @Operation(summary = "")
    public Mono<LocationDtoResponse> findByCoordinates(@RequestParam Long latitude,
                                                       @RequestParam Long longitude) {
        return service.findByCoordinates(latitude, longitude)
                .map(mapper::toDto);
    }

    @PostMapping("/")
    @Operation(summary = "")
    public Mono<LocationDtoResponse> save(@RequestBody LocationDto dto) {
        Location location = mapper.toEntity(dto);
        return service.save(location)
                .map(mapper::toDto);
    }

    @GetMapping("/")
    @Operation(summary = "")
    public Flux<LocationDtoResponse> findAll() {
        return service.findAll()
                .map(mapper::toDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}

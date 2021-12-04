package com.rosatom.oilspills.api.controller;

import com.rosatom.oilspills.api.controller.dto.request.LocationDto;
import com.rosatom.oilspills.api.controller.dto.response.LocationDtoResponse;
import com.rosatom.oilspills.api.controller.dto.response.UavTemp;
import com.rosatom.oilspills.api.mapper.LocationMapper;
import com.rosatom.oilspills.entity.Location;
import com.rosatom.oilspills.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
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
    @Operation(summary = "Find location by coordinates")
    public Mono<LocationDtoResponse> findByCoordinates(@RequestParam Long latitude,
                                                       @RequestParam Long longitude) {
        return service.findByCoordinates(latitude, longitude)
                .map(mapper::toDto);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new location")
    public Mono<LocationDtoResponse> save(@RequestBody LocationDto dto) {
        Location location = mapper.toEntity(dto);
        return service.save(location)
                .map(mapper::toDto);
    }

    @GetMapping("/")
    @Operation(summary = "Get all locations")
    public Flux<LocationDtoResponse> findAll() {
        return service.findAll()
                .map(mapper::toDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete by it's id")
    public Mono<Void> deleteById(@PathVariable UUID id) {
        return service.deleteById(id);
    }

    @GetMapping("/geojson")
    @Operation(summary = "Geojson for UAV flight track")
    public Flux<List<UavTemp>> findAllForGeojson() {
        return service.findAll().collectList().flatMap(locations -> {
            List<UavTemp> uavTemps = new ArrayList<>();
            for (int i = 0; i < locations.size() / 3; i++) {
                UavTemp uavTemp = UavTemp.of(locations.get(i), locations.get(i + 1), locations.get(i + 2));
                uavTemps.add(uavTemp);
            }
            return Mono.just(uavTemps);
        }).flatMapMany(Flux::just);
    }
}

package com.rosatom.oilspills.api.controller;

import com.rosatom.oilspills.api.controller.dto.request.PollutionDto;
import com.rosatom.oilspills.api.controller.dto.response.PollutionDtoResponse;
import com.rosatom.oilspills.api.mapper.PollutionMapper;
import com.rosatom.oilspills.entity.Location;
import com.rosatom.oilspills.entity.Pollution;
import com.rosatom.oilspills.service.LocationService;
import com.rosatom.oilspills.service.PollutionService;
import com.rosatom.oilspills.service.UavRouteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.MalformedURLException;
import java.util.UUID;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Tag(name = "Pollutions")

@RestController
@RequestMapping("/pollutions")
public class PollutionController {

    private final PollutionService service;
    private final PollutionMapper mapper;
    private final UavRouteService uavRouteService;
    private final LocationService locationService;

    public PollutionController(PollutionService service, PollutionMapper mapper,
                               UavRouteService uavRouteService, LocationService locationService) {
        this.service = service;
        this.mapper = mapper;
        this.uavRouteService = uavRouteService;
        this.locationService = locationService;
    }

    @GetMapping("/")
    @Operation(summary = "Get all pollution records")
    public Flux<PollutionDtoResponse> findAll() {
        return service.findAll()
                .map(mapper::toDto);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create record about pollution")
    public Mono<PollutionDtoResponse> save(@RequestBody @Valid PollutionDto dto) {
        Pollution pollution = mapper.toEntity(dto);
        uavRouteService.generate(dto.getStartLocation(), dto.getEndLocation());
        return service.save(pollution).map(mapper::toDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete by it's id")
    public Mono<Void> deleteById(@PathVariable UUID id) {
        return service.deleteById(id);
    }

    @GetMapping("/files")
    @Operation(summary = "Download file with pollutions")
    public Mono<Resource> download() {
        return Mono.just(new ClassPathResource("top50.geojson"));
    }

}

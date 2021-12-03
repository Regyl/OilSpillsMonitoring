package com.rosatom.oilspills.api.controller;

import com.rosatom.oilspills.api.controller.dto.request.PollutionDto;
import com.rosatom.oilspills.api.controller.dto.response.PollutionDtoResponse;
import com.rosatom.oilspills.api.mapper.PollutionMapper;
import com.rosatom.oilspills.entity.Pollution;
import com.rosatom.oilspills.service.PollutionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.UUID;

@Tag(name = "Pollutions")

@RestController
@RequestMapping("/pollutions")
public class PollutionController {

    private final PollutionService service;
    private final PollutionMapper mapper;

    public PollutionController(PollutionService service, PollutionMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/")
    @Operation(summary = "All pollutions")
    public Flux<PollutionDtoResponse> findAll() {
        return service.findAll()
                .map(mapper::toDto);
    }

    @PostMapping("/")
    @Operation(summary = "Create new pollution")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PollutionDtoResponse> save(@RequestBody @Valid PollutionDto dto) {
        Pollution pollution = mapper.toEntity(dto);
        return service.save(pollution)
                .map(mapper::toDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete pollution by it's id")
    public Mono<Void> deleteById(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}

package com.rosatom.oilspills.api.mapper;

import com.rosatom.oilspills.api.controller.dto.request.PollutionDto;
import com.rosatom.oilspills.api.controller.dto.response.PollutionDtoResponse;
import com.rosatom.oilspills.entity.Location;
import com.rosatom.oilspills.entity.Pollution;
import com.rosatom.oilspills.service.LocationService;
import org.apache.tomcat.jni.Poll;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class PollutionMapper {

    private final ModelMapper mapper;
    private final LocationService locationService;

    public PollutionMapper(ModelMapper mapper, LocationService locationService) {
        this.mapper = mapper;
        this.locationService = locationService;
    }

    public Pollution toEntity(PollutionDto dto) {
        return mapper.map(dto, Pollution.class);
    }

    public PollutionDtoResponse toDto(Pollution pollution) {
        return mapper.map(pollution, PollutionDtoResponse.class);
    }
}

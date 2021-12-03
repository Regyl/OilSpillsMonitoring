package com.rosatom.oilspills.api.mapper;

import com.rosatom.oilspills.api.controller.dto.request.PollutionDto;
import com.rosatom.oilspills.api.controller.dto.response.PollutionDtoResponse;
import com.rosatom.oilspills.entity.Pollution;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PollutionMapper {

    private final ModelMapper mapper;

    public PollutionMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Pollution toEntity(PollutionDto dto) {
        return mapper.map(dto, Pollution.class);
    }

    public PollutionDtoResponse toDto(Pollution pollution) {
        return mapper.map(pollution, PollutionDtoResponse.class);
    }
}

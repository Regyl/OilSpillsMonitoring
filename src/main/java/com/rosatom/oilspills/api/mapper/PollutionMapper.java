package com.rosatom.oilspills.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PollutionMapper {

    private final ModelMapper mapper;

    public PollutionMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

}

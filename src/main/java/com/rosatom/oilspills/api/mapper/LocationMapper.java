package com.rosatom.oilspills.api.mapper;

import com.rosatom.oilspills.api.controller.dto.request.LocationDto;
import com.rosatom.oilspills.api.controller.dto.response.LocationDtoResponse;
import com.rosatom.oilspills.entity.Location;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    private final ModelMapper mapper;

    public LocationMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Location toEntity(LocationDto dto) {
        return mapper.map(dto, Location.class);
    }

    public LocationDtoResponse toDto(Location location) {
        return mapper.map(location, LocationDtoResponse.class);
    }
}

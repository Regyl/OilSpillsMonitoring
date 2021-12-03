package com.rosatom.oilspills.api.mapper;

import com.rosatom.oilspills.api.controller.dto.request.UavRouteDto;
import com.rosatom.oilspills.api.controller.dto.response.UavRouteDtoResponse;
import com.rosatom.oilspills.entity.UavRoute;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UavRouteMapper {

    private final ModelMapper mapper;

    public UavRouteMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public UavRoute toEntity(UavRouteDto dto) {
        return mapper.map(dto, UavRoute.class);
    }

    public UavRouteDtoResponse toDto(UavRoute uavRoute) {
        return mapper.map(uavRoute, UavRouteDtoResponse.class);
    }
}

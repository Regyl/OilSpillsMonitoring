package com.rosatom.oilspills.api.controller.dto.response;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Data
public class UavRouteDtoResponse extends AbstractDtoResponse {

    private Set<UUID> locations;

    private Long flightAltitude;
}

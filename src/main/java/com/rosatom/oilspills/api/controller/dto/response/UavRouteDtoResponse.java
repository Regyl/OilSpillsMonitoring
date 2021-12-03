package com.rosatom.oilspills.api.controller.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class UavRouteDtoResponse extends AbstractDtoResponse {

    private Set<UUID> locations;

    private Long flightAltitude;
}

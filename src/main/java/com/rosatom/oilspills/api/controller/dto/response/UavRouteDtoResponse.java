package com.rosatom.oilspills.api.controller.dto.response;

import com.rosatom.oilspills.entity.UavRouteLocation;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class UavRouteDtoResponse extends AbstractDtoResponse {

    private Set<UavRouteLocation> locations;

    private Long flightAltitude;
}

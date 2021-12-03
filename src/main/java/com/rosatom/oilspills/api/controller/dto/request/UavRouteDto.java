package com.rosatom.oilspills.api.controller.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Data
public class UavRouteDto {

    @NotNull
    private Set<UUID> locations;

    @NotNull
    private Long flightAltitude;
}

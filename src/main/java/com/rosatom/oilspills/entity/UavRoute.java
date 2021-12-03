package com.rosatom.oilspills.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class UavRoute extends AbstractEntity {

    @NotNull
    private Set<UUID> locations;

    @NotNull
    private Long flightAltitude;
}

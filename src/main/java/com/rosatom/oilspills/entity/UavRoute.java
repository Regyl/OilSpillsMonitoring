package com.rosatom.oilspills.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class UavRoute extends AbstractEntity {

    @NotNull
    private Set<Location> location;

    @NotNull
    private Long flightAltitude;
}

package com.rosatom.oilspills.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class Location extends AbstractEntity {

    @NotNull
    private Long latitude;

    @NotNull
    private Long longitude;
}

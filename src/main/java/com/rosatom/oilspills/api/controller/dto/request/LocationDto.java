package com.rosatom.oilspills.api.controller.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LocationDto {
    @NotNull
    private Long latitude;

    @NotNull
    private Long longitude;
}

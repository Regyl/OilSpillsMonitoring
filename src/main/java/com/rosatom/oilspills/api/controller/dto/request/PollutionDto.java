package com.rosatom.oilspills.api.controller.dto.request;

import com.rosatom.oilspills.entity.enums.HazardTypes;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PollutionDto {
    private String companyName;

    private Long companyInn;

    private HazardTypes hazardType;

    @NotNull
    private Long latitude;

    @NotNull
    private Long longitude;

    private String additionalInfo;
}

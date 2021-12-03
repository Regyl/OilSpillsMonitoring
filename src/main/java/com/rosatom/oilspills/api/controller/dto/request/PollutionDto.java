package com.rosatom.oilspills.api.controller.dto.request;

import com.rosatom.oilspills.entity.enums.HazardTypes;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class PollutionDto {
    private String companyName;

    private Long companyInn;

    private HazardTypes hazardType;

    @NotNull
    private UUID startLocation;

    @NotNull
    private UUID endLocation;

    private String additionalInfo;
}

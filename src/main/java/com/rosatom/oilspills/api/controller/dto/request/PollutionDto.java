package com.rosatom.oilspills.api.controller.dto.request;

import com.rosatom.oilspills.entity.enums.HazardTypes;
import lombok.Data;

@Data
public class PollutionDto {
    private String companyName;

    private Long companyInn;

    private HazardTypes hazardType;
}

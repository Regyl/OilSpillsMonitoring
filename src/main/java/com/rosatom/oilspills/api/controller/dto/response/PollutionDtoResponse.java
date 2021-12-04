package com.rosatom.oilspills.api.controller.dto.response;

import com.rosatom.oilspills.entity.enums.HazardTypes;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class PollutionDtoResponse extends AbstractDtoResponse {

    private String companyName;

    private Long companyInn;

    private HazardTypes hazardType;

    private UUID startLocation;

    private UUID endLocation;

    private String additionalInfo;

}

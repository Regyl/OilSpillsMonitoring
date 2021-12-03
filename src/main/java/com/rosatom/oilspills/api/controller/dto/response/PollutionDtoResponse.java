package com.rosatom.oilspills.api.controller.dto.response;

import com.rosatom.oilspills.entity.enums.HazardTypes;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PollutionDtoResponse extends AbstractDtoResponse {

    private String companyName;

    private Long companyInn;

    private HazardTypes hazardType;

}

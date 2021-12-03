package com.rosatom.oilspills.api.controller.dto.response;

import com.rosatom.oilspills.entity.enums.HazardTypes;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class PollutionDtoResponse extends AbstractDtoResponse {

    private String companyName;

    private Long companyInn;

    private HazardTypes hazardType;

    private UUID locationId;

    private String additionalInfo;

}

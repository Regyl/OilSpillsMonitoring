package com.rosatom.oilspills.entity;

import com.rosatom.oilspills.entity.enums.HazardTypes;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class Pollution extends AbstractEntity {

    private String companyName;

    private Long companyInn;

    private HazardTypes hazardType;

    @NotNull
    private UUID location;

    private String additionalInfo;
}

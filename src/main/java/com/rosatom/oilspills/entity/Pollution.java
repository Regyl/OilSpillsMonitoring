package com.rosatom.oilspills.entity;

import com.rosatom.oilspills.entity.enums.HazardTypes;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Pollution extends AbstractEntity {

    private String companyName;

    private Long companyInn;

    private HazardTypes hazardType;
}

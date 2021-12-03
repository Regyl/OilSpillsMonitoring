package com.rosatom.oilspills.api.controller.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LocationDtoResponse extends AbstractDtoResponse {

    private Long latitude;

    private Long longitude;
}

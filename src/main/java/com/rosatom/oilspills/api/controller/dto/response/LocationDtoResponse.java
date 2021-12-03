package com.rosatom.oilspills.api.controller.dto.response;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LocationDtoResponse extends AbstractDtoResponse {

    private Long latitude;

    private Long longitude;
}

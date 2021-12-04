package com.rosatom.oilspills.api.controller.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReportResponse extends AbstractDtoResponse {

    private Integer totalAccident; //общее число разливов
}

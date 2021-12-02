package com.rosatom.oilspills.api.controller.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class AbstractDtoResponse {

    private LocalDateTime timestamp;

    AbstractDtoResponse() {
        this.timestamp = LocalDateTime.now();
    }
}

package com.rosatom.oilspills.api.controller.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public abstract class AbstractDtoResponse {

    private UUID id;

    private LocalDateTime timestamp;

    AbstractDtoResponse() {
        this.timestamp = LocalDateTime.now();
    }
}

package com.rosatom.oilspills.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.UUID;

@Data
public abstract class AbstractEntity {
    @Id
    private UUID id;

    @CreatedDate
    private LocalDate creationTimestamp;

}

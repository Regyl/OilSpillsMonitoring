package com.rosatom.oilspills.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private String patronymic;

    @NotEmpty
    private LocalDate birthDate;
}

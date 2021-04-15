package com.flightsaccounting.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@Entity(name = "airline")
public class Airline {
    @Id
    @NotNull(message = "Введите код авиакомпании")
    private Integer airlineCode;

    @NotBlank(message = "Введите название авиакомпании")
    @Size(min = 1, max = 30, message = "Допустимое количество символов от 1 до 30")
    private String name;
}

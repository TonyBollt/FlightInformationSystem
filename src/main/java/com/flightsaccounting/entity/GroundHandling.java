package com.flightsaccounting.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity(name = "ground_handling")
public class GroundHandling {
    @Id
    @NotNull(message = "Введите код услуги")
    private Integer ghCode;

    @NotBlank(message = "Введите наименование услуги")
    @Size(min = 1, max = 30, message = "Допустимое количество символов от 1 до 50")
    private String name;
}

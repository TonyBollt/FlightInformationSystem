package com.flightsaccounting.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity(name = "flight_type")
public class FlightType {

    @Id
    @NotNull(message = "Введите код типа рейса")
    private Integer ftCode;

    @NotBlank(message = "Введите тип рейса")
    @Size(min = 1, max = 30, message = "Допустимое количество символов от 1 до 30")
    private String name;


}

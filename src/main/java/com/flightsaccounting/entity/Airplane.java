package com.flightsaccounting.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity(name = "airplane")
public class Airplane {
    @Id
    @NotBlank(message = "Введите бортовой номер самолёта")
    @Size(min = 1, max = 7, message = "Допустимое количество символов от 1 до 7")
    private String tailNumber;

    @NotBlank(message = "Введите модель самолёта")
    private String model;

    @ManyToOne
    @JoinColumn(name = "airline_code") //, table = "airline", insertable = false, updatable = false
    private Airline airline;
}

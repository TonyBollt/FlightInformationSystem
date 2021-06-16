package com.flightsaccounting.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;

@Data
@Entity(name = "flight")
public class Flight {
    @Id
    @NotBlank(message = "Введите номер рейса")
    @Size(min = 1, max = 30, message = "Допустимое количество символов от 1 до 30")
    private String flightNo;

    @NotBlank(message = "Введите пункт отправления")
    @Size(min = 1, max = 50, message = "Допустимое количество символов от 1 до 50")
    private String depPlace;

    @NotBlank(message = "Введите пункт назначения")
    @Size(min = 1, max = 50, message = "Допустимое количество символов от 1 до 50")
    private String desPlace;

    @NotBlank(message = "Заполните регулярность")
    @Size(min = 1, max = 30, message = "Допустимое количество символов от 1 до 30")
    private String regul;

    //@Temporal(TemporalType.TIME)
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    //@DateTimeFormat(pattern = "HH:mm:ss", iso = DateTimeFormat.ISO.TIME)
    //@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @NotNull(message = "Введите время отправки")
    private LocalTime depTime;

    @ManyToOne
    @JoinColumn(name = "airline_code")
    private Airline airline;

    @ManyToOne()
    @JoinColumn(name = "ft_code")
    private FlightType flightType;

}

package com.flightsaccounting.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity(name = "current_flight")
public class CurrentFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cfId;

    @PastOrPresent(message = "Дата должна быть текущей или прошедшей")
    @NotNull(message = "Введите дату отправления")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate depDate;

    @NotNull(message = "Введите время вылета")
    private LocalTime flightTime;

    @NotBlank(message = "Введите статус")
    private String status;

    @NotNull(message = "Введите кол-во пассажиров")
    private Integer passengerNumbers;

    private BigDecimal totalCost;

    @ManyToOne
    @JoinColumn(name = "flight_no")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "tail_number")
    private Airplane airplane;

    @ManyToOne
    @JoinColumn(name = "runway_code")
    private Runway runway;

}

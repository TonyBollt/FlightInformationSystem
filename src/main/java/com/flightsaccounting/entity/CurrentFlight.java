package com.flightsaccounting.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity(name = "current_flight")
public class CurrentFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cfId;

    @Past
    @NotNull(message = "Введите дату отправления")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate depDate;

    @NotNull(message = "Введите время вылета")
    //@Temporal(TemporalType.TIME)
    //@JsonFormat(pattern = "hh:mm")
    //@DateTimeFormat(pattern = "hh:mm")
    private LocalTime flightTime;

    @NotBlank(message = "Введите статус")
    private String status;

    @NotNull(message = "Введите кол-во пассажиров")
    private Integer passengerNumbers;

    @NotNull(message = "Введите стоимость расходов")
    private BigDecimal totalCost;

    @ManyToOne
    @JoinColumn(name = "flight_no", insertable = false, updatable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "tail_number", insertable = false, updatable = false)
    private Airplane airplane;

    @ManyToOne
    @JoinColumn(name = "runway_code", insertable = false, updatable = false)
    private Runway runway;

}

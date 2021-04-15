package com.flightsaccounting.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "runway")
public class Runway {
    @Id
    @NotNull(message = "Введите код ВПП")
    private Integer runwayCode;

    @NotNull(message = "Введите длину")
    private Integer length;

}


package com.flightsaccounting.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity(name = "ledger")
public class Ledger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ledgerId;

    @NotNull(message = "Введите стоимость услуги")
    private BigDecimal cost;

    @ManyToOne
    @JoinColumn(name = "cf_id")
    private CurrentFlight currentFlight;

    @ManyToOne
    @JoinColumn(name = "cp_code")
    private Counterparty counterparty;

    @ManyToOne
    @JoinColumn(name = "gh_code")
    private GroundHandling groundHandling;
}


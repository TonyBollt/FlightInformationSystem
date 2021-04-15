package com.flightsaccounting.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity(name = "counterparty")
public class Counterparty {
    @Id
    @NotNull(message = "Введите код контрагента")
    private Integer cpCode;

    @NotBlank(message = "Введите наименование контрагента")
    @Size(min = 1, max = 50, message = "Допустимое количество символов от 1 до 50")
    private String name;

    @NotBlank(message = "Введите адрес контрагента")
    @Size(min = 1, max = 50, message = "Допустимое количество символов от 1 до 50")
    private String address;
}

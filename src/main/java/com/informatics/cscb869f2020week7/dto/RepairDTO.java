package com.informatics.cscb869f2020week7.dto;

import com.informatics.cscb869f2020week7.data.entity.Car;
import com.informatics.cscb869f2020week7.data.entity.RepairType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class RepairDTO {

    private Car car;
    private RepairType repairType;
    private double price;
}

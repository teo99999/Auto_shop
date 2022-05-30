package com.informatics.cscb869f2020week7.dto;

import com.informatics.cscb869f2020week7.data.entity.Autoshop;
import com.informatics.cscb869f2020week7.data.entity.RepairType;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

public class UpdateEmployeeDTO {

    @NotBlank
    private String name;

    @Enumerated
    private RepairType repairType;

    private Autoshop autoshop;
}

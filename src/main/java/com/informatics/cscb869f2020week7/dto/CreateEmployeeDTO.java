package com.informatics.cscb869f2020week7.dto;

import com.informatics.cscb869f2020week7.data.entity.Autoshop;
import com.informatics.cscb869f2020week7.data.entity.RepairType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateEmployeeDTO {

    @NotBlank
    private String name;

    @Enumerated
    private RepairType repairType;

    private Autoshop autoshop;
}

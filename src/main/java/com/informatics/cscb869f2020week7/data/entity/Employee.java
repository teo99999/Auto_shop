package com.informatics.cscb869f2020week7.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@PrimaryKeyJoinColumn(name = "idEmployee")
@SecondaryTable(name = "Employee")
public class Employee extends User{

    @NotBlank
    private String name;

    @Enumerated
    private RepairType repairType;

    @ManyToOne
    @JoinColumn(name = "autoshop_id")
    private Autoshop autoshop;


}

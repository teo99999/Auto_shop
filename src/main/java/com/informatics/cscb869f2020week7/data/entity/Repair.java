package com.informatics.cscb869f2020week7.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "repair")
public class Repair extends BaseEntity{



    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @NotNull
    private RepairType repairType;

    private double price;

    @ManyToOne
    @JoinColumn(name = "autoshop_id")
    private Autoshop autoshop;

}

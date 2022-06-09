package com.informatics.cscb869f2020week7.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@ToString
@Entity
@Table(name = "autoshop")
public class Autoshop extends BaseEntity{

    @NotBlank
    @Size(min = 3, max = 20, message = "Min 3, Max 20")
    private String name;

    @NotNull
    @Min(value = 2, message = "Min 2")
    private int employeeCount;

    @OneToMany(mappedBy = "autoshop")
    @JsonIgnoreProperties("autoshop")
    private List<Employee> employees;

    @Enumerated
    private Brand brand;


    @OneToMany(mappedBy = "autoshop")
    @JsonIgnoreProperties("autoshop")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "autoshop")
    @JsonIgnoreProperties("autoshop")
    private List<Repair> repairs;

   /* @OneToMany(mappedBy = "autoshop")
    @JsonIgnoreProperties("autoshop")
    private List<Car> cars;*/






}

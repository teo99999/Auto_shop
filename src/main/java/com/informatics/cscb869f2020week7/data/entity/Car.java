package com.informatics.cscb869f2020week7.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "car")
public class Car extends BaseEntity{

    @Size(min = 4, max=4, message = "Registration number should be 4 digits!")
    private String registrationNum;

    @Enumerated
    private Brand brand;

    private String model;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
   @Past(message = "The year should be in the past!")
    private LocalDate productionYear;

    private boolean isRepaired;

    @OneToMany(mappedBy = "car")
    @JsonIgnoreProperties("car")
    private List<Repair> repairs;

/*    @ManyToOne
    @JoinColumn(name = "autoshop_id")
    private Autoshop autoshop;*/

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;



}

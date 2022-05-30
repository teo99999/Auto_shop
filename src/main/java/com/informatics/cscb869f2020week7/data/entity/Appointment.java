package com.informatics.cscb869f2020week7.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
//@ToString
@Entity
@Table(name = "appointment")
public class Appointment extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "autoshop_id")
    private Autoshop autoshop;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "The date should be in the future")
    private LocalDate appointmentDate;


    @ManyToOne
    private User user;










}

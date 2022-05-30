package com.informatics.cscb869f2020week7.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateAppointmentDTO {

    private LocalDate appointmentDate;



}

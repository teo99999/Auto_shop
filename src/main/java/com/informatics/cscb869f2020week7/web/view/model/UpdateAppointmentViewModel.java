package com.informatics.cscb869f2020week7.web.view.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateAppointmentViewModel {

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "The date has to be in the future!")
    private LocalDate appointmentDate;



}

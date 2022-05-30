package com.informatics.cscb869f2020week7.dto;

import com.informatics.cscb869f2020week7.data.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateAppointmentDTO {


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "The date has to be in the future!")
    private LocalDate appointmentDate;

    private User user;

    private Autoshop autoshop;

}

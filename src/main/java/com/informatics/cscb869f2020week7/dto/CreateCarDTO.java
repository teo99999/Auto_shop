package com.informatics.cscb869f2020week7.dto;

import com.informatics.cscb869f2020week7.data.entity.Brand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateCarDTO {

    @NotNull
    @Size(min = 4, max=4, message = "Registration number should be 4 digits!")
    private String registrationNum;

    @Enumerated
    @Max(value = 15, message = "Max 15")
    private Brand brand;

    @Max(value = 15, message = "Max 15")
    private String model;

    @NotNull
    @DateTimeFormat
    @Past(message = "The year should be in the past!")
    private LocalDate productionYear;
}

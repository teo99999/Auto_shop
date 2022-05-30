package com.informatics.cscb869f2020week7.web.view.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateAutoshopViewModel {

    @NotBlank
    @Size(min = 3, max = 20, message = "Min 3, Max 20")
    private String name;

    @NotNull
    @Min(value = 2, message = "Min 2")
    private int employeeCount;
}

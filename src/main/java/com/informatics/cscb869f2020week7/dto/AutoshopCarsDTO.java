package com.informatics.cscb869f2020week7.dto;

import com.informatics.cscb869f2020week7.data.entity.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AutoshopCarsDTO {

    private String name;
    private List<Car> cars;
}

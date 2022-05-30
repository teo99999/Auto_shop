package com.informatics.cscb869f2020week7.web.view.model;

import com.informatics.cscb869f2020week7.data.entity.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AutoshopCarsViewModel {

    private long id;
    private String name;
    List<Car> carList;
}

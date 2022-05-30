package com.informatics.cscb869f2020week7.web.view.model;

import com.informatics.cscb869f2020week7.data.entity.Brand;
import com.informatics.cscb869f2020week7.data.entity.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AutoshopViewModel {

    private long id;
    private String name;
    private int employeeCount;
    private Brand brand;
    private List<Car> cars;
}

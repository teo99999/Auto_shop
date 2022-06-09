package com.informatics.cscb869f2020week7.services;

import com.informatics.cscb869f2020week7.data.entity.Autoshop;
import com.informatics.cscb869f2020week7.data.entity.Brand;
import com.informatics.cscb869f2020week7.data.entity.Car;
import com.informatics.cscb869f2020week7.dto.CarDTO;
import com.informatics.cscb869f2020week7.dto.CreateCarDTO;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

public interface CarService {

    List<CarDTO> getCars();

    Car create(@Valid CreateCarDTO createCarDTO);

    List<CarDTO> getCarsByBrand(Brand brand);

    List<CarDTO> getCarsByProductionYear(LocalDate productionYear);

 /*   List<CarDTO> getCarsByAutoshopId(long id);
*/



}

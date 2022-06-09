package com.informatics.cscb869f2020week7.data.repository;

import com.informatics.cscb869f2020week7.data.entity.Autoshop;
import com.informatics.cscb869f2020week7.data.entity.Brand;
import com.informatics.cscb869f2020week7.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByBrand(Brand brand);

    List<Car> findAllByProductionYear(LocalDate productionYear);

 /*   List<Car> findAllByAutoshopId(long id);

    List<Car> findAllByAutoshopName(String name);*/


}

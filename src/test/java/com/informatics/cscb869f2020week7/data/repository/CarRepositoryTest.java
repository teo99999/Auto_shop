package com.informatics.cscb869f2020week7.data.repository;

import com.informatics.cscb869f2020week7.data.entity.Autoshop;
import com.informatics.cscb869f2020week7.data.entity.Brand;
import com.informatics.cscb869f2020week7.data.entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void findAllByAutoshopName(){

        String name = "Auto";
        Autoshop autoshop = new Autoshop();
        autoshop.setName(name);
        autoshop.setEmployeeCount(2);
        testEntityManager.persistAndFlush(autoshop);

        Car car = new Car();
        car.setBrand(Brand.BMW);
        car.setModel("x6");
        car.setProductionYear(LocalDate.of(1999, 9, 8));
        car.setRegistrationNum("hhhh");
        car.setAutoshop(autoshop);
        testEntityManager.persistAndFlush(car);

        assertThat(carRepository.findAllByAutoshopName(name).size()).isEqualTo(1);
    }
}

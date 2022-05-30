package com.informatics.cscb869f2020week7.data.repository;

import com.informatics.cscb869f2020week7.data.entity.Autoshop;
import com.informatics.cscb869f2020week7.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoshopRepository extends JpaRepository<Autoshop, Long> {

    List<Autoshop> findAllByName(String name);





}

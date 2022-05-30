package com.informatics.cscb869f2020week7.services.implementations;

import com.informatics.cscb869f2020week7.data.entity.Autoshop;
import com.informatics.cscb869f2020week7.data.entity.Brand;
import com.informatics.cscb869f2020week7.data.entity.Car;
import com.informatics.cscb869f2020week7.data.repository.CarRepository;

import com.informatics.cscb869f2020week7.dto.CarDTO;
import com.informatics.cscb869f2020week7.dto.CreateCarDTO;
import com.informatics.cscb869f2020week7.services.CarService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<CarDTO> getCars() {
        return carRepository.findAll().stream()
                .map(this::convertToCarDTO)
                .collect(Collectors.toList());

    }

    @Override
    public Car create(@Valid CreateCarDTO createCarDTO) {
        return carRepository.save(modelMapper.map(createCarDTO, Car.class));
    }

    @Override
    public List<CarDTO> getCarsByBrand(Brand brand){
        return carRepository.findAllByBrand(brand).stream()
                .map(this::convertToCarDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDTO> getCarsByProductionYear(LocalDate productionYear){
        return carRepository.findAllByProductionYear(productionYear).stream()
                .map(this::convertToCarDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDTO> getCarsByAutoshopId(long id){
        return carRepository.findAllByAutoshopId(id).stream()
                .map(this::convertToCarDTO)
                .collect(Collectors.toList());
    }



    private CarDTO convertToCarDTO(Car car){
        return modelMapper.map(car, CarDTO.class);
    }
}

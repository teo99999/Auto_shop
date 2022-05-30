package com.informatics.cscb869f2020week7.web.api;


import com.informatics.cscb869f2020week7.dto.CarDTO;
import com.informatics.cscb869f2020week7.services.CarService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
@Validated
public class CarApiController {

    private final CarService carService;

    private final ModelMapper modelMapper;

    @GetMapping
    public List<CarDTO> getCars() {return carService.getCars(); }
}

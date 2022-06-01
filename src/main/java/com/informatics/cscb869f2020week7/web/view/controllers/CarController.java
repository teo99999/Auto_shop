package com.informatics.cscb869f2020week7.web.view.controllers;

import com.informatics.cscb869f2020week7.data.entity.*;
import com.informatics.cscb869f2020week7.dto.CarDTO;
import com.informatics.cscb869f2020week7.dto.CreateCarDTO;
import com.informatics.cscb869f2020week7.services.AutoshopService;
import com.informatics.cscb869f2020week7.services.CarService;
import com.informatics.cscb869f2020week7.services.EmployeeService;
import com.informatics.cscb869f2020week7.web.view.model.CarViewModel;
import com.informatics.cscb869f2020week7.web.view.model.CreateCarViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final AutoshopService autoshopService;
    private final EmployeeService employeeService;
    private ModelMapper modelMapper;


    @GetMapping
    public String getCars(Model model, Authentication authentication) {

        User principal = (User) authentication.getPrincipal();

        final List<CarViewModel> cars = carService.getCarsByAutoshopId(principal.getAutoshop().getId()) 
                .stream()
                .map(this::convertToCarViewModel)
                .collect(Collectors.toList());

        model.addAttribute("cars", cars);


        return "/cars/cars";
    }

    @GetMapping("/create-car")
    public String showCreateCarForm(Model model) {
        model.addAttribute("car", new CreateCarViewModel());
        return "/cars/create-car";
    }

    @GetMapping("/create")
    public String createCar(@Valid @ModelAttribute("car") CreateCarViewModel car, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/cars/create-car";
        }
        carService.create(modelMapper.map(car, CreateCarDTO.class));
        return "redirect:/cars";
    }

/*
    @GetMapping("/search-cars-autoshop")
    public String processSearchCarAutoshop(Model model) {

        model.addAttribute("autoshops", autoshopService.getAutoshops());
        model.addAttribute("car", new CarViewModel());
        return "/cars/search-cars-autoshop";
    }

    @GetMapping("/autoshop")
    public String getCarsByAutoshop(Model model, @RequestParam Autoshop autoshop) { // error appears without required

        List<CarViewModel> cars = carService
                .getCarsByAutoshop(autoshop)
                .stream()
                .map(this::convertToCarViewModel)
                .collect(Collectors.toList());

        return "/cars/cars";
    }
*/

    private CarViewModel convertToCarViewModel(CarDTO carDTO) {
        return modelMapper.map(carDTO, CarViewModel.class);
    }

}

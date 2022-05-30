package com.informatics.cscb869f2020week7.web.view.controllers;

import com.informatics.cscb869f2020week7.data.entity.Car;
import com.informatics.cscb869f2020week7.dto.AutoshopDTO;
import com.informatics.cscb869f2020week7.dto.CarDTO;
import com.informatics.cscb869f2020week7.dto.CreateAutoshopDTO;
import com.informatics.cscb869f2020week7.dto.UpdateAutoshopDTO;
import com.informatics.cscb869f2020week7.services.AutoshopService;
import com.informatics.cscb869f2020week7.web.view.model.*;
import lombok.AllArgsConstructor;
import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/autoshops")
public class AutoshopController {

    private final AutoshopService autoshopService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getAutoshops(Model model) {
        final List<AutoshopViewModel> autoshops = autoshopService.getAutoshops()
                .stream()
                .map(this::convertToAutoshopViewModel)
                .collect(Collectors.toList());
        model.addAttribute("autoshops", autoshops);
        return "/autoshops/autoshops";
    }

    @GetMapping("/create-autoshop")
    public String showCreateAutoshopForm(Model model) {
        model.addAttribute("autoshop", new CreateAutoshopViewModel());
        return "/autoshops/create-autoshop";
    }

    @PostMapping("/create")
    public String createAutoshop(@Valid @ModelAttribute("autoshop") CreateAutoshopViewModel autoshop,
                                 BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/autoshops/create-autoshop";
        }
        autoshopService.create(modelMapper.map(autoshop, CreateAutoshopDTO.class));
        return "redirect:/autoshops";
    }

    @GetMapping("/edit-autoshop/{id}")
    public String showEditAutoshopForm(Model model, @PathVariable Long id) {
        model.addAttribute("autoshop", modelMapper.map(autoshopService.getAutoshop(id),
                UpdateAutoshopViewModel.class));
        return "/autoshops/edit-autoshop";
    }

    @PostMapping("/update/{id}")
    public String updateAutoshop(@PathVariable long id, @Valid @ModelAttribute("autoshop") UpdateAutoshopViewModel autoshop,
                                 BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "/autoshops/edit-autoshop";
        }
        autoshopService.updateAutoshop(id, modelMapper.map(autoshop, UpdateAutoshopDTO.class));
        return "redirect:/autoshops";
    }

    @GetMapping("/search-autoshops")
    public String processSearchAutoshopForm() { return "/autoshops/search-autoshops"; }

    @GetMapping("/names")
    public String getAutoshopsByName(Model model, @RequestParam String autoshopName){
        List<AutoshopViewModel> autoshops = autoshopService
                .getAutoshopsByName(autoshopName)
                .stream()
                .map(this::convertToAutoshopViewModel)
                .collect(Collectors.toList());

        model.addAttribute("autoshops", autoshops);

        return "/autoshops/autoshop-cars";
    }


    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        autoshopService.deleteAutoshop(id);
        return "redirect:/autoshops";
    }

    private AutoshopViewModel convertToAutoshopViewModel(AutoshopDTO autoshopDTO){
        return modelMapper.map(autoshopDTO, AutoshopViewModel.class);
    }

    private AutoshopCarsViewModel convertToAutoshopCarsViewModel(AutoshopDTO autoshopDTO){
        return modelMapper.map(autoshopDTO, AutoshopCarsViewModel.class);
    }

}

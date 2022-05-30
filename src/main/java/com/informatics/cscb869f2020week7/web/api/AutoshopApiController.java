package com.informatics.cscb869f2020week7.web.api;

import com.informatics.cscb869f2020week7.data.entity.Autoshop;
import com.informatics.cscb869f2020week7.data.entity.Car;
import com.informatics.cscb869f2020week7.dto.AutoshopDTO;
import com.informatics.cscb869f2020week7.dto.CarDTO;
import com.informatics.cscb869f2020week7.services.AutoshopService;
import com.informatics.cscb869f2020week7.services.CarService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/autoshops")
@AllArgsConstructor
@Validated
public class AutoshopApiController {

    private final AutoshopService autoshopService;

    private final ModelMapper modelMapper;

    @GetMapping
    public List<AutoshopDTO> getAutoshops(){ return autoshopService.getAutoshops(); }

    @RequestMapping("/{id}")
    public AutoshopDTO getAutoshop(@PathVariable("id") @Min(1) int id) {return autoshopService.getAutoshop(id); }

    @DeleteMapping(value = "/{id}")
    public void deleteAutoshop(@PathVariable long id) { autoshopService.deleteAutoshop(id);}



}

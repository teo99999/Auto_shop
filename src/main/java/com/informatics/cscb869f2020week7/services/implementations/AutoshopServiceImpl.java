package com.informatics.cscb869f2020week7.services.implementations;

import com.informatics.cscb869f2020week7.data.entity.Autoshop;
import com.informatics.cscb869f2020week7.data.entity.Car;
import com.informatics.cscb869f2020week7.data.repository.AutoshopRepository;
import com.informatics.cscb869f2020week7.dto.*;
import com.informatics.cscb869f2020week7.exceptions.AutoshopNotFoundException;
import com.informatics.cscb869f2020week7.services.AutoshopService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class AutoshopServiceImpl implements AutoshopService {

    private final AutoshopRepository autoshopRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<AutoshopDTO> getAutoshops(){
        return autoshopRepository.findAll().stream()
                .map(this::convertToAutoshopDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AutoshopDTO getAutoshop(@Min(1) long id){
        return modelMapper.map(autoshopRepository.findById(id)
                .orElseThrow(() -> new AutoshopNotFoundException("Invalid autoshop ID: " + id)), AutoshopDTO.class);
    }

    @Override
    public Autoshop create(@Valid CreateAutoshopDTO createAutoshopDTO) {
        return autoshopRepository.save(modelMapper.map(createAutoshopDTO, Autoshop.class));
    }

    @Override
    public Autoshop updateAutoshop(long id, UpdateAutoshopDTO updateAutoshopDTO) {
        Autoshop autoshop = modelMapper.map(updateAutoshopDTO, Autoshop.class);
        autoshop.setId(id);
        return autoshopRepository.save(autoshop);
    }

    @Override
    public void deleteAutoshop(long id) {autoshopRepository.deleteById(id);}

    @Override
    public List<AutoshopDTO> getAutoshopsByName(String name){
        return autoshopRepository.findAllByName(name).stream()
                .map(this::convertToAutoshopDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AutoshopDTO> getAutoshopsSortedBy(String sortedBy, Sort.Direction direction){
        return autoshopRepository.findAll(Sort.by(direction, sortedBy)).stream()
                .map(this::convertToAutoshopDTO)
                .collect(Collectors.toList());
    }

 /*   @Override
    public List<Car> getAllCarsByAutoshopId(long id) {
        AutoshopCarsDTO autoshop = modelMapper.map(getAutoshop(id), AutoshopCarsDTO.class);
        return autoshop.getCars();
    }*/


    private AutoshopDTO convertToAutoshopDTO(Autoshop autoshop){
        return modelMapper.map(autoshop, AutoshopDTO.class);
    }

}

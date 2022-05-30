package com.informatics.cscb869f2020week7.services;

import com.informatics.cscb869f2020week7.data.entity.Autoshop;
import com.informatics.cscb869f2020week7.data.entity.Car;
import com.informatics.cscb869f2020week7.dto.AutoshopDTO;
import com.informatics.cscb869f2020week7.dto.CreateAutoshopDTO;
import com.informatics.cscb869f2020week7.dto.UpdateAutoshopDTO;
import org.springframework.data.domain.Sort;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

public interface AutoshopService {

    List<AutoshopDTO> getAutoshops();

    AutoshopDTO getAutoshop(@Min(1) long id);

    Autoshop create(@Valid CreateAutoshopDTO createAutoshopDTO);

    Autoshop updateAutoshop(long id, UpdateAutoshopDTO updateAutoshopDTO);

    void deleteAutoshop(long id);

    List<AutoshopDTO> getAutoshopsByName(String name);

    List<AutoshopDTO> getAutoshopsSortedBy(String sortedBy, Sort.Direction direction);

   /* List<Car> getAllCarsByAutoshopId(long id);*/


}

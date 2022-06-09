package com.informatics.cscb869f2020week7.services.implementations;

import com.informatics.cscb869f2020week7.data.entity.Repair;
import com.informatics.cscb869f2020week7.data.repository.RepairRepository;
import com.informatics.cscb869f2020week7.dto.CarDTO;
import com.informatics.cscb869f2020week7.dto.RepairDTO;
import com.informatics.cscb869f2020week7.services.RepairService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class RepairServiceImpl implements RepairService {

    private ModelMapper modelMapper;

    private RepairRepository repairRepository;

    @Override
    public List<RepairDTO> getRepairs() {
        return repairRepository.findAll().stream()
                .map(this::convertToRepairDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RepairDTO> getRepairsByAutoshopId(long id){
        return repairRepository.findAllByAutoshopId(id).stream()
                .map(this::convertToRepairDTO)
                .collect(Collectors.toList());
    }

    private RepairDTO convertToRepairDTO(Repair repair) { return modelMapper.map(repair, RepairDTO.class); }
}

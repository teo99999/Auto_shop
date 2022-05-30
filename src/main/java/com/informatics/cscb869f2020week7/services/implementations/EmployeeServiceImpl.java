package com.informatics.cscb869f2020week7.services.implementations;

import com.informatics.cscb869f2020week7.data.repository.EmployeeRepository;
import com.informatics.cscb869f2020week7.dto.AppointmentDTO;
import com.informatics.cscb869f2020week7.dto.EmployeeDTO;
import com.informatics.cscb869f2020week7.exceptions.AppointmentNotFoundException;
import com.informatics.cscb869f2020week7.exceptions.EmployeeNotFoundException;
import com.informatics.cscb869f2020week7.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

@Service
@AllArgsConstructor
@Validated
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    @Override
    public EmployeeDTO getEmployee(long id) {
        return modelMapper.map(employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Invalid employee ID " + id)), EmployeeDTO.class);

    }


}

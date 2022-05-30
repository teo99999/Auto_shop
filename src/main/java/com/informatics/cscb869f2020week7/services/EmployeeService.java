package com.informatics.cscb869f2020week7.services;

import com.informatics.cscb869f2020week7.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    /*List<EmployeeDTO> getEmployees();*/

    public EmployeeDTO getEmployee(long id);
}

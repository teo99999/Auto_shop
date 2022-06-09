package com.informatics.cscb869f2020week7.services;

import com.informatics.cscb869f2020week7.dto.RepairDTO;

import java.util.List;

public interface RepairService {

    List<RepairDTO> getRepairs();

    List<RepairDTO> getRepairsByAutoshopId(long id);
}

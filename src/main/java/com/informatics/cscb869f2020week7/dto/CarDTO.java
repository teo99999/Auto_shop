package com.informatics.cscb869f2020week7.dto;

import com.informatics.cscb869f2020week7.data.entity.Autoshop;
import com.informatics.cscb869f2020week7.data.entity.Brand;
import com.informatics.cscb869f2020week7.data.entity.Client;
import com.informatics.cscb869f2020week7.data.entity.Repair;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CarDTO {

    private long id;
    private String registrationNum;
    private Brand brand;
    private String model;
    private LocalDate productionYear;
    private boolean isRepaired;
    private Autoshop autoshop;
    private Client client;
   /* private List<Repair> repairs;*/
    /*private String autoshopName;*/
}

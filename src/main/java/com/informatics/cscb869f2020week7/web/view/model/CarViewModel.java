package com.informatics.cscb869f2020week7.web.view.model;

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

public class CarViewModel {
    private long id;
    private Brand brand;
    private LocalDate productionYear;
    private List<Repair> repairs;
    private Autoshop autoshop;
    private Client client;
/*    private String autoshopName;*/
}

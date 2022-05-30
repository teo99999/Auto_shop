package com.informatics.cscb869f2020week7.web.view.model;

import com.informatics.cscb869f2020week7.data.entity.Autoshop;
import com.informatics.cscb869f2020week7.data.entity.Brand;
import com.informatics.cscb869f2020week7.data.entity.Client;
import com.informatics.cscb869f2020week7.data.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentViewModel {

    private long id;
    private LocalDate appointmentDate;
    private double price;
    private Autoshop autoshop;
    private User user;


}

package com.informatics.cscb869f2020week7.services;

import com.informatics.cscb869f2020week7.data.entity.Appointment;
import com.informatics.cscb869f2020week7.dto.AppointmentDTO;
import com.informatics.cscb869f2020week7.dto.CreateAppointmentDTO;
import com.informatics.cscb869f2020week7.dto.UpdateAppointmentDTO;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

public interface AppointmentService {

    List<AppointmentDTO> getAppointments();

    AppointmentDTO getAppointment(@Min(1) long id);

    Appointment create(@Valid CreateAppointmentDTO createAppointmentDTO);

    Appointment updateAppointment(long id, UpdateAppointmentDTO updateAppointmentDTO);

    void deleteAppointment(long id);


}

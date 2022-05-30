package com.informatics.cscb869f2020week7.services.implementations;

import com.informatics.cscb869f2020week7.data.entity.Appointment;
import com.informatics.cscb869f2020week7.data.repository.AppointmentRepository;
import com.informatics.cscb869f2020week7.dto.AppointmentDTO;
import com.informatics.cscb869f2020week7.dto.CreateAppointmentDTO;
import com.informatics.cscb869f2020week7.dto.UpdateAppointmentDTO;
import com.informatics.cscb869f2020week7.exceptions.AppointmentNotFoundException;
import com.informatics.cscb869f2020week7.services.AppointmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

import static org.modelmapper.Converters.Collection.map;

@Service
@AllArgsConstructor
@Validated
public class AppointementServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<AppointmentDTO> getAppointments() {
        return appointmentRepository.findAll().stream()
                .map(this::convertToAppointmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDTO getAppointment(@Min(1) long id){
        return modelMapper.map(appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Invalid appointment ID: " + id)), AppointmentDTO.class);
    }

    @Override
    public Appointment create(@Valid CreateAppointmentDTO createAppointmentDTO){
        return appointmentRepository.save(modelMapper.map(createAppointmentDTO, Appointment.class));

    }

    @Override
    public Appointment updateAppointment(long id, UpdateAppointmentDTO updateAppointmentDTO) {
        Appointment appointment = modelMapper.map(updateAppointmentDTO, Appointment.class);
        appointment.setId(id);
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(long id) {
        appointmentRepository.deleteById(id);
    }



    private AppointmentDTO convertToAppointmentDTO(Appointment appointment){
        return modelMapper.map(appointment, AppointmentDTO.class);
    }
}

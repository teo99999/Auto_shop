package com.informatics.cscb869f2020week7.data.repository;

import com.informatics.cscb869f2020week7.data.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {




    /*List<Appointment> findAllByAppointmentDate(LocalDate appointmentDate)*/;
}

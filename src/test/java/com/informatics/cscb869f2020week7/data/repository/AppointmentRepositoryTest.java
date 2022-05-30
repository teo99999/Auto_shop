package com.informatics.cscb869f2020week7.data.repository;

import com.informatics.cscb869f2020week7.data.entity.Appointment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AppointmentRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Test
    void findAllByClientNameTest() {
       /* String name = "Ivan";
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(LocalDate.of(2022, 1, 22));
        appointment.setClientName(name);
        testEntityManager.persistAndFlush(appointment);

        Appointment appointment1 = new Appointment();
        appointment1.setAppointmentDate(LocalDate.of(2022, 1, 24));
        appointment1.setClientName(name);
        testEntityManager.persistAndFlush(appointment1);

        assertThat(appointmentRepository.findAllByClientName(name).size()).isEqualTo(2);*/
    }
}

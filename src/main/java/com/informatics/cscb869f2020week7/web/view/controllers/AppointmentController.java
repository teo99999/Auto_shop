package com.informatics.cscb869f2020week7.web.view.controllers;

import com.informatics.cscb869f2020week7.data.entity.Appointment;
import com.informatics.cscb869f2020week7.data.entity.Client;
import com.informatics.cscb869f2020week7.data.entity.User;
import com.informatics.cscb869f2020week7.dto.AppointmentDTO;
import com.informatics.cscb869f2020week7.dto.CreateAppointmentDTO;
import com.informatics.cscb869f2020week7.dto.UpdateAppointmentDTO;
import com.informatics.cscb869f2020week7.exceptions.AppointmentNotFoundException;
import com.informatics.cscb869f2020week7.exceptions.AutoshopNotFoundException;
import com.informatics.cscb869f2020week7.exceptions.CarNotFoundException;
import com.informatics.cscb869f2020week7.services.AppointmentService;
import com.informatics.cscb869f2020week7.services.AutoshopService;
import com.informatics.cscb869f2020week7.services.UserService;
import com.informatics.cscb869f2020week7.web.view.model.AppointmentViewModel;
import com.informatics.cscb869f2020week7.web.view.model.CreateAppointmentViewModel;
import com.informatics.cscb869f2020week7.web.view.model.UpdateAppointmentViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final UserService userService;
    private final AutoshopService autoshopService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getAppointments(Model model, Authentication authentication) {

        User principal = (User) authentication.getPrincipal();

        final List<AppointmentViewModel> appointments = principal.getAppointments()
                .stream()
                .map(this::convertToAppointmentViewModel1)//tuk izpolzvam druga funkciya
                .collect(Collectors.toList());
        model.addAttribute("appointments", appointments);

        return "/appointments/appointments";
    }

    @GetMapping("/create-appointment")
    public String showCreateAppointmentForm(Model model){
        model.addAttribute("appointment", new CreateAppointmentViewModel());
        model.addAttribute("autoshops", autoshopService.getAutoshops());
        return "/appointments/create-appointment";
    }

    @PostMapping("/create")
    public String createAppointment(@Valid @ModelAttribute("appointment") CreateAppointmentViewModel appointment,
                                    BindingResult bindingResult, Model model, Authentication authentication) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("autoshops", autoshopService.getAutoshops());
            return "/appointments/create-appointment";
        }

        User principal = (User) authentication.getPrincipal();
        principal.getAppointments().add(modelMapper.map(appointment, Appointment.class));
        appointment.setUser(principal);
        appointmentService.create(modelMapper.map(appointment, CreateAppointmentDTO.class));

        return "/appointments/created-appointment";
    }

    @GetMapping("/edit-appointment/{id}")
    public String showEditAppointmentForm(Model model, @PathVariable Long id) {
        model.addAttribute("appointment", modelMapper.map(appointmentService.getAppointment(id),
                UpdateAppointmentViewModel.class));
        return "/appointments/edit-appointment";
    }

    @PostMapping("/update/{id}")
    public String updateAppointment(@PathVariable long id, @Valid @ModelAttribute("appointment") UpdateAppointmentViewModel appointment,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/appointments/edit-appointment";
        }
        appointmentService.updateAppointment(id, modelMapper.map(appointment, UpdateAppointmentDTO.class));
        return "redirect:/appointments";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments";
    }

    // search appointments by client name

/*    @GetMapping("/search-appointments-client-name")
    public String processSearchAppointmentClientNameForm() {
        return "/appointments/search-appointments-client-name";
    }

    @GetMapping("/client-name")
    public String getAppointmentsByClientName(Model model, @RequestParam String clientName){
        List<AppointmentViewModel> appointments = appointmentService
                .getAppointmentByClientName(clientName)
                .stream()
                .map(this::convertToAppointmentViewModel)
                .collect(Collectors.toList());
        model.addAttribute("appointments", appointments);
        return "/appointments/appointments";
    }*/


    private AppointmentViewModel convertToAppointmentViewModel(AppointmentDTO appointmentDTO) {
        return modelMapper.map(appointmentDTO, AppointmentViewModel.class);
    }

    private AppointmentViewModel convertToAppointmentViewModel1(Appointment appointment) {
        return modelMapper.map(appointment, AppointmentViewModel.class);
    }


    @ExceptionHandler({AppointmentNotFoundException.class, AutoshopNotFoundException.class, CarNotFoundException.class})
    public String handleException(AppointmentNotFoundException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "/errors/autoshop-errors";
    }
}

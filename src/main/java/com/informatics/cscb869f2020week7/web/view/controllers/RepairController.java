package com.informatics.cscb869f2020week7.web.view.controllers;

import com.informatics.cscb869f2020week7.data.entity.User;
import com.informatics.cscb869f2020week7.dto.RepairDTO;
import com.informatics.cscb869f2020week7.services.RepairService;
import com.informatics.cscb869f2020week7.web.view.model.RepairViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/repairs")
public class RepairController {

    private final RepairService repairService;
    private ModelMapper modelMapper;

    @GetMapping
    public String getRepairs(Model model, Authentication authentication) {

        User principal = (User) authentication.getPrincipal();

        final List<RepairViewModel> repairs = repairService.getRepairsByAutoshopId(principal.getAutoshop().getId())
                .stream()
                .map(this::convertToRepairViewModel)
                .collect(Collectors.toList());

        model.addAttribute("repairs", repairs);

        return "/repairs/repairs";
    }

    private RepairViewModel convertToRepairViewModel(RepairDTO repairDTO) { return modelMapper.map(repairDTO, RepairViewModel.class); }
}

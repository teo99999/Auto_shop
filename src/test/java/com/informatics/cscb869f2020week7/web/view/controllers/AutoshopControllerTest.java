package com.informatics.cscb869f2020week7.web.view.controllers;

import com.informatics.cscb869f2020week7.services.AutoshopService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AutoshopController.class)
public class AutoshopControllerTest {

    @MockBean
    private AutoshopService autoshopService;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createAutoshops() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/autoshops/create-autoshop/"))
                .andExpect(status().isOk())
                .andExpect(view().name("/autoshops/create-autoshop/"));
    }
}

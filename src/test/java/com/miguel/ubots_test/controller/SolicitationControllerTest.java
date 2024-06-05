package com.miguel.ubots_test.controller;

import com.miguel.ubots_test.model.Solicitation;
import com.miguel.ubots_test.service.SolicitationDistributor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SolicitationController.class)
public class SolicitationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SolicitationDistributor solicitationDistributor;

    @Test
    public void testReceiveSolicitation() throws Exception {
        Solicitation solicitation = new Solicitation("Card Issues", "123");

        doNothing().when(solicitationDistributor).distribute(solicitation);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/solicitations")
                        .contentType("application/json")
                        .content("{\"type\":\"Card Issues\",\"clientId\":\"123\"}"))
                .andExpect(status().isOk());
    }
}

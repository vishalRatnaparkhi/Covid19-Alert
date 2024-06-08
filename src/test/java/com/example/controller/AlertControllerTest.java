package com.example.controller;

import com.example.covidalertservice.dto.AlertStatus;
import com.example.entity.SummaryData;
import com.example.service.AlertService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class AlertControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlertService alertService;

    @Test
    void getAlertAboutStatusTest() throws Exception {
        AlertStatus status = new AlertStatus();
        status.setAlertLavel("GREEN");
        Mockito.when(alertService.getAlertAboutStatus(ArgumentMatchers.anyString())).thenReturn(status);
        mockMvc.perform(MockMvcRequestBuilders.get("/india/delhi"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().json("{\"alertLavel\":\"GREEN\",\"stateData\":null,\"measuresToBeTaken\":null}"));
    }

    @Test
    void getSummaryTest() throws Exception {
        SummaryData sd = new SummaryData();
        Mockito.when(alertService.getOverallSumamry()).thenReturn(sd);
        mockMvc.perform(MockMvcRequestBuilders.get("/india/summary"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().json("{\"total\":0,\"confirmedCasesIndian\":0,\"updateTime\":null,\"confirmedCasesForeign\":0,\"discharged\":0,\"deaths\":0,\"confirmedButLocationUnidentified\":0}"));
    }

    @Test
    void invalidEndPoint() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders.get("/india123"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

}

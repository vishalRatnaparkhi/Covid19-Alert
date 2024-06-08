package com.example.service;

import com.example.covidalertservice.dto.AlertStatus;
import com.example.dataprovider.Covid19DataProvide;
import com.example.entity.StateData;
import com.example.entity.SummaryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AlertService {
    @Autowired
    private Covid19DataProvide dataProvide;

    public AlertStatus getAlertAboutStatus(String state) {

        AlertStatus status = new AlertStatus();
        StateData stateData = dataProvide.getStateData(state);
        status.setStateData(stateData);
        if (stateData.getTotalConfirmed() < 1000) {
            status.setAlertLavel("GREEN");
            status.setMeasuresToBeTaken(Arrays.asList("Everything is Normal!!"));
        } else if (stateData.getTotalConfirmed() > 1000 && stateData.getTotalConfirmed() < 10000) {
            status.setAlertLavel("ORANGE");
            status.setMeasuresToBeTaken(Arrays.asList("Only Essesntials are Allowed!!", "List of services that come under this"));
        } else {
            status.setAlertLavel("RED");
            status.setMeasuresToBeTaken(Arrays.asList("Absolute Lockdown!!", "only Medical Services Can be Open"));
        }

        return status;
    }

    public SummaryData getOverallSumamry() {
        return dataProvide.getSummaryData();
    }
}

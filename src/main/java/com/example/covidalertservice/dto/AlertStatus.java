package com.example.covidalertservice.dto;

import com.example.entity.StateData;
import com.example.entity.SummaryData;

import java.util.List;

public class AlertStatus {

    String alertLavel;

    public StateData getStateData() {
        return stateData;
    }

    public void setStateData(StateData stateData) {
        this.stateData = stateData;
    }

    private StateData stateData;

    public List<String> getMeasuresToBeTaken() {
        return measuresToBeTaken;
    }

    public void setMeasuresToBeTaken(List<String> measuresToBeTaken) {
        this.measuresToBeTaken = measuresToBeTaken;
    }

    public String getAlertLavel() {
        return alertLavel;
    }

    public void setAlertLavel(String alertLavel) {
        this.alertLavel = alertLavel;
    }

    List<String> measuresToBeTaken;
}

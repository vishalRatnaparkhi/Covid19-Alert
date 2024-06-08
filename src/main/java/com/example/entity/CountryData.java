package com.example.entity;

import java.util.Arrays;
import java.util.List;

public class CountryData {
    @Override
    public String toString() {
        return "CountryData{" +
                "summary=" + summary +
                ", regional=" + Arrays.toString(regional) +
                '}';
    }

    private SummaryData summary;

    public SummaryData getSummary() {
        return summary;
    }

    public void setSummary(SummaryData summary) {
        this.summary = summary;
    }

    public StateData[] getRegional() {
        return regional;
    }

    public void setRegional(StateData[] regional) {
        this.regional = regional;
    }

    private StateData[] regional;
}

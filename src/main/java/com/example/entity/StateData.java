package com.example.entity;

public class StateData {

    private String loc;
    private int confirmedCasesIndian;

    @Override
    public String toString() {
        return "StateData{" +
                "loc='" + loc + '\'' +
                ", confirmedCasesIndian=" + confirmedCasesIndian +
                ", confirmedCasesForeign=" + confirmedCasesForeign +
                ", discharged=" + discharged +
                ", deaths=" + deaths +
                ", totalConfirmed=" + totalConfirmed +
                '}';
    }

    public int getConfirmedCasesForeign() {
        return confirmedCasesForeign;
    }

    public void setConfirmedCasesForeign(int confirmedCasesForeign) {
        this.confirmedCasesForeign = confirmedCasesForeign;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getDischarged() {
        return discharged;
    }

    public void setDischarged(int discharged) {
        this.discharged = discharged;
    }

    public int getConfirmedCasesIndian() {
        return confirmedCasesIndian;
    }

    public void setConfirmedCasesIndian(int confirmedCasesIndian) {
        this.confirmedCasesIndian = confirmedCasesIndian;
    }

    public int getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(int totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    private int confirmedCasesForeign;
    private int discharged;
    private int deaths;
    private int totalConfirmed;
}

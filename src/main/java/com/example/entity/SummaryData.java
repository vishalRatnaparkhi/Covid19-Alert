package com.example.entity;

import java.time.ZonedDateTime;

public class SummaryData {

    private int total;

    @Override
    public String toString() {
        return "SummaryData{" +
                "total=" + total +
                ", confirmedCasesIndian=" + confirmedCasesIndian +
                ", updateTime=" + updateTime +
                ", confirmedCasesForeign=" + confirmedCasesForeign +
                ", discharged=" + discharged +
                ", deaths=" + deaths +
                ", confirmedButLocationUnidentified=" + confirmedButLocationUnidentified +
                '}';
    }


    private int confirmedCasesIndian;
    private ZonedDateTime updateTime;


    public ZonedDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(ZonedDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public int getConfirmedButLocationUnidentified() {
        return confirmedButLocationUnidentified;
    }

    public void setConfirmedButLocationUnidentified(int confirmedButLocationUnidentified) {
        this.confirmedButLocationUnidentified = confirmedButLocationUnidentified;
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

    public int getConfirmedCasesForeign() {
        return confirmedCasesForeign;
    }

    public void setConfirmedCasesForeign(int confirmedCasesForeign) {
        this.confirmedCasesForeign = confirmedCasesForeign;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private int confirmedCasesForeign;
    private int discharged;
    private int deaths;
    private int confirmedButLocationUnidentified;
}

package com.example.entity;

import java.time.ZonedDateTime;
import java.util.List;

public class CovidApiData {

    private  boolean success;
    private  CountryData data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ZonedDateTime getLastOriginUpdate() {
        return lastOriginUpdate;
    }

    public void setLastOriginUpdate(ZonedDateTime lastOriginUpdate) {
        this.lastOriginUpdate = lastOriginUpdate;
    }

    public ZonedDateTime getLastRefreshed() {
        return lastRefreshed;
    }

    public void setLastRefreshed(ZonedDateTime lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }

    @Override
    public String toString() {
        return "CovidApiData{" +
                "success=" + success +
                ", data=" + data +
                ", lastRefreshed=" + lastRefreshed +
                ", lastOriginUpdate=" + lastOriginUpdate +
                '}';
    }

    public CountryData getData() {
        return data;
    }

    public void setData(CountryData data) {
        this.data = data;
    }

    private ZonedDateTime lastRefreshed;
    private  ZonedDateTime lastOriginUpdate;

}

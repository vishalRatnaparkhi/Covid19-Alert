package com.example.dataprovider;

import com.example.entity.CovidApiData;
import com.example.entity.StateData;
import com.example.entity.SummaryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.plaf.nimbus.State;
import java.util.Arrays;

@Service
public class Covid19DataProvide {
    final String url = "https://api.rootnet.in/covid19-in/stats/latest";

    @Autowired
    private RestTemplate restTemplate;

    public StateData getStateData(String state) {
        CovidApiData covidApiData = restTemplate.getForObject(url, CovidApiData.class);
        StateData stateData = Arrays.stream(covidApiData.getData().getRegional()).filter(x -> x.getLoc().equalsIgnoreCase(state)).findAny().orElse(new StateData());
        return stateData;
    }

    public SummaryData getSummaryData() {
        CovidApiData covidApiData = restTemplate.getForObject(url, CovidApiData.class);

        SummaryData summaryData= covidApiData.getData().getSummary();
        System.out.println( covidApiData.getData());
        //summaryData.setUpdateTime(covidApiData.getLastRefreshed());
        return summaryData;
    }
}

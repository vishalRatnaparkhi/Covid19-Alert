package com.example.dataprovider;

import com.example.entity.CountryData;
import com.example.entity.CovidApiData;
import com.example.entity.StateData;
import com.example.entity.SummaryData;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;

import static org.mockito.Mockito.*;

@Nested
public class Covid19DataProvideTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private Covid19DataProvide dataProvide;


    {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    @DisplayName("State Data Provider Test")
    void getStateDataTest()
    {
        CovidApiData covidApiData = getCovidApiData();
        when(restTemplate.getForObject(anyString(),any())).thenReturn(covidApiData);

        StateData delhi=dataProvide.getStateData("Delhi");

        Assertions.assertAll(
                ()-> Assertions.assertEquals("Delhi",delhi.getLoc()),
                ()-> Assertions.assertEquals(4,delhi.getDeaths()),
                ()-> Assertions.assertEquals(0,delhi.getConfirmedCasesForeign()),
                ()-> Assertions.assertEquals(1000,delhi.getConfirmedCasesIndian()),
                ()-> Assertions.assertEquals(4,delhi.getDischarged()),
                ()-> Assertions.assertEquals(1000,delhi.getTotalConfirmed())
        );

    }

    @Test
    @DisplayName("State Data Provider Test -- No Data Found")
    void getStateDataTestNoDataFoundForSate()
    {
        CovidApiData covidApiData = getCovidApiData();
        when(restTemplate.getForObject(anyString(),any())).thenReturn(covidApiData);

        StateData maharashtra=dataProvide.getStateData("Maharashtra");

        Assertions.assertAll(
                ()-> Assertions.assertEquals(null,maharashtra.getLoc()),
                ()-> Assertions.assertEquals(0,maharashtra.getDeaths()),
                ()-> Assertions.assertEquals(0,maharashtra.getConfirmedCasesForeign()),
                ()-> Assertions.assertEquals(0,maharashtra.getConfirmedCasesIndian()),
                ()-> Assertions.assertEquals(0,maharashtra.getDischarged()),
                ()-> Assertions.assertEquals(0,maharashtra.getTotalConfirmed())
        );

    }

     @Test
     @DisplayName("Get Summary Data Test")
   void  getSummaryDataTest()
     {
         when(restTemplate.getForObject(anyString(),any())).thenReturn(getCovidApiDataForSummary());
         SummaryData summaryData=dataProvide.getSummaryData();
         Assertions.assertAll(
                 ()-> Assertions.assertEquals(0,summaryData.getConfirmedButLocationUnidentified()),
                 ()-> Assertions.assertEquals(100,summaryData.getTotal()),
                 ()-> Assertions.assertEquals(2,summaryData.getDeaths()),
                 ()-> Assertions.assertEquals(1,summaryData.getDischarged()),
                 ()-> Assertions.assertEquals(10,summaryData.getConfirmedCasesForeign()),
                 ()-> Assertions.assertEquals(90,summaryData.getConfirmedCasesIndian())

         );
     }

    private CovidApiData getCovidApiDataForSummary() {
        CovidApiData covidApiData = new CovidApiData();
        CountryData countryData= new CountryData();
        SummaryData summaryData= new SummaryData();
        summaryData.setTotal(100);
        summaryData.setDeaths(2);
        summaryData.setDischarged(1);
        summaryData.setConfirmedCasesIndian(90);
        summaryData.setConfirmedCasesForeign(10);
        summaryData.setUpdateTime(ZonedDateTime.now());

        countryData.setSummary(summaryData);

        covidApiData.setData(countryData);

        covidApiData.setSuccess(true);

        covidApiData.setLastRefreshed(ZonedDateTime.now());
        return covidApiData;
    }

    private static CovidApiData getCovidApiData() {
        CovidApiData covidApiData = new CovidApiData();
        CountryData countryData= new CountryData();

        StateData stateData= new StateData();
        stateData.setDeaths(4);
        stateData.setLoc("Delhi");
        stateData.setDischarged(4);
        stateData.setConfirmedCasesIndian(1000);
        stateData.setConfirmedCasesForeign(0);
        stateData.setTotalConfirmed(1000);

        countryData.setRegional(new StateData[]{stateData});
        covidApiData.setData(countryData);

        covidApiData.setSuccess(true);

        covidApiData.setLastRefreshed(ZonedDateTime.now());
        return covidApiData;
    }
}

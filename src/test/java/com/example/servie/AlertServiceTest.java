package com.example.servie;

import com.example.covidalertservice.dto.AlertStatus;
import com.example.dataprovider.Covid19DataProvide;
import com.example.entity.StateData;
import com.example.entity.SummaryData;
import com.example.service.AlertService;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

@Nested
public class AlertServiceTest {

    @InjectMocks
    private AlertService alertService;

    @Mock
    private Covid19DataProvide dataProvide;
    @BeforeEach
    void setup()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("When the number of confirmed patients are less than 1000")
    void getAlertAboutStatusTestGreen(){
        StateData stateData= new StateData();
        stateData.setTotalConfirmed(100);

        Mockito.when(dataProvide.getStateData(ArgumentMatchers.anyString())).thenReturn(stateData);
       AlertStatus status= alertService.getAlertAboutStatus("Assam");
        Assertions.assertEquals(List.of("Everything is Normal!!"), status.getMeasuresToBeTaken());
        Assertions.assertEquals("GREEN", status.getAlertLavel());
        Assertions.assertEquals(stateData,status.getStateData());

        Mockito.verify(dataProvide, Mockito.times(1)).getStateData("Assam");
    }

    @Test
    @DisplayName("When the number of confirmed patients are greater than 1000 and less than 10000")
    void getAlertAboutStatusTestOrange(){
        StateData stateData= new StateData();
        stateData.setTotalConfirmed(1005);

        Mockito.when(dataProvide.getStateData(ArgumentMatchers.anyString())).thenReturn(stateData);
        AlertStatus status= alertService.getAlertAboutStatus("Assam");
        Assertions.assertEquals(Arrays.asList("Only Essesntials are Allowed!!", "List of services that come under this"), status.getMeasuresToBeTaken());
        Assertions.assertEquals("ORANGE", status.getAlertLavel());
        Assertions.assertEquals(stateData,status.getStateData());
        Mockito.verify(dataProvide, Mockito.times(1)).getStateData("Assam");
    }

    @Test
    @DisplayName("When the number of confirmed patients are greater than 10000")
    void getAlertAboutStatusTestRed(){
        StateData stateData= new StateData();
        stateData.setTotalConfirmed(10005);

        Mockito.when(dataProvide.getStateData(ArgumentMatchers.anyString())).thenReturn(stateData);
        AlertStatus status= alertService.getAlertAboutStatus("Delhi");
        Assertions.assertEquals(Arrays.asList("Absolute Lockdown!!", "only Medical Services Can be Open"), status.getMeasuresToBeTaken());
        Assertions.assertEquals("RED", status.getAlertLavel());
        Assertions.assertEquals(stateData,status.getStateData());
        Mockito.verify(dataProvide, Mockito.times(1)).getStateData("Delhi");
    }
    @Test
    @DisplayName("Summary Test")
    void getOverallSumamryTest()
    {
        SummaryData summaryData= new SummaryData();
        summaryData.setUpdateTime(ZonedDateTime.now());
        summaryData.setConfirmedButLocationUnidentified(10);
        summaryData.setConfirmedCasesForeign(1);
        summaryData.setConfirmedCasesIndian(1000);
        summaryData.setDischarged(20);
        summaryData.setDeaths(2);
        summaryData.setTotal(1011);

        Mockito.when(dataProvide.getSummaryData()).thenReturn(summaryData);
        SummaryData actualSummary = alertService.getOverallSumamry();

        Assertions.assertEquals(summaryData,actualSummary);

    }

}

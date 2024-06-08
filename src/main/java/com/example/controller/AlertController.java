package com.example.controller;

import com.example.covidalertservice.dto.AlertStatus;
import com.example.entity.SummaryData;
import com.example.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/india")
public class AlertController {


    @Autowired
    private AlertService alertService;

    @GetMapping("/{state}")
    AlertStatus getAlertAboutStatus(@PathVariable  String state)
    {
      return   alertService.getAlertAboutStatus(state);
    }

    @GetMapping("/summary")
    SummaryData getOverallSumamry()
    {
        return  alertService.getOverallSumamry();
    }
}

package com.apap.TA.controller;

import com.apap.TA.model.KebutuhanReagenModel;
import com.apap.TA.service.KebutuhanReagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebServiceController {
    @Autowired
    private KebutuhanReagenService reagenService;

    @GetMapping(value = "lab/kebutuhan/perencanaan")
    private List<KebutuhanReagenModel> getReagen(){
        List<KebutuhanReagenModel> reagenModel = reagenService.getAllKebutuhanReagen();
        return reagenModel;
    }
}

package com.apap.TA.controller;

import com.apap.TA.model.KebutuhanReagenModel;
import com.apap.TA.service.KebutuhanReagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ReagenController {

    @Autowired
    private KebutuhanReagenService reagenService;

    @RequestMapping(value = "/lab/kebutuhan/tambah", method = RequestMethod.GET)
    private String view(Model model) {
        List<KebutuhanReagenModel> list = reagenService.getAllKebutuhanReagen();
        model.addAttribute("reagen", list);
        return "kebutuhan-reagen";
    }

}

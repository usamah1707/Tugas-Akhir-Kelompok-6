package com.apap.TA.controller;

import com.apap.TA.model.KebutuhanReagenModel;
import com.apap.TA.model.LabSuppliesModel;
import com.apap.TA.service.KebutuhanReagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.DateUtils;


import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller
public class ReagenController {

    @Autowired
    private KebutuhanReagenService reagenService;

    @RequestMapping(value = "/lab/kebutuhan", method = RequestMethod.GET)
    private String view(Model model) {
        List<KebutuhanReagenModel> list = reagenService.getAllKebutuhanReagen();
        model.addAttribute("reagen", list);
        return "kebutuhan-reagen";
    }

    @RequestMapping(value = "/lab/kebutuhan/ubah/{id}", method = RequestMethod.GET)
    private String updateReagen(@PathVariable(value = "id") Long id, Model model) {
        KebutuhanReagenModel temp = reagenService.getDetail(id).get();
        model.addAttribute("reagen", temp);
        return "update-kebutuhan-reagen";
    }

    @RequestMapping(value = "/lab/kebutuhan/ubah", method = RequestMethod.POST)
    private String updateReagen(@ModelAttribute KebutuhanReagenModel reagen, Model model) {
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        reagen.setTanggal_update(date);
        reagen.setJumlah(reagenService.getDetail(reagen.getId()).get().getJumlah());
        reagen.setLab_supplies(reagenService.getDetail(reagen.getId()).get().getLab_supplies());
        reagenService.addKebutuhan(reagen);
        return "update";
    }

}

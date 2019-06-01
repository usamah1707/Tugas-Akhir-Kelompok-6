package com.apap.TA.controller;

import com.apap.TA.model.LabSuppliesModel;
import com.apap.TA.model.PemeriksaanModel;
import com.apap.TA.service.PemeriksaanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PemeriksaanController {

    @Autowired
    private PemeriksaanService periksaService;

    @RequestMapping(value = "/lab/pemeriksaan", method = RequestMethod.GET)
    private String view(Model model) {
        List<PemeriksaanModel> list = periksaService.getAllJadwal();
        model.addAttribute("jadwal", list);
        return "view-pemeriksaan";
    }
    
    @RequestMapping(value = "/lab/pemeriksaan/permintaan", method = RequestMethod.GET)
    private String add(Model model) {
        model.addAttribute("jadwal", new PemeriksaanModel());
        return "add-pemeriksaan";
    }
    
    @RequestMapping(value = "/lab/pemeriksaan/permintaan", method = RequestMethod.POST)
    private String addJadwalSubmit(@ModelAttribute PemeriksaanModel periksa) {
        periksaService.addJadwal(periksa);
        return "add";

    }

}
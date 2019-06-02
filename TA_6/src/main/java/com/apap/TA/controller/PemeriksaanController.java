package com.apap.TA.controller;

import com.apap.TA.model.PasienModel;
import com.apap.TA.model.PemeriksaanModel;
import com.apap.TA.service.PasienService;
import com.apap.TA.service.PemeriksaanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PemeriksaanController {

    @Autowired
    private PemeriksaanService periksaService;
    
    @Autowired
    private PasienService pasienService;

    @RequestMapping(value = "/lab/pemeriksaan", method = RequestMethod.GET)
    private String view(Model model) {
        List<PasienModel> list = pasienService.getAllPasien();
        model.addAttribute("pasien", list);
        return "view-pemeriksaan";
    }
    
    @RequestMapping(value = "/lab/pemeriksaan/permintaan/{id}", method = RequestMethod.GET)
    private String addJadwal(@PathVariable(value = "id") Long id, Model model) {
        PasienModel pas = pasienService.getDetail(id).get();
        model.addAttribute("pasien", pas);
        return "add-pemeriksaan";
    }
    
    @RequestMapping(value = "/lab/pemeriksaan/permintaan", method = RequestMethod.POST)
    private String addJadwalSubmit(@ModelAttribute PemeriksaanModel periksa, Model model) {
        periksa.setPasien(pasienService.getDetail(periksa.getId()).get());
        periksa.setJadwal_jaga(periksaService.getDetail(periksa.getId()).get().getJadwal_jaga());
    	periksaService.addJadwal(periksa);
        return "add";

    }

}
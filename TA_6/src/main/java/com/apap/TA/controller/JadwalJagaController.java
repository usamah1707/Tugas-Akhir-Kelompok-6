package com.apap.TA.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.TA.model.JadwalJagaModel;
import com.apap.TA.model.StaffModel;
import com.apap.TA.service.JadwalJagaService;
import com.apap.TA.service.StaffService;

@Controller
public class JadwalJagaController {
	@Autowired
	private JadwalJagaService jadwalJagaService;
	
	@Autowired 
	private StaffService staffService;

	@RequestMapping(value ="/lab/jadwal-jaga/tambah", method = RequestMethod.GET)
	private String addJadwal (Model model) {
		
		model.addAttribute("listStaff", staffService.getAllStaff());
		
		//get todays date and waktuMulai for constrain
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        String nowTime = LocalTime.now().format(dtf);
		model.addAttribute("timeNow", nowTime);
		System.out.println(nowTime);
		LocalDate today = LocalDate.now();
		model.addAttribute("today", today);
		model.addAttribute("jadwal", new JadwalJagaModel());
		return "add-jadwal";
		
	}
	@RequestMapping(value = "/lab/jadwal-jaga/tambah", method = RequestMethod.POST)
	private String addJadwalSubmit (@ModelAttribute JadwalJagaModel jadwal ) {
		jadwalJagaService.addJadwal(jadwal);
		return "add-jadwal-submit";
	}
	@RequestMapping(value ="/lab/staff-jaga/tambah", method = RequestMethod.GET)
	private String addStaff (Model model) {
		model.addAttribute("staff", new StaffModel());
		return "add-staff";
	}
	@RequestMapping (value = "/lab/staff-jaga/tambah", method = RequestMethod.GET)
	private String addStaffSubmit (@ModelAttribute StaffModel staff) {
		staffService.addStaff(staff);
		return "add-staff-submit";
	}
}

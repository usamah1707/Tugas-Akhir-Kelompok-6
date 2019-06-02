package com.apap.TA.controller;

import java.util.List;

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
	private StaffService staffService;
	
	@Autowired
	private JadwalJagaService jadwalJagaService;
	
	@RequestMapping(value= "/lab/jadwal-jaga", method =RequestMethod.GET)
	private String viewStaff (Model model) {
		List <StaffModel> archieveStaff = staffService.getAllStaff();
		model.addAttribute("listStaff", archieveStaff);
		return "view-jadwal";
	}
	@RequestMapping (value="/lab/jadwal-jaga/staff", method=RequestMethod.GET)
	private String addStaff (Model model) {
		model.addAttribute("staff", new StaffModel());
		return "add-staff";
	}
	@RequestMapping(value="lab/jadwal-jaga/staff", method = RequestMethod.POST)
	private String addStaffSubmit (@ModelAttribute StaffModel staff) {
		staffService.addStaff(staff);
		return "add";
	}
	@RequestMapping (value="lab/jadwal-jaga/tambah", method = RequestMethod.GET)
	private String addJadwal (Model model) {
		JadwalJagaModel jadwal = new JadwalJagaModel();
		List <StaffModel> archieveStaff = staffService.getAllStaff();
		model.addAttribute("jadwal", jadwal);
		model.addAttribute("listStaff", archieveStaff);
		return "add-jadwal";
	}
	@RequestMapping (value="lab/jadwal-jaga/tambah", method= RequestMethod.POST)
	private String addJadwalSubmit (@ModelAttribute JadwalJagaModel jadwal) {
		jadwalJagaService.addJadwal(jadwal);
		return "add";
	}
	

}

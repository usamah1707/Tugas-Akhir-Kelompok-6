package com.apap.TA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/")
	public String home(Model model) {
		String kata = "tes: nyoba masukin aja ini mah";
		model.addAttribute("word", kata);
		return "home";
	}

}

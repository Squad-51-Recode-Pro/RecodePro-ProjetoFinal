package com.jobteens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RotasController {

	@GetMapping("/carreira")
	public String Carreira() {
		return "carreira";
	}

	@GetMapping("/sobrenos")
	public String sobreNos() {
		return "sobrenos";
	}

	@GetMapping("/login")
	public String login() {
		return "login/login";
	}
}

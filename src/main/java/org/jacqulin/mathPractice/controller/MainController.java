package org.jacqulin.mathPractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@GetMapping("/")
	public String viewIndex() {
		return "index";
	}

	@GetMapping("/Home")
	public String viewHome() {
		return "home";
	}

	@GetMapping("/About")
	public String viewAbout() {
		return "about";
	}

	@GetMapping("/Login")
	public String login(Model model) {
		System.out.println("IN  MainController->login()");
		return "login";
	}

	@ResponseBody
	@GetMapping("/logoutSuccess")
	public String logoutResponse() {
		System.out.println("IN  MainController->logoutResponse()");
		return "Logged Out!!!!";
	}
}

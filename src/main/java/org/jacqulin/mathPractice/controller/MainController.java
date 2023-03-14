package org.jacqulin.mathPractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
	
	//Retrieving Index page
	@GetMapping("/")
	public String viewIndex() {
		log.info("Index Page Retrieved");
		return "index";
	}
	
	//Retrieving Home page
	@GetMapping("/Home")
	public String viewHome() {
		log.info("Home Page Retrieved");
		return "home";
	}
	
	//Retrieving About page
	@GetMapping("/About")
	public String viewAbout() {
		log.info("About Page Retrieved");
		return "about";
	}
	
	//Retrieving Login page
	@GetMapping("/Login")
	public String login(Model model) {
		log.info("Login Page Retrieved");
		return "login";
	}
	
	//Successful logout
	@ResponseBody
	@GetMapping("/logoutSuccess")
	public String logoutResponse() {
		log.info("You are logged out");
		return "Logged Out!!!!";
	}
}

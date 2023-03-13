package org.jacqulin.mathPractice.controller;

import java.util.Collection;

import org.jacqulin.mathPractice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@Autowired
	private TeacherService teacherService;

//	@GetMapping("/")
//	public String root(HttpSession session) {
//
//		System.out.println("IN  MainController->root()");
//		session.getAttributeNames();
//
//		Collection<? extends GrantedAuthority> teacherRoles;
//
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		if (principal instanceof UserDetails) {
//			teacherRoles = ((UserDetails) principal).getAuthorities();
//
//			for (GrantedAuthority teacherRole : teacherRoles) {
//				if (teacherRole.getAuthority().equals("ROLE_SUPER")) {
//					return "redirect:/Home";
//				}
//			}
//		}
//
//		System.out.println("USER ROLE Defaults to Regular USER");
//		return "redirect:/students";
//	}

//	@GetMapping("/admin")
//	public String admin(Model model) {
//		System.out.println("IN  MainController->admin()");
//		return "admin";
//	}
	
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

//	@GetMapping("/teacher")
//	public String teacherIndex() {
//		System.out.println("IN  MainController->teacherIndex()");
//		return "teacher/index";
//	}

	@ResponseBody
	@GetMapping("/logoutSuccess")
	public String logoutResponse() {
		System.out.println("IN  MainController->logoutResponse()");
		return "Logged Out!!!!";
	}
}

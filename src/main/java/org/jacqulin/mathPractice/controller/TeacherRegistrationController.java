package org.jacqulin.mathPractice.controller;

import org.jacqulin.mathPractice.model.Teacher;
import org.jacqulin.mathPractice.repository.TeacherRegistrationDto;
import org.jacqulin.mathPractice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/Registration")
public class TeacherRegistrationController {

	@Autowired
	private TeacherService teacherService;

	@ModelAttribute("teacher")
	public TeacherRegistrationDto teacherRegistrationDto() {
		return new TeacherRegistrationDto();
	}

	@GetMapping
	public String showRegistrationForm(Model model) {
		return "registration";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("teacher") @Valid TeacherRegistrationDto teacherDto,
			BindingResult result) {

		Teacher existing = teacherService.findByEmail(teacherDto.getEmail());
		if (existing != null) {
			result.rejectValue("email", null, "There is already an account registered with that email");
		}

		if (result.hasErrors()) {
			return "registration";
		}

		teacherService.save(teacherDto);
		return "redirect:/Registration?success";
	}
}
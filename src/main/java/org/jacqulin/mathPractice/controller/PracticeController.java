package org.jacqulin.mathPractice.controller;

import org.jacqulin.mathPractice.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PracticeController {
	
	@Autowired
	private PracticeService practiceService;
	
	@GetMapping("/students/practice/{id}")
	public String practiceStudent(@PathVariable Long id) {
		return "practice";
	}
	
	@GetMapping("/Addition")
	public String additionQuestions(Model model) {
		final Long id1 = (long) 1;
		model.addAttribute("questions", practiceService.getQuestionByTopic(id1));
		return "questions";
	}
	
	@GetMapping("/Subraction")
	public String subtractionQuestions(Model model) {
		final Long id2 = (long) 2;
		model.addAttribute("questions", practiceService.getQuestionByTopic(id2));
		return "questions";
	}
	
	@GetMapping("/Multiplication")
	public String multiplicationQuestions(Model model) {
		final Long id3 = (long) 3;
		model.addAttribute("questions", practiceService.getQuestionByTopic(id3));
		return "questions";
	}
	
	@GetMapping("/Division")
	public String divisionQuestions(Model model) {
		final Long id4 = (long) 4;
		model.addAttribute("questions", practiceService.getQuestionByTopic(id4));
		return "questions";
	}
}

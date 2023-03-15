package org.jacqulin.mathPractice.controller;

import org.jacqulin.mathPractice.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PracticeController {

	@Autowired
	private PracticeService practiceService;

	// Student practice page
	@GetMapping("/students/practice/{id}")
	public String practiceStudent(@PathVariable Long id) {
		log.info("Students Practice Page");
		return "practice";
	}

	// Addition questions
	@GetMapping("/Addition")
	public String additionQuestions(Model model) {
		final Long ID1 = (long) 1;
		model.addAttribute("questionList", practiceService.getQuestionByTopic(ID1));
		log.info("Addition questions");
		return "questions";
	}

	// Subtraction questions
	@GetMapping("/Subraction")
	public String subtractionQuestions(Model model) {
		final Long ID2 = (long) 2;
		model.addAttribute("questionList", practiceService.getQuestionByTopic(ID2));
		log.info("Subtraction questions");
		return "questions";
	}

	// Multiplication questions
	@GetMapping("/Multiplication")
	public String multiplicationQuestions(Model model) {
		final Long ID3 = (long) 3;
		model.addAttribute("questionList", practiceService.getQuestionByTopic(ID3));
		log.info("Multiplication questions");
		return "questions";
	}

	// Division questions
	@GetMapping("/Division")
	public String divisionQuestions(Model model) {
		final Long ID4 = (long) 4;
		model.addAttribute("questionList", practiceService.getQuestionByTopic(ID4));
		log.info("Division questions");
		return "questions";
	}
}

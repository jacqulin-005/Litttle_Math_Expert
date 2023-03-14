package org.jacqulin.mathPractice.controller;

import org.jacqulin.mathPractice.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReportController {

	@Autowired
    private ReportService reportService;
	
	//Retrieving student reports
    @GetMapping("/Report")
    public String showReport(Model model) {
        model.addAttribute("reports", reportService.getAllReports());
        log.info("Students Report Retrieved");
        return "reports";
    }
    
    //Retrieving report of a student
	@GetMapping("/students/report/{id}")
	public String reportStudent(@PathVariable Long id, Model model) {
		model.addAttribute("student", reportService.getReportById(id));
		log.info("Student Report Retrieved");
		return "reports";
	}
	
}
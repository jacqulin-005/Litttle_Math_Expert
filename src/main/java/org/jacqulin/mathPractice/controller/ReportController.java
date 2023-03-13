package org.jacqulin.mathPractice.controller;

import org.jacqulin.mathPractice.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ReportController {

	@Autowired
    private ReportService reportService;

    @GetMapping("/Report")
    public String showReport(Model model) {
        model.addAttribute("reports", reportService.getAllReports());
        return "reports";
    }
    
    @GetMapping("/students/practice/{id}")
	public String practiceStudent(@PathVariable Long id) {
		return "practice";
	}
	
	@GetMapping("/students/report/{id}")
	public String reportStudent(@PathVariable Long id, Model model) {
		model.addAttribute("student", reportService.getReportById(id));
		return "reports";
	}
}
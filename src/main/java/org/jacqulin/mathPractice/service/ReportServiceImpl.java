package org.jacqulin.mathPractice.service;

import java.util.List;

import org.jacqulin.mathPractice.model.Report;
import org.jacqulin.mathPractice.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private ReportRepository reportRepository;

	@Override
	public List<Report> getAllReports() {
	
		return reportRepository.findAll();
		
	}

	@Override
	public Report getReportById(Long id) {
		
		return reportRepository.findById(id).get();
	}
}

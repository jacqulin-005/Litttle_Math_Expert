package org.jacqulin.mathPractice.service;

import java.util.List;

import org.jacqulin.mathPractice.model.Report;
import org.jacqulin.mathPractice.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportRepository reportRepository;

	// Students report retrieved
	@Override
	public List<Report> getAllReports() {
		log.info("Students Report");
		return reportRepository.findAll();
	}

	// Getting student report by Id
	@Override
	public Report getReportById(Long id) {
		log.info("Student Report by Id");
		return reportRepository.findById(id).get();
	}
}

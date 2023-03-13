package org.jacqulin.mathPractice.service;

import java.util.List;

import org.jacqulin.mathPractice.model.Report;

public interface ReportService {
	List<Report> getAllReports();

	Report getReportById(Long id);
}

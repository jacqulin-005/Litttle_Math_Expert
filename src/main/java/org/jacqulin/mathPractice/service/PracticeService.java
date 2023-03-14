package org.jacqulin.mathPractice.service;

import java.util.List;

import org.jacqulin.mathPractice.model.Practice;

public interface PracticeService {
	List<Practice> getQuestionByTopic(Long topicId);
}

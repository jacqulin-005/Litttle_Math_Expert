package org.jacqulin.mathPractice.service;

import org.jacqulin.mathPractice.model.Practice;

public interface PracticeService {
	Practice getQuestionByTopic(Long topicId);
}

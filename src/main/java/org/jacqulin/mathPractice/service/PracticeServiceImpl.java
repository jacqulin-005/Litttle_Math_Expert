package org.jacqulin.mathPractice.service;

import org.jacqulin.mathPractice.model.Practice;
import org.jacqulin.mathPractice.repository.PracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PracticeServiceImpl implements PracticeService {
	
	@Autowired
	private PracticeRepository practiceRepository;

	@Override
	public Practice getQuestionByTopic(Long topicId) {
		
		return practiceRepository.findQuestionsByTopicId(topicId);
	}

}

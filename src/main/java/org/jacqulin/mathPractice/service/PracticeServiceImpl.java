package org.jacqulin.mathPractice.service;

import java.util.List;

import org.jacqulin.mathPractice.model.Practice;
import org.jacqulin.mathPractice.repository.PracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PracticeServiceImpl implements PracticeService {

	@Autowired
	private PracticeRepository practiceRepository;

	// Getting questions by topic
	@Override
	public List<Practice> getQuestionByTopic(Long topicId) {
		log.info("Questions by Topic");
		System.out.println(topicId);
		return practiceRepository.findByTopicId(topicId);
	}
}
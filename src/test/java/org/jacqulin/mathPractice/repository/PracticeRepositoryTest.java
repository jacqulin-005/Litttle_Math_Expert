package org.jacqulin.mathPractice.repository;

import java.util.List;

import org.jacqulin.mathPractice.model.Practice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PracticeRepositoryTest {

	@Autowired
	private PracticeRepository practiceRepository;

	@Test
	public void testFindByTopicId() {

		final Long ID1 = (long) 10;

		List<Practice> actualPractice = practiceRepository.findByTopicId(ID1);

		Assertions.assertNotNull(actualPractice);
	}
	
}

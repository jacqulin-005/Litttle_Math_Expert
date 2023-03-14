package org.jacqulin.mathPractice.repository;

import org.jacqulin.mathPractice.model.Practice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PracticeRepository extends JpaRepository<Practice, Long> {
	@Query("select p from Practice p where p.topicId = ?1")
	Practice findQuestionsByTopicId(Long topicId);
}

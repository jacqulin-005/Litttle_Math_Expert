package org.jacqulin.mathPractice.repository;

import java.util.List;

import org.jacqulin.mathPractice.model.Practice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracticeRepository extends JpaRepository<Practice, Long> {
	//@Query("select p from Practice p where p.topicId = ?1")
	List<Practice> findByTopicId(Long topicId);
}

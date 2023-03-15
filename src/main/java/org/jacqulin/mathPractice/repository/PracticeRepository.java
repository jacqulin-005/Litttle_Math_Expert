package org.jacqulin.mathPractice.repository;

import java.util.List;

import org.jacqulin.mathPractice.model.Practice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracticeRepository extends JpaRepository<Practice, Long> {

	List<Practice> findByTopicId(Long topicId);
}

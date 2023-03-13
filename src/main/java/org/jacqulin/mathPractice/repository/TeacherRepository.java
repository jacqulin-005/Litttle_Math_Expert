package org.jacqulin.mathPractice.repository;

import org.jacqulin.mathPractice.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	Teacher findBytEmail(String email);
}

package org.jacqulin.mathPractice.repository;

import org.jacqulin.mathPractice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
package org.jacqulin.mathPractice.service;

import java.util.List;

import org.jacqulin.mathPractice.model.Student;

public interface StudentService {
	List<Student> getAllStudents();

	Student saveStudent(Student student);

	Student getStudentById(Long id);

	Student updateStudent(Student student);

	void deleteStudentById(Long id);
}

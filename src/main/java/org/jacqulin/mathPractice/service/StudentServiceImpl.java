package org.jacqulin.mathPractice.service;

import java.util.List;

import org.jacqulin.mathPractice.model.Student;
import org.jacqulin.mathPractice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	// Student Details
	@Override
	public List<Student> getAllStudents() {
		log.info("All Students");
		return studentRepository.findAll();
	}

	// Adding Student
	@Override
	public Student saveStudent(Student student) {
		log.info("Saving Student Details");
		return studentRepository.save(student);
	}

	// Getting student by Id
	@Override
	public Student getStudentById(Long id) {
		log.info("Getting student by Id");
		return studentRepository.findById(id).get();
	}

	// Updating student details
	@Override
	public Student updateStudent(Student student) {
		log.info("Updating student details");
		return studentRepository.save(student);
	}

	// Deleting the student
	@Override
	public void deleteStudentById(Long id) {
		log.info("Deleting the student");
		studentRepository.deleteById(id);
	}
}
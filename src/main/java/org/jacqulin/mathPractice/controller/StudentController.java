package org.jacqulin.mathPractice.controller;

import org.jacqulin.mathPractice.exception.StudentNotFoundException;
import org.jacqulin.mathPractice.model.Student;
import org.jacqulin.mathPractice.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class StudentController {

	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//Retrieving student list
	@GetMapping("/students")
	public String studentList(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		log.info("Student Details Retrieved");
		return "students";
	}
	
	//Adding new student
	@GetMapping("/students/new")
	public String showNewStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		log.info("New Student");
		return "new-student";
	}
	
	//List of students after adding new student
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		log.info("New List of Students Retrieved");
		return "redirect:/students";
	}

	//Retrieving student detail to update
	@GetMapping("/students/update/{id}")
	public String showUpdateStudent(@PathVariable Long id, Model model) {

		//Student student = studentService.getStudentById(id);
		model.addAttribute("student", studentService.getStudentById(id));
		log.info("Student Details to Update");
		return "update-student";	
	}
	
	//Updating student details
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {

		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setStudentId(id);
		existingStudent.setSFirstName(student.getSFirstName());
		existingStudent.setSLastName(student.getSLastName());
		existingStudent.setSUserName(student.getSUserName());
		existingStudent.setSPassword(student.getSPassword());

		studentService.updateStudent(existingStudent);
		log.info("Student Details Updated");
		return "redirect:/students";
	}
	
	//Deleting the Student
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		this.studentService.deleteStudentById(id);
		log.info("Student Deleted");
		return "redirect:/students";		
	}
	
}
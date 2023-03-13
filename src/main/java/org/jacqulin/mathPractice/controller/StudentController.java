package org.jacqulin.mathPractice.controller;

import org.jacqulin.mathPractice.model.Student;
import org.jacqulin.mathPractice.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public String studentList(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";

	}

	@GetMapping("/students/new")
	public String showNewStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "new-student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("//students/update/{id}")
	public String showUpdateStudent(@PathVariable Long id, Model model) {

		//Student student = studentService.getStudentById(id);
		model.addAttribute("student", studentService.getStudentById(id));
		return "update-student";	
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {

		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setStudentId(id);
		existingStudent.setSFirstName(student.getSFirstName());
		existingStudent.setSLastName(student.getSLastName());
		existingStudent.setSUserName(student.getSUserName());
		existingStudent.setSPassword(student.getSPassword());

		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		this.studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
	@GetMapping("/students/practice/{id}")
	public String practiceStudent(@PathVariable Long id) {
		return "practice";
	}
	
	@GetMapping("/students/report/{id}")
	public String reportStudent(@PathVariable Long id) {
		return "report";
	}
}
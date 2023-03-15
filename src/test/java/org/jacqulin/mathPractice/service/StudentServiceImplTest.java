package org.jacqulin.mathPractice.service;

import org.jacqulin.mathPractice.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentServiceImplTest {

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@Test
	public void testGetStudentById() {
		
		final Long ID1 = (long) 10;

		
		Student expectedStudent = new Student(ID1, "Queen", "King", "queen@king.com", "1234");
		
		Student actualStudent = studentServiceImpl.getStudentById(ID1);
		
		System.out.println(actualStudent.getSFirstName() + " " + actualStudent.getSLastName() +
				" " + actualStudent.getSUserName() + " " + actualStudent.getSPassword() );
		
		Assertions.assertNotNull(actualStudent);
	}
	
}

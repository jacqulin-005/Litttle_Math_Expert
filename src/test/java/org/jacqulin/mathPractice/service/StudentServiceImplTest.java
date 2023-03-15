package org.jacqulin.mathPractice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.jacqulin.mathPractice.model.Student;
import org.jacqulin.mathPractice.repository.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentServiceImplTest {
	
	@Mock
	private StudentRepository studentRepository;

	@InjectMocks
	private StudentServiceImpl studentServiceImpl;	

	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetStudentById() {

		final Long ID1 = (long) 10;

		when(((StudentServiceImpl) studentRepository).getStudentById(ID1))
				.thenReturn(new Student(ID1, "Queen", "King", "queen@king.com", "1234"));
		
		Student student = studentServiceImpl.getStudentById(ID1);
		
		assertEquals("Queen", student.getSFirstName());
		assertEquals("King", student.getSLastName());
		assertEquals("queen@king.com", student.getSUserName());
		assertEquals("1234", student.getSPassword());
	}
}

//public class StudentServiceImplTest {
//	
//	@Autowired
//	private StudentRepository StudentRepository;
//
//	@Test
//	public Student testGetStudentById() {
//		
//		final Long ID1 = (long) 10;
//		//Student student = new Student();
//		//StudentRepository studentRepository;;
//		
//		Student expectedStudent = new Student(ID1, "Queen", "King", "queen@king.com", "1234");
//		
//		Student actualStudent = new StudentServiceImpl(StudentRepository).getStudentById(ID1);
//		
//		System.out.println(actualStudent.getSFirstName() + " " + actualStudent.getSLastName() +
//				" " + actualStudent.getSUserName() + " " + actualStudent.getSPassword());
//				
//		Assertions.assertEquals(expectedStudent,actualStudent);
//		return actualStudent;
//	}
//}

package org.jacqulin.mathPractice.service;

import org.jacqulin.mathPractice.model.Teacher;
import org.jacqulin.mathPractice.repository.TeacherRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface TeacherService extends UserDetailsService {

	Teacher findByEmail(String email);

	Teacher save(TeacherRegistrationDto registration);

}

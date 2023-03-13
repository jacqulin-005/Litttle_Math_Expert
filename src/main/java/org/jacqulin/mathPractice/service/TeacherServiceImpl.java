package org.jacqulin.mathPractice.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.jacqulin.mathPractice.model.Role;
import org.jacqulin.mathPractice.model.Teacher;
import org.jacqulin.mathPractice.repository.TeacherRegistrationDto;
import org.jacqulin.mathPractice.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public Teacher findByEmail(String email) {
		return teacherRepository.findBytEmail(email);
	}

	public Teacher save(TeacherRegistrationDto registration) {
		Teacher teacher = new Teacher();
		teacher.settFirstName(registration.getFirstName());
		teacher.settLastName(registration.getLastName());
		teacher.settEmail(registration.getEmail());
		teacher.settPassword(passwordEncoder.encode(registration.getPassword()));
		teacher.setSchool(registration.getSchool());
		teacher.setRoles(Arrays.asList(new Role("ROLE_USER")));
		return teacherRepository.save(teacher);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Teacher teacher = teacherRepository.findBytEmail(email);
		if (teacher == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(teacher.gettEmail(), teacher.gettPassword(),
				mapRolesToAuthorities(teacher.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}

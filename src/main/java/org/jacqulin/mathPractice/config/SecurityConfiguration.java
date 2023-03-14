package org.jacqulin.mathPractice.config;

import org.jacqulin.mathPractice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.extern.slf4j.Slf4j;


@Configuration
@Slf4j
public class SecurityConfiguration {

	@Autowired
	private TeacherService teacherService;
	
	//Configuring security
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers("/Registration**", "/js/**", "/css/**", "/img/**", "/webjars/**")
				.permitAll().anyRequest().authenticated().and().formLogin().loginPage("/Login").permitAll().and()
				.logout().invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/Login?logout")
				.permitAll();
		log.info("Security Configured");
		return http.build();
	}
	
	//Encrypting the password
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		log.info("Password Encrypted");
		return new BCryptPasswordEncoder();
	}

	//DAO Authentication
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(teacherService);
		auth.setPasswordEncoder(passwordEncoder());
		log.info("Authentication Provided");
		return auth;
	}
}
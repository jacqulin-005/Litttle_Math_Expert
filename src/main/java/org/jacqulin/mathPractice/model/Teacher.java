package org.jacqulin.mathPractice.model;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "tEmail"))
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String tFirstName;
	private String tLastName;
	private String tEmail;
	private String tPassword;
	private String school;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "teachers_roles", joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles;
	
	@OneToMany(targetEntity = Student.class, cascade = { CascadeType.ALL })
	private List<Student> student;

	public Teacher() {
	}

	public Teacher(Long id, String tFirstName, String tLastName, String tEmail, String tPassword, String school) {
		super();
		this.id = id;
		this.tFirstName = tFirstName;
		this.tLastName = tLastName;
		this.tEmail = tEmail;
		this.tPassword = tPassword;
		this.school = school;
	}
	
	public Teacher(Long id, String tFirstName, String tLastName, String tEmail, String tPassword, String school,
			Collection<Role> roles, List<Student> student) {
		super();
		this.id = id;
		this.tFirstName = tFirstName;
		this.tLastName = tLastName;
		this.tEmail = tEmail;
		this.tPassword = tPassword;
		this.school = school;
		this.roles = roles;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String gettFirstName() {
		return tFirstName;
	}

	public void settFirstName(String tFirstName) {
		this.tFirstName = tFirstName;
	}

	public String gettLastName() {
		return tLastName;
	}

	public void settLastName(String tLastName) {
		this.tLastName = tLastName;
	}

	public String gettEmail() {
		return tEmail;
	}

	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}

	public String gettPassword() {
		return tPassword;
	}

	public void settPassword(String tPassword) {
		this.tPassword = tPassword;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", tFirstName=" + tFirstName + ", tLastName=" + tLastName + ", tEmail=" + tEmail
				+ ", tPassword=" + tPassword + ", school=" + school + ", roles=" + roles + ", student=" + student + "]";
	}
	
	
	
}
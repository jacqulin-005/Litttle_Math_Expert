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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	private String sFirstName;
	private String sLastName;
	private String sUserName;
	private String sPassword;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "students_topics", joinColumns = @JoinColumn(name = "studentId"), inverseJoinColumns = @JoinColumn(name = "topicId"))
	private Collection<Topic> topics;

	@OneToMany(targetEntity = Report.class, cascade = { CascadeType.ALL })
	private List<Report> reports;
}
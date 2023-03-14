package org.jacqulin.mathPractice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Practice {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long questionId;
	private Long topicId;
	private String question;
	private String answer;
}

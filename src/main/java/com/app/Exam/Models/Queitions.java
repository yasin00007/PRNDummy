package com.app.Exam.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Queitions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long queistionsId;
	
	private String answer;
	
	@Column(length = 5000)
	private String content;
	
	private String image;
	
	private String option1;
	
	private String option2;
	
	private String option3;
	
	private String option4;
	
	@ManyToOne 
	private Quize quize;

}

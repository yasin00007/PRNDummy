package com.app.Exam.Models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Quize {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long quizeid;
	
	private boolean active=false;
	
	private String title;
	
	private String maxMarks;
	
	private String description;
	
	private String noOfQuestions;
	
	@ManyToOne
	private Category category;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "quize")
	@JsonIgnore
	List<Queitions> queitions=new ArrayList<>();

}

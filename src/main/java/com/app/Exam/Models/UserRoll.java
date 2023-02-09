package com.app.Exam.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class UserRoll {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long userRollId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user; 
	
	@ManyToOne
	private Roles roles;
}

package com.app.Exam.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rollId;
	
	private String rollName; 
   
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	List<UserRoll> userRolls=new ArrayList<>();
	
//	@ManyToOne()
//	private User user;
	
}
  
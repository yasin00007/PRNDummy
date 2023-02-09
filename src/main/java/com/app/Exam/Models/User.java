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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	
	private String userName;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phone;
	
	private boolean enabled=true; 
	
	@OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER,mappedBy ="user")
	@JsonIgnore
	private List<UserRoll> userRolls=new ArrayList<>();

}

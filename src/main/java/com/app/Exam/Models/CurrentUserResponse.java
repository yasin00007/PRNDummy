package com.app.Exam.Models;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class CurrentUserResponse {
	private User user;
	
	private UserDetails userDetails;
	

}

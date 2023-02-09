package com.app.Exam.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.Exam.Models.User;
import com.app.Exam.Repo.UserRepo;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{
	@Autowired
	private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=this.userRepo.findUserByuserName(username);
		if (user==null) {
			throw new UsernameNotFoundException("User not found!!"); 
		}
		return new com.app.Exam.Security.UserDetails(user);
	}

}

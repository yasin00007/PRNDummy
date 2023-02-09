package com.app.Exam.Security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.app.Exam.Models.User;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails{
	User user=new User();

	public UserDetails(User user2) {
		this.user=user2;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
   return this.user.getUserRolls().stream().map(roll->new SimpleGrantedAuthority(roll.getRoles().getRollName())).collect(Collectors.toList());
		
	}

	@Override 
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}

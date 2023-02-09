package com.app.Exam.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.app.Exam.JwtConfig.JwtAuthenticationEntryPoint;
import com.app.Exam.JwtConfig.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	JwtRequestFilter jwtAuthenticationFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		 
	
		http
		.csrf().disable().cors().disable()
		.authorizeHttpRequests() 
		.requestMatchers("/Authenticate","/user/","/user/email").permitAll()
		.requestMatchers(HttpMethod.OPTIONS).permitAll()
		.anyRequest().authenticated()  
		.and()
		.exceptionHandling()
		.authenticationEntryPoint(jwtAuthenticationEntryPoint)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authenticationProvider(this.daoAuthenticationProvider());
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
	return  http.build();
		
	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.csrf().disable().cors()
//		.disable().authorizeHttpRequests().antMatchers("/Authenticate","/user/").permitAll()
//		.antMatchers(HttpMethod.OPTIONS).permitAll()
//		.anyRequest().authenticated() 
//		.and()
//		.exceptionHandling()
//		.authenticationEntryPoint(jwtAuthenticationEntryPoint)
//		.and()
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		
//		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//		}
//	
	@Bean  
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	} 
	

	 
	@Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception { 
        return authenticationConfiguration.getAuthenticationManager();
    }
	
	@Bean
	DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(this.userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
		return daoAuthenticationProvider;
	}

}

package com.app.Exam.JWtcontorler;

import java.security.Principal;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationManager;/
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.Exam.JwtConfig.JwtRequestFilter;
import com.app.Exam.JwtConfig.Jwtutil;
import com.app.Exam.Models.CurrentUserResponse;
import com.app.Exam.Models.JwtRequest;
import com.app.Exam.Models.JwtResponse;
import com.app.Exam.Models.User;
import com.app.Exam.Repo.UserRepo;
import com.app.Exam.Security.UserDetailsService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class JwtController {
	@Autowired
	private UserDetailsService userService;
	
	@Autowired
	private Jwtutil jwtutil;
	
	@Autowired
	 JwtRequestFilter jwtRequestFilter;
	
	@Autowired
   BCryptPasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepo userRepo;
	
	
	@PostMapping("/Authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)throws Exception {
		System.out.println(authenticationRequest.getUserName());
		final UserDetails userDetails = userService
				.loadUserByUsername(authenticationRequest.getUserName());
		System.out.println(authenticationRequest.getPassword());
		authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());

		 
		final String token = jwtutil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	
		
	public void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
	
 
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}catch (BadCredentialsException e) {
			e.printStackTrace();
			System.out.println("executed............");
			throw new Exception("INVALID_CREDENTIALS", e);
		}catch(AuthenticationException e){
			System.out.println(e);
			e.printStackTrace();
		}
	}
	  
	@GetMapping("/Current-User")
	public ResponseEntity<?> getuser(Principal principal) { 
		User user=this.userRepo.findUserByuserName(principal.getName());
		UserDetails userDetails=this.userService.loadUserByUsername(principal.getName());
		return new ResponseEntity<>(new CurrentUserResponse(user,userDetails),HttpStatus.CREATED);
	}


}
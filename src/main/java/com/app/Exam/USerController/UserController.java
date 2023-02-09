package com.app.Exam.USerController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Exam.EmailSenderService;
import com.app.Exam.Models.Mail;
import com.app.Exam.Models.Roles;
import com.app.Exam.Models.User;
import com.app.Exam.Models.UserRoll;
import com.app.Exam.Service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private	EmailSenderService emailSenderService;

	@Autowired
	private UserService userService;
	
	@Autowired
 private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		User user2=new User();
		user2.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		user2.setEmail(user.getEmail());
		user2.setFirstName(user.getFirstName());
		user2.setLastName(user.getLastName());
		user2.setPhone(user.getPhone());
		user2.setUserName(user.getUserName());
//		
		Roles roll=new Roles();
		//roll.setRollId(46L);
		roll.setRollName("NORMAL");
		
		
		//user.setUserRolls(list);
		
		List<UserRoll> list=new ArrayList<>();
		UserRoll userRoll=new UserRoll();
		userRoll.setRoles(roll);
		userRoll.setUser(user2); 
		list.add(userRoll);
		roll.setUserRolls(list);
		
		
		 User local=this.userService.CreateUser(user2,list);
	 
	 return local;
	}
	
	@GetMapping("/{username}")
	private User getUserByName(@PathVariable("username") String username) {
	User user=this.userService.getUserByName(username);
	return user;
	}
	
//	@GetMapping("/{id}")
//	private User deleteUser(@PathVariable("id") Long id) throws Exception {
//	User user=this.userService.deleteUserbyid(id);
//	return user;
//	}
	
	
	@PostMapping("/email")
private Mail responseEntity(@RequestBody User user){
		System.out.println("mail service Ececuted");
		this.emailSenderService.sendEmail(user.getEmail(), "About the Registration of the Quize-Server","Your Account for an quize service registered !!"
				+ "With Username :"+user.getUserName()+" and phone: "+user.getPhone()+" thnak you "+user.getFirstName()+" "+user.getLastName()+" for registering with Quize Server !!");
		return new Mail("User Registered to email "+user.getEmail());
		
	} 
}

package com.app.Exam.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Exam.Models.User;
import com.app.Exam.Models.UserRoll;
import com.app.Exam.Repo.RollRepo;
import com.app.Exam.Repo.UserRepo;
import com.app.Exam.Service.UserService;
import com.app.Exam.helper.UserfoundException;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepo userRepo;
	
	@Autowired   
	RollRepo rollRepo;   
	
	
	@Override
	public User CreateUser(User user,List<UserRoll> userRolls) throws Exception {
		User local=this.userRepo.findUserByuserName(user.getUserName());
		if (local!=null) {
			throw new UserfoundException("User With UserName ALready Present");
		}
		else { 
			for (UserRoll userRoll : userRolls) {
				this.rollRepo.save(userRoll.getRoles());
			}
//			user.setUserRolls(userRolls);
			user.getUserRolls().addAll(userRolls);
			local=this.userRepo.save(user);
			 
		} 
		   
		return local;
	}
	
	@Override
	public User getUserByName(String username) {
	User user=this.userRepo.findUserByuserName(username);
		return user;
	}
@Override
	public User deleteUserbyid(Long id) throws Exception {
	User user=this.userRepo.findById(id).orElseThrow(()->new Exception("user not found")); 
		return user;
	}
} 

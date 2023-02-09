package com.app.Exam.Service;

import java.util.List;

import com.app.Exam.Models.User;
import com.app.Exam.Models.UserRoll;

public interface UserService {
	
	 User CreateUser(User user,List<UserRoll> userRolls ) throws Exception;

	User getUserByName(String username);
	
	User deleteUserbyid(Long id) throws Exception;
}

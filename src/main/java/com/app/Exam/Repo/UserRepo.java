package com.app.Exam.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.app.Exam.Models.User;

public interface UserRepo extends JpaRepository<User,Long>{

	User findUserByuserName(String userName);

}
 
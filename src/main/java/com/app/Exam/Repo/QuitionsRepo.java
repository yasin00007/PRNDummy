package com.app.Exam.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Exam.Models.Queitions;
import com.app.Exam.Models.Quize;

public interface QuitionsRepo extends JpaRepository<Queitions, Long>{

	List<Queitions> findByQuize(Quize quize);
	 
	//List<Queitions> findQuestionsByQuize(Quize quize);
 
}


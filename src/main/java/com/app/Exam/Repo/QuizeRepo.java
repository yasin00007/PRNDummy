package com.app.Exam.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Exam.Models.Category;
import com.app.Exam.Models.Quize;

public interface QuizeRepo extends JpaRepository<Quize, Long> {

//	Quize findQuizeByCategory(Category category);

//	Quize findquizeByCategory(Category category);

	List<Quize> findQuizeByCategory(Category category);

//	Optional<Quize> findbyQuize(Quize quize);
	
	//for Active Users
	List<Quize> findQuizeByActive(Boolean a);
	
	List<Quize> findQuizeByCategoryAndActive(Category c,Boolean a);

}

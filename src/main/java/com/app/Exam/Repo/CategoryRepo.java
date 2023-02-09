package com.app.Exam.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Exam.Models.Category;
import com.app.Exam.Models.Quize;

public interface CategoryRepo extends JpaRepository<Category, Long>{

//	void deleteByQuize(Quize quize);
 
}

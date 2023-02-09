package com.app.Exam.Service;

import java.util.List;

import com.app.Exam.Models.Category;
import com.app.Exam.Models.Quize;

public interface CategoryService {

	public Category addCategory(Category category);
	
	public Category UpdateCategory(Category category);
	
	public List<Category> getcatagories();
	
	
	public Category getcategoryByID(Long categoryId) throws Exception;
	
	public Category deleCategoryById(Long categoryId) throws Exception;
	
	
}

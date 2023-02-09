package com.app.Exam.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Exam.Models.Category;
import com.app.Exam.Repo.CategoryRepo;
import com.app.Exam.Repo.QuizeRepo;
import com.app.Exam.Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo categoryRepo;


	@Override
	public Category addCategory(Category category) {
		Category category2=this.categoryRepo.save(category);
		return category2; 
	}

	@Override
	public Category UpdateCategory(Category category) {
	Category category2=this.categoryRepo.save(category);
		return category2;
	}

	@Override
	public List<Category> getcatagories() {
	List<Category> categories=this.categoryRepo.findAll();
		return categories;
	}

	@Override
	public Category getcategoryByID(Long categoryId) throws Exception {
	Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new Exception("categroy Not Found "));
		return category;
	}

	@Override
	public Category deleCategoryById(Long categoryId) throws Exception {
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new Exception("categroy Not Found "));
		this.categoryRepo.delete(category);
		return category;
	}

}

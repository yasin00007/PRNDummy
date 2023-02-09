package com.app.Exam.USerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Exam.Models.Category;
import com.app.Exam.Service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public Category addCategory(@RequestBody Category category) {
	Category category2=this.categoryService.addCategory(category);
	return category2;
	}
	

	@PutMapping("/")
	public Category UpdateCategory(@RequestBody Category category) {
	Category category2=this.categoryService.UpdateCategory(category);
	return category2;
	}
	

	@GetMapping("/")
	public List<Category> getAllCategories() {
	List<Category> category2=this.categoryService.getcatagories();
	return category2;
	}
	
	

	@GetMapping("/{id}")
	public Category getcategoryById(@PathVariable("id") Long Categoryid) throws Exception {
	Category category2=this.categoryService.getcategoryByID(Categoryid);
	return category2;
	}
	

	@DeleteMapping("/{id}")
	public Category deleteCategory(@PathVariable("id") Long Categoryid) throws Exception {
	Category category2=this.categoryService.deleCategoryById(Categoryid);
	return category2;
	}
	
	

}

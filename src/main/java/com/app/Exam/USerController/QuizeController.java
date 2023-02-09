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
import com.app.Exam.Models.Quize;
import com.app.Exam.Service.QuizeService;

@RequestMapping("/quize")
@RestController
@CrossOrigin("*")
public class QuizeController {
	@Autowired
	private QuizeService quizeService;
	
	@PostMapping("/")
	public Quize addQuize(@RequestBody Quize quize) {
		Quize quize2=this.quizeService.addQuize(quize);
		return quize2;
	}
	@PutMapping("/")
	public Quize updateQuize(@RequestBody Quize quize) {
		Quize quize2=this.quizeService.Update(quize);
		return quize2;
	}
	@GetMapping("/{id}")
	public Quize getquQuize(@PathVariable("id") Long quizeId) throws Exception {
		Quize quize2=this.quizeService.getQuizeById(quizeId);
		return quize2;
	}
	@GetMapping("/")
	public List<Quize> getQuize() {
		List<Quize> quize2=this.quizeService.getAllQuize();
		return quize2;
	}
	
	@DeleteMapping("/{id}")
	public Quize delete(@PathVariable("id") Long quize) throws Exception {
		Quize quize2=this.quizeService.deleteQuizeById(quize);
		System.out.println(quize);
		return quize2;
	}

	@GetMapping("/cat/{id}")
	public List<Quize> getQuizeByCategoryId(@PathVariable("id") Long id) {
		Category category=new Category();
		category.setCatagoryId(id);
		List<Quize> quize=this.quizeService.getQuizeByCategory(category);
//		System.out.println(quize);
		return quize; 
	}
	
	@GetMapping("/cat/active/{id}")
	public List<Quize> getQuizeByCategoryIdActice(@PathVariable("id") Long id) {
		Category category=new Category();
		category.setCatagoryId(id);
		List<Quize> quize=this.quizeService.findQuizeBycategoryAndActive(category);
//		System.out.println(quize);
		return quize; 
	}
	@GetMapping("/active")
	public List<Quize> getActiveCategory() {
		List<Quize> quize2=this.quizeService.findAllAciveQuize();
		return quize2;
	}
	
}

package com.app.Exam.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Exam.Models.Category;
import com.app.Exam.Models.Quize;
import com.app.Exam.Repo.CategoryRepo;
import com.app.Exam.Repo.QuizeRepo;
import com.app.Exam.Service.QuizeService;

@Service
public class QuizeServiceImpl implements QuizeService{
	@Autowired
 private QuizeRepo quizeRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Quize addQuize(Quize quize) {
		Quize quize2=this.quizeRepo.save(quize);
		return quize2;
	}

	@Override
	public Quize Update(Quize quize) {
		Quize quize2=this.quizeRepo.save(quize);
		return quize2;
	}

	@Override
	public List<Quize> getAllQuize() {
		List<Quize> quizes=this.quizeRepo.findAll();
		return quizes;
	}

	@Override
	public Quize getQuizeById(Long quizeId) throws Exception {
		Quize quize=this.quizeRepo.findById(quizeId).orElseThrow(()->new Exception("Quize with this id not found"));
		return quize;
	}

	@Override
	public Quize deleteQuizeById(Long quizeId) throws Exception {
		Quize quize=this.quizeRepo.findById(quizeId).orElseThrow(()->new Exception("Quize with this id not found"));
		
//		this.categoryRepo.deleteByQuize(quize);
		this.quizeRepo.delete(quize); 
//		System.out.println(quize);
		return quize;
	}
	@Override
	public List<Quize> getQuizeByCategory(Category category) {
		List<Quize> quize=this.quizeRepo.findQuizeByCategory(category);
//		System.out.println(quize);
		return quize;
	} 
	
	//find Active Quize 
	public List<Quize> findAllAciveQuize(){
		return this.quizeRepo.findQuizeByActive(true);
	}

	public List<Quize> findQuizeBycategoryAndActive(Category category){
		return this.quizeRepo.findQuizeByCategoryAndActive(category,true);
	}
	
}

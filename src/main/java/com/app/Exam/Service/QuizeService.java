package com.app.Exam.Service;

import java.util.List;

import com.app.Exam.Models.Category;
import com.app.Exam.Models.Quize;

public interface QuizeService {
		public Quize addQuize(Quize quize);
		
		public Quize Update(Quize quize);
		
		public List<Quize> getAllQuize();
		
		
		public Quize getQuizeById(Long quizeId)throws Exception;
		
		
		public Quize deleteQuizeById(Long quizeId) throws Exception;

		public List<Quize> getQuizeByCategory(Category category);
		
		List<Quize> findAllAciveQuize();
		
		List<Quize> findQuizeBycategoryAndActive(Category category);
}

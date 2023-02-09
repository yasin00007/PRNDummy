package com.app.Exam.Service;

import java.util.List;

import com.app.Exam.Models.Queitions;
import com.app.Exam.Models.Quize;

public interface QueitionService {
	public Queitions addQuition(Queitions question);
	
	public Queitions Update(Queitions queitions);
	
	public List<Queitions> getAllQueitions();
	
	public Queitions getByID(Long id)throws Exception;
	
	public Queitions deleteById(Long id)throws Exception;
	
	//public List<Queitions> getQueitionsofQuize( quize) throws Exception;

	List<Queitions> getQueitionsofQuize(Quize quize) throws Exception;
}

package com.app.Exam.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Exam.Models.Queitions;
import com.app.Exam.Models.Quize;
import com.app.Exam.Repo.QuitionsRepo;
import com.app.Exam.Repo.QuizeRepo;
import com.app.Exam.Service.QueitionService;

@Service
public class QueistionsServiceImpl implements QueitionService{
	@Autowired
	private QuitionsRepo quitionsRepo;
	
	@Autowired
	private QuizeRepo quizeRepo;

	@Override
	public Queitions addQuition(Queitions queitions) {
		Queitions queitions2=this.quitionsRepo.save(queitions);
		return queitions2;
	}

	@Override
	public Queitions Update(Queitions queitions) {
		Queitions queitions2=this.quitionsRepo.save(queitions);
		return queitions2; 
	}

	@Override
	public List<Queitions> getAllQueitions() {
		List<Queitions> queitions=this.quitionsRepo.findAll();
		return queitions;
	}

	@Override
	public Queitions getByID(Long id) throws Exception {
	Queitions quiQueitions=	this.quitionsRepo.findById(id).orElseThrow(()->new Exception("Quiestion Not Found With That Id"));
		return quiQueitions;
	}
 
	@Override
	public List<Queitions> getQueitionsofQuize(Quize quize) throws Exception { 
		List<Queitions> quizes=this.quitionsRepo.findByQuize(quize);
		return quizes;
	}
 @Override
public Queitions deleteById(Long id) throws Exception {
	 Queitions quiQueitions=	this.quitionsRepo.findById(id).orElseThrow(()->new Exception("Quiestion Not Found With That Id"));
	 this.quitionsRepo.delete(quiQueitions);
	return quiQueitions;
}
	
}

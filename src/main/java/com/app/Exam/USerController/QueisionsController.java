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

import com.app.Exam.EmailSenderService;
import com.app.Exam.Models.Queitions;
import com.app.Exam.Models.Quize;
import com.app.Exam.Service.QueitionService;
import com.app.Exam.Service.QuizeService;

@RequestMapping("/queition")
@RestController
@CrossOrigin("*")
public class QueisionsController {
	@Autowired
	private	EmailSenderService emailSenderService;

	@Autowired
	private QueitionService queitionService;
	
	@Autowired
	private QuizeService quizeService;
	
	@PostMapping("/")
	public Queitions addQueistions(@RequestBody Queitions question) {
		Queitions question2=this.queitionService.addQuition(question);
		return question2;
	}
	@PutMapping("/")
	public Queitions update(@RequestBody Queitions question) {
		Queitions question2=this.queitionService.Update(question);
		return question2;
	}
	 
	@GetMapping("/")
	public List<Queitions> getAllQueitions() {
		List<Queitions> question2=this.queitionService.getAllQueitions();
		return question2;
	}
	@GetMapping("/id")
	public Queitions getQueitions(@PathVariable("id") Long id) throws Exception {
		Queitions question2=this.queitionService.getByID(id);
		return question2;
	}
	@GetMapping("/quize/{id}")
	public List<Queitions> getQueitionByQuize(@PathVariable("id") Long quize) throws Exception {
//		Quize quize2=new Quize();
//		quize2.setQuizeid(quize);
//		List<Queitions> queitions=this.queitionService.getQueitionsofQuize(quize2);
	
		Quize quize2=this.quizeService.getQuizeById(quize);
		
	List<Queitions> queitions=quize2.getQueitions();   
	
	if (queitions.size()>Integer.parseInt(quize2.getNoOfQuestions())) {
		queitions=queitions.subList(0, Integer.parseInt(quize2.getNoOfQuestions()));
	
	}
		
		return queitions;
	}
	
	@DeleteMapping("/{id}")
	public Queitions deleteQueistion(@PathVariable("id") Long id) throws Exception {
	Queitions queitions=this.queitionService.deleteById(id);
	return queitions;
		
	}
}

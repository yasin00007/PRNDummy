package com.app.Exam.Models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long catagoryId;
	
	private String title;
	
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
	@JsonIgnore
	private List<Quize> quizes=new ArrayList<>();

}

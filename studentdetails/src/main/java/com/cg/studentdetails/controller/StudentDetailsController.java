package com.cg.studentdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cg.studentdetails.document.StudentDetails;
import com.cg.studentdetails.repository.StudentDetailsRepository;

@RestController
public class StudentDetailsController {
	
	@Autowired
	private StudentDetailsRepository repository;
	
	public List<StudentDetails> getAllDetails()
	{
		List<StudentDetails> details = repository.findAll();
		return  details;
	}	

}

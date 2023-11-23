package com.cg.studentdetails.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.studentdetails.document.StudentDetails;
import com.cg.studentdetails.repository.StudentDetailsRepository;

@RestController
public class StudentDetailsController {
	
	@Autowired
	private StudentDetailsRepository repository;
	
	@GetMapping
	public List<StudentDetails> getAllDetails()
	{
		List<StudentDetails> details = repository.findAll();
		return  details;
	}	
	@PostMapping
	public StudentDetails AddStudentDetails(@RequestBody StudentDetails studentDetails)
	{
		StudentDetails detail = repository.save(studentDetails);
		return  detail;
	}
	
	@PutMapping("/{id}")
	public StudentDetails updateStudentDetails(@PathVariable Integer id,@RequestBody StudentDetails student)
	{
		Optional<StudentDetails> optional = repository.findById(id);
		
		if(optional.isPresent()) {
			StudentDetails details = optional.get();
			details.setName(student.getName());
			details.setAge(student.getAge());
			details.setSalary(student.getSalary());
			
			StudentDetails updatedDetails = repository.save(details);
			return updatedDetails;
		}		
		
		return  null;
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudentDetails(@PathVariable Integer id)
	{
		repository.deleteById(id);
		return "Details successfully deleted!";
		
	}

}

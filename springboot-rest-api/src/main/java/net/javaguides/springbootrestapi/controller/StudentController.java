package net.javaguides.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springbootrestapi.entity.Student;

@RestController
@RequestMapping("/students")
public class StudentController {
	
		
	@GetMapping
	public ResponseEntity<List<Student>>  getAllStudents(){
		List<Student> students = new ArrayList<>();
		
		students.add(new Student(1,"Intekhab", "Alam"));
		students.add(new Student(2,"Umesh", "Yadav"));
		students.add(new Student(3,"Ram", "Jadhav"));
		students.add(new Student(4,"Sanjay", "Kumar"));
		
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/{first-name}/{last-name}")
	public ResponseEntity<Student>  getStudentById(@PathVariable Integer id,@PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName) {
		Student student = new Student(
				id,
				firstName,
				lastName);
		return new ResponseEntity<Student>(student,HttpStatus.OK);					
	}
	@GetMapping("/query")
	public Student studentRequestVariable(@RequestParam Integer id){
		return new Student(id,"Inekhab", "Alam");
	}
	
	@PostMapping("/create")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());

		return new ResponseEntity<Student>(student,HttpStatus.CREATED);					
	}
	@PutMapping("/{id}/update")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer id,@RequestBody Student student) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return new ResponseEntity<Student>(student,HttpStatus.OK);					
	} 
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
		return new ResponseEntity<String>("Student deleted successfully!", HttpStatus.OK);
	}

}

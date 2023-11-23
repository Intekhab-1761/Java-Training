package com.cg.studentdetails.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.studentdetails.document.StudentDetails;
import com.cg.studentdetails.repository.StudentDetailsRepository;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class StudentDetailsControllerTest {

	@Mock
	private StudentDetailsRepository repository;
	@InjectMocks
	private StudentDetailsController controller;
	
	private List<StudentDetails> students;
	
	@BeforeAll
	void setup() {
		
		 students = List.of(
				new StudentDetails(1,"John","32","5000"),
				new StudentDetails(2,"Smith","43","6000")
				);
	}
	
	@Test
	void getAllDetailsTest() {
		when(repository.findAll()).thenReturn(students);
		assertThat(controller.getAllDetails()).hasSameElementsAs(students);
	}
	
	@Test
	void AddStudentDetailsTest() {
		StudentDetails student = new StudentDetails(4,"Intekhab","30","8000");
		when(repository.save(student)).thenReturn(student);
		assertEquals(controller.AddStudentDetails(student).getName(),(student.getName()));
	}
	
	@Test
	void updateStudentDetailsTest() {
		Optional<StudentDetails > student = Optional.of(new StudentDetails(4,"Intekhab","30","8000"));
		when(repository.findById(4)).thenReturn(student);
		when(repository.save(student.get())).thenReturn(student.get());
		assertEquals(controller.updateStudentDetails(4,student.get()).getName(),(student.get().getName()));
	}
	
	@Test
	void deleteStudentDetailsTest() {
		String str = "Details successfully deleted!"; 
		//when(repository.deleteById(1)).thenReturn(str);
		assertEquals(controller.deleteStudentDetails(1),str);
	}

}

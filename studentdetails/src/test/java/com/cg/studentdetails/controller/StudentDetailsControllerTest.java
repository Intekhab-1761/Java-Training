package com.cg.studentdetails.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.studentdetails.document.StudentDetails;
import com.cg.studentdetails.repository.StudentDetailsRepository;

@ExtendWith(MockitoExtension.class)
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
		assertThat(repository.findAll()).hasSameElementsAs(students);
	}

}

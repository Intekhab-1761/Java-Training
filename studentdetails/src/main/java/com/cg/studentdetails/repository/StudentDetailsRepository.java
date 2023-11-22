package com.cg.studentdetails.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.studentdetails.document.StudentDetails;

public interface StudentDetailsRepository extends MongoRepository<StudentDetails, Integer>{

}

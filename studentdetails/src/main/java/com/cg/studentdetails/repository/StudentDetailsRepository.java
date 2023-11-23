package com.cg.studentdetails.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.studentdetails.document.StudentDetails;

@Repository
public interface StudentDetailsRepository extends MongoRepository<StudentDetails, Integer>{

}

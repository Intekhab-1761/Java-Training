package com.cg.springbootrestfulwebservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.springbootrestfulwebservices.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

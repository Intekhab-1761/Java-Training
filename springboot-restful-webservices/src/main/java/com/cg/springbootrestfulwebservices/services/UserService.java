package com.cg.springbootrestfulwebservices.services;

import java.util.List;

import com.cg.springbootrestfulwebservices.dto.UserDto;


public interface UserService {

	UserDto createUser(UserDto user);
	
	UserDto getUserById(Long id);
	
	List<UserDto> getAllUsers();
	
	UserDto updateUser(UserDto userDto);
	
	void deleteUser(Long id);
}

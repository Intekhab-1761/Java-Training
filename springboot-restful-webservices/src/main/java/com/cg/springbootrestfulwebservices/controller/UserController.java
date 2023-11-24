package com.cg.springbootrestfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.springbootrestfulwebservices.dto.UserDto;
import com.cg.springbootrestfulwebservices.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@Tag(
	name = "CRUD REST APIs for User Resource",
	description = "CRUD REST APIs - Create User, Update user, Get User, Get All Users, Delete Users"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Operation(summary = "Create User REST API",
			description = "Create User REST API is used to save user in database.")
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 CREATED"
			)
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto user){
		UserDto savedUser = userService.createUser(user);
		return new ResponseEntity<UserDto>(savedUser, HttpStatus.CREATED);
	}
	@Operation(summary = "Get User BY ID REST API",
			description = "Get User By Id REST API is used to get single user from database.")
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
			)
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
		UserDto user = userService.getUserById(id);
		return new ResponseEntity<UserDto>(user, HttpStatus.OK);
	}
	@Operation(summary = "Get all Users REST API",
			description = "Get all Users REST API is used to get all users from database.")
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
			)
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> users = userService.getAllUsers();
		return new ResponseEntity<List<UserDto>>(users,HttpStatus.OK);
	}
	@Operation(summary = "Update User by id REST API",
			description = "Update User By Id REST API is used to update single user in the database.")
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
			)
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody @Valid UserDto user) {
		UserDto updatedUser = userService.updateUser(user);
		return new ResponseEntity<UserDto>(updatedUser, HttpStatus.OK);
	}
	@Operation(summary = "Delete User BY ID REST API",
			description = "Delete User By Id REST API is used to delete single user from database.")
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCESS"
			)
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return new ResponseEntity<String>("User deleted successfully!", HttpStatus.OK);
	}
	
}

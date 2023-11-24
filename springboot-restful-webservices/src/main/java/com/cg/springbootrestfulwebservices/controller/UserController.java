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

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto user){
		UserDto savedUser = userService.createUser(user);
		return new ResponseEntity<UserDto>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
		UserDto user = userService.getUserById(id);
		return new ResponseEntity<UserDto>(user, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> users = userService.getAllUsers();
		return new ResponseEntity<List<UserDto>>(users,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody @Valid UserDto user) {
		UserDto updatedUser = userService.updateUser(user);
		return new ResponseEntity<UserDto>(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return new ResponseEntity<String>("User deleted successfully!", HttpStatus.OK);
	}
	
}

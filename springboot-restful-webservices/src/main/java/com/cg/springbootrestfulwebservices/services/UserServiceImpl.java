package com.cg.springbootrestfulwebservices.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springbootrestfulwebservices.dto.UserDto;
import com.cg.springbootrestfulwebservices.entities.User;
import com.cg.springbootrestfulwebservices.mapper.UserMapper;
import com.cg.springbootrestfulwebservices.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto user) {
		
		User user1 = UserMapper.mapToUser(user);
		
		User savedUser = userRepository.save(user1);
		
		UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
		return savedUserDto;
	}

	@Override
	public UserDto getUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if(optionalUser.isEmpty()) {
			return null;
		}
		User user = optionalUser.get();
		UserDto userDto = UserMapper.mapToUserDto(user);
		return userDto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		
		return users.stream()
				.map(UserMapper::mapToUserDto)
				.collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto user) {
		User existingUser = userRepository.findById(user.getId()).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		
		User updatedUser = userRepository.save(existingUser);
		UserDto updatedUserDto = UserMapper.mapToUserDto(updatedUser);
		return updatedUserDto;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);		
	}

}

package com.cg.springbootrestfulwebservices.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springbootrestfulwebservices.dto.UserDto;
import com.cg.springbootrestfulwebservices.entities.User;
import com.cg.springbootrestfulwebservices.exception.EmailAlreadyExistException;
import com.cg.springbootrestfulwebservices.exception.ResourceNotFoundException;
import com.cg.springbootrestfulwebservices.mapper.UserMapper;
import com.cg.springbootrestfulwebservices.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	private ModelMapper mapper;

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
		
		if(optionalUser.isPresent()) {
			throw new EmailAlreadyExistException("Email already exist for user!");
		}
		//User user1 = UserMapper.mapToUser(user);
		User user1 = mapper.map(userDto, User.class);

		
		User savedUser = userRepository.save(user1);
		
		UserDto savedUserDto =mapper.map(savedUser, UserDto.class);
		return savedUserDto;
	}

	@Override
	public UserDto getUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("user", "id", id)
				);
		
		//User user = optionalUser.get();
		UserDto userDto = mapper.map(user,UserDto.class);
		return userDto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		
//		return users.stream()
//				.map(UserMapper::mapToUserDto)
//				.collect(Collectors.toList());
		
		return users.stream()
				.map(user -> mapper.map(user, UserDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto user) {
		User existingUser = userRepository.findById(user.getId()).orElseThrow(
				() -> new ResourceNotFoundException("user", "id", user.getId())
				);
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		
		User updatedUser = userRepository.save(existingUser);
		UserDto updatedUserDto = mapper.map(updatedUser,UserDto.class);
		return updatedUserDto;
	}

	@Override
	public void deleteUser(Long id) {
		
		userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("user", "id", id)
				);
		userRepository.deleteById(id);		
	}

}

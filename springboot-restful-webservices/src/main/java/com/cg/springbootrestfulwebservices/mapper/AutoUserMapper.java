package com.cg.springbootrestfulwebservices.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cg.springbootrestfulwebservices.dto.UserDto;
import com.cg.springbootrestfulwebservices.entities.User;

@Mapper
public interface AutoUserMapper {
	
	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

	UserDto mapToUserDto(User user);
	
	User mapToUser(UserDto userSto);
	
}

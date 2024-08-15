package com.cg.springbootrestfulwebservices.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private Long id;
	@NotEmpty(message = "User first name must not be empty.")
	private String firstName;
	@NotEmpty(message = "User last name must not be empty.")
	private String lastName;
	@NotEmpty(message = "User email must not be empty or null.")
	@Email
	private String email;
}

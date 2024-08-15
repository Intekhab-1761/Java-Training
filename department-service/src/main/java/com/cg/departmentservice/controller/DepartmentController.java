package com.cg.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.departmentservice.dto.DepartmentDto;
import com.cg.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("api/departments")
public class DepartmentController {

	private DepartmentService service;
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
		DepartmentDto savedDepartment = service.saveDepartment(departmentDto);
		return new ResponseEntity<DepartmentDto>(savedDepartment, HttpStatus.CREATED);
	}
	
	@GetMapping("/{department-code}")
	public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String code){
		DepartmentDto departmentDto = service.getDepartmentByCode(code);
		return new ResponseEntity<DepartmentDto>(departmentDto, HttpStatus.OK);
	}
}

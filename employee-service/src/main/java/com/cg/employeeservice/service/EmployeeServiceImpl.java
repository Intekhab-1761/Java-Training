package com.cg.employeeservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.cg.employeeservice.dto.EmployeeDto;
import com.cg.employeeservice.entity.Employee;
import com.cg.employeeservice.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository repository;
	
	private ModelMapper mapper;
		
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = mapper.map(employeeDto, Employee.class);
		var savedEmployee = repository.save(employee);
		return mapper.map(savedEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {
		Employee employee = repository.findById(id).get();
		return mapper.map(employee, EmployeeDto.class);
	}

	
}

package com.cg.departmentservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.departmentservice.dto.DepartmentDto;
import com.cg.departmentservice.entity.Department;
import com.cg.departmentservice.repository.DepartmentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository repository;
	@Autowired
	private ModelMapper mapper;
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		Department department = mapper.map(departmentDto, Department.class);
		var savedDepartment = repository.save(department);	
		return mapper.map(savedDepartment, DepartmentDto.class);
	}
	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		Department department =  repository.findByDepartmentCode(departmentCode);
		DepartmentDto departmentDto = mapper.map(department, DepartmentDto.class);
		return departmentDto;
	}

}

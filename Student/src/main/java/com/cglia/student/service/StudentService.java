package com.cglia.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglia.student.dto.StudentDTO;
import com.cglia.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository stdRepo;

	public StudentDTO saveStudent(StudentDTO std) {
		return stdRepo.save(std);
	}

	public java.util.List<StudentDTO> getAll() {
		return stdRepo.findAll();
	}

	public StudentDTO getOne(Integer id) {
		return stdRepo.findById(id).orElse(null);
	}

	public int deleteById(Integer id) {
		if (id != null) {
			stdRepo.deleteById(id);
			return 1;
		} else
			return 0;
	}
	
	public StudentDTO updateById( StudentDTO std)
	{
		return stdRepo.save(std);
	}
}

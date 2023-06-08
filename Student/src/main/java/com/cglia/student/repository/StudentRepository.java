package com.cglia.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cglia.student.dto.StudentDTO;

@Repository
public interface StudentRepository extends JpaRepository<StudentDTO, Integer> {
	   StudentDTO findByUserName(String userName);
}

package com.cglia.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.student.dto.AuthRequest;
import com.cglia.student.dto.StudentDTO;
import com.cglia.student.service.StudentService;
import com.cglia.student.util.JwtUtil;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/save")
	public String saveStudent(@RequestBody StudentDTO std) {
		StudentDTO newStd = service.saveStudent(std);
		if (newStd != null) {
			return "Save Details";
		} else {
			return "failed";
		}
	}

	@GetMapping("/getAll")
	public List<StudentDTO> getAll() {
		return service.getAll();
	}

	@GetMapping("/getById/{id}")
	public StudentDTO getById(@PathVariable int id) {
		return service.getOne(id);
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id) {
		int result = service.deleteById(id);
		if (result >= 1)
			return "Delete Successfull";
		else
			return "Failed";
	}

	@PutMapping("/updateById")
	public String updateStudent(@RequestBody StudentDTO std) {
		StudentDTO newStd = service.updateById(std);
		if (newStd != null) {
			return "update Details";
		} else {
			return "failed";
		}
	}
    
	@Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private AuthenticationManager authenticationManager;
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}

}

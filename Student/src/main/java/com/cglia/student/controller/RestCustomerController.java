package com.cglia.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cglia.student.dto.RestCustomerDTO;

@RestController
@RequestMapping("/rest")
public class RestCustomerController {
	private final RestTemplate restTemplate;

	@Autowired
	public RestCustomerController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("/customer")
	public String getAllCustomerData() {
		String url = "http://192.168.60.51:8080/api/customers";
		String response = restTemplate.getForObject(url, String.class);
		return response;
	}

	@GetMapping("/customer/{id}")
	public String getById(@PathVariable int id) {
		String url = "http://192.168.60.51:8080/api/customers/" + id;
		String response = restTemplate.getForObject(url, String.class);
		return response;
	}

	@PostMapping("/customer")
	public String saveCustomer(@RequestBody RestCustomerDTO customer) {
		String url = "http://192.168.60.51:8080/api/customers";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Create the request entity with the requestData as the body and headers
		HttpEntity<RestCustomerDTO> requestEntity = new HttpEntity<>(customer, headers);
		String response = restTemplate.postForObject(url, requestEntity, String.class);
		return response;

	}
	
	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@PathVariable int id)
	{
		String url="http://192.168.60.51:8080/api/customers/"+id;
		restTemplate.delete(url);
		return "deleted";
	}
}

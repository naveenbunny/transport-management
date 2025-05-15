package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CustomerDto;
import com.example.response.CustomerResponse;
import com.example.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerServicee;
	

	public void setCustomerServicee(CustomerService customerServicee) {
		this.customerServicee = customerServicee;
	}

	@PostMapping("/add/{aid}")
	public CustomerResponse addCustomer(@PathVariable(value = "aid")Long aid,@RequestBody CustomerDto dto) {
		return customerServicee.addCustomer(dto, aid);
	}
	
	@GetMapping("/all")
	public List<CustomerResponse> getAllCustomers() {
		return customerServicee.getAllCustomers();
	}
	@GetMapping("/{id}")
	public CustomerResponse getCustommerById(@PathVariable(value = "id")Long id) {
		return customerServicee.getCustomerById(id);
	}
	@PutMapping("/update/{id}")
	public CustomerResponse updateCustomer(@PathVariable(value = "id")Long id, @RequestBody CustomerDto dto) {
		return customerServicee.updateCustomer(id, dto);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerServicee.deleteCustomer(id);
	}
	
}

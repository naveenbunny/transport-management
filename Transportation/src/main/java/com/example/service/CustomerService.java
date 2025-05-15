package com.example.service;

import java.util.List;

import com.example.dto.CustomerDto;
import com.example.response.CustomerResponse;

public interface CustomerService {

	public CustomerResponse addCustomer(CustomerDto dto,Long aid);
	
	public List<CustomerResponse> getAllCustomers();
	
	public CustomerResponse getCustomerById(Long id);
	
	public CustomerResponse updateCustomer(Long id,CustomerDto dto);
	
	public void deleteCustomer(Long id);
}

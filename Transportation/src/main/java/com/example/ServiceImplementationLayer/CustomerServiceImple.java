package com.example.ServiceImplementationLayer;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dto.CustomerDto;
import com.example.entity.Admin;
import com.example.entity.Customer;
import com.example.repository.AdminRepository;
import com.example.repository.CustomerRepository;
import com.example.response.CustomerResponse;
import com.example.service.CustomerService;

@Service
public class CustomerServiceImple implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public CustomerResponse addCustomer(CustomerDto dto, Long aid) {
		
		Admin admin = adminRepository.findById(aid).orElseThrow(() -> new RuntimeException("Admin id not found "+aid));
		
		Customer customer = new Customer();
		customer.setCid(customer.getCid());
		customer.setName(dto.getName());
		customer.setContact_Number(dto.getContact_Number());
		customer.setEmail(dto.getEmail());
		customer.setAddress(dto.getAddress());
		customer.setAdmin(admin);
		customerRepository.save(customer);
		CustomerResponse customerResponse = mapper.map(customer, CustomerResponse.class);
		return customerResponse;
	}

	@Override
	public List<CustomerResponse> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerResponse> customerResponses = customers.stream().map(customer -> mapper.map(customer, CustomerResponse.class)).collect(Collectors.toList());
		return customerResponses;
	}

	@Override
	public CustomerResponse getCustomerById(Long id) {
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("customerid not found "+id));
		CustomerResponse customerResponse = mapper.map(customer, CustomerResponse.class);
		return customerResponse;
	}

	@Override
	public CustomerResponse updateCustomer(Long id, CustomerDto dto) {
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("customer is not found "+id));
		mapper .map(dto, customer);
		customerRepository.save(customer);
		CustomerResponse customerResponse = mapper.map(customer, CustomerResponse.class);
		return customerResponse;
	}

	@Override
	public void deleteCustomer(@PathVariable Long id) {
		Customer customer = customerRepository.findById(id).orElseThrow(()-> new RuntimeException("customer id not found "+id));
		customerRepository.deleteById(id);
	}

}

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

import com.example.dto.AccountDto;
import com.example.response.AccountResponse;
import com.example.service.AccountService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	public void setService(AccountService accountService) {
		this.accountService = accountService;
	}

	@PostMapping("/add/owner/{ownerId}")
	public AccountResponse addAccount(@RequestBody AccountDto dto, @PathVariable(value = "ownerId") Long ownerId) {
		return accountService.addOwnerAccount(dto, ownerId);
	}
	
	@PostMapping("/add/customer/{cid}")
	public AccountResponse addCustomerAccount(@RequestBody AccountDto dto, @PathVariable(value = "cid") Long cid) {
		return accountService.addCustomerAccount(dto, cid);
	}
		
	@PostMapping("/add/admin/{aid}")
	public AccountResponse addAdminAccount(@RequestBody AccountDto dto, @PathVariable(value = "aid") Long aid) {
		return accountService.addAdminAccount(dto, aid);
	}
	
	@GetMapping("/all")
	public List<AccountResponse> getAllAccounts() {
		return accountService.getAllAccounts();
	}
	@GetMapping("/{id}")
	public AccountResponse getAccountById(@PathVariable Long id) {
		return accountService.getAccountById(id);
	}
	@PutMapping("/update/{id}")
	public AccountResponse updateAccount(@PathVariable (value = "id")Long id,AccountDto dto) {
		return accountService.updateAccount(id, dto);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteAccount(@PathVariable(value = "id")Long id) {
		accountService.deleteAccount(id);
		
	}
	
		


}
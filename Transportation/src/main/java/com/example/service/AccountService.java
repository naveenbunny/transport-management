package com.example.service;

import java.util.List;

import com.example.dto.AccountDto;
import com.example.response.AccountResponse;

public interface AccountService {

	public AccountResponse addOwnerAccount(AccountDto dto,Long ownerId );
	
	public List<AccountResponse> getAllAccounts();
	
	public AccountResponse getAccountById(Long id);
	
	public AccountResponse updateAccount(Long id,AccountDto dto);
	
	public void deleteAccount(Long id);

	public AccountResponse addCustomerAccount(AccountDto dto, Long cid);

	public AccountResponse addAdminAccount(AccountDto dto, Long aid);

}

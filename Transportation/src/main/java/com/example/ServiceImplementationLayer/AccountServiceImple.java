package com.example.ServiceImplementationLayer;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dto.AccountDto;
import com.example.entity.Account;
import com.example.entity.Admin;
import com.example.entity.Customer;
import com.example.entity.VehicleOwner;
import com.example.repository.AccountRepository;
import com.example.repository.AdminRepository;
import com.example.repository.CustomerRepository;
import com.example.repository.VehicleOwnerRepository;
import com.example.response.AccountResponse;
import com.example.service.AccountService;

@Service
public class AccountServiceImple implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private VehicleOwnerRepository vehicleOwnerRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public AccountResponse addAdminAccount(AccountDto dto, Long aid) {
		
		Admin admin = adminRepository.findById(aid).orElseThrow(()-> new RuntimeException("Admin id not found "+ aid));
		
		Account account = new Account();
		account.setAccount_Number(account.getAccount_Number());
		account.setAccount_Type(dto.getAccount_Type());
		account.setBalance(dto.getBalance());
		account.setAdmin(admin);
		accountRepository.save(account);
		AccountResponse accountResponse = mapper.map(account, AccountResponse.class); 
		return accountResponse;
	}
	
	@Override
	public AccountResponse addOwnerAccount(AccountDto dto, Long ownerId) {
		VehicleOwner vehicleOwner = vehicleOwnerRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("VehicleOwner id not found "+ownerId));
		
		Account account = new Account();
		account.setAccount_Id(account.getAccount_Id());
		account.setAccount_Number(account.getAccount_Number());
		account.setAccount_Type(dto.getAccount_Type());
		account.setBalance(dto.getBalance());
		account.setOwner(vehicleOwner);
		accountRepository.save(account);
		AccountResponse accountResponse = mapper.map(account, AccountResponse.class);
		return accountResponse;
	}
	
	@Override
	public AccountResponse addCustomerAccount(AccountDto dto, Long cid) {
		Customer customer = customerRepository.findById(cid).orElseThrow(() -> new RuntimeException("Customer id not found "+cid));
		
		Account account = new Account();
		account.setAccount_Id(account.getAccount_Id());
		account.setAccount_Number(account.getAccount_Number());
		account.setAccount_Type(dto.getAccount_Type());
		account.setBalance(dto.getBalance());
		account.setCustomer(customer);
		accountRepository.save(account);
		AccountResponse accountResponse = mapper.map(account, AccountResponse.class);
		return accountResponse;
	}

	@Override
	public List<AccountResponse> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();
		List<AccountResponse> accountResponses = accounts.stream().map(account -> mapper.map(account, AccountResponse.class)).collect(Collectors.toList());
		return accountResponses;
	}

	@Override
	public AccountResponse getAccountById(Long id) {
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account id not found with "+id));
		AccountResponse accountResponse = mapper.map(account, AccountResponse.class);
		return accountResponse;
	}

	@Override
	public AccountResponse updateAccount(Long id, AccountDto dto) {
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account id not found with "+id));
		mapper.map(dto, account);
		accountRepository.save(account);
		AccountResponse accountResponse = mapper.map(account, AccountResponse.class);
		return accountResponse;
	}

	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account id not found with "+id));
		accountRepository.deleteById(id);
		
	}

	

	

}

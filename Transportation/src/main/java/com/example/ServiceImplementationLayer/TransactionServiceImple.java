package com.example.ServiceImplementationLayer;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.TransactionDto;
import com.example.repository.AccountRepository;
import com.example.repository.TransactionRepository;
import com.example.response.TransactionResponse;
import com.example.service.TransactionService;

@Service
public class TransactionServiceImple implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public TransactionResponse addTransaction(TransactionDto dto) {
		
		
		return null;
	}

	@Override
	public List<TransactionResponse> getAllTransactions() {
		return null;
	}

	@Override
	public TransactionResponse getTransactionById(int id) {
		return null;
	}

	@Override
	public TransactionResponse updateTransaction(int id, TransactionDto dto) {
		return null;
	}

	@Override
	public void deleteTransaction(int id) {
		
	}

}

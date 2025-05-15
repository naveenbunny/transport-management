package com.example.service;

import java.util.List;

import com.example.dto.TransactionDto;
import com.example.response.TransactionResponse;

public interface TransactionService {

	public TransactionResponse addTransaction(TransactionDto dto);
	
	public List<TransactionResponse> getAllTransactions();
	
	public TransactionResponse getTransactionById(int id);
	
	public TransactionResponse updateTransaction(int id,TransactionDto dto);
	
	public void deleteTransaction(int id);
}

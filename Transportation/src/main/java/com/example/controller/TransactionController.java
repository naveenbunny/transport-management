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

import com.example.dto.TransactionDto;
import com.example.response.TransactionResponse;
import com.example.service.TransactionService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	
	
	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	@PostMapping("/add")
	public TransactionResponse addTransaction(@RequestBody TransactionDto dto) {
		return transactionService.addTransaction(dto);
	}
	@GetMapping("/all")
	public List<TransactionResponse> getAllTransactions() {
		return transactionService.getAllTransactions();
	}
	@GetMapping("/{id}")
	public TransactionResponse getTransactionById(@PathVariable int id) {
		return transactionService.getTransactionById(id);
	}
	@PutMapping("/update/{id}")
	public TransactionResponse updateTransaction(@PathVariable(value = "id")int id,TransactionDto dto) {
		return transactionService.updateTransaction(id, dto);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteTransaction(@PathVariable int id) {
		transactionService.deleteTransaction(id);
	}
	
}

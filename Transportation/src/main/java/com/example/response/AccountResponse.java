package com.example.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountResponse {

	private long account_Id;
	private String account_Number;
	private double balance;
	private String account_Type;
}

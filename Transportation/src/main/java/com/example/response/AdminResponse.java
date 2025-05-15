package com.example.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminResponse {

	private long aid;
	private String name;
	private long contact_Number;
	private String address;
	private String email;
}

package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleOwnerDto {

	private String name;
	private long contact_Number;
	private String address;
	private String email;
}

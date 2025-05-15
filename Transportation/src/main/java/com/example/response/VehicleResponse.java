package com.example.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleResponse {

	private long vid;
	private long vehicle_Number;
	private long capacity;
	private long insurance_Number;
}

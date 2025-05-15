package com.example.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransportationResponse {

	private long tid;
	private String item;
	private long capacity;
	private String destination;
	private String from_Where;
}

package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransportationDto {

	private String item;
	private long capacity;
	private String destination;
	private String from_Where;
}

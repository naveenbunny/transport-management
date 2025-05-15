package com.example.service;

import java.util.List;

import com.example.dto.TransportationDto;
import com.example.response.TransportationResponse;

public interface TransportationService {

	public TransportationResponse addTransportation(TransportationDto dto,Long aid,Long cid);
	
	public List<TransportationResponse> getAllTransportations();
	
	public TransportationResponse getTransportationById(Long id);
	
	public TransportationResponse updateTransportation(Long id,TransportationDto dto);
	
	public void deleteTransportation(Long id);
}

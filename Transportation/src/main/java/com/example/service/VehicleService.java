package com.example.service;

import java.util.List;

import com.example.dto.VehicleDto;
import com.example.response.VehicleResponse;

public interface VehicleService {

	public VehicleResponse addVehicle(VehicleDto dto,Long ownerId);
	
	public List<VehicleResponse> getAllVehicles();
	
	public VehicleResponse getVehicleById(Long id);
	
	public VehicleResponse updateVehicle(Long id,VehicleDto dto);
	
	public void deleteVehicle(Long id);
	
}

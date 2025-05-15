package com.example.service;

import java.util.List;

import com.example.dto.VehicleOwnerDto;
import com.example.response.VehicleOwnerResponse;

public interface VehicleOwnerService {

	public VehicleOwnerResponse addVehicleOwner(VehicleOwnerDto dto,Long aid);
	
	public List<VehicleOwnerResponse> getAllVehicleOwners();
	
	public VehicleOwnerResponse getVehicleOwnerById(Long id);
	
	public VehicleOwnerResponse updateVehicleOwner(Long id,VehicleOwnerDto dto);
	
	public void deleteVehicleOwner(Long id);
}

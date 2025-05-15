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

import com.example.dto.VehicleOwnerDto;
import com.example.response.VehicleOwnerResponse;
import com.example.service.VehicleOwnerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/VehicleOwner")
public class VehicleOwnerController {

	@Autowired
	private VehicleOwnerService vehicleOwnerService;
	
	@PostMapping("/add/{aid}")
	public VehicleOwnerResponse addVehicleOwner(@RequestBody VehicleOwnerDto dto,@PathVariable(value = "aid" )Long aid) {
		return vehicleOwnerService.addVehicleOwner(dto, aid);
	}
	@GetMapping("/all")
	public List<VehicleOwnerResponse> getAllVehicleOwners() {
		return vehicleOwnerService.getAllVehicleOwners();
	}
	@GetMapping("/{id}")
	public VehicleOwnerResponse getVehicleOwnerById(@PathVariable(value = "id")Long id) {
		return vehicleOwnerService.getVehicleOwnerById(id);
	}
	@PutMapping("/update/{id}")
	public VehicleOwnerResponse updateVehicleOwner(@RequestBody VehicleOwnerDto dto,@PathVariable(value = "id")Long id) {
		return vehicleOwnerService.updateVehicleOwner(id, dto);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteVehicleOwner(@PathVariable Long id) {
		vehicleOwnerService.deleteVehicleOwner(id);
	}
}

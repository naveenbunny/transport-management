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

import com.example.dto.VehicleDto;
import com.example.response.VehicleResponse;
import com.example.service.VehicleService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping("/add/ownerId")
	public VehicleResponse addVehicle(@RequestBody VehicleDto dto,@PathVariable(value = "ownerId")Long ownerId) {
		return vehicleService.addVehicle(dto, ownerId);
	}
	@GetMapping("/all")
	public List<VehicleResponse> getAllVehicles() {
		return vehicleService.getAllVehicles();
	}
	@GetMapping("/{id}")
	public VehicleResponse getVehicleById(@PathVariable(value = "id")Long id) {
		return vehicleService.getVehicleById(id);
	}
	@PutMapping("/update/{id}")
	public VehicleResponse updateVehicle(@RequestBody VehicleDto dto, @PathVariable(value = "id")Long id) {
		return vehicleService.updateVehicle(id, dto);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteVehicle(@PathVariable Long id) {
		vehicleService.deleteVehicle(id);
	}
}

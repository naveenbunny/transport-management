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

import com.example.dto.TransportationDto;
import com.example.response.TransportationResponse;
import com.example.service.TransportationService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Transport")
public class TransportationController {

	@Autowired
	private TransportationService transportationService;
	
	public void setTransportationService(TransportationService transportationService) {
		this.transportationService = transportationService;
	}
	@PostMapping("/add")
	public TransportationResponse addTransportation(@RequestBody TransportationDto dto, @PathVariable(value = "aid")Long aid, @PathVariable(value = "cid")Long cid) {
		return transportationService.addTransportation(dto, aid, cid);
	}
	@GetMapping("/all")
	public List<TransportationResponse> getAllTransportations() {
		return transportationService.getAllTransportations();
	}
	@GetMapping("/{id}")
	public TransportationResponse getTransportationById(@PathVariable(value = "id")Long id) {
		return transportationService.getTransportationById(id);
	}
	@PutMapping("/update/{id}")
	public TransportationResponse updateTransportation(@PathVariable(value = "id")Long id,@RequestBody TransportationDto dto) {
		return transportationService.updateTransportation(id, dto);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteTransportation(@PathVariable Long id) {
		transportationService.deleteTransportation(id);
	}
}

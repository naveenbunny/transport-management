package com.example.ServiceImplementationLayer;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.VehicleOwnerDto;
import com.example.entity.Admin;
import com.example.entity.VehicleOwner;
import com.example.repository.AdminRepository;
import com.example.repository.VehicleOwnerRepository;
import com.example.response.VehicleOwnerResponse;
import com.example.service.VehicleOwnerService;

@Service
public class VehicleOwnerServiceImple implements VehicleOwnerService{
	
	@Autowired
	private VehicleOwnerRepository vehicleOwnerRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public VehicleOwnerResponse addVehicleOwner(VehicleOwnerDto dto, Long aid) {
		
		Admin admin = adminRepository.findById(aid).orElseThrow(() -> new RuntimeException("Admin id not found "+aid));
		
		VehicleOwner vehicleOwner = new VehicleOwner();
		vehicleOwner.setOwnerId(vehicleOwner.getOwnerId());
		vehicleOwner.setAddress(dto.getAddress());
		vehicleOwner.setContact_Number(dto.getContact_Number());
		vehicleOwner.setEmail(dto.getEmail());
		vehicleOwner.setName(dto.getName());
		vehicleOwner.setAdmin(admin);
		vehicleOwnerRepository.save(vehicleOwner);
		VehicleOwnerResponse vehicleOwnerResponse = mapper.map(vehicleOwner, VehicleOwnerResponse.class);
		return vehicleOwnerResponse;
	}

	@Override
	public List<VehicleOwnerResponse> getAllVehicleOwners() {
		List<VehicleOwner> vehicleOwners = vehicleOwnerRepository.findAll();
		List<VehicleOwnerResponse> vehicleOwnerResponses = vehicleOwners.stream().map(vehicleOwner -> mapper.map(vehicleOwners, VehicleOwnerResponse.class)).collect(Collectors.toList());
		return vehicleOwnerResponses;
	}

	@Override
	public VehicleOwnerResponse getVehicleOwnerById(Long id) {
		VehicleOwner vehicleOwner = vehicleOwnerRepository.findById(id).orElseThrow(() -> new RuntimeException("VehicleOwner id not found "+id));
		VehicleOwnerResponse vehicleOwnerResponse = mapper.map(vehicleOwner, VehicleOwnerResponse.class);
		return vehicleOwnerResponse;
	}

	@Override
	public VehicleOwnerResponse updateVehicleOwner(Long id, VehicleOwnerDto dto) {
		VehicleOwner vehicleOwner = vehicleOwnerRepository.findById(id).orElseThrow(() -> new RuntimeException("VehicleOwner id not found "+id));
		mapper.map(dto,vehicleOwner);
		vehicleOwnerRepository.save(vehicleOwner);
		VehicleOwnerResponse vehicleOwnerResponse = mapper.map(vehicleOwner, VehicleOwnerResponse.class);
		return vehicleOwnerResponse;
	}

	@Override
	public void deleteVehicleOwner(Long id) {
		VehicleOwner vehicleOwner = vehicleOwnerRepository.findById(id).orElseThrow(() -> new RuntimeException("VehicleOwner id not found "+id));
		vehicleOwnerRepository.deleteById(id);
	}

}

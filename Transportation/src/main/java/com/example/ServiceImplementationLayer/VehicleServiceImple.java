package com.example.ServiceImplementationLayer;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.VehicleDto;
import com.example.entity.Vehicle;
import com.example.entity.VehicleOwner;
import com.example.repository.VehicleOwnerRepository;
import com.example.repository.VehicleRepository;
import com.example.response.VehicleResponse;
import com.example.service.VehicleService;

@Service
public class VehicleServiceImple implements VehicleService{
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private VehicleOwnerRepository vehicleOwnerRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public VehicleResponse addVehicle(VehicleDto dto, Long ownerId) {
		
		VehicleOwner vehicleOwner = vehicleOwnerRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("VehicleOwner id not found "+ownerId));
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVid(vehicle.getVid());
		vehicle.setCapacity(dto.getCapacity());
		vehicle.setInsurance_Number(dto.getInsurance_Number());
		vehicle.setVehicle_Number(dto.getVehicle_Number());
		vehicle.setOwner(vehicleOwner);
		vehicleRepository.save(vehicle);
		VehicleResponse vehicleResponse = mapper.map(vehicle, VehicleResponse.class);
		return vehicleResponse;
	}

	@Override
	public List<VehicleResponse> getAllVehicles() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		List<VehicleResponse> vehicleResponses = vehicles.stream().map(vehicle -> mapper.map(vehicles, VehicleResponse.class)).collect(Collectors.toList());
		return vehicleResponses;
	}

	@Override
	public VehicleResponse getVehicleById(Long id) {
		Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("vehicle id not found "+id));
		VehicleResponse vehicleResponse = mapper.map(vehicle, VehicleResponse.class);
		return vehicleResponse;
	}

	@Override
	public VehicleResponse updateVehicle(Long id, VehicleDto dto) {
		Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("vehicle id not found "+id));
		mapper.map(dto, vehicle);
		vehicleRepository.save(vehicle);
		VehicleResponse vehicleResponse = mapper.map(vehicle, VehicleResponse.class);
		return vehicleResponse;
	}

	@Override
	public void deleteVehicle(Long id) {
		Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("vehicle id not found "+id));
		vehicleRepository.deleteById(id);
		
	}

}

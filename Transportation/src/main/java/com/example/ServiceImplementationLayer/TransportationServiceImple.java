package com.example.ServiceImplementationLayer;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.TransportationDto;
import com.example.entity.Admin;
import com.example.entity.Customer;
import com.example.entity.Transportation;
import com.example.repository.AdminRepository;
import com.example.repository.CustomerRepository;
import com.example.repository.TransportationRepository;
import com.example.response.TransportationResponse;
import com.example.service.TransportationService;

@Service
public class TransportationServiceImple implements TransportationService{
	
	@Autowired
	private TransportationRepository transportationRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	

	@Override
	public TransportationResponse addTransportation(TransportationDto dto, Long aid, Long cid) {
		
		Admin admin = adminRepository.findById(aid).orElseThrow(() -> new RuntimeException("Admin id not found "+aid));
		Customer customer = customerRepository.findById(cid).orElseThrow(() -> new RuntimeException("customer id not found "+cid));
		
		Transportation transportation = new Transportation();
		transportation.setTid(transportation.getTid());
		transportation.setCapacity(dto.getCapacity());
		transportation.setDestination(dto.getDestination());
		transportation.setFrom_Where(dto.getFrom_Where());
		transportation.setItem(dto.getItem());
		transportation.setAdmin(admin);
		transportation.setCustomer(customer);
		transportationRepository.save(transportation);
		TransportationResponse transportationResponse = mapper.map(transportation, TransportationResponse.class);
		return transportationResponse;
	}

	@Override
	public List<TransportationResponse> getAllTransportations() {
		List<Transportation> transportations = transportationRepository.findAll();
		List<TransportationResponse> transportationResponses = transportations.stream().map(transportation -> mapper.map(transportations, TransportationResponse.class)).collect(Collectors.toList());
		return transportationResponses;
	}

	@Override
	public TransportationResponse getTransportationById(Long id) {
		Transportation transportation = transportationRepository.findById(id).orElseThrow(() -> new RuntimeException("Transportation id not found "+id));
		TransportationResponse transportationResponse = mapper.map(transportation, TransportationResponse.class);
		return transportationResponse;
	}

	@Override
	public TransportationResponse updateTransportation(Long id, TransportationDto dto) {
		Transportation transportation = transportationRepository.findById(id).orElseThrow(() -> new RuntimeException("Transportation id not found "+id));
		mapper.map(dto, transportation);
		transportationRepository.save(transportation);
		TransportationResponse transportationResponse = mapper.map(transportation, TransportationResponse.class);
		return transportationResponse;
	}

	@Override
	public void deleteTransportation(Long id) {
		Transportation transportation = transportationRepository.findById(id).orElseThrow(() -> new RuntimeException("Transportation id not found "+id));
		transportationRepository.deleteById(id);
		
	}

}

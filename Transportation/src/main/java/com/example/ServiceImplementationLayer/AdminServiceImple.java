package com.example.ServiceImplementationLayer;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.AdminDto;
import com.example.entity.Admin;
import com.example.repository.AdminRepository;
import com.example.response.AdminResponse;
import com.example.service.AdminService;

@Service
public class AdminServiceImple implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public AdminResponse addAdmin(AdminDto dto) {
		Admin admin = new Admin();
		admin.setAid(admin.getAid());
		admin.setName(dto.getName());
		admin.setContact_Number(dto.getContact_Number());
		admin.setEmail(dto.getEmail());
		admin.setAddress(dto.getAddress());
		adminRepository.save(admin);
		AdminResponse adminResponse = mapper.map(admin, AdminResponse.class);
		return adminResponse;
	}

	@Override
	public List<AdminResponse> getAll() {
		List<Admin> admins = adminRepository.findAll();
		List<AdminResponse> adminResponses = admins.stream().map(admin -> mapper.map(admin, AdminResponse.class)).collect(Collectors.toList());
		return adminResponses;
	}

	@Override
	public AdminResponse getById(Long id) {
		Admin admin = adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin id not found"+id));
		AdminResponse adminResponse = mapper.map(admin, AdminResponse.class);
		return adminResponse;
	}

	@Override
	public AdminResponse updateAdmin(Long id, AdminDto dto) {
		Admin admin = adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin id not found"+id));
		mapper.map(dto,admin);
		adminRepository.save(admin);
		AdminResponse adminResponse = mapper.map(admin, AdminResponse.class);
		return adminResponse;
	}

	@Override
	public void deleteAdmin(Long id) {
		Admin admin = adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin id not found "+id));
		adminRepository.deleteById(id);
		
	}

}

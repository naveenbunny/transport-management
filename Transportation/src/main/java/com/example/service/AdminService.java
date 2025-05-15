package com.example.service;

import java.util.List;

import com.example.dto.AdminDto;

import com.example.response.AdminResponse;

public interface AdminService {

	public AdminResponse addAdmin(AdminDto dto);
	
	public List<AdminResponse> getAll();
	
	public AdminResponse getById(Long id);
	
	public AdminResponse updateAdmin(Long id,AdminDto dto);
	
	public void deleteAdmin(Long id);
}

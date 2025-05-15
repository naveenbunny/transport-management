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

import com.example.dto.AdminDto;
import com.example.response.AdminResponse;
import com.example.service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/add")
	public AdminResponse addAdmin(@RequestBody AdminDto dto) {
		return adminService.addAdmin(dto);
	}
	
	@GetMapping("/all")
	public List<AdminResponse> getAll() {
		return adminService.getAll();
	}
	@GetMapping("/{id}")
	public AdminResponse getById(@PathVariable Long id) {
		return adminService.getById(id);
	}
	@PutMapping("/update/{id}")
	public AdminResponse updateAdmin(@PathVariable(value = "id")Long id, @RequestBody AdminDto dto) {
		return adminService.updateAdmin(id, dto);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteAdmin(@PathVariable(value = "id") Long id) {
		adminService.deleteAdmin(id);
	}
}

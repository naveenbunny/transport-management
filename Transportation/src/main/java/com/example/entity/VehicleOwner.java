package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class VehicleOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  ownerId;
	private String name;
	private long contact_Number;
	private String address;
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "admin_id",referencedColumnName = "aid")
	private Admin admin;
	
	@OneToMany(mappedBy = "owner",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Vehicle> vehicle;
	
	
	
}

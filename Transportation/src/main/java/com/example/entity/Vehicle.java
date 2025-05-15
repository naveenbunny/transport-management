package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long vid;
	private long vehicle_Number;
	private long capacity;
	private long insurance_Number;
	
	@ManyToOne
	@JoinColumn(name = "owner_id",referencedColumnName = "ownerId")
	private VehicleOwner owner;
	
	
	
}

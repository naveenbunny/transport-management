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
public class Transportation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tid;
	private String item;
	private long capacity;
	private String destination;
	private String from_Where;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "cid")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "admin_id",referencedColumnName = "aid")
	private Admin admin;
}

package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long account_Id;
	private String account_Number;
	private double balance;
	private String account_Type;
	
	@PrePersist
	public void setAccountNumber()
	{
		this.account_Number = "AC "+System.currentTimeMillis();
	}
	
	@OneToOne
	@JoinColumn(name = "admin_id")
	private Admin admin;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name = "owner_Id")
	private VehicleOwner owner;
	
	@OneToMany(mappedBy = "fromAccount",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Transaction> fromTransaction;
	
	@OneToMany(mappedBy = "toAccount", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Transaction> toTransaction;
	
}

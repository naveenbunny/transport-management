package com.example.entity;

import java.util.Date;

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
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactio_Id;
	private Date date;
	private double amount;
	
	public void setDate() {
		this.date=new Date();
	}
	
	@ManyToOne
	@JoinColumn(name = "from_account",referencedColumnName = "account_Id")
	private Account fromAccount;
	
	@ManyToOne
	@JoinColumn(name = "to_account",referencedColumnName = "account_Id")
	private Account toAccount;
}

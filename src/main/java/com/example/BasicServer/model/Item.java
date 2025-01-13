package com.example.BasicServer.model;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "items")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String title;
	
	@Positive
	@Max(value = 10000, message = "Amount cannot exceed 10000")
	private int amount;
	
	@Email
	@Column(unique = true)
	private String email;

	public Item() {
	    // Default constructor (for Hibernate)
	}
	public Item(@NotBlank String title,
			@Positive @Max(value = 10000, message = "Amount cannot exceed 10000") int amount,
			@Email String email) {
		this.title = title;
		this.amount = amount;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(@NotBlank String title) {
		this.title = title;
	}

	public int getAmount() {
		return amount;
	}
	public void setAmount(@Positive @Max(value = 10000, message = "Amount cannot exceed 10000") int amount) {
		this.amount = amount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(@Email String email) {
		this.email = email;
	}

	
}

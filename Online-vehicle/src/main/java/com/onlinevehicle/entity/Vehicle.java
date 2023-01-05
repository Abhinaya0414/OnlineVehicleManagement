package com.onlinevehicle.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId;

	@NotNull
	private String vehicleNumber;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Driver driver;

	@NotNull
	private String type;

	@NotNull
	private String category;

	private String description;

	@NotNull
	private String location;

	@NotNull
	private int capacity;

	@NotNull
	private Double chargesPerKM;

	private Double fixedCharges;
}

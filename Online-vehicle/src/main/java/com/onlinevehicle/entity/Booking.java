package com.onlinevehicle.entity;

import java.time.LocalDate;

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
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;

	@OneToOne
	private Customer customer;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Vehicle vehicle;

	@NotNull
	private LocalDate bookingDate;

	@NotNull
	private LocalDate bookedTillDate;

	@NotNull
	private String bookingDescription;

	@NotNull
	private Double totalCost;

	@NotNull
	private Double distance;

}

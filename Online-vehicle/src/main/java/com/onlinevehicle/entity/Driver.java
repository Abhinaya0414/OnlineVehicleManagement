package com.onlinevehicle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 4, max = 15, message = "characters in the firstname should be min 4 and max 15")
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	private String address;

	@NotNull
	private String mobileNumber;

	@NotNull
	@Email
	private String email;

	@NotNull
	private String licenseNo;

}

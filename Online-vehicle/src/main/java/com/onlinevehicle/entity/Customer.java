package com.onlinevehicle.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "customerId")
public class Customer  extends User
{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int customerId;
 
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@Email
	private String email;
	
	@NotNull
	private String mobileNumber;
	
	@NotNull
	private String address;

	public void setRole(String string) {
		// TODO Auto-generated method stub
		
	}

}

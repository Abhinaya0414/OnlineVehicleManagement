package com.onlinevehicle.service;

import java.util.List;

import com.onlinevehicle.entity.Customer;
import com.onlinevehicle.entity.Vehicle;
import com.onlinevehicle.exceptions.ResourceNotFoundException;

public interface ICutomerService {

	Customer addCustomer(Customer customer) throws Exception;

	String removeCustomer(Customer customer) throws ResourceNotFoundException;

	Customer updaeCustomer(Customer customer) throws ResourceNotFoundException;

	Customer viewCustomerById(int id) throws ResourceNotFoundException;

	List<Customer> viewAllCustomers(String vType);

	//List<Customer> viewAllCustomerByLocation(String location);
}

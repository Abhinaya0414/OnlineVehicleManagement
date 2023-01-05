package com.onlinevehicle.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinevehicle.entity.Customer;
import com.onlinevehicle.exceptions.ResourceNotFoundException;
import com.onlinevehicle.service.ICutomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICutomerService cutomerService;

	@GetMapping("/viewCustomerById/{id}")
	public ResponseEntity<?> viewCustomerById(@PathVariable int id) throws ResourceNotFoundException {
		return ResponseEntity.ok(cutomerService.viewCustomerById(id));
	}

	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomer(@Valid @RequestBody Customer c) throws Exception {
		return ResponseEntity.ok(cutomerService.addCustomer(c));
	}

	@DeleteMapping("deleteCustomer")
	public ResponseEntity<?> deleteCustomer(@Valid @RequestBody Customer u) throws ResourceNotFoundException {
		return ResponseEntity.ok(cutomerService.removeCustomer(u));
	}

	@PutMapping("/updateCustomer")
	public ResponseEntity<?> updateCustomer(@Valid @RequestBody Customer u) throws ResourceNotFoundException {
		return ResponseEntity.ok(cutomerService.updaeCustomer(u));
	}

	@GetMapping("/getAllCustomerByvType/{type}")
	public ResponseEntity<?> viewAllCustomers(@PathVariable String type) {
		return ResponseEntity.ok(cutomerService.viewAllCustomers(type));
	}
}

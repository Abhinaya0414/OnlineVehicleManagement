package com.onlinevehicle.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinevehicle.entity.Payment;
import com.onlinevehicle.exceptions.ResourceNotFoundException;
import com.onlinevehicle.service.IPaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private IPaymentService iPaymentService;

	@GetMapping("/viewPaymentById/{id}")
	public ResponseEntity<?> viewPaymentById(@PathVariable int id) throws ResourceNotFoundException {
		return ResponseEntity.ok(iPaymentService.viewPaymentById(id));
	}

	@GetMapping("/viewAllPayments")
	public ResponseEntity<?> viewAllPayments() throws ResourceNotFoundException {
		return ResponseEntity.ok(iPaymentService.viewAllPayments());
	}

	@DeleteMapping("/cancelPayment/{id}")
	public ResponseEntity<?> cancelPayment(@PathVariable int id ) throws ResourceNotFoundException {
		return ResponseEntity.ok(iPaymentService.cancelPayment(id));
	}

	@PostMapping("/addPayment")
	public ResponseEntity<?> addPayament(@Valid @RequestBody Payment p) throws Exception {
		return ResponseEntity.ok(iPaymentService.addPayment(p));
	}
}

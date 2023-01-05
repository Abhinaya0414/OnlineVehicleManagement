package com.onlinevehicle.service;

import java.util.List;

import com.onlinevehicle.entity.Payment;
import com.onlinevehicle.exceptions.ResourceNotFoundException;

public interface IPaymentService {

	Payment addPayment(Payment payment) throws Exception;

//	Payment cancelPayment(Payment payment) throws ResourceNotFoundException;

	Payment viewPaymentById(int id) throws ResourceNotFoundException;

	List<Payment> viewAllPayments();

	String cancelPayment(int id) throws ResourceNotFoundException;

	// Double calculateToatalPayment();
}

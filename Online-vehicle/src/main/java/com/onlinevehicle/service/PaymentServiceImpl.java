package com.onlinevehicle.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinevehicle.entity.Payment;
import com.onlinevehicle.exceptions.ResourceNotFoundException;
import com.onlinevehicle.repository.IPaymentRepository;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private IPaymentRepository iPaymentRepository;

	private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Override
	public Payment addPayment(Payment payment) throws Exception {

		Optional<Payment> b1 = iPaymentRepository.findById(payment.getPaymentId());
		if (b1.isPresent()) {
			logger.info("Payment Already Exists with id " + payment.getPaymentId());
			throw new Exception("Payment Already Exists with id " + payment.getPaymentId());
		}
		logger.info("Adding payment");
		return iPaymentRepository.save(payment);

	}

	@Override
	public String cancelPayment(int id ) throws ResourceNotFoundException {

		Payment p = iPaymentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Payment Doesn't exists " + id));

		logger.info("Cancel payment");
		iPaymentRepository.deleteById(id);
		return "Payment Canceld ";
	}

	@Override
	public Payment viewPaymentById(int id) throws ResourceNotFoundException {
		Payment p = iPaymentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Payment Not found with id" + id));
		logger.info("View Payment By Id");
		return p;
	}

	@Override
	public List<Payment> viewAllPayments() {
		logger.info("Getting List of Payments");
		return iPaymentRepository.findAll();
	}

}

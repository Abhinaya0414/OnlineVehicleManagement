package com.onlinevehicle.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinevehicle.entity.Customer;
import com.onlinevehicle.entity.User;
import com.onlinevehicle.exceptions.ResourceNotFoundException;
import com.onlinevehicle.repository.IBookRepository;
import com.onlinevehicle.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICutomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	@Autowired
	private IBookRepository bookRepository;

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Override
	public Customer addCustomer(Customer customer) throws Exception {
		Optional<Customer> u = customerRepository.findById(customer.getUserId());
		if (u.isPresent()) {
			logger.info("Customer Already exists");
			throw new Exception("Customer Already Exists with id " + customer.getUserId());
		}

		return customerRepository.save(customer);
	}

	@Override
	public String removeCustomer(Customer customer) throws ResourceNotFoundException {
		Customer u = customerRepository.findById(customer.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
		logger.info("Deleting the Customer");
		customerRepository.delete(customer);
		return "Deleted Customer";
	}

	@Override
	public Customer updaeCustomer(Customer customer) throws ResourceNotFoundException {
		Customer u = customerRepository.findById(customer.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
		logger.info("Updating  Customer");
		return customerRepository.save(customer);
	}

	@Override
	public Customer viewCustomerById(int id) throws ResourceNotFoundException {
		Customer u = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
		logger.info("Veiw Customer By Id");
		return u;
	}

	@Override
	public List<Customer> viewAllCustomers(String vType) {

		logger.info("View All Customer By vehicle Type");
		return bookRepository.getAllVehicleByType(vType);
	}

//	@Override
//	public List<Customer> viewAllCustomerByLocation(String location) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}

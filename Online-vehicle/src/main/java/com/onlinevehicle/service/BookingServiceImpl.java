package com.onlinevehicle.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinevehicle.entity.Booking;
import com.onlinevehicle.entity.Customer;
import com.onlinevehicle.exceptions.ResourceNotFoundException;
import com.onlinevehicle.repository.IBookRepository;

@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private IBookRepository bookRepository;

	private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Override
	public Booking addBooking(Booking b) throws Exception {

		Optional<Booking> b1 = bookRepository.findById(b.getBookingId());
		if (b1.isPresent()) {
			logger.info("Booking Already exists");
			throw new Exception("Booking Already Exists with id " + b.getBookingId());
		}
		return bookRepository.save(b);

	}

	@Override
	public Booking updateBooking(Booking b) throws ResourceNotFoundException {
		Booking b1 = bookRepository.findById(b.getBookingId())
				.orElseThrow(() -> new ResourceNotFoundException("Booking not found for the id : " + b.getBookingId()));
		logger.info("Updating the Booking");
		return bookRepository.save(b);
	}

	@Override
	public String cancelBooking(Booking b) throws ResourceNotFoundException {
		Booking b1 = bookRepository.findById(b.getBookingId())
				.orElseThrow(() -> new ResourceNotFoundException("Booking not found for the id : " + b.getBookingId()));
		bookRepository.delete(b);
		logger.info("cancel booking ");
		return "Booking Canceld successfully";
	}

	@Override
	public Booking veiwBookingById(int id) throws ResourceNotFoundException {
		Booking b1 = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Booking not found for the id : " + id));
		logger.info("Veiw Booking By Id " + id);
		return b1;
	}

	@Override
	public List<Booking> viewListOfBookings() {

		logger.info("View List Of Booking");
		return bookRepository.findAll();
	}

//	@Override
//	public List<Booking> viewAllBookingByCustomer(Customer c) {
//		
//		return bookRepository.findById(c.getUserId());
//	}

	@Override
	public List<Booking> viewAllBookingByDate(LocalDate date) {

		logger.info("View All booking By Date");
		return bookRepository.getListOfBookingByDate(date);
	}

}

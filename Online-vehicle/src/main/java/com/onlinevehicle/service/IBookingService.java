package com.onlinevehicle.service;

import java.time.LocalDate;
import java.util.List;

import com.onlinevehicle.entity.Booking;
import com.onlinevehicle.exceptions.ResourceNotFoundException;

public interface IBookingService {

	Booking addBooking(Booking b) throws Exception;

	Booking updateBooking(Booking b) throws ResourceNotFoundException;

	String cancelBooking(Booking b) throws ResourceNotFoundException;

	Booking veiwBookingById(int id) throws ResourceNotFoundException;

	List<Booking> viewListOfBookings();

	List<Booking> viewAllBookingByDate(LocalDate date);

	

//	List<Booking> viewAllBookingByCustomer(int id);

}

package com.onlinevehicle.controller;

import java.time.LocalDate;

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

import com.onlinevehicle.entity.Booking;
import com.onlinevehicle.exceptions.ResourceNotFoundException;
import com.onlinevehicle.service.IBookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private IBookingService bookingService;

	@PostMapping("/addBooking")
	public ResponseEntity<?> addBooking( @Valid @RequestBody Booking b) throws Exception {
		return ResponseEntity.ok(bookingService.addBooking(b));
	}

	@DeleteMapping("/cancelBooking")
	public ResponseEntity<?> cancelBooking(@Valid @RequestBody Booking b) throws ResourceNotFoundException {
		return ResponseEntity.ok(bookingService.cancelBooking(b));
	}

	@GetMapping("/viewListOfBookings")
	public ResponseEntity<?> viewListOfBookings() {
		return ResponseEntity.ok(bookingService.viewListOfBookings());
	}

	@GetMapping("/veiwBookingById/{id}")
	public ResponseEntity<?> veiwBookingById(@PathVariable int id) throws ResourceNotFoundException {
		return ResponseEntity.ok(bookingService.veiwBookingById(id));
	}

	@PutMapping("/updateBooking")
	public ResponseEntity<?> updateBooking(@RequestBody Booking b) throws ResourceNotFoundException {
		return ResponseEntity.ok(bookingService.updateBooking(b));
	}

	@GetMapping("/viewAllBookingByDate/{date}")
	public ResponseEntity<?> viewAllBookingByDate(@PathVariable String date) throws Exception {
		return ResponseEntity.ok(bookingService.viewAllBookingByDate(LocalDate.parse(date)));
	}

}

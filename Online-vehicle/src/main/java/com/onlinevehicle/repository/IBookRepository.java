package com.onlinevehicle.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinevehicle.entity.Booking;
import com.onlinevehicle.entity.Customer;
import com.onlinevehicle.entity.Vehicle;

@Repository
public interface IBookRepository extends JpaRepository<Booking, Integer> {

	@Query("Select v from Booking v where v.vehicle.type=?1")
	List<Customer> getAllVehicleByType(String type);
	
	@Query("Select o from Booking o where o.bookingDate=?1")
	List<Booking> getListOfBookingByDate(LocalDate bookingDate);


}

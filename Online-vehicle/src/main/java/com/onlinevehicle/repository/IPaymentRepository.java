package com.onlinevehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinevehicle.entity.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

}

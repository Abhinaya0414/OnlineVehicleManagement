package com.onlinevehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinevehicle.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

}

package com.onlinevehicle.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinevehicle.entity.User;
import com.onlinevehicle.exceptions.ResourceNotFoundException;
import com.onlinevehicle.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService iUserService;

	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@Valid @RequestBody User u) throws Exception {
		return ResponseEntity.ok(iUserService.addUser(u));
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) throws ResourceNotFoundException {
		return ResponseEntity.ok(iUserService.removeUser(id));
	}

	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody User u) throws ResourceNotFoundException {
		return ResponseEntity.ok(iUserService.validateUser(u));

	}

	@PostMapping("/signOut")
	public ResponseEntity<?> signOutUser( @RequestBody User u) throws ResourceNotFoundException {
		return ResponseEntity.ok(iUserService.signOut(u));
	}

}

package com.onlinevehicle.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinevehicle.entity.User;
import com.onlinevehicle.exceptions.ResourceNotFoundException;
import com.onlinevehicle.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository iUserRepository;

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User validateUser(User user) throws ResourceNotFoundException {
		User u = iUserRepository.findById(user.getUserId()).orElseThrow(
				() -> new ResourceNotFoundException("Requested User Not found with the User " + user.getUserId()));
		return u;
	}

	@Override
	public User addUser(User user) throws Exception {

		Optional<User> u = iUserRepository.findById(user.getUserId());
		if (u.isPresent()) {
			throw new Exception("User Already Exists with id " + user.getUserId());
		}

		return iUserRepository.save(user);
	}

	@Override
	public String removeUser(int id) throws ResourceNotFoundException {
		User u = iUserRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for the id " + id));
		if (u != null) {
			iUserRepository.deleteById(id);
		}
		return "User Deleted Successfully";
	}

	@Override
	public String signOut(User user) throws ResourceNotFoundException {
		User u = iUserRepository.findById(user.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Credentials " + user.getUserId()));
		return "Signouted";
	}

}

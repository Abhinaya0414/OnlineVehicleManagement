package com.onlinevehicle.service;

import com.onlinevehicle.entity.User;
import com.onlinevehicle.exceptions.ResourceNotFoundException;

public interface IUserService {
	
	User validateUser(User user) throws ResourceNotFoundException;
	
	User addUser(User user) throws Exception;
	
	String removeUser(int id) throws ResourceNotFoundException;
	
	String signOut(User user) throws ResourceNotFoundException;

}

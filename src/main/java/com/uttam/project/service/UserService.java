package com.uttam.project.service;

import java.util.List;

import com.uttam.project.DTO.User;

public interface UserService {
	User createUser(User user);
	User updateUser(Integer userId, User user);
	String deleteUser(Integer userId);
	User getUser(Integer userId);
	List<User> getAllUsers();
	List<User> getUsersByFirstName(String firstNamwe);
	List<User> getUsersByLastName(String lastName);
	
}

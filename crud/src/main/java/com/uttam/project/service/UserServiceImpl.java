package com.uttam.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uttam.project.model.User;
import com.uttam.project.repository.UserRepository;

import lombok.Setter;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Setter
	UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
		 
	}

	@Override
	public User updateUser(User user) {
		 return userRepository.save(user);
		 
		
	}

	@Override
	public String deleteUser(Integer userId) {
		userRepository.deleteById(userId);
		return "done";
	}

	@Override
	public User getUser(Integer userId) {
		if(userRepository.findById(userId).isEmpty()) {
			return new User();
		}
		else {
			return userRepository.findById(userId).get();
			}
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}


	@Override
	public List<User> getUsersByFirstName(String firstName) {
		return userRepository.getUsersByFirstName(firstName);
	}

	@Override
	public List<User> getUsersByLastName(String lastName) {
		return userRepository.getUsersByLastName(lastName);
	}

}

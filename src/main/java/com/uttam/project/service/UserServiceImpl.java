package com.uttam.project.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uttam.project.DTO.User;
import com.uttam.project.mapper.UserMapper;
import com.uttam.project.model.UserDO;
import com.uttam.project.repository.UserRepository;

import lombok.Setter;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Setter
	UserRepository userRepository;
	
	
	@Autowired
	@Setter
	UserMapper userMapper;

	@Override
	public User createUser(User user) {
		UserDO userDO = userMapper.userDTOtoDO(Arrays.asList(user)).get(0);
		userDO = userRepository.save(userDO);
		
		User savedUser = userMapper.userDOtoDTO(Arrays.asList(userDO)).get(0);
		return savedUser;
		 
	}

	@Override
	public User updateUser(User user) {
		UserDO userDO = userMapper.userDTOtoDO(Arrays.asList(user)).get(0);
		userDO = userRepository.save(userDO);
		
		User savedUser = userMapper.userDOtoDTO(Arrays.asList(userDO)).get(0);
		return savedUser;
	}

	@Override
	public String deleteUser(Integer userId) {
		userRepository.deleteById(userId);
		return "done";
	}

	@Override
	public User getUser(Integer userId) {
		UserDO userDO = userRepository.findById(userId).get();
		User user =  userMapper.userDOtoDTO(Arrays.asList(userDO)).get(0);
		return user;
		
	}

	@Override
	public List<User> getAllUsers() {
		List<UserDO> userDOs = userRepository.findAll(); 
		return userMapper.userDOtoDTO(userDOs);
	}


	@Override
	public List<User> getUsersByFirstName(String firstName) {
		List<UserDO> userDOs = userRepository.getUsersByFirstName(firstName);
		return userMapper.userDOtoDTO(userDOs);
	}

	@Override
	public List<User> getUsersByLastName(String lastName) {
		List<UserDO> userDOs = userRepository.getUsersByLastName(lastName);
		return userMapper.userDOtoDTO(userDOs);
	}

}

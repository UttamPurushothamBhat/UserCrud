package com.uttam.project.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uttam.project.DTO.User;
import com.uttam.project.exception.UserNotFoundException;
import com.uttam.project.mapper.UserMapper;
import com.uttam.project.model.AccountDO;
import com.uttam.project.model.UserDO;
import com.uttam.project.repository.UserRepository;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Setter
	UserRepository userRepository;
	
	
	@Autowired
	@Setter
	UserMapper userMapper;

	@Override
	public User createUser(User user) {
		UserDO userDO = userMapper.userDTOtoDO(user);
		userDO = userRepository.save(userDO);
		
		User savedUser = userMapper.userDOtoDTO(userDO);
		return savedUser;
		 
	}

	@Override
	public User updateUser(Integer userId, User user) {
		log.info("check if user with id: {} exists", userId);
		Optional<UserDO> userDO = userRepository.findById(userId);
		if(userDO.isEmpty()) {
			throw new UserNotFoundException("no user by id "+ userId);
		}
		
		List<AccountDO> accountDO = userDO.get().getAccounts();
		
		UserDO updatedUserDO = userMapper.userDTOtoDO(user);
		log.info("set userid and accounts back to this updated user" );
		updatedUserDO.setUserId(userId);
		updatedUserDO.setAccounts(accountDO);
		updatedUserDO = userRepository.save(updatedUserDO);
		
		User savedUser = userMapper.userDOtoDTO(updatedUserDO);
		return savedUser;
	}

	@Override
	public String deleteUser(Integer userId) {
		userRepository.deleteById(userId);
		return "done";
	}

	@Override
	public User getUser(Integer userId) {
		Optional<UserDO> userDO = userRepository.findById(userId);
		if(userDO.isEmpty()) {
			log.error("user with id {} not found", userId);
			throw new UserNotFoundException("no user by id "+ userId);
		}
		User user =  userMapper.userDOtoDTO(userDO.get());
		return user;
		
	}

	@Override
	public List<User> getAllUsers() {
		List<UserDO> userDOs = userRepository.findAll();
		return userDOs.stream().map(u->userMapper.userDOtoDTO(u)).collect(Collectors.toList());
	}


	@Override
	public List<User> getUsersByFirstName(String firstName) {
		List<UserDO> userDOs = userRepository.getUsersByFirstName(firstName);
		return userDOs.stream().map(u->userMapper.userDOtoDTO(u)).collect(Collectors.toList());
	}

	@Override
	public List<User> getUsersByLastName(String lastName) {
		List<UserDO> userDOs = userRepository.getUsersByLastName(lastName);
		return userDOs.stream().map(u->userMapper.userDOtoDTO(u)).collect(Collectors.toList());
	}

}

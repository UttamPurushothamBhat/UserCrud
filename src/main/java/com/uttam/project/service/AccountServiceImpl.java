package com.uttam.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uttam.project.dto.Account;
import com.uttam.project.exception.UserNotFoundException;
import com.uttam.project.exception.ValidationException;
import com.uttam.project.mapper.AccountMapper;
import com.uttam.project.model.AccountDO;
import com.uttam.project.model.UserDO;
import com.uttam.project.repository.AccountRepository;
import com.uttam.project.repository.UserRepository;

import lombok.Setter;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	@Setter
	AccountMapper accountMapper;
	
	@Autowired
	@Setter
	AccountRepository accountRepository;
	
	@Autowired
	@Setter
	UserRepository userRepository;

	@Override
	public Account registerAccount(Integer userId, Account account) {
		
		Optional<UserDO> userDO = userRepository.findById(userId);
		
		if(userDO.isEmpty()) {
			throw new ValidationException("no user by id "+ userId);
		}
		
		AccountDO accountDO = accountMapper.accountDTOtoDO(account);
		accountDO.setUserDO(userDO.get());
		
		accountDO = accountRepository.save(accountDO);
		
		Account savedAccount = accountMapper.accountDOtoDTO(accountDO);
		
		return savedAccount;
	}

}

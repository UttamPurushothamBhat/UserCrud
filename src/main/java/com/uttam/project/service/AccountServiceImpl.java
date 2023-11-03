package com.uttam.project.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uttam.project.DTO.Account;
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
		
		UserDO userDO = userRepository.findById(userId).get();
		
		AccountDO accountDO = accountMapper.accountDTOtoDO(Arrays.asList(account)).get(0);
		accountDO.setUserDO(userDO);
		
		accountDO = accountRepository.save(accountDO);
		
		Account savedAccount = accountMapper.accountDOtoDTO(Arrays.asList(accountDO)).get(0);
		
		return savedAccount;
	}

}

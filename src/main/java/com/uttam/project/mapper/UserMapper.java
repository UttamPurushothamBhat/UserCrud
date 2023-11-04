package com.uttam.project.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uttam.project.DTO.Account;
import com.uttam.project.DTO.User;
import com.uttam.project.model.AccountDO;
import com.uttam.project.model.UserDO;

import lombok.Setter;

@Component
public class UserMapper {
	
	@Autowired
	@Setter
	AccountMapper accountMapper;

	
	public User userDOtoDTO(UserDO userDO) {
		if(isNull(userDO))return null;
		
			User user = User.builder()
					.userId(userDO.getUserId())
					.address(userDO.getAddress())
					.age(userDO.getAge())
					.email(userDO.getEmail())
					.firstName(userDO.getFirstName())
					.lastName(userDO.getLastName())
					.build();
			
			List<Account> accountList = isNull(userDO.getAccounts())? new ArrayList<>() : userDO.getAccounts().stream()
																		 					  .map(u->accountMapper.accountDOtoDTO(u))
																		 					  .collect(Collectors.toList());
			user.setAccounts(accountList);
			return user;
		
	}
	
	public UserDO userDTOtoDO(User user) {
			if(isNull(user))return null;
			UserDO userDO = UserDO.builder()
					.firstName(user.getFirstName())
					.lastName(user.getLastName())
					.address(user.getAddress())
					.age(user.getAge())
					.email(user.getEmail())
					.build();
			
			List<AccountDO> accountDOList =  isNull(user.getAccounts())? new ArrayList<>() :user.getAccounts().stream()
																							.map(u->accountMapper.accountDTOtoDO(u))
																							.collect(Collectors.toList());
			userDO.setAccounts(accountDOList);
			return userDO;	
	}
}

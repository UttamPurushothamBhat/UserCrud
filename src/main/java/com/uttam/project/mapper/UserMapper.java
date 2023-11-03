package com.uttam.project.mapper;

import static java.util.Objects.isNull;
import java.util.ArrayList;
import java.util.List;

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

	
	public List<User> userDOtoDTO(List<UserDO> userDOList) {
		List<User> userDTOList = new ArrayList<>();
		
		for(UserDO userDO : userDOList) {
			User user = User.builder()
					.userId(userDO.getUserId())
					.address(userDO.getAddress())
					.age(userDO.getAge())
					.email(userDO.getEmail())
					.firstName(userDO.getFirstName())
					.lastName(userDO.getLastName())
					.build();
			
			List<Account> accountList = isNull(userDO.getAccounts())? new ArrayList<>(): accountMapper.accountDOtoDTO(userDO.getAccounts());
			
			user.setAccounts(accountList);
			userDTOList.add(user);
		}
		return userDTOList;
		
	}
	
	public List<UserDO> userDTOtoDO(List<User> userList) {
		List<UserDO> userDOList = new ArrayList<>();
		
		for(User user : userList) {
			UserDO userDO = UserDO.builder()
					.firstName(user.getFirstName())
					.lastName(user.getLastName())
					.address(user.getAddress())
					.age(user.getAge())
					.email(user.getEmail())
					.build();
			List<AccountDO> accountDOList =  isNull(user.getAccounts())? new ArrayList<>() : accountMapper.accountDTOtoDO(user.getAccounts());
	
			userDO.setAccounts(accountDOList);
			userDOList.add(userDO);
		}
		return userDOList;	
	}
}

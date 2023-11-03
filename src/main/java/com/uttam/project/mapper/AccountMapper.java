package com.uttam.project.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.uttam.project.DTO.Account;
import com.uttam.project.model.AccountDO;

@Component
public class AccountMapper {

	
	public List<Account> accountDOtoDTO(List<AccountDO> accountDOs) {
		List<Account> accounts = new ArrayList<>();
		for(AccountDO accountDO : accountDOs) {
			Account account = Account.builder()
					.userId(accountDO.getUserDO().getUserId())
					.accountId(accountDO.getAccountId())
					.userName(accountDO.getUserName())
					.password(accountDO.getPassword())
					.build();
				accounts.add(account);		
		}
		return accounts;
	}
	
	public List<AccountDO> accountDTOtoDO (List<Account> accounts){
		List<AccountDO> accountDOList =  new ArrayList<>();
		for(Account account : accounts) {
			AccountDO accountDO = AccountDO.builder()
					.userName(account.getUserName())
					.password(account.getPassword())
					.build();
			accountDOList.add(accountDO);				
		}
		return accountDOList;
	}
}

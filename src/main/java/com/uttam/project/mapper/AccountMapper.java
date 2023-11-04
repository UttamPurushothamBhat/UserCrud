package com.uttam.project.mapper;

import org.springframework.stereotype.Component;

import com.uttam.project.DTO.Account;
import com.uttam.project.model.AccountDO;

@Component
public class AccountMapper {

	
	public Account accountDOtoDTO(AccountDO accountDO) {
		
			return Account.builder()
					.userId(accountDO.getUserDO().getUserId())
					.accountId(accountDO.getAccountId())
					.userName(accountDO.getUserName())
					.password(accountDO.getPassword())
					.build();
				
		
	}
	
	public AccountDO accountDTOtoDO (Account account){
		
			return AccountDO.builder()
					.userName(account.getUserName())
					.password(account.getPassword())
					.build();
						
		
	}
}

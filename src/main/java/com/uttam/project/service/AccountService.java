package com.uttam.project.service;

import com.uttam.project.dto.Account;

public interface AccountService {
	Account registerAccount(Integer userId, Account account);
}

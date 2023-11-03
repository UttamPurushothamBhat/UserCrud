package com.uttam.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uttam.project.DTO.Account;
import com.uttam.project.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.Setter;

@Component
@RestController
@RequestMapping("/account")
public class AcountController {

	@Autowired
	@Setter
	AccountService accountServiceImpl;
	
	@PostMapping("/{id}")
	@Operation(summary = "Create Account",
    description = "Create a new account for given user")
	public Account createUser(@PathVariable("id") Integer userId,@RequestBody Account account) {
		return accountServiceImpl.registerAccount(userId, account);
	}
}

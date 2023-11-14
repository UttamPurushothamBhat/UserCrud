package com.uttam.project.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonRootName("user")
public class User{
	
	private Integer userId;
	
	private List<Account> accounts;
	
	private String firstName;
	
	private String lastName;
	
	private Integer age;
	
	private String email;
	
	private String address;
	
}

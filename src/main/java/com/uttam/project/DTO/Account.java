package com.uttam.project.DTO;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Builder;
import lombok.Data;

@Data
@JsonRootName("account")
@Builder
public class Account {
	
	private Integer accountId;
	
	private Integer userId;
	
	private String userName;
	
	private String password;
	
	

}

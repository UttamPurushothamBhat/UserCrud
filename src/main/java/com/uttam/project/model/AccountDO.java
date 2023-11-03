package com.uttam.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="account")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "account_id", unique = true)
	private Integer accountId;
	
	@ManyToOne
	@JoinColumn(name ="user_id")
	private UserDO userDO;
	
	@Column(name = "user_name", unique = true)	
	private String userName;
	
	@Column(name = "password")
	private String password;
}

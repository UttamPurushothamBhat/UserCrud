package com.uttam.project.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "UserDO.getUsersByLastName", query = "SELECT u FROM UserDO u WHERE u.lastName= :lastName")
@Builder
public class UserDO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id", unique = true)
	private Integer userId;
	
	@OneToMany(mappedBy = "userDO", cascade = CascadeType.ALL)
	private List<AccountDO> accounts;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "user_age")
	private Integer age;
	
	@Column(name = "primary_email")
	private String email;
	
	@Column(name = "address")
	private String address;	
	
	
}

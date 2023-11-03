package com.uttam.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uttam.project.model.AccountDO;

public interface AccountRepository extends JpaRepository<AccountDO, Integer> {

}

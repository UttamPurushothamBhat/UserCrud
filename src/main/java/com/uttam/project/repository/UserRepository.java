package com.uttam.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uttam.project.model.UserDO;
import com.uttam.project.model.UserDO;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserDO, Integer> {
	@Query("SELECT u FROM UserDO u WHERE u.firstName = :firstName")
	List<UserDO> getUsersByFirstName(@Param ("firstName") String firstName);
	
	
	List<UserDO> getUsersByLastName(@Param ("lastName")String lastName);

	
}

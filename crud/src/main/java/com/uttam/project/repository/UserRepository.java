package com.uttam.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uttam.project.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT u FROM User u WHERE u.firstName = :firstName")
	List<User> getUsersByFirstName(@Param ("firstName") String firstName);
	
	
	List<User> getUsersByLastName(@Param ("lastName")String lastName);

}

package com.uttam.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uttam.project.dto.User;
import com.uttam.project.model.UserDO;
import com.uttam.project.service.UserService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


//author uttamBhat
@RestController
@RequestMapping("/user")
@OpenAPIDefinition (info =
 @Info(
          title = "User Account registration",
          version = "1.0",
          description = "UserCrud API",
          license = @License(name = "UserCrud License", url = "http://userCrud"),
          contact = @Contact(url = "https://www.linkedin.com/in/uttam-bhat/", name = "Uttam Bhat", email = "ub@gmail.com")
  )
)
@Slf4j
class UserController {
	
	@Autowired
	@Setter
	UserService userServiceImpl;
	
	@GetMapping("/{id}")
	@Operation(summary = "Get user",
    description = "Get specific user")
	public User getUser(@PathVariable("id") Integer userId) {
		return userServiceImpl.getUser(userId);
	}
	
	@GetMapping("")
	@Operation(summary = "Get users",
    description = "Get list of users")
	public List<User>getAllUsers() {
		log.info("looking for users");
		return userServiceImpl.getAllUsers();
	}

	@PostMapping("")
	@Operation(summary = "create user",
    description = "create a user with provided details")
	public User createUser(@RequestBody User user) {
		return userServiceImpl.createUser(user);
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "update user",
    description = "update user detail for given id")
	public User updateUser(@PathVariable("id") Integer userId, @RequestBody User user) {
		return userServiceImpl.updateUser(userId, user);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "delete user",
    description = "delete the given user")
	@ApiResponse(responseCode = "200", description = "user deteled")
    @ApiResponse(responseCode = "400", description = "Invalid username supplied")
    @ApiResponse(responseCode = "404", description = "User not found")
	public String deleteUser(@PathVariable("id") Integer userId) {
		return userServiceImpl.deleteUser(userId);
	}
	
	@GetMapping(params = {"lastName"})
	public List<User> getUsersByLastName( @Parameter(description = "lastName mactching", required = true) @RequestParam String lastName) {
		 return userServiceImpl.getUsersByLastName(lastName);
	}
	
	@GetMapping(params ="firstName")
	public List<User> getUsersByFirstName( @Parameter(description = "firstname matching", required = true) @RequestParam String firstName) {
		 return userServiceImpl.getUsersByFirstName(firstName);
	}
	
}

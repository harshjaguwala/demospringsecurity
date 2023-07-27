package com.example.demospringsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demospringsecurity.models.User;
import com.example.demospringsecurity.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController
{
	@Autowired
	private UserService userService;
	
	
	//all users
	@GetMapping
	public List<User> getAlluser()
	{
		return this.userService.getAllUsers();
	}
	
	@GetMapping("/{username}")
//	@PreAuthorize("hasRole('ADMIN')")
	public User getUser(@PathVariable("username") String username)
	{
		return this.userService.getUserById(username);
	}
	
	@PostMapping("/")
	public User add(@RequestBody User user)
	{
		return this.userService.addUser(user);
	}
}

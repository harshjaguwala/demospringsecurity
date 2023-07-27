package com.example.demospringsecurity.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demospringsecurity.models.User;

@Service
public class UserService 
{
	List<User> list = new ArrayList<>();

	public UserService() 
	{
		list.add(new User("abc","abc","abc@gmail.com","NORMAL"));
		list.add(new User("xyz","abcxyz","xyz@gmail.com","ADMIN"));
	}
	
	//get all user
	public List<User> getAllUsers()
	{
		return this.list;
	}
	
	//get user by id
	public User getUserById(String username) 
	{
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
	}
	
	//add new user
	public User addUser(User user)
	{
		this.list.add(user);
		return user;
	}
	
}

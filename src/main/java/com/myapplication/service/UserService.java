package com.myapplication.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapplication.entity.User;
import com.myapplication.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findOne(int id){
		return userRepository.findOne(id);
	}
	
	public boolean findByUserName(String username){
		return userRepository.findByUserName(username);
	}	
	
	public boolean findByPassword(String password){
		return userRepository.findByPassword(password);
	}
	
	public User findByName(String username){
		return userRepository.findByName(username);		
	}

}

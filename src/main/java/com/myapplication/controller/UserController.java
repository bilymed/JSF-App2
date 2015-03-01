package com.myapplication.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.myapplication.service.UserService;

@ManagedBean
@SessionScoped
public class UserController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{userService}")
	private UserService userService;
	
	@PostConstruct
	public void loadUsers(){
		userService.findAll();
	}

}

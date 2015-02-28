package com.myapplication.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.myapplication.entity.User;
import com.myapplication.service.UserService;

@ManagedBean
@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{userService}")
	private UserService userService;
	private boolean logged;
	
	//private User user = new User();
	//private List<User> users;

	private String username;
	private String password;

	// private String message;
	
	@PostConstruct
	public void loadUser(){
		//users = userService.findAll();
		//user = userService.findByName(username);
	}

	public String login() {
		// String result = userService.findOne(id).toString();
		//String un = null;
		//for(User u : users){
	    //    if(u.getUsername().contains(username))
	    //       un = username;
	    //    break;
	    //}
		//if(users.contains(user)){
		//String un = userService.findByName(username).getUsername().toString();
		//String up = userService.findByPassword(password).getPassword().toString();
		if ((userService.findByName(username)) &&  (userService.findByPassword(password))) {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("username", username);
			this.logged = true;
			return "questions";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Invalid Login!", "Please Try Again!"));
			return "login";
		}
	}

	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	      session.invalidate();
	      this.logged = false;
	      return "login";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	
	
	
	
	

}

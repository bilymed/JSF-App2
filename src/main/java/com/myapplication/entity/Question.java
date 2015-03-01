package com.myapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;


@Entity
public class Question {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min = 1, message = "Question title cannot be empty !")
	private String title;
	
	@Size(min = 1, max= 10000, message = "Question content cannot be empty !")
	private String content;
	
	@ManyToOne
	private User user;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	

}

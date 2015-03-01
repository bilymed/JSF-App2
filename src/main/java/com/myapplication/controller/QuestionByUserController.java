package com.myapplication.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.myapplication.entity.Question;
import com.myapplication.service.QuestionService;

@ManagedBean
@SessionScoped
public class QuestionByUserController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{questionService}")
	private QuestionService questionService;
	
	@ManagedProperty("#{loginController}")
	private LoginController loginController;
	
	private List<Question> questions;
	private Question question = new Question();
	
	
	@PostConstruct
	public void loadQuestionsByUser(){
		questions = questionService.findByUser(loginController.getUser());
	}


	public QuestionService getQuestionService() {
		return questionService;
	}


	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}


	public LoginController getLoginController() {
		return loginController;
	}


	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}


	public List<Question> getQuestions() {
		return questions;
	}


	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}


	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
	
	
}

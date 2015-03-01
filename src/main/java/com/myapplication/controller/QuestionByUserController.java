package com.myapplication.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.myapplication.entity.Question;
import com.myapplication.service.QuestionService;

@ManagedBean
@SessionScoped
public class QuestionByUserController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{questionService}")
	private QuestionService questionService;
	
	@ManagedProperty("#{userController}")
	private UserController userController;
	
	private List<Question> questions;
	private Question question = new Question();
	
	
	@PostConstruct
	public void loadQuestionsByUser(){
		questions = questionService.findByUser(userController.getUser());
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
	
	public void save(){
		questionService.save(question);
		question = new Question();
		questions = questionService.findByUser(userController.getUser());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Question Saved!", null));
	}
	
	public void remove(Question question){
		questionService.remove(question);
		questions = questionService.findByUser(userController.getUser());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Question removed!", null));
	}
	
	public void refresh(){
		questions.clear();
		questions = questionService.findByUser(userController.getUser());
	}
	
	//=========================================================================================================//

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}
		
}

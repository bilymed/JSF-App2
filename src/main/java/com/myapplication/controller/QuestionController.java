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

//@Component //Spring
@ManagedBean
@SessionScoped
public class QuestionController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//@Autowired //Spring
	@ManagedProperty("#{questionService}")
	private QuestionService questionService;

	private List<Question> questions;
	private Question question = new Question();
	
	@ManagedProperty("#{userController}")
	private UserController userController;
	
	@PostConstruct
	public void loadQuestions(){
		questions = questionService.findAll();
	}
	
	public void save(){
		question.setUser(userController.getUser());
		questionService.save(question);
		question = new Question();
		questions = questionService.findAll();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Question Saved!", null));
	}
	
	public void remove(Question question){
		questionService.remove(question);
		questions = questionService.findAll();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Question removed!", null));
	}
	
	public void clear(){
		question = new Question();
		questions.clear();
		questions = questionService.findAll();
	}
	
	
	//=================================================================================================//

	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
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

	public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

}

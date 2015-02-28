package com.myapplication.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
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
	
	@PostConstruct
	public void loadArticles(){
		questions = questionService.findAll();
	}
	
	public void save(){
		questionService.save(question);
		question = new Question();
		questions = questionService.findAll();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aticle Saved!", null));
	}
	
	public void remove(Question question){
		questionService.remove(question);
		questions = questionService.findAll();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aticle removed!", null));
	}
	
	public void clear(){
		question = new Question();
	}
	
	public String nav(){
		question = new Question();
		return "questions";
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
	
}

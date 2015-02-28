package com.myapplication.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.myapplication.entity.Answer;
import com.myapplication.entity.Question;
import com.myapplication.service.AnswerService;

@ManagedBean
@RequestScoped
public class AnswerController {
	
	@ManagedProperty("#{answerService}")
	private AnswerService answerService;
	
	@ManagedProperty("#{questionController.question}")
	private Question question;
	
	private List<Answer> answers;
	private Answer answer = new Answer();
	
	@PostConstruct
	public void loadAnswers(){
		answers = answerService.findByQuestion(question);
	}
	
	public void save(){
		answer.setQuestion(question);
		answerService.save(answer);
		answers = answerService.findByQuestion(question);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Answer Saved!", null));
	}
	
	
	
	
	//===========================================================================================//

	public AnswerService getAnswerService() {
		return answerService;
	}

	public void setAnswerService(AnswerService answerService) {
		this.answerService = answerService;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}	

}

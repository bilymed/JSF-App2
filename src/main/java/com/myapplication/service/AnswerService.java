package com.myapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapplication.entity.Answer;
import com.myapplication.entity.Question;
import com.myapplication.repository.AnswerRepository;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	public List<Answer> findByQuestion(Question question){
		return answerRepository.findByQuestion(question);
	}
	
	public void save(Answer answer){
		answerRepository.save(answer);
	}
	
	

}

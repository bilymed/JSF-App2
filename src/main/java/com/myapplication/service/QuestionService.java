package com.myapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapplication.entity.Question;
import com.myapplication.entity.User;
import com.myapplication.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public List<Question> findAll(){
		return questionRepository.findAll();
	}

	public void save(Question question) {
		questionRepository.save(question);		
	}

	public void remove(Question question) {
		questionRepository.delete(question);
	}
	
	public List<Question> findByUser(User user){
		return questionRepository.findByUser(user);
	}

}

package com.myapplication.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapplication.entity.Answer;
import com.myapplication.entity.Question;
import com.myapplication.entity.User;
import com.myapplication.repository.AnswerRepository;
import com.myapplication.repository.QuestionRepository;
import com.myapplication.repository.UserRepository;

@Service
public class InitDbService {
	
	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private QuestionRepository articleRepository;
	
	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init() {
		System.out.println("****** INIT DATABASE START ******");
		{
			Question question = new Question();
			question.setTitle("JPA OneToMany not deleting child ?");
			question.setContent("content 1 content 1 content 1 content 1 content 1 content 1 content 1 content 1 content 1 content 1 content 1 content 1 content 1 content 1 content 1 content 1");
			articleRepository.save(question);
			{
				Answer answer = new Answer();
				answer.setContent("answer 1");
				answer.setQuestion(question);
				answerRepository.save(answer);
			}
		}
		{
			Question article = new Question();
			article.setTitle("title 2");
			article.setContent("content 2");
			articleRepository.save(article);
		}
		{
			Question article = new Question();
			article.setTitle("title 3");
			article.setContent("content 3");
			articleRepository.save(article);
		}		
		{
			User user = new User();
			user.setUsername("username");
			user.setPassword("password");
			userRepository.save(user);
		}
		System.out.println("****** INIT DATABASE FINISH ******");
	}

}

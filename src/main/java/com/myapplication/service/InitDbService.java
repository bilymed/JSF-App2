package com.myapplication.service;

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
	private QuestionRepository questionRepository;

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init() {
		System.out.println("****** INIT DATABASE START ******");
		{
			User user = new User();
			user.setUsername("user1");
			user.setPassword("pass1");
			userRepository.save(user);
			{
				Question question = new Question();
				question.setTitle("JPA OneToMany not deleting child ?");
				question.setContent("I have a problem with a simple OneToMany "
						+ "mapping between a parent and a child entity. All works well, "
						+ "only that child records are not deleted when i remove them "
						+ "from the collection.");
			    question.setUser(user);
				questionRepository.save(question);
				{
					Answer answer = new Answer();
					answer.setContent("You need to either use vendor-specific extensions "
							+ "to force this behaviour or explicitly delete the child "
							+ "AND remove it from the parent's collection.");
					answer.setQuestion(question);
					answer.setUser(user);
					answerRepository.save(answer);
				}
			}
			{
				Question question = new Question();
				question.setTitle("title 2");
				question.setContent("content 2");
				question.setUser(user);
				questionRepository.save(question);
			}
		}
		{
			User user = new User();
			user.setUsername("user2");
			user.setPassword("pass2");
			userRepository.save(user);
			{
				{
					Question question = new Question();
					question.setTitle("title 3");
					question.setContent("content 3");
					question.setUser(user);
					questionRepository.save(question);
				}
			}
		}

		System.out.println("****** INIT DATABASE FINISH ******");
	}

}

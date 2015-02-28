package com.myapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapplication.entity.Answer;
import com.myapplication.entity.Question;

public interface AnswerRepository extends JpaRepository<Answer, Integer>{

	List<Answer> findByQuestion(Question question);
}

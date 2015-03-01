package com.myapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myapplication.entity.Question;
import com.myapplication.entity.User;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	
	@Query("select q from Question q where q.user = ?1")
	List<Question> findByUser(User user);

}

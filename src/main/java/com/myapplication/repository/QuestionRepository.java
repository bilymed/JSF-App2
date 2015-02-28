package com.myapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapplication.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

}

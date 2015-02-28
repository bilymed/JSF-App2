package com.myapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myapplication.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("select case  WHEN count(u) > 0 THEN 'true' ELSE 'false' END from User u where u.username = ?1 ")
	Boolean findByName(String userName);
	
	@Query("select case  WHEN count(u) > 0 THEN 'true' ELSE 'false' END from User u where u.password = ?1")
	Boolean findByPassword(String password);
	
}

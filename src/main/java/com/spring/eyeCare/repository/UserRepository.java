package com.spring.eyeCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.eyeCare.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	@Query("select u from User u where u.userName=?1")
	public User findUserByUsername(String userName);
	

}

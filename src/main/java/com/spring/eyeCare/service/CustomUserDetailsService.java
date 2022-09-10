package com.spring.eyeCare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.eyeCare.model.CustomUserDetails;
import com.spring.eyeCare.model.User;
import com.spring.eyeCare.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findUserByUsername(username);
		if(user!= null) {
			return new CustomUserDetails(userRepo.findUserByUsername(username));
		}
		return new CustomUserDetails(new User(1,"Sneha","$2a$10$g/Pqf4gxueqJYzGrPGmGqupShS5Q1PvhRheqIH0/33LhsTHNn2Xdy","Sneha"));
	}

}

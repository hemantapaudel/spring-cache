package com.paudel.spring.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.paudel.spring.cache.model.User;
import com.paudel.spring.cache.repository.UsersRepository;

@Service
public class UserService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	
	@Cacheable(value = "usersCache", key = "#userId")
	public User getUser(String userId){
		System.out.println("=====fetching data from db , userId "+ userId);
		return usersRepository.findById(Long.parseLong(userId));
	}

}

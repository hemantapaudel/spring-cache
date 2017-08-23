package com.paudel.spring.cache.loader;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paudel.spring.cache.model.User;
import com.paudel.spring.cache.repository.UsersRepository;

@Component
public class DataLoader {

	@Autowired
	UsersRepository usersRepository;
	
	@PostConstruct
	public void load(){
		List<User> userList = getUserList();
		usersRepository.save(userList);
	}
	
	List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		for (long i = 0; i < 1000; i++) {
			User user = new User();
			user.setId(i);
			user.setName("Hemanta");
			user.setSalary(90000L + i);
			user.setTeamName("boys");
			userList.add(user);
		}
		return userList;

	}
}

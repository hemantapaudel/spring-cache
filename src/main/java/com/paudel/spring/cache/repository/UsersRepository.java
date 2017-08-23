package com.paudel.spring.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paudel.spring.cache.model.User;

public interface UsersRepository extends JpaRepository<User, Long> {
	
    User	findById(Long id);
   
    User findByName(String name);
    
    
    @SuppressWarnings("unchecked")
	User save(User user);
    
    

}

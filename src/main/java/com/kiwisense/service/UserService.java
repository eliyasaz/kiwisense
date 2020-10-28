package com.kiwisense.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiwisense.dal.model.User;
import com.kiwisense.dal.repository.UserRepository;
import com.kiwisense.exception.ResourceNotFoundException;

@Service
public class UserService {

	Logger _LOG = LoggerFactory.getLogger(UserService.class);

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}


//	public boolean existsByUserName(String userName) {
//		return this.userRepository.existsByUserName(userName);
//	}
	
	public User getUser(String email) {
		return this.userRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found with id: " + email));
				
	}
	
	public boolean existsByEmail(String userEmail) {
		return this.userRepository.existsByEmail(userEmail);
	}

	public List<User> getUsers() {
		return this.userRepository.findAll();
	}
	
	public Long findUserByEmail(String email) {
		return this.userRepository.findUserIdByEmail(email);
	}

	public User getUser(Long userId) {
		User usr = null;
		try {
			usr = this.userRepository.findById(userId).get();
		} catch (NoSuchElementException nsc) {
			String msg = "User with id " + userId + "  not found.";
			_LOG.warn(msg);;
			throw new ResourceNotFoundException(msg);
		}
		return usr;
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		if(user  == null) {
			throw new ResourceNotFoundException("user could not be retrived");
		}
		return this.userRepository.save(user);
	}

}

package com.springangular.application.SpringAngular.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springangular.application.SpringAngular.model.User;

@Service
public class UserDaoService {

	@Autowired
	UserRepository userRepository;

	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	public User saveUser(User user) {

		userRepository.save(user);
		
		return user;

	}

	public void deleteUser(int id) {
		Optional<User> user = userRepository.findById(id);
		userRepository.delete(user.get());

	}

	public void findbyemail(User user) {

	}

	public User getUser(int id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();

	}

}

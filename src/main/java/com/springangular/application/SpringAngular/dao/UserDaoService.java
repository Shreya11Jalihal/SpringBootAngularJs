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
		List<User> users = userRepository.findAll();
		for (User nuser : users) {
			if (!nuser.getemail().equals(user.getemail())) {
				userRepository.save(user);
			} else
				return null;
		}

		return user;

	}

	public Optional<User> getUserByEmail(String email) {

		return userRepository.findByEmail(email);

	}

	public void deleteUser(int id) {
		Optional<User> user = userRepository.findById(id);
		userRepository.delete(user.get());

	}

	public User getUser(int id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();

	}

}

package com.springangular.application.SpringAngular.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springangular.application.SpringAngular.dao.UserRepository;
import com.springangular.application.SpringAngular.model.User;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepository userRepository;

	/*
	 * Service to save the user bean in the database after checking if the user
	 * already exists
	 * 
	 * @param User bean
	 * 
	 * @return saved User bean in the Database
	 */
	public User saveUser(User user) {
		logger.debug("Retrieving all the users from the database");
		List<User> users = userRepository.findAll();
		if (users.size() == 0) {
			userRepository.save(user);
		}
		logger.debug("Checking if the user already exists in the database");
		for (User nuser : users) {
			if (!nuser.getEmail().equals(user.getEmail())) {
				logger.debug("Saving the user" + user);
				userRepository.save(user);
			} else
				return null;
		}

		return user;

	}

	/*
	 * Service method to retrieve user from the database with emailId
	 * 
	 * @param String email
	 * 
	 * @param String password
	 * 
	 * @return retrieved user bean
	 */
	public Optional<User> getUserByEmail(String email, String password) {
		logger.debug("retrieving the user from the database associated with the emailId");
		Optional<User> user = userRepository.findByEmail(email);
		logger.debug("Validating if the user exists and the password matches");
		if (user.get() != null && password.equals(user.get().getPassword())) {
			return user;
		} else {
			return Optional.ofNullable(null);
		}

	}

}

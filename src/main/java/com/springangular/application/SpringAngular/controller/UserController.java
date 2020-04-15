package com.springangular.application.SpringAngular.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springangular.application.SpringAngular.model.User;
import com.springangular.application.SpringAngular.service.UserService;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	/*
	 * Endpoint to save a User bean in the Database
	 * 
	 * @param User bean
	 * 
	 * @return saved User bean in the Database
	 */
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public User saveUser(@RequestBody User user) {
		logger.info("Saving User Bean in the Database");
		User responseUser = userService.saveUser(user);
		return responseUser;

	}

	/*
	 * End point to retrieve a User bean from the Database
	 * 
	 * @param User bean
	 * 
	 * @return User bean from the database
	 */
	@RequestMapping(value = "/validateUser", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public Optional<User> getUser(@RequestBody User data) {
		logger.info("Validating User Bean in the Database" + data);
		Optional<User> user = userService.getUserByEmail(data.getEmail(), data.getPassword());
		return user;

	}

	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView model) {
		ModelAndView view = new ModelAndView();
		view.setViewName("login");
		return view;

	}

}

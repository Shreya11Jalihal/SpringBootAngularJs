package com.springangular.application.SpringAngular.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springangular.application.SpringAngular.dao.UserDaoService;
import com.springangular.application.SpringAngular.model.User;

@Controller
public class IndexController {

	@Autowired
	UserDaoService userDaoService;

	@RequestMapping(value = "/users", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getUsers() {
		return userDaoService.getAllUsers();
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public User saveUser(@RequestBody User user) {
		User responseUser = userDaoService.saveUser(user);
		System.out.println(responseUser);

		return responseUser;

	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteUser(@PathVariable int id) {
		userDaoService.deleteUser(id);
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public User getUser(@RequestBody User data) {

		Optional<User> responseUser = userDaoService.getUserByEmail(data.getemail());
		return responseUser.get();

	}

	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView model) {
		ModelAndView view = new ModelAndView();
		view.setViewName("login");
		return view;

	}

	@RequestMapping(value = "/thyme")
	public ModelAndView logged(ModelAndView model) {
		ModelAndView view = new ModelAndView();
		view.setViewName("thyme");
		return view;

	}

}

package com.springangular.application.SpringAngular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springangular.application.SpringAngular.dao.UserDaoService;
import com.springangular.application.SpringAngular.model.User;

@RestController
public class IndexController {

	@Autowired
	UserDaoService userDaoService;

	@RequestMapping(value = "/users", method = RequestMethod.GET,headers = "Accept=application/json")
	public List<User> getUsers() {
		return userDaoService.getAllUsers();
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public User saveUser(@RequestBody User user) {
		userDaoService.saveUser(user);

		return user;	

	}
	
	@RequestMapping(value="/deleteUser/{id}",method=RequestMethod.DELETE,headers = "Accept=application/json")
	public void deleteUser(@PathVariable int id)
	{
		userDaoService.deleteUser(id);
	}
	
	@RequestMapping(value="/getusers/{id}",method=RequestMethod.GET)
	public ModelAndView getUser(@PathVariable int id)
	{
		
		User user=userDaoService.getUser(id);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("thyme");
		modelAndView.addObject("user",user);
		return modelAndView;		
		
	}
	
	@RequestMapping(value="/thyme",method=RequestMethod.GET)
	public String login()
	{
		return "Welcome";		
		
	}
}

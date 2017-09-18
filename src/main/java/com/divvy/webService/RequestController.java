package com.divvy.webService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestController {
	
	

	@RequestMapping("/login/{user}/{password}")
	@ResponseBody
	int login(@PathVariable("user") String username, @PathVariable("password") String password) {
		return SqlCommunication.login(username, password);
	}
	
	
	
	@RequestMapping("/register/{user}/{password}")
	@ResponseBody
	int register(@PathVariable("user") String username, @PathVariable("password") String password) {
		return SqlCommunication.register(username, password);
	}
	
	@RequestMapping("/checkuser/{user}")
	@ResponseBody
	int checkUser(@PathVariable("user") String username) {
		return SqlCommunication.checkUser(username);
	}
		
		
	

}

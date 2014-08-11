package com.nut.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nut.domain.UserInfo;
import com.nut.service.IUserService;

@Controller
public class UserController {

	@Autowired
	@Qualifier("userServiceImpl")
	private IUserService userService;

	
	@RequestMapping(value="doLogin", method=RequestMethod.POST)
	public ModelAndView loginUser(@RequestParam(value = "userId", required = true) String userId,
			@RequestParam(value = "password", required = true) String password, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		UserInfo user = new UserInfo();
		user.setPassword(password);
		user.setUserId(userId);
		if(userService.validateUser(user)){
			request.getSession().setAttribute("LOGINUSER", user);
			mav.setViewName("redirect:bill");
		}
		else{
			mav.setViewName("redirect:login");
		}
		return mav;
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String toLoginPage()
	{
		return "login";
	}
	
	@RequestMapping(value="validate", method=RequestMethod.POST)
	@ResponseBody
	public boolean validateUserId(@RequestParam(value="userId", required=true) String userId){
		return userService.validateUserId(userId);
	}
}

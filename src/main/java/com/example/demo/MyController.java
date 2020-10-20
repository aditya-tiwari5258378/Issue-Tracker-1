package com.example.demo;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("/")
	public String home() {
		return "Home";
	}
	
	@RequestMapping("/Login")
		public String login() {
			return "Login";
		}
	
	@RequestMapping("/SignUp")
	public String signUp() {
		return "SignUp";
	}
	
	@RequestMapping("/add")
	public String add(User user) throws SQLException
	{
		UserDAO udao=new UserDAO();
		int no=udao.create(user);
		if(no==1)
			return "success";
		else
			return "failure";
	}
	
//	@RequestMapping("/verify")
//	public String verify(Login login) throws SQLException
//	{
//		LoginDAO ldao=new LoginDAO();
//		String p=ldao.validateUser(login);
//		if(p.equals("user"))
//			return "Uhome";
//		else if(p.equals("admin"))
//			return "Ahome";
//		else if(p.equals("catrep"))
//			return "CRhome";
//		else
//			return "failure";
//	}
	@RequestMapping("/verify")
	public ModelAndView validate(String userId, String password, HttpSession session) throws SQLException
	{
		//how to check if login is successful or not?
		//by calling dao method read
		// if i get null, it means failure.
		ModelAndView mv=new ModelAndView();
		UserDAO udao=new UserDAO();
		User user = udao.read(userId, password);
		if(user==null)
		{
			mv.setViewName("failure");
			mv.addObject("message","Login failed");
		}
		else
		{
			//check the role and redirect accordingly
			
			mv.setViewName(user.getCategory());		
			session.setAttribute("user", user);		
		}
		return mv;
	}

	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "Logged Out. Click<a href=Login > here </a>to go to login page";
	}
}

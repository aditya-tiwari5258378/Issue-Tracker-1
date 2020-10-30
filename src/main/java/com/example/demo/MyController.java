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
	public ModelAndView add(User user,HttpSession session) throws SQLException
	{
		UserDAO udao=new UserDAO();
		int no=udao.create(user);
		ModelAndView mv= new ModelAndView();
		if(no==1) {
			mv.setViewName("question");		
			session.setAttribute("user", user);	
		}
		else
			mv.setViewName("failure");
		return mv;
	}
	
	@RequestMapping("/savequestion")
	public ModelAndView add(Question question) throws SQLException {
		QuestionDAO qdao=new QuestionDAO();
		int no=qdao.create(question);
		ModelAndView mv=new ModelAndView();
		if(no==1) {
			mv.setViewName("Login");
		}
		else {
			mv.setViewName("question");
	        mv.addObject("message","Failed To Register");
		}
		return mv;
	}
	
	@RequestMapping("/verify")
	public ModelAndView validate(String userId, String password, HttpSession session) throws SQLException
	{

		ModelAndView mv=new ModelAndView();
		UserDAO udao=new UserDAO();
		User user = udao.read(userId, password);
		if(user==null)
		{
			String userid =udao.find(userId);
			if(userid.equals("found")) {
				mv.setViewName("Login");
				mv.addObject("message","Password Incorrect");
			}
			else {
				mv.setViewName("Login");
				mv.addObject("message","UserId Not Present");
			}
			
		}
		else
		{
			//check the role and redirect accordingly
			
			mv.setViewName(user.getCategory());		
			session.setAttribute("user", user);		
		}
		return mv;
	}
	
	@RequestMapping("/requestid")
	public String fetch() {
		return "fetchId";
	}
	
	@RequestMapping("/getuserid")
	public ModelAndView getuserid(String contactNumber,String email) throws SQLException {
		ModelAndView mv= new ModelAndView();
		UserDAO udao=new UserDAO();
		User user = udao.fetch(contactNumber, email);
		if(user==null) {
			mv.setViewName("fetchId");
			mv.addObject("message","Invalid Answers");
	
		}
		else {
			mv.setViewName("fetchId");
			mv.addObject("userid","User ID is "+user.getUserId());
		}
		return mv;
	}
	@RequestMapping("/resetpass")
	public String update() {
		return "resetq";
	}
	
	@RequestMapping("passreset")
	public ModelAndView change(String userId,String a1, String a2,String a3,HttpSession session ) throws SQLException {
		ModelAndView mv=new ModelAndView();
		QuestionDAO qdao=new QuestionDAO();
		Question question =qdao.read(userId, a1, a2, a3);
		if(question==null)
		{
			mv.setViewName("resetq");
			mv.addObject("message", "Invalid Answers");
		}
		else {
			session.setAttribute("userId", userId);
			mv.setViewName("passwordreset");
		}
		return mv;
	}
	
	@RequestMapping("modifypass")
	public ModelAndView modifypass(String password, String userId) throws SQLException
	{

		ModelAndView mv=new ModelAndView();
		UserDAO udao=new UserDAO();
		int no= udao.update(password, userId);
		if(no==1)
		{
			mv.setViewName("Login");	
			
		}
		else
		{
			mv.setViewName("passwordreset");
			mv.addObject("message","Unable To Change Password");	
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

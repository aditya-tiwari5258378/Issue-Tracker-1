package com.example.demo;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping("/rhelp")
	public ModelAndView rhelp(HttpSession session) {
		ModelAndView mv= new ModelAndView();
		User user=(User)session.getAttribute("user");
		if(user==null) {
			mv.addObject("error","you have not logged in please click here <a href=Login> here</a> to go to login page");
			mv.setViewName("failure");
		}
		else {
		mv.setViewName("help");	
		}
		return mv;
		
	}
	
	@RequestMapping("/rissue")
	public ModelAndView rissue(HttpSession session) {
		ModelAndView mv= new ModelAndView();
		User user=(User)session.getAttribute("user");
		if(user==null) {
			mv.addObject("error","you have not logged in please click here <a href=Login> here</a> to go to login page");
			mv.setViewName("failure");
		}
		else {
		mv.setViewName("raiseIssue");	
		}
		return mv;
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
	
	@RequestMapping(value="/verify",method = RequestMethod.POST)
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
	
	
	@RequestMapping(value = "/helpIssue", method = RequestMethod.POST)
	public String checkLogin(@ModelAttribute("Help") Help userformData,  BindingResult result, HttpSession session)  throws SQLException{
		
		HelpDAO hdao = new HelpDAO(); 
		 
		User user = (User)session.getAttribute("user");
	    System.out.println("Controller...");
	    String userId= user.getUserId();
	    String requestId= Help.getAlphaNumericString(10);
	    String issue = userformData.getIssue();
	    String description = userformData.getDescription();
	    String dob = Help.getCurrentTimeUsingDate();
	    Help help = new Help(userId,requestId,issue,description,dob);
	    int n= hdao.getHelp(help);
	    return "helpOutput";
	}
	
	@RequestMapping(value = "/RaiseIssue", method = RequestMethod.POST)
	public String RaiseIssue(@ModelAttribute("raiseIssue") raiseIssue userformData, BindingResult 
	result, HttpSession session) throws SQLException{
		raiseIssueDAO rdao = new raiseIssueDAO();
		User user = (User)session.getAttribute("user");
		String userId= user.getUserId();
		String categoryId = raiseIssue.getAlphaNumeric(8);
		String category = userformData.getCategory();
		String details = userformData.getDetails();
		String status = userformData.getStatus();
		raiseIssue rissue = new raiseIssue(userId,categoryId,category,details,status);
		int n = rdao.getRaiseIssue(rissue);
		return "raiseIssueDisplay";
	}
	
	@RequestMapping(value="/viewHelp",method=RequestMethod.GET)
	public String update1(HttpSession session,ModelMap model) throws SQLException 
	{
		//List<Help>requestList = List<Help>(session.getAttribute("requestList"));
		HelpDAO helpdao = new HelpDAO();
		List<Help> requestList = helpdao.viewHelp();
		//System.out.println(requestList);
		model.put("requestList", requestList);
		//System.out.println(requestList);
		return "viewHelp";
	}
	
	@RequestMapping("/resolveIssue")
	public String update2(Help help,HttpSession session) {
		session.setAttribute("help", help);
		System.out.println(help.getRequestId());
		return "resolveIssue";
	}
	
	@RequestMapping(value = "/roIssue", method = RequestMethod.POST)
	public String checkLogin(@ModelAttribute("Resolution") Resolution userformData, BindingResult 
	result,HttpSession session)  throws SQLException{
		
		ResolutionDAO rdao = new ResolutionDAO(); 
		 
		
		Help help = (Help)session.getAttribute("help");
	    System.out.println("Resolution...");
  
	    System.out.println("=====>  " + userformData.getResolution());
	    System.out.println("=====>  " + help.getRequestId());
	   
	  
	    String requestId  = help.getRequestId();
	    String resolve = userformData.getResolution();
	   
	    Resolution resolution = new Resolution(requestId,resolve);
	  
	    //rdao.addHelp(resolution);
	   // session.setAttribute("requestList", requestList);
	   int n= rdao.getResolved(resolution);
	   System.out.println(n);
	    return "showResolution";
	}
      @RequestMapping(value="/delete",method=RequestMethod.GET)
      public String deleteToDo(Help help,HttpSession session) throws SQLException
      {
    	  session.setAttribute("help", help);
    	  Help help1 = (Help)session.getAttribute("help");
    	   String requestId  = help1.getRequestId();
    	  HelpDAO hdao = new HelpDAO();
    	  hdao.delete(requestId);
    	  return "redirect:/viewHelp";
    	  
      }
      

      @RequestMapping(value="/userhistory",method = RequestMethod.GET)
    	public String userHistoryList(ModelMap model,HttpSession session) throws SQLException 
        {
      	  //session.setAttribute("user", user);
      	  User user = (User)session.getAttribute("user");
    	    //System.out.println("Controller...");
    	    String userId= user.getUserId();
      	   System.out.println(userId);
      	raiseIssueDAO rdao = new raiseIssueDAO();
    		List<raiseIssue> displayList = rdao.displayList(userId);
    		//System.out.println(requestList);
    		model.put("displayList", displayList);
    		System.out.println(displayList);
    		return "userHistory";
    	}
      

      @RequestMapping("/displayUserHistory")
    	public String userHistoryDetails(HttpSession session, raiseIssue raiseissue,ModelMap model) throws SQLException 
        {
      	  session.setAttribute("raiseissue", raiseissue);
      	  raiseIssue raiseissue1 = (raiseIssue)session.getAttribute("raiseissue");
      	  User user = (User)session.getAttribute("user");
      	   String categoryId  = raiseissue1.getCategoryId();
      	 raiseIssueDAO rdao = new raiseIssueDAO();
      	  raiseIssue raiseIssue2 = rdao.view(categoryId);
      	  model.put("raiseIssue", raiseIssue2);
    		return "displayUserHistory";
    	  }
      @RequestMapping(value="/adminHistory",method = RequestMethod.GET)
  	public String adminHistoryList( raiseIssue raiseissue,ModelMap model,HttpSession session) throws SQLException 
      {
    	  // session.setAttribute("user", user);
    	  session.setAttribute("raiseissue", raiseissue);
    	  raiseIssue raiseIssue1 = (raiseIssue)session.getAttribute("raiseissue");
    	  //User user1 = (User)session.getAttribute("user");
    	   //String requestId  = help1.getRequestId();
    	  raiseIssueDAO rdao = new raiseIssueDAO();
    	  List<raiseIssue>categoryList = rdao.viewHistoryIssue();
    	  //System.out.println(categoryList);
    	  model.put("categoryList", categoryList);
    	  return "adminHistory";
  	}
      
      @RequestMapping("/displayAdminHistory")
    	public String adminHistoryDetails(HttpSession session, raiseIssue raiseissue,ModelMap model,User user) throws SQLException 
        {
    	  session.setAttribute("raiseissue", raiseissue);
      	  raiseIssue raiseissue1 = (raiseIssue)session.getAttribute("raiseissue");
      	  User user1 = (User)session.getAttribute("user");
      	   String categoryId  = raiseissue1.getCategoryId();
      	 raiseIssueDAO rdao = new raiseIssueDAO();
      	  raiseIssue raiseIssue2 = rdao.view(categoryId);
      	  model.put("raiseIssue", raiseIssue2);
    		return "displayAdminHistory";
    	  }
      
      
      @RequestMapping(value="/mapCat",method=RequestMethod.GET)
      public String mapCategory(raiseIssue raiseissue,HttpSession session,ModelMap model) throws SQLException
      {
    	  session.setAttribute("raiseissue", raiseissue);
    	  raiseIssue help1 = (raiseIssue)session.getAttribute("raiseissue");
    	   String categoryId  = help1.getCategoryId();
    	   raiseIssueDAO rdao = new raiseIssueDAO();
    	  raiseIssue issue=rdao.view(categoryId);
    	  model.put("issue", issue);
    	  return "changeCat";
    	  
      }
      
      @RequestMapping(value="/updateCat",method=RequestMethod.GET)
      public String updateCategory(raiseIssue raiseissue,HttpSession session) throws SQLException
      {
    	  session.setAttribute("raiseissue", raiseissue);
    	  raiseIssue help1 = (raiseIssue)session.getAttribute("raiseissue");
    	  String categoryId  = help1.getCategoryId();
    	  String category  = help1.getCategory();
    	  raiseIssueDAO upd=new raiseIssueDAO();
    	  int n=upd.update(category,categoryId);
    	 return "redirect:catIssue";
      }
      
      @RequestMapping(value="/catIssue",method=RequestMethod.GET)
  	public String updateIssue(HttpSession session,ModelMap model) throws SQLException 
  	{
  		//List<Help>requestList = List<Help>(session.getAttribute("requestList"));
  		raiseIssueDAO helpdao = new raiseIssueDAO();
  		List<raiseIssue> requestList = helpdao.viewIssue();
  		//System.out.println(requestList);
  		model.put("requestList", requestList);
  		//System.out.println(requestList);
  		return "viewIssue";
  	}
      
     //mani
      
      @RequestMapping("/addCatpage")
      public String showaddcatpage() {
    	  return "addcategory";
      }
      
      @RequestMapping(value="/addCat",method=RequestMethod.GET)
  	public String addCat(Category category,HttpSession session) throws SQLException
  	{
  		CategoryDAO cdao=new CategoryDAO();
  		int no=cdao.addCat(category);
  		if(no==1) {
  			return "redirect:/viewCat";
  		}
  		else
  			return "failure";
  	}
      
      @RequestMapping(value="/deleteCat",method=RequestMethod.GET)
      public String deleteCat(Category category,HttpSession session) throws SQLException
      {
    	  session.setAttribute("category", category);
    	  Category help1 = (Category)session.getAttribute("category");
    	   String id  = category.getId();
    	   CategoryDAO catdao = new CategoryDAO();
    	   catdao.delete(id);
    	  return "redirect:/viewCat";
    	  
      }

    @RequestMapping(value="/viewCat",method=RequestMethod.GET)
	public String viewCat(HttpSession session,ModelMap model) throws SQLException 
	{
		//List<Category>requestList = List<Category>(session.getAttribute("requestList"));
		CategoryDAO catdao = new CategoryDAO();
		List<Category> requestList = catdao.viewCat();
		//System.out.println(requestList);
		model.put("requestList", requestList);
		//System.out.println(requestList);
		return "viewcategory";
	}


    


	
}

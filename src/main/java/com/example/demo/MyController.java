package com.example.demo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	

	@Autowired
	raiseIssueDAO rdao;
	@Autowired
	HelpDAO hdao;
	@Autowired
	QuestionDAO qdao;
	@Autowired
	ResolutionDAO redao;
	@Autowired
	UserDAO udao;
	@Autowired
	CategoryDAO cdao;

	@RequestMapping("/")
	public String home() {
		return "Home";
	}
	
	@RequestMapping("/Login")
		public String login() {
			return "Login";
		}

	@RequestMapping(value = "/SignUp", method = RequestMethod.GET)
	public String showUserRegisterPage(ModelMap model)
	{
		model.addAttribute("user", new User());
		return "SignUp";
	}
	@RequestMapping(value = "/SignUp", method = RequestMethod.POST)
	public String RegisterUser(@Valid @ModelAttribute("user") User user,  BindingResult result, ModelMap model,HttpSession session) throws SQLException {
		
		if (result.hasErrors())
			return "SignUp";
			if(udao.create(user)==1)
			{
				model.put("success","Your details are submitted successfully.");
				session.setAttribute("user", user);	
				return "question";
			}
			else
				return "SignUp";
		
	}
	
	
	
//	@RequestMapping("/add")
//	public ModelAndView add(User user,HttpSession session) throws SQLException
//	{
//		//UserDAO udao=new UserDAO();
//		int no=udao.create(user);
//		ModelAndView mv= new ModelAndView();
//		if(no==1) {
//			mv.setViewName("question");		
//			session.setAttribute("user", user);	
//		}
//		else
//			mv.setViewName("failure");
//		return mv;
//	}
	
	@RequestMapping("/savequestion")
	public ModelAndView add(Question question) throws SQLException {
		//QuestionDAO qdao=new QuestionDAO();
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
	
	@RequestMapping("/requestid")
	public String fetch() {
		return "fetchId";
	}
	
	@RequestMapping("/getuserid")
	public ModelAndView getuserid(String contactNumber,String email) throws SQLException {
		ModelAndView mv= new ModelAndView();
		//UserDAO udao=new UserDAO();
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
		//QuestionDAO qdao=new QuestionDAO();
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
		//UserDAO udao=new UserDAO();
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
	
//after login for user
	
	@RequestMapping(value="/verify",method = RequestMethod.POST)
	public ModelAndView validate(String userId, String password, HttpSession session) throws SQLException
	{

		ModelAndView mv=new ModelAndView();
		UserDAO u=new UserDAO();
		User user = u.read(userId, password);
		if(user==null)
		{
			String userid =u.find(userId);
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
//			feedbackDAO fdao=new feedbackDAO();
//			String id=user.getUserId();
			// feedback f=fdao.viewfeedback(id);
			 //System.out.println(f);
//			 if(f.getUserId()==id)
//			 {
//				 mv.addObject("requestId",f.getRequestId());
//				 mv.setViewName("feedback");
//				 }
			mv.setViewName(user.getCategory());	
			notificationDAO ndao=new notificationDAO();
			List<Category> notificationList=ndao.read();
			mv.addObject("str", "a new ");
			mv.addObject("notificationList", notificationList);
			mv.addObject("str1", "has been added");
			session.setAttribute("user", user);		
		}
		return mv;
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
	public ModelAndView rissue(HttpSession session) throws SQLException {
		ModelAndView mv= new ModelAndView();
		User user=(User)session.getAttribute("user");
		if(user==null) {
			mv.addObject("error","you have not logged in please click here <a href=Login> here</a> to go to login page");
			mv.setViewName("failure");
		}
		else {
			//CategoryDAO catdao = new CategoryDAO();
			List<Category> requestList = cdao.viewCat();
			mv.addObject("requestList", requestList);
			mv.setViewName("raiseIssue");	
		}
		return mv;
	}
	
	@RequestMapping(value = "/helpIssue", method = RequestMethod.POST)
	public String checkLogin(@ModelAttribute("Help") Help userformData,  BindingResult result, HttpSession session)  throws SQLException{
		
		//HelpDAO hdao = new HelpDAO(); 
		 
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
		//raiseIssueDAO rdao = new raiseIssueDAO();
		User user = (User)session.getAttribute("user");
		String userId= user.getUserId();
		String categoryId = raiseIssue.getAlphaNumeric(8);
		String category = userformData.getCategory();
		String details = userformData.getDetails();
		String status = userformData.getStatus();
		Date dateOfIssue = raiseIssue.getDate();
		raiseIssue rissue = new raiseIssue(userId,categoryId,category,details,status,dateOfIssue);
		int n = rdao.getRaiseIssue(rissue);
		return "raiseIssueDisplay";
	}

	
	
	   @RequestMapping(value="/userhistory",method = RequestMethod.GET)
   	public ModelAndView userHistoryList(ModelMap model,HttpSession session) throws SQLException 
       {
		   ModelAndView mv= new ModelAndView();
     	  User user = (User)session.getAttribute("user");
     	 if(user==null) {
 			mv.addObject("error","you have not logged in please click here <a href=Login> here</a> to go to login page");
 			mv.setViewName("failure");
 		}
     	 else {
   	      String userId= user.getUserId();
     	//  raiseIssueDAO rdao = new raiseIssueDAO();
   		  List<raiseIssue> displayList = rdao.displayList(userId);
   		  model.put("displayList", displayList);
   		mv.setViewName("userHistory");
     	 }
     	return mv;
   	}
     

     @RequestMapping("/displayUserHistory")
   	public String userHistoryDetails(HttpSession session, raiseIssue raiseissue,ModelMap model) throws SQLException 
       {
     	  session.setAttribute("raiseissue", raiseissue);
     	  raiseIssue raiseissue1 = (raiseIssue)session.getAttribute("raiseissue");
     	  User user = (User)session.getAttribute("user");
     	   String categoryId  = raiseissue1.getCategoryId();
     //	 raiseIssueDAO rdao = new raiseIssueDAO();
     	  raiseIssue raiseIssue2 = rdao.view(categoryId);
     	  model.put("raiseIssue", raiseIssue2);
   		return "displayUserHistory";
   	  }
	
     @RequestMapping("/Reopen")
 	public String reopen(raiseIssue raiseIssue,HttpSession session) throws SQLException {
 		session.setAttribute("raiseIssue", raiseIssue);
 		raiseIssue raiseissue1 = (raiseIssue)session.getAttribute("raiseIssue");
       String categoryId  = raiseissue1.getCategoryId();
     //  raiseIssueDAO rdao = new raiseIssueDAO();
       rdao.reopen(categoryId);
       catnotificationDAO cn=new catnotificationDAO();
       int n=cn.addnotification(categoryId);
 		return "redirect:userhistory ";
 	}
     @RequestMapping("/Close")
   	public String close(raiseIssue raiseIssue,HttpSession session) throws SQLException {
   		session.setAttribute("raiseIssue", raiseIssue);
   		raiseIssue raiseissue1 = (raiseIssue)session.getAttribute("raiseIssue");
         String categoryId  = raiseissue1.getCategoryId();
  //       raiseIssueDAO rdao = new raiseIssueDAO();
         rdao.close(categoryId);
   		return "redirect:userhistory ";

     }
	
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "Logged Out. Click<a href=Login > here </a>to go to login page";
	}
	
	// admin functions
	
	@RequestMapping(value="/viewHelp",method=RequestMethod.GET)
	public ModelAndView update1(HttpSession session,ModelMap model) throws SQLException 
	{

		   ModelAndView mv= new ModelAndView();
  	       User user = (User)session.getAttribute("user");
  	     if(user==null) {
  			mv.addObject("error","you have not logged in please click here <a href=Login> here</a> to go to login page");
  			mv.setViewName("failure");
  		}
  	     else if(user.getCategory().equals("user")) {
  	    	mv.addObject("error","you have not logged in as admin to perform this task please click here <a href=Login> here</a> to go to login as admin");
  			mv.setViewName("failure");
  	     }
  	     else {
		//HelpDAO helpdao = new HelpDAO();
		List<Help> requestList = hdao.viewHelp();;
		model.put("requestList", requestList);
		mv.setViewName("viewHelp");
  	     }
  	     return mv;
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
		
	//	ResolutionDAO rdao = new ResolutionDAO(); 
		Help help = (Help)session.getAttribute("help");
	    String requestId  = help.getRequestId();
	    String resolve = userformData.getResolution();
	    Resolution resolution = new Resolution(requestId,resolve);
	    int n= redao.getResolved(resolution);
	    return "showResolution";
	}
	

    @RequestMapping(value="/delete",method=RequestMethod.GET)
    public String deleteToDo(Help help,HttpSession session) throws SQLException
    {
  	  session.setAttribute("help", help);
  	  Help help1 = (Help)session.getAttribute("help");
  	   String requestId  = help1.getRequestId();
  	 // HelpDAO hdao = new HelpDAO();
  	  hdao.delete(requestId);
  	  return "redirect:/viewHelp";
  	  
    }
    
//    @RequestMapping(value="/feedback",method=RequestMethod.GET)
//    public String getfeedback(Help help,HttpSession session) throws SQLException
//    {
//  	  session.setAttribute("help", help);
//  	  Help help1 = (Help)session.getAttribute("help");
//  	  String userId=help1.getUserId();
//  	   String requestId  = help1.getRequestId();
//  	   feedbackDAO fdao=new feedbackDAO();
//  	   fdao.addfeedback(userId,requestId);
////  	  HelpDAO hdao = new HelpDAO();
////  	  hdao.delete(requestId);
//  	  return "redirect:/viewHelp";
//  	  
//    }
    
    
    @RequestMapping(value="/removenoti",method=RequestMethod.GET)
    public String deletenoti(Category noti,HttpSession session) throws SQLException
    {
  	  session.setAttribute("noti", noti);
  	Category help1 = (Category)session.getAttribute("noti");
  	   String name  = help1.getName();
  	  notificationDAO ndao = new notificationDAO();
  	  ndao.delete(name);
  	  return "success";
  	  
    }
    
    @RequestMapping(value="/deletenoti",method=RequestMethod.GET)
    public String deletecatnoti(catnotification categoryId,HttpSession session) throws SQLException
    {
  	  session.setAttribute("categoryId", categoryId);
  	catnotification help1 = (catnotification)session.getAttribute("categoryId");
  	   String name  = help1.getCategoryId();
  	  catnotificationDAO ndao = new catnotificationDAO();
  	  ndao.delete(name);
  	  return "redirect:/catNoti";
  	  
    }
    
    
    
    @RequestMapping(value="/viewCat",method=RequestMethod.GET)
	public ModelAndView viewCat(HttpSession session,ModelMap model) throws SQLException 
	{

		   ModelAndView mv= new ModelAndView();
	       User user = (User)session.getAttribute("user");
	     if(user==null) {
			mv.addObject("error","you have not logged in please click here <a href=Login> here</a> to go to login page");
			mv.setViewName("failure");
		}
	     else if(user.getCategory().equals("user")) {
	    	mv.addObject("error","you have not logged in as admin to perform this task please click here <a href=Login> here</a> to go to login as admin");
			mv.setViewName("failure");
	     }
	     else {
		   // CategoryDAO catdao = new CategoryDAO();
		    List<Category> requestList = cdao.viewCat();
	    	model.put("requestList", requestList);
	    	mv.setViewName("viewcategory");
	     }
	     return mv;
	}

    @RequestMapping("/addCatpage")
    public String showaddcatpage() {
  	  return "addcategory";
    }
    
    @RequestMapping(value="/addCat",method=RequestMethod.GET)
	public String addCat(Category category,HttpSession session) throws SQLException
	{
		//CategoryDAO cdao=new CategoryDAO();
		int no=cdao.addCat(category);
		if(no==1) {
			notificationDAO ndao=new notificationDAO();
			int n=ndao.addnotification(category);
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
  	   //CategoryDAO catdao = new CategoryDAO();
  	   cdao.delete(id);
  	  return "redirect:/viewCat";
  	  
    }
   
      @RequestMapping(value="/adminHistory",method = RequestMethod.GET)
  	public ModelAndView adminHistoryList( raiseIssue raiseissue,ModelMap model,HttpSession session) throws SQLException 
      {

		   ModelAndView mv= new ModelAndView();
	       User user = (User)session.getAttribute("user");
	     if(user==null) {
			mv.addObject("error","you have not logged in please click here <a href=Login> here</a> to go to login page");
			mv.setViewName("failure");
		}
	     else if(user.getCategory().equals("user")) {
	    	mv.addObject("error","you have not logged in as admin to perform this task please click here <a href=Login> here</a> to go to login as admin");
			mv.setViewName("failure");
	     }
	     else {
    	  session.setAttribute("raiseissue", raiseissue);
    	  raiseIssue raiseIssue1 = (raiseIssue)session.getAttribute("raiseissue");
    	//  raiseIssueDAO rdao = new raiseIssueDAO();
    	  List<raiseIssue>categoryList = rdao.viewHistoryIssue();
    	  model.put("categoryList", categoryList);
    	  mv.setViewName("adminHistory");
	     }
	     return mv;
  	}
      
      @RequestMapping("/displayAdminHistory")
    	public String adminHistoryDetails(HttpSession session, raiseIssue raiseissue,ModelMap model,User user) throws SQLException 
        {
    	  session.setAttribute("raiseissue", raiseissue);
      	  raiseIssue raiseissue1 = (raiseIssue)session.getAttribute("raiseissue");
      	  User user1 = (User)session.getAttribute("user");
      	   String categoryId  = raiseissue1.getCategoryId();
      //	 raiseIssueDAO rdao = new raiseIssueDAO();
      	  raiseIssue raiseIssue2 = rdao.view(categoryId);
      	  model.put("raiseIssue", raiseIssue2);
    		return "displayAdminHistory";
    	  }
      
      //-------------------------------------------------------------------
      // category rep
      
      @RequestMapping(value="/catIssue",method=RequestMethod.GET)
    	public ModelAndView updateIssue(HttpSession session,ModelMap model) throws SQLException 
    	{

		   ModelAndView mv= new ModelAndView();
	       User user = (User)session.getAttribute("user");
	     if(user==null) {
			mv.addObject("error","you have not logged in please click here <a href=Login> here</a> to go to login page");
			mv.setViewName("failure");
		}
	     else if(user.getCategory().equals("user")) {
	    	mv.addObject("error","you have not logged in as caterogy rep to perform this task please click here <a href=Login> here</a> to go to login as Category rep");
			mv.setViewName("failure");
	     }
	     else if(user.getCategory().equals("admin")) {
		    	mv.addObject("error","you have not logged in as caterogy rep to perform this task please click here <a href=Login> here</a> to go to login as Category rep");
				mv.setViewName("failure");
		     }
	     else {
    		raiseIssueDAO dao = new raiseIssueDAO();
    		List<raiseIssue> requestList = rdao.viewIssue();
    		List<String> listCategory=dao.viewStatus();
    		model.put("listCategory", listCategory);
    		model.put("requestList", requestList);
    		mv.setViewName("viewIssue");
	     }
	     return mv;
    	}
      
      @RequestMapping(value="/catNoti",method=RequestMethod.GET)
      public ModelAndView viewnotification(HttpSession session,ModelMap model) throws SQLException {
    	  ModelAndView mv= new ModelAndView();
	       User user = (User)session.getAttribute("user");
	     if(user==null) {
			mv.addObject("error","you have not logged in please click here <a href=Login> here</a> to go to login page");
			mv.setViewName("failure");
		}
	     else if(user.getCategory().equals("user")) {
	    	mv.addObject("error","you have not logged in as caterogy rep to perform this task please click here <a href=Login> here</a> to go to login as Category rep");
			mv.setViewName("failure");
	     }
	     else if(user.getCategory().equals("admin")) {
		    	mv.addObject("error","you have not logged in as caterogy rep to perform this task please click here <a href=Login> here</a> to go to login as Category rep");
				mv.setViewName("failure");
		     }
	     else {
	    	 catnotificationDAO cn=new catnotificationDAO();
	    	 List<catnotification> notiList=cn.read();
	    	 model.put("notiList",notiList );
	    	 mv.setViewName("viewcatnoti");
	     }
	     return mv;
      }
      
      @RequestMapping(value="/mapCat",method=RequestMethod.GET)
      public String mapCategory(raiseIssue raiseissue,HttpSession session,ModelMap model) throws SQLException
      {
    	  session.setAttribute("raiseissue", raiseissue);
    	  raiseIssue help1 = (raiseIssue)session.getAttribute("raiseissue");
    	   String categoryId  = help1.getCategoryId();
    	 //  raiseIssueDAO rdao = new raiseIssueDAO();
    	  raiseIssue issue=rdao.view(categoryId);
    	  model.put("issue", issue);
    	  //CategoryDAO catdao = new CategoryDAO();
  		List<Category> requestList = cdao.viewCat();
  		model.put("requestList", requestList);
    	  return "changeCat";
    	  
      }
      
      @RequestMapping(value="/updateCat",method=RequestMethod.GET)
      public String updateCategory(raiseIssue raiseissue,HttpSession session) throws SQLException
      {
    	  session.setAttribute("raiseissue", raiseissue);
    	  raiseIssue help1 = (raiseIssue)session.getAttribute("raiseissue");
    	  String categoryId  = help1.getCategoryId();
    	  String category  = help1.getCategory();
    	//  raiseIssueDAO upd=new raiseIssueDAO();
    	  int n=rdao.update(category,categoryId);
    	 return "redirect:catIssue";
      }
      
      @RequestMapping(value="/change",method=RequestMethod.GET)
      public ModelAndView change(String categoryId,String newstatus, ModelMap model) throws SQLException
       {
    	  ModelAndView mv= new ModelAndView();
         // raiseIssueDAO helpdao=new raiseIssueDAO();
          rdao.updateStatusByUserId(categoryId, newstatus);
          mv.setViewName("redirect:catIssue");
 
        return mv;
        
       }
      @RequestMapping(value = "/report", method = RequestMethod.GET)
    	public ModelAndView showGenerateReport(ModelMap model) throws SQLException {
    	  ModelAndView mv= new ModelAndView();
    	    List<Category> requestList = cdao.viewCat();
			mv.addObject("requestList", requestList);
			 mv.setViewName("generateReport");
			 return mv;
    	}

    	@RequestMapping(value = "/show", method = RequestMethod.POST)
    	public String showReport(@RequestParam("category")String category,@RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
    			@RequestParam("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate, ModelMap model)
    			throws SQLException 
    	{
    		//raiseIssueDAO raiseissue = new raiseIssueDAO();
    		System.out.println(category);
    		List<raiseIssue> issueDetails = rdao.filter(startDate, endDate,category);
    		//List<raiseIssue> issueDetails = raiseissue.filter(category);
    		System.out.println(issueDetails);
    		model.put("issueDetails", issueDetails);
    		return "showReport";
    	}
     
}

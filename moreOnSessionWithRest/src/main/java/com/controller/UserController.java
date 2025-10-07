package com.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties.Listener.Session;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.model.Users;
import com.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView loginPage() {
        System.out.println("Basic controller");
        ModelAndView mv = new ModelAndView();
        mv.addObject("userObj", new Users());
        mv.setViewName("login");
        return mv;
    }
    
    
    @PostMapping("/user/")
	public ModelAndView processFrom(
			@ModelAttribute("userObj") Users user,
			BindingResult result,
	        HttpSession session
			)
	{
		ModelAndView obj = new ModelAndView();
		
		Users currentUser = userService.login(user);
		System.out.println("currentUser" +currentUser);
		if(currentUser == null)
		{
			obj.setViewName("register");
			return obj;

		}
		else
		{
			session.setAttribute("sessionUID", currentUser.getId());			
	        obj.setViewName("welcome");
			return obj;

		}
		
	}
    
    
    @PostMapping("/user/signup")
  	public ModelAndView signupProcessFrom(
  			@ModelAttribute("userObj") Users user,
  			BindingResult result
  			)
  	{
  		ModelAndView obj = new ModelAndView();
  		
  		Users newUser = userService.signup(user);
  		if( newUser  == null)
  		{
  			obj.setViewName("login");
  			return obj;

  		}
  		else
  		{
  			obj.setViewName("welcome");
  			return obj;

  		}
  		
  	}
    
    
    @PostMapping("/user/logout")
  	public ModelAndView logoutProcess(
	        HttpSession session
  			)
  	{
    	
    	System.out.println("logout called");
  		ModelAndView obj = new ModelAndView(); 
  		
  		UUID userId = (UUID) session.getAttribute("sessionUID");
  		System.out.println("USERID"+ userId);
  		userService.logout(userId);
        
  		obj.addObject("userObj", new Users());
  		obj.setViewName("login");
  		return obj;

  		
  	}
    
    
    @PostMapping("/user/shop")
   	public ModelAndView shop()
   	{
   		ModelAndView obj = new ModelAndView();
   		
   	        obj.setViewName("shop");
   			return obj;   		
   	}
    
    @PostMapping("/user/welcome")
   	public ModelAndView welcome()
   	{
   		ModelAndView obj = new ModelAndView();
   		
   	        obj.setViewName("welcome");
   			return obj;   		
   	}
       
       
	
}

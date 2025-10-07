package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;
import com.repository.UserRepo;
import com.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
@Controller
@RequestMapping("/form2")
public class RegisterController {
	@Autowired
	private UserRepo userrepo;
	@Autowired
    private UserService userService;
	
	 @GetMapping("/register")
	    public ModelAndView loadform() {
	        ModelAndView mandv = new ModelAndView("register");
	        mandv.addObject("userRegister", new User());
	        return mandv;
	    }
	
	@PostMapping("/register")
    public ModelAndView processForm(@Valid @ModelAttribute("userRegister") User user,
                                    BindingResult result,
                                    HttpServletRequest request) {
        ModelAndView mandv = new ModelAndView();
        if (result.hasErrors()) {
            mandv.setViewName("redirect:/form2/register");
            return mandv;
        }
        try {
            boolean isValid = userService.checkUser(user.getUsername(), user.getUserpass());
            if (!isValid) {
            	userService.updateFlag(user.getUsername(), 0);
                userrepo.save(user);
                mandv.setViewName("redirect:/form1/login");
            }
        } catch (Exception e) {
            mandv.setViewName("redirect:/form2/register");
            mandv.addObject("error", "User already exist");
        }
        return mandv;
    }
}
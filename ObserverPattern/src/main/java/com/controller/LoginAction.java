package com.controller;

import com.model.UserMaster;
import com.repository.UserRepository;
import com.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/form1")
public class LoginAction {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userservice;
    
    @PostMapping("/shop1")
    public ModelAndView showShopPage(HttpSession session) {
        ModelAndView mandv = new ModelAndView();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            mandv.setViewName("redirect:/form1/register");
        } else {
            mandv.setViewName("shop1");
        }
        return mandv;
    }
    
    @GetMapping("/register")
    public ModelAndView loadForm() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("userObj", new UserMaster());
        mv.setViewName("login");
        return mv;
    }

    @PostMapping("/register")
    public ModelAndView processForm(
            @Valid @ModelAttribute("userObj") UserMaster user,
            BindingResult result,
            HttpServletRequest request,
            HttpSession session) {

        ModelAndView mv = new ModelAndView();

        if (result.hasErrors()) {
            mv.setViewName("login");
            return mv;
        }

        // 🔍 Lookup user directly (no Optional)
        UserMaster dbUser = userRepo.findByUsername(user.getUsername());

        if (dbUser != null) {
            if (dbUser.getUserpass().equals(user.getUserpass())) {
                request.setAttribute("loggedInUser", dbUser);
                mv.addObject("myUser", dbUser);
                userservice.updateFlag(dbUser.getUsername(), 1);
                request.getSession().setAttribute("username", user.getUsername());
                session.setAttribute("username", dbUser.getUsername());
                mv.setViewName("welcome");
            } else {
                result.rejectValue("password", "error.user", "Invalid password");
                mv.setViewName("login");
            }
        } else {
            result.rejectValue("username", "error.user", "User not found");
            mv.setViewName("login");
        }

        return mv;
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username != null) {
            userservice.updateFlag(username, 0);
            session.invalidate();
        }
        return "redirect:/form1/register";
    }
}

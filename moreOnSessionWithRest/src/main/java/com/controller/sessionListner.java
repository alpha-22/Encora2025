package com.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.services.UserService;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@Component
@WebListener
public class sessionListner implements HttpSessionListener{
	public HttpSession session;
	
	@Autowired
	UserService userService;
		
	
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("SESSION CREATED CALLED");
		HttpSession session = se.getSession();
		this.session =session;
		session.setMaxInactiveInterval(10);
		HttpSessionListener.super.sessionCreated(se);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("SESSION DESTROYED CALLED");

		HttpSession session = se.getSession();
		UUID userId = (UUID) session.getAttribute("sessionUID");
  		System.out.println("USERID"+ userId);
  		userService.logout(userId);
		HttpSessionListener.super.sessionDestroyed(se);
	}
}
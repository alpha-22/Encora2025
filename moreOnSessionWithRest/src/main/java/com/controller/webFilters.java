package com.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
@WebFilter(urlPatterns = "/user/*")
public class webFilters implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        System.out.println("Incoming request: " + req.getMethod() + " " + req.getRequestURI());

        HttpSession session = req.getSession();
        System.out.println("SESSION FROM FILTER: " + session);
      
        if (session.isNew()) { 	
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/views/index.jsp");
            dispatcher.forward(request, response);
        	return ;
        }

        chain.doFilter(request, response);
    }
}

package com.servlet;

import java.io.IOException;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.UserService;

public class loginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("username");
		String pwd = req.getParameter("password");
		UserService us = new UserService();
		if(us.login(name, pwd) != null){
			HttpSession session = (HttpSession) req.getSession();
			session.setAttribute("user", us.login(name, pwd));
			resp.sendRedirect("welcome.jsp");
		}else{
			resp.sendRedirect("login.jsp");
		}
	}

	
}

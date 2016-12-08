package org.admu.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.admu.controller.UserController;
import org.admu.model.User;

public class ServletAuthUser extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatch = null;
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		
		boolean isUser = UserController.getInstance().auth(userName, userPass);
		
		if (isUser){
			User usr = UserController.getInstance().getUserByName(userName);
			HttpSession session = request.getSession(true);
			session.setAttribute("usuario", usr);
			dispatch = request.getRequestDispatcher("dashboard.jsp");
			
		} else {
			dispatch = request.getRequestDispatcher("index.jsp");
		}
		
		dispatch.forward(request, response);
	}
	
}

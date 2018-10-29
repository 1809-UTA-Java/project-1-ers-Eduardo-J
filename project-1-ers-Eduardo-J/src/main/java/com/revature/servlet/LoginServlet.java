package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.User;
import com.revature.repository.UserDao;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	UserDao udao = new UserDao();
	
	//protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		
		User userLogin = udao.getByUsername(user);
		
		if (userLogin != null && pass.equals(userLogin.getPassword())) {
			HttpSession session = req.getSession();
			session.setAttribute("username", user);
			session.setAttribute("user", userLogin);
			
			if (userLogin.getRoleId() == 1)
				resp.sendRedirect("manager.html");
			else
				resp.sendRedirect("employee.html");
		} else {
			System.out.println("incorrect username or password");
			resp.sendRedirect("index.html");
		}
	}
}
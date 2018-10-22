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
	UserDao dao = new UserDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sUsername = req.getParameter("username");
		String sPassword = req.getParameter("password");
		
		User userLogin = dao.getUserByUserName(sUsername);
		
		if (userLogin != null && sPassword.equals(userLogin.getPassword())) {
			HttpSession session = req.getSession();
			session.setAttribute("username", sUsername);
			session.setAttribute("user", userLogin);
			
			if (userLogin.getRoleId() == 1)
				resp.sendRedirect("manager.html");
			else
				resp.sendRedirect("employee.html");
		} else {
			resp.sendRedirect("index.html");
		}
	}
}
package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.User;
import com.revature.repository.UserDao;

@SuppressWarnings("serial")
@WebServlet("/update")
public class EmployeeUpdateServlet extends HttpServlet {
	UserDao dao = new UserDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User u = new User();
		String sUsername = (String) session.getAttribute("username");
		
		if(sUsername != null) {
			u = dao.getUserByUserName(sUsername);
			
			String sUN = (String) req.getParameter("username");
			if (!sUN.isEmpty())
				u.setUsername(sUN);
			
			String sPW = (String) req.getParameter("password");
			if (!sPW.isEmpty())
				u.setPassword(sPW);
			
			String sFN = (String) req.getParameter("firstname");
			if (!sFN.isEmpty())
				u.setFirstname(sFN);
			
			String sLN = (String) req.getParameter("lastname");
			if (!sFN.isEmpty())
				u.setLastname(sLN);
			 
			String sEmail = (String) req.getParameter("email");
			if (!sEmail.isEmpty())
				u.setEmail(sEmail);
			
			dao.saveUser(u);

			PrintWriter pw = resp.getWriter();
			pw.println(u.toString());
			pw.close();
		} else
			resp.sendRedirect("/index.html");
	}
}

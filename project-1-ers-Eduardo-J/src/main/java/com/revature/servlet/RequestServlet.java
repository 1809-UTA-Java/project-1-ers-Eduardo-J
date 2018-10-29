package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.repository.ReimbursementDao;
import com.revature.repository.UserDao;

@SuppressWarnings("serial")
@WebServlet("/viewreq")
public class RequestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserDao uDao = new UserDao();
	ReimbursementDao rDao = new ReimbursementDao();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		User u = new User();
		String sUsername = (String) session.getAttribute("username");
		
		if(sUsername != null) {
			u = uDao.getByUsername(sUsername);
			User uEmp = uDao.getByUsername(req.getParameter("empname"));
			
			List<Reimbursement> reimbursements = new ArrayList<>();
			reimbursements = rDao.getReimbursementsByAuthor(uEmp.getId());
			
			PrintWriter pw = resp.getWriter();
			pw.println(Arrays.toString(reimbursements.toArray()));
			pw.close();
		}
	}
}



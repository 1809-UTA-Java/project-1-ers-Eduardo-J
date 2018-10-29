package com.revature.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.repository.ReimbursementDao;

/**
 * Servlet implementation class SubmissionServlet
 */
public class SubmissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReimbursementDao dao = new ReimbursementDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmissionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		User u  = (User) session.getAttribute("user");
		Reimbursement r = new Reimbursement();
		r.setAuthorId(u.getId());
		
		double a = Double.parseDouble(req.getParameter("amount"));
		r.setAmount(a);
		String d = (String) req.getParameter("description");
		System.out.println(d);
		
		//dao.saveReimbursement(r);
		
		PrintWriter pw = res.getWriter();
		pw.println("Submitted");
		pw.close();
		res.sendRedirect("/index.html");
	}

}
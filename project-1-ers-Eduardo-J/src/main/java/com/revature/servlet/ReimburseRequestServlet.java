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

@SuppressWarnings("serial")
@WebServlet("/submission")
public class ReimburseRequestServlet extends HttpServlet {
	
	ReimbursementDao dao = new ReimbursementDao();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		User u  = (User) session.getAttribute("user");
		
		if (u != null && u.getRoleId() == 0) {
			Reimbursement r = new Reimbursement();
			r.setAuthorId(u.getId());
			
			double amt = Double.parseDouble(req.getParameter("amount"));
			r.setAmount(amt);
			String des = (String) req.getParameter("description");
			System.out.println(des);
			
			if (!des.isEmpty())
				r.setDescription(des);
			
			if (req.getParameter("receipt") != null) {
				File rec = new File(req.getParameter("receipt"));
				if (rec != null && rec.exists())
					r.setReceipt(rec);
			}
			else {
				System.out.println("no reciept");
			}
			
			String rt = req.getParameter("rtype");
			int intrt = Integer.parseInt(rt);
			r.setRtId(intrt);
			dao.saveReimbursement(r);
			
			PrintWriter pw = resp.getWriter();
			pw.println("Submitted");
			pw.close();
			
		} else
			resp.sendRedirect("/index.html");
	}
}

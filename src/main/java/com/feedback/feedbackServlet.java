package com.feedback;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AllTextPh.dao.SMSdao;

/**
 * Servlet implementation class feedbackServlet
 */
public class feedbackServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email"); 
		String concern = request.getParameter("concern"); 
		String referer = request.getHeader("referer");
		
		SMSdao dao = new SMSdao(); 
		
		if(email.isBlank() || concern.isBlank()) {
			
		}
		else {
			response.sendRedirect("index.jsp");
			dao.storeFeedback(email, concern);
		}
	}

}

package com.AllTextPh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AllTextPh.dao.SMSdao;
import com.SMS.SMS;

/**
 * Servlet implementation class getSMSController
 */
public class getSMSController extends HttpServlet {
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String phone = getNumber(request.getParameter("phone")); 
		String message = request.getParameter("message"); 
		double TextPrice = 0.1699;
		 
		SMS sms = new SMS(); 
		sms.setNumber(phone);
		sms.setSms(message);
		double balance = sms.checkBalance(); 
		
		SMSdao dao = new SMSdao(); 
		boolean connectedDb = dao.connectJDBS(); 
		
		PrintWriter out = response.getWriter();
		
		if(connectedDb && balance>TextPrice) {
			
			sms.sendSMS();
			
			dao.storeSMS(sms.getMessageId(), phone, message);
			
			request.setAttribute("message", message);
			request.setAttribute("phone", phone);
			
			RequestDispatcher rd = request.getRequestDispatcher("sent.jsp"); 
			rd.forward(request, response);
			
			if(sms.checkBalance()==balance) {
				System.out.print("not sent!");
			}
			else {
				System.out.print("Sent!");
			}
			
		}
		else if(balance<0.1699) {
			System.out.print("Insufficient load balance!\n" + "Balance: "+balance);
			out.print("Error!!");
		}
		else
			out.print("Errors somewhere");
	}
	
	private String getNumber(String phone) {
		
		return "+63" + phone.substring(phone.indexOf('9')); 
	}


}

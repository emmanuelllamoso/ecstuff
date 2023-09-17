package com.AllTextPh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.SMS.SMS;

public class SMSdao {
	
	String sqlSMS = "INSERT INTO sms(message_id,phone,message) VALUES(?,?,?)"; 
	String sqlFeedback = "INSERT INTO feedback(email,concern) VALUES(?,?)"; 
	String sqlLatestMessage = "SELECT * FROM sms ORDER BY message_id DESC LIMIT 1";
	String url ="jdbc:mysql://localhost:3306/AllTextPh"; 
	String username = "root"; 
	String password = "Emman12pogi"; 
	Connection con; 
	
	public SMSdao(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection(url,username, password);  
			
			System.out.print(con.toString());			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void storeSMS(String messageId, String phone, String message) {
		PreparedStatement st;
		try {
			st = con.prepareStatement(sqlSMS);
			st.setString(1, messageId);
			st.setString(2, phone);
			st.setString(3, message);
			System.out.print(url);
			
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void storeFeedback(String email, String concern) {
		PreparedStatement st;
		try {
			st = con.prepareStatement(sqlFeedback);
			st.setString(1, email);
			st.setString(2, concern);
			System.out.print(url);
			
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String[] getLatestMessage() {
		String message[] = {"Message here", "+639123456789"};
		try {
			
			PreparedStatement st = con.prepareStatement(sqlLatestMessage); 
			ResultSet rs = st.executeQuery(); 
			if(rs.next()) {
				message[0] = rs.getString("phone");
				message[1] = rs.getString("message");
				
				System.out.println(message[0]);
				System.out.println(message[1]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return message; 
	}
	
	
}

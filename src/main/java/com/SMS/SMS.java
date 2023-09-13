package com.SMS;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Base64;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class SMS {
	private String number; 
	private String sms;
	private String messageId; 
	
	public static final String ACCOUNT_SID = "AC489b1ba5f8de3366d43be2308a4a39cc";
	public static final String AUTH_TOKEN = "db9b6d65f8246df0097750d4f27d3bda";

	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	@Override
	public String toString() {
		return "SMS [number=" + number + ", message=" + sms + "]";
	} 
	
	public String getMessageId() {
		return messageId;
	}
	
	public void sendSMS() {
	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	    Message message = Message.creator(
	      new com.twilio.type.PhoneNumber(number),
	      new com.twilio.type.PhoneNumber("+12512734637"),
	      sms)
	    .create();
	    
	    messageId = message.getSid(); 
	    System.out.println(message.getSid());
	    System.out.print("number: " +number);
	}
	public double checkBalance() throws IOException {
		
        
        // Construct the URL
        String apiUrl = "https://api.twilio.com/2010-04-01/Accounts/" + ACCOUNT_SID + "/Balance.json";
        URL url = new URL(apiUrl);
        
        // Open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // Set the request method to GET
        connection.setRequestMethod("GET");
        
        // Set up Basic Authentication
        String credentials = ACCOUNT_SID + ":" + AUTH_TOKEN;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);
        
        // Get the response code
        int responseCode = connection.getResponseCode();
        double balance = 0; 
        
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Read and print the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
            	
                response.append(line);
            }
            reader.close();
            JSONObject jsonResponse = new JSONObject(response.toString());
            balance = jsonResponse.getDouble("balance");
            System.out.println("Balance: " + balance);
        } else {
            System.out.println("Failed to fetch data. Response code: " + responseCode);
        }
        
        // Close the connection
        connection.disconnect();
		
        return balance; 
	}
	
}

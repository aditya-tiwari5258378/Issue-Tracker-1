package com.example.demo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


public class Help {
	
	public Help(String userId, String requestId, String issue, String description, String dateOfTicket) {
		super();
		this.userId = userId;
		this.requestId = requestId;
		this.issue = issue;
		this.description = description;
		this.dateOfTicket = dateOfTicket;
	}
	private String userId;
	private String requestId;
	private String issue;
	private String description;
	private String dateOfTicket;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateOfTicket() {
		return dateOfTicket;
	}
	public void setDateOfTicket(String dateOfTicket) {
		this.dateOfTicket = dateOfTicket;
	}
	
	public static String getCurrentTimeUsingDate() {
		LocalDateTime instance = LocalDateTime.now();
		 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");
		return formatter.format(instance);
    }
	
	public static String getAlphaNumericString(int n) 
    { 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
            int index = (int)(AlphaNumericString.length()*Math.random()); 
            sb.append(AlphaNumericString.charAt(index)); 
        } 
        return sb.toString(); 
    }
	
	@Override
	public String toString() {
		return "Help [userId=" + userId + ", requestId=" + requestId + ", issue=" + issue + ", description="
				+ description + ", dateOfTicket=" + dateOfTicket + "]";
	}
}

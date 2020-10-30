package com.example.demo;
import java.util.Random;


public class raiseIssue {

	
		
		public raiseIssue(String userId, String categoryId, String category, String details) {
		super();
		this.userId = userId;
		this.categoryId = categoryId;
		this.category = category;
		this.details = details;
	}
		private String userId;
		private String categoryId;
		private String category;
		private String details;
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(String categoryId) {
			this.categoryId = categoryId;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getDetails() {
			return details;
		}
		public void setDetails(String details) {
			this.details = details;
		}
		
		public static String getAlphaNumeric(int n) 
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
			return "raiseIssue [userId=" + userId + ", categoryId=" + categoryId + ", category=" + category
					+ ", details=" + details + "]";
		}
		
		
		
}

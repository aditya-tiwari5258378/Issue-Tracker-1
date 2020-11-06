package com.example.demo;

public class feedback {

	public feedback(String userId, String requestId) {
		super();
		this.userId = userId;
		this.requestId = requestId;
	}
	private String userId;
	private String requestId;
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
	@Override
	public String toString() {
		return "feedback [userId=" + userId + ", requestId=" + requestId + "]";
	}
}

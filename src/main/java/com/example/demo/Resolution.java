package com.example.demo;

public class Resolution {
private String requestId;
	
	private String resolution;
	
	public Resolution(String requestId, String resolution) {
		super();
		this.requestId = requestId;
		this.resolution = resolution;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
}

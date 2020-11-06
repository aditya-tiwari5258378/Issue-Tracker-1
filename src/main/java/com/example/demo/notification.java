package com.example.demo;

public class notification {

	public notification(String id, String msg) {
		super();
		this.id = id;
		this.msg = msg;
	}

	private String id;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

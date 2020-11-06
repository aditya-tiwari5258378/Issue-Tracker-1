package com.example.demo;

public class catnotification {

	public catnotification(String categoryId) {
		super();
		this.categoryId = categoryId;
	}

	private String categoryId;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
}

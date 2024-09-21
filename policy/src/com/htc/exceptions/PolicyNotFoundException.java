package com.htc.exceptions;

public class PolicyNotFoundException extends Exception {
	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PolicyNotFoundException(String message) {
		super();
		this.message = message;
	}
}

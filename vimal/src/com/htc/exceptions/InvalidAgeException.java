package com.htc.exceptions;

public class InvalidAgeException extends Throwable {
	private String exceptionMessage;

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public InvalidAgeException(String exceptionMessage) {
		super();
		this.exceptionMessage = exceptionMessage;
	}

	@Override
	public String toString() {
		return "InvalidAgeExceptions [exceptionMessage=" + exceptionMessage + "]";
	}

}

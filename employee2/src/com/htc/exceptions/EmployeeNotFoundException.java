package com.htc.exceptions;

import java.util.Date;

public class EmployeeNotFoundException extends Exception {
	private String errorMsg;
	private Date errorOccurenceTime;
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Date getErrorOccurenceTime() {
		return errorOccurenceTime;
	}
	public void setErrorOccurenceTime(Date errorOccurenceTime) {
		this.errorOccurenceTime = errorOccurenceTime;
	}
	public EmployeeNotFoundException(String errorMsg, Date errorOccurenceTime) {
		super();
		this.errorMsg = errorMsg;
		this.errorOccurenceTime = errorOccurenceTime;
	}
	@Override
	public String toString() {
		return "EmployeeNotFoundException [errorMsg=" + errorMsg + ", errorOccurenceTime=" + errorOccurenceTime + "]";
	}
	
}

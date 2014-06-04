package com.FMS.utils;

public class FmsException extends Exception {

	private int errorCode;
	private String errorMessage;

	public FmsException()
	{
		
	}
	public FmsException(int errorCode, String errorMeString) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}

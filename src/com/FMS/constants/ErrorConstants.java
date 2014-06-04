package com.FMS.constants;

public enum ErrorConstants {
	
	INVALID_FIELD_VALUE(10001, "Invalid value: Please provide a valid field value"),
	INVALID_INTEGER_VALUE(10002, "Invalid value: Please provide a valid integer value");
	
	private int errorCode;
	private String errorMessage;
	
	private ErrorConstants(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
}

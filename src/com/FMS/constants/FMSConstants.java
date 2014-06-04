package com.FMS.constants;

public enum FMSConstants {
	DB_DRIVER("com.mysql.jdbc.Driver"),
	DB_USER("root"),
	DB_PASSWORD("mysql"),
	DB_URL("jdbc:mysql://localhost/fms"),
	USER_DETAILS("USER_DETAILS");
	
	private String value;
	
	private FMSConstants (String value)
	{
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
}

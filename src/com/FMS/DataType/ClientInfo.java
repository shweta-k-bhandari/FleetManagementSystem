package com.FMS.DataType;

import java.util.Date;


public class ClientInfo {

	String ClientName;
	String ClientAddress;
	int ClientPhoneNumber;
	Date LastTradingDate;

	public String toString() {
		return "Client Details are :\n ClientName = " + ClientName + " ClientAddress = " + ClientAddress + " ClientPhoneNumber = "
	                + ClientPhoneNumber + " LastTradingDate = " + LastTradingDate ;
    }
	public String getClientName() {
		return ClientName;
	}

	public void setClientName(String clientName) {
		ClientName = clientName;
	}

	public String getClientAddress() {
		return ClientAddress;
	}

	public void setClientAddress(String clientAddress) {
		ClientAddress = clientAddress;
	}

	public int getClientPhoneNumber() {
		return ClientPhoneNumber;
	}

	public void setClientPhoneNumber(int clientPhoneNumber) {
		ClientPhoneNumber = clientPhoneNumber;
	}

	public Date getLastTradingDate() {
		return LastTradingDate;
	}

	public void setLastTradingDate(Date lastTradingDate) {
		LastTradingDate = lastTradingDate;
	}

}

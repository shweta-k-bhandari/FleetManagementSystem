package com.FMS.DataType;

import java.util.Date;


public class OrderInfo {

	int OrderNumber;
	String ClientName;
	Date OrderDate;
	Date BillingDate;
	Date DeliveryDate;
	String DestinationAddress;
	
	public String toString() {
        return "Order Details are :\n OrderNumber = " + OrderNumber + ", ClientName = " + ClientName + ", OrderDate = "
                + OrderDate + ", BillingDate = " + BillingDate + ", DeliveryDate = " + DeliveryDate + ", DestinationAddress = " + DestinationAddress ;
    }
	
	public int getOrderNumber() {
		return OrderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		OrderNumber = orderNumber;
	}
	public String getClientName() {
		return ClientName;
	}
	public void setClientName(String clientName) {
		ClientName = clientName;
	}
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	public Date getBillingDate() {
		return BillingDate;
	}
	public void setBillingDate(Date billingDate) {
		BillingDate = billingDate;
	}
	public Date getDeliveryDate() {
		return DeliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		DeliveryDate = deliveryDate;
	}
	public String getDestinationAddress() {
		return DestinationAddress;
	}
	public void setDestinationAddress(String destinationAddress) {
		DestinationAddress = destinationAddress;
	}

}

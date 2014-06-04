package com.FMS.DataType;

public class DriverInfo {

	String DriverName;
	String DriverIdProof;
	String DriverIdNumber;
	String DriverAddress;
	String DriverStatus;
	int DriverPhoneNumber;
	
	public String toString() {
        return "Driver Details are :\n DriverName = " + DriverName + ", DriverIdProof = " + DriverIdProof + ", DriverIdNumber = "
                + DriverIdNumber + ", DriverAddress = " + DriverAddress + ", DriverStatus = " + DriverStatus + ", DriverPhoneNumber = " + DriverPhoneNumber ;
    }
	
	public String getDriverName() {
		return DriverName;
	}
	public void setDriverName(String driverName) {
		DriverName = driverName;
	}
	public String getDriverIdProof() {
		return DriverIdProof;
	}
	public void setDriverIdProof(String driverIdProof) {
		DriverIdProof = driverIdProof;
	}
	public String getDriverIdNumber() {
		return DriverIdNumber;
	}
	public void setDriverIdNumber(String driverIdNumber) {
		DriverIdNumber = driverIdNumber;
	}
	public String getDriverAddress() {
		return DriverAddress;
	}
	public void setDriverAddress(String driverAddress) {
		DriverAddress = driverAddress;
	}
	public String getDriverStatus() {
		return DriverStatus;
	}
	public void setDriverStatus(String driverStatus) {
		DriverStatus = driverStatus;
	}
	public int getDriverPhoneNumber() {
		return DriverPhoneNumber;
	}
	public void setDriverPhoneNumber(int driverPhoneNumber) {
		DriverPhoneNumber = driverPhoneNumber;
	}
	
}

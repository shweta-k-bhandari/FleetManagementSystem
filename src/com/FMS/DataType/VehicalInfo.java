package com.FMS.DataType;

import java.util.Date;

public class VehicalInfo {

	int VehicalUniqueId;
	int VehicalRegistrationNumber;
	String VehicalModelName;
	Date VehicalInsuranceExpiryDate;
	String VehicalStatus;
	String VehicalLocation;
	long VehicalKilometerReading;
	
	public String toString() {
        return "Vehical Info is :\n VehicalUniqueId = " + VehicalUniqueId + ", VehicalRegistrationNumber = " + VehicalRegistrationNumber + ", VehicalModelName = "
                + VehicalModelName + ", VehicalInsuranceExpiryDate = " + VehicalInsuranceExpiryDate + ", VehicalStatus = " + VehicalStatus + ", VehicalLocation = " + VehicalLocation + ", VehicalKilometerReading = " + VehicalKilometerReading;
    } 
	
	public int getVehicalUniqueId() {
		return VehicalUniqueId;
	}
	public void setVehicalUniqueId(int vehicalUniqueId) {
		VehicalUniqueId = vehicalUniqueId;
	}
	public int getVehicalRegistrationNumber() {
		return VehicalRegistrationNumber;
	}
	public void setVehicalRegistrationNumber(int vehicalRegistrationNumber) {
		VehicalRegistrationNumber = vehicalRegistrationNumber;
	}
	public String getVehicalModelName() {
		return VehicalModelName;
	}
	public void setVehicalModelName(String vehicalModelName) {
		VehicalModelName = vehicalModelName;
	}
	public Date getVehicalInsuranceExpiryDate() {
		return VehicalInsuranceExpiryDate;
	}
	public void setVehicalInsuranceExpiryDate(Date vehicalInsuranceExpiryDate) {
		VehicalInsuranceExpiryDate = vehicalInsuranceExpiryDate;
	}
	public String getVehicalStatus() {
		return VehicalStatus;
	}
	public void setVehicalStatus(String vehicalStatus) {
		VehicalStatus = vehicalStatus;
	}
	public String getVehicalLocation() {
		return VehicalLocation;
	}
	public void setVehicalLocation(String vehicalLocation) {
		VehicalLocation = vehicalLocation;
	}
	public long getVehicalKilometerReading() {
		return VehicalKilometerReading;
	}
	public void setVehicalKilometerReading(long vehicalKilometerReading) {
		VehicalKilometerReading = vehicalKilometerReading;
	}

}

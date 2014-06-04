package com.FMS.Logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.FMS.dbconnector.FMSConnection;
import com.FMS.utils.FmsException;

import com.FMS.DataType.VehicalInfo;

public class VehicalOperation{

	public static VehicalInfo oVehicalInfo = new VehicalInfo();
	
	public static void createVehicalDatabase(String vUIdString, String vRegNumbString, String vModelName, String vInsurExpdate, String vStatus, String vLocation, String vKmReadingString) throws FmsException
	{
		Connection connection = null;
        Statement statement = null;
         
		int vUId = Integer.parseInt(vUIdString);
		int vRegNumb = Integer.parseInt(vRegNumbString);
		int vKmReading = Integer.parseInt(vKmReadingString);

        String query = "insert into VehicalInfo(VehicalUniqueId, VehicalRegistrationNumber, VehicalModelName, VehicalInsuranceExpiryDate, VehicalStatus, VehicalLocation, VehicalKilometerReading) values(" + vUId + "," +vRegNumb + ",'" + vModelName + "','" + vInsurExpdate + "','" + vStatus + "','" + vLocation + "'," + vKmReading + ");";
        try {          
            connection = FMSConnection.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
             
        } catch (SQLException e) {
            e.printStackTrace();
            throw new FmsException(e.getErrorCode(), "Error occured while inserting details: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	public static void updateVehicalInfo() throws FmsException
	{
        Connection connection = null;
        Statement statement = null;
         
		String fieldToUpdate = JOptionPane.showInputDialog("Which Field you want to modify\n VehicalUniqueId \n VehicalRegistrationNumber\n VehicalModelName\n VehicalInsuranceExpiryDate\n VehicalStatus\n VehicalLocation\n VehicalKilometerReading");
		if("VehicalUniqueId".equals(fieldToUpdate))
		{
			String regNumb = JOptionPane.showInputDialog("Enter the Vehical Registration Number for which Name Unique ID needs to be modified");
			String updatedVehicalUniqueId = JOptionPane.showInputDialog("Enter New Vehical ID");
			String query = "update VehicalInfo set VehicalUniqueId='" + updatedVehicalUniqueId + "' where VehicalRegistrationNumber='" + regNumb +"';";
			try{
				connection = FMSConnection.getConnection();
				statement = connection.createStatement();
				statement.executeUpdate(query);
			} //try
			catch (SQLException e) {
	            e.printStackTrace();
	            throw new FmsException(e.getErrorCode(), "Error occured while inserting details: " + e.getMessage());
	        } finally {
	            if (connection != null) {
	                try {
	                    connection.close();
	                }//try
	                catch (SQLException e) {
	                    e.printStackTrace();
	                } //catch
	            }//if
	        }//finally
		}//if
		else if("VehicalModelName".equals(fieldToUpdate))
		{
			String regNumb = JOptionPane.showInputDialog("Enter the Vehical registration Number for which Model Name field needs to be modified");
			String updatedVehicalModelName = JOptionPane.showInputDialog("Enter New Vehical Model Name");
			String query = "update VehicalInfo set VehicalModelName='" + updatedVehicalModelName + "' where VehicalRegistrationNumber='" + regNumb +"';";
			try{
				connection = FMSConnection.getConnection();
				statement = connection.createStatement();
				statement.executeUpdate(query);
			} //try
			catch (SQLException e) {
	            e.printStackTrace();
	            throw new FmsException(e.getErrorCode(), "Error occured while inserting details: " + e.getMessage());
	        } finally {
	            if (connection != null) {
	                try {
	                    connection.close();
	                }//try
	                catch (SQLException e) {
	                    e.printStackTrace();
	                } //catch
	            }//if
	        }//finally
		}//if
		else if("VehicalInsuranceExpiryDate".equals(fieldToUpdate))
		{
			String regNumb = JOptionPane.showInputDialog("Enter the Vehical Registration Number for which Insurance Expiry Date field needs to be modified");
			String updatedVehicalInsuranceExpiryDate = JOptionPane.showInputDialog("Enter New Vehical Insurance expiry date");
			String query = "update VehicalInfo set VehicalInsuranceExpiryDate='" + updatedVehicalInsuranceExpiryDate + "' where VehicalRegistrationNumber='" + regNumb +"';";
			try{
				connection = FMSConnection.getConnection();
				statement = connection.createStatement();
				statement.executeUpdate(query);
			} //try
			catch (SQLException e) {
	            e.printStackTrace();
	            throw new FmsException(e.getErrorCode(), "Error occured while inserting details: " + e.getMessage());
	        } finally {
	            if (connection != null) {
	                try {
	                    connection.close();
	                }//try
	                catch (SQLException e) {
	                    e.printStackTrace();
	                } //catch
	            }//if
	        }//finally
		}//if
		else if("VehicalStatus".equals(fieldToUpdate))
		{
			String regNumb = JOptionPane.showInputDialog("Enter the Vehical Registration Number for which Status field needs to be modified");
			String updatedVehicalStatus = JOptionPane.showInputDialog("Enter Vehical New Status");
			String query = "update VehicalInfo set VehicalStatus='" + updatedVehicalStatus + "' where regNumb='" + regNumb +"';";
			try{
				connection = FMSConnection.getConnection();
				statement = connection.createStatement();
				statement.executeUpdate(query);
			} //try
			catch (SQLException e) {
	            e.printStackTrace();
	            throw new FmsException(e.getErrorCode(), "Error occured while inserting details: " + e.getMessage());
	        } finally {
	            if (connection != null) {
	                try {
	                    connection.close();
	                }//try
	                catch (SQLException e) {
	                    e.printStackTrace();
	                } //catch
	            }//if
	        }//finally
		}//if
		else if("VehicalLocation".equals(fieldToUpdate))
		{
			String regNumb = JOptionPane.showInputDialog("Enter the Vehical Registration Number for which location field needs to be modified");
			String updatedVehicalLocation = JOptionPane.showInputDialog("Enter New vehical Location");
			String query = "update VehicalInfo set VehicalLocation='" + updatedVehicalLocation + "' where VehicalRegistrationNumber='" + regNumb +"';";
			try{
				connection = FMSConnection.getConnection();
				statement = connection.createStatement();
				statement.executeUpdate(query);
			} //try
			catch (SQLException e) {
	            e.printStackTrace();
	            throw new FmsException(e.getErrorCode(), "Error occured while inserting details: " + e.getMessage());
	        } finally {
	            if (connection != null) {
	                try {
	                    connection.close();
	                }//try
	                catch (SQLException e) {
	                    e.printStackTrace();
	                } //catch
	            }//if
	        }//finally
		}//if
		else if("VehicalKilometerReading".equals(fieldToUpdate))
		{
			String regNumb = JOptionPane.showInputDialog("Enter the Vehical Registration Number for which KM Reading field needs to be modified");
			String updatedVehicalKilometerReading = JOptionPane.showInputDialog("Enter Vehical new KM reading");
			String query = "update VehicalInfo set VehicalKilometerReading='" + updatedVehicalKilometerReading + "' where VehicalRegistrationNumber='" + regNumb +"';";
			try{
				connection = FMSConnection.getConnection();
				statement = connection.createStatement();
				statement.executeUpdate(query);
			} //try
			catch (SQLException e) {
	            e.printStackTrace();
	            throw new FmsException(e.getErrorCode(), "Error occured while inserting details: " + e.getMessage());
	        } finally {
	            if (connection != null) {
	                try {
	                    connection.close();
	                }//try
	                catch (SQLException e) {
	                    e.printStackTrace();
	                } //catch
	            }//if
	        }//finally
		}//if
	}
	
	public static void deleteVehicalInfo(String vehicalRegNumb) throws FmsException
	{
        Connection connection = null;
        Statement statement = null;
 
		String query = "delete from VehicalInfo where VehicalRegistrationNumber =" + vehicalRegNumb + ";";
		try{
			connection = FMSConnection.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} //try
		catch (SQLException e) {
            e.printStackTrace();
            throw new FmsException(e.getErrorCode(), "Error occured while inserting details: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                }//try
                catch (SQLException e) {
                    e.printStackTrace();
                } //catch
            }//if
        }//finally
	}
	
	public static void getVehicalInfo(String dvrName) throws FmsException
	{
		ResultSet rs = null;
        Connection connection = null;
        Statement statement = null;
         
        VehicalInfo vInfo = null;
        String query = "SELECT * FROM VehicalInfo WHERE DriverName='" + dvrName +"'";
        try {          
            connection = FMSConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
             
            if (rs.next()) {
            	vInfo = new VehicalInfo();
            	vInfo.setVehicalUniqueId(rs.getInt("VehicalUniqueId"));
            	vInfo.setVehicalRegistrationNumber(rs.getInt("VehicalRegistrationNumber"));
            	vInfo.setVehicalModelName(rs.getString("VehicalModelName"));
            	vInfo.setVehicalInsuranceExpiryDate(rs.getDate("VehicalInsuranceExpiryDate"));
            	vInfo.setVehicalStatus(rs.getString("VehicalStatus"));
            	vInfo.setVehicalLocation(rs.getString("VehicalLocation"));
            	vInfo.setVehicalKilometerReading(rs.getLong("VehicalKilometerReading"));
            	oVehicalInfo = vInfo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new FmsException(e.getErrorCode(), "Error occured while inserting details: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		JOptionPane.showMessageDialog(null,oVehicalInfo.toString(),"Output", JOptionPane.PLAIN_MESSAGE);

        System.out.println(vInfo);
	}
}

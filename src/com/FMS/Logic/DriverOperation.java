package com.FMS.Logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.FMS.dbconnector.FMSConnection;
import com.FMS.utils.FmsException;
import com.FMS.DataType.DriverInfo;

public class DriverOperation {

	public static DriverInfo oDriverInfo = new DriverInfo();
	
	public static void createDriverDatabase(String dName, String dIdProof, String dIdNumb, String dAddress, String dStatus, int dPhNumb) throws FmsException
	{
		Connection connection = null;
        Statement statement = null;
         
        String query = "insert into DriverInfo(DriverName, DriverIdProof, DriverIdNumber, DriverAddress, DriverStatus, DriverPhoneNumber) values('" + dName + "','" +dIdProof + "','" + dIdNumb + "','" + dAddress + "','" + dStatus + "'," + dPhNumb + ");";
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
	public static void updateDriverInfo () throws FmsException
	{
        Connection connection = null;
        Statement statement = null;
         
		String fieldToUpdate = JOptionPane.showInputDialog("Which Field you want to modify\n DriverName \n DriverIdProof\n DriverIdNumber\n DriverAddress\n DriverStatus\n DriverPhoneNumber");
		if("DriverName".equals(fieldToUpdate))
		{
			String idNumb = JOptionPane.showInputDialog("Enter the Driver Identification Number for which Name field needs to be modified");
			String updatedDriverName = JOptionPane.showInputDialog("Enter New Driver Name");
			String query = "update DriverInfo set DriverName='" + updatedDriverName + "' where DriverIdNumber='" + idNumb +"';";
			try{
				connection = FMSConnection.getConnection();
				statement = connection.createStatement();
				statement.executeUpdate(query);
			} // try
			catch (SQLException e) {
	            e.printStackTrace();
	            throw new FmsException(e.getErrorCode(), "Error occured while inserting details: " + e.getMessage());
	        } finally {
	            if (connection != null) {
	                try {
	                    connection.close();
	                }// try
	                catch (SQLException e) {
	                    e.printStackTrace();
	                } // catch
	            }// if
	        }// finally
		}// if
		else if("DriverIdProof".equals(fieldToUpdate))
		{
			String idNumb = JOptionPane.showInputDialog("Enter the Driver Identification Number for which ID Proof field needs to be modified");
			String updatedDriverIdProof = JOptionPane.showInputDialog("Enter New Driver Id Proof");
			String query = "update DriverInfo set DriverIdProof='" + updatedDriverIdProof + "' where DriverIdNumber='" + idNumb +"';";
			try{
				connection = FMSConnection.getConnection();
				statement = connection.createStatement();
				statement.executeUpdate(query);
			} // try
			catch (SQLException e) {
	            e.printStackTrace();
	            throw new FmsException(e.getErrorCode(), "Error occured while inserting details: " + e.getMessage());
	        } finally {
	            if (connection != null) {
	                try {
	                    connection.close();
	                }// try
	                catch (SQLException e) {
	                    e.printStackTrace();
	                } // catch
	            }// if
	        }// finally
		}// if
		else if("DriverAddress".equals(fieldToUpdate))
		{
			String idNumb = JOptionPane.showInputDialog("Enter the Driver Identification Number for which Address field needs to be modified");
			String updatedDriverAddress = JOptionPane.showInputDialog("Enter New Driver Address");
			String query = "update DriverInfo set DriverAddress='" + updatedDriverAddress + "' where DriverIdNumber='" + idNumb +"';";
			try{
				connection = FMSConnection.getConnection();
				statement = connection.createStatement();
				statement.executeUpdate(query);
			} // try
			catch (SQLException e) {
	            e.printStackTrace();
	            throw new FmsException(e.getErrorCode(), "Error occured while inserting details: " + e.getMessage());
	        } finally {
	            if (connection != null) {
	                try {
	                    connection.close();
	                }// try
	                catch (SQLException e) {
	                    e.printStackTrace();
	                } // catch
	            }// if
	        }// finally
		}// if
		else if("DriverStatus".equals(fieldToUpdate))
		{
			String idNumb = JOptionPane.showInputDialog("Enter the Driver Identification Number for which Name field needs to be modified");
			String updatedDriverStatus = JOptionPane.showInputDialog("Enter Driver New Status");
			String query = "update DriverInfo set DriverStatus='" + updatedDriverStatus + "' where DriverIdNumber='" + idNumb +"';";
			try{
				connection = FMSConnection.getConnection();
				statement = connection.createStatement();
				statement.executeUpdate(query);
			} // try
			catch (SQLException e) {
	            e.printStackTrace();
	            throw new FmsException(e.getErrorCode(), "Error occured while inserting details: " + e.getMessage());
	        } finally {
	            if (connection != null) {
	                try {
	                    connection.close();
	                }// try
	                catch (SQLException e) {
	                    e.printStackTrace();
	                } // catch
	            }// if
	        }// finally
		}// if
		else if("DriverPhoneNumber".equals(fieldToUpdate))
		{
			String idNumb = JOptionPane.showInputDialog("Enter the Driver Identification Number for which Name field needs to be modified");
			String updatedDriverPhoneNumber = JOptionPane.showInputDialog("Enter New Driver Phone Number");
			String query = "update DriverInfo set DriverPhoneNumber='" + updatedDriverPhoneNumber + "' where DriverIdNumber='" + idNumb +"';";
			try{
				connection = FMSConnection.getConnection();
				statement = connection.createStatement();
				statement.executeUpdate(query);
			} // try
			catch (SQLException e) {
	            e.printStackTrace();
	            throw new FmsException(e.getErrorCode(), "Error occured while inserting details: " + e.getMessage());
	        } finally {
	            if (connection != null) {
	                try {
	                    connection.close();
	                }// try
	                catch (SQLException e) {
	                    e.printStackTrace();
	                } // catch
	            }// if
	        }// finally
		}// if
	}
	
	public static void deleteDriverInfo(String drvrIdNumber) throws FmsException
	{
        Connection connection = null;
        Statement statement = null;
 
		String query = "delete from DriverInfo where DriverIdNumber ='" + drvrIdNumber + "';";
		try{
			connection = FMSConnection.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} // try
		catch (SQLException e) {
            e.printStackTrace();
            throw new FmsException(e.getErrorCode(), "Error occured while inserting details: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                }// try
                catch (SQLException e) {
                    e.printStackTrace();
                    throw new FmsException(e.getErrorCode(), "Error occured while inserting details: " + e.getMessage());
                } // catch
            }// if
        }// finally
	}
	
	public static void getDriverInfo(String dvrName) throws FmsException
	{
		ResultSet rs = null;
        Connection connection = null;
        Statement statement = null;
         
        DriverInfo drvDetail = null;
        String query = "SELECT * FROM DriverInfo WHERE DriverName='" + dvrName +"'";
        try {          
            connection = FMSConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
             
            if (rs.next()) {
            	drvDetail = new DriverInfo();
            	drvDetail.setDriverName(rs.getString("DriverName"));
            	drvDetail.setDriverIdProof(rs.getString("DriverIdProof"));
            	drvDetail.setDriverIdNumber(rs.getString("DriverIdNumber"));
            	drvDetail.setDriverAddress(rs.getString("DriverAddress"));
            	drvDetail.setDriverStatus(rs.getString("DriverStatus"));
            	drvDetail.setDriverPhoneNumber(rs.getInt("DriverPhoneNumber"));
            	oDriverInfo = drvDetail;
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
		JOptionPane.showMessageDialog(null,oDriverInfo.toString(),"Output", JOptionPane.PLAIN_MESSAGE);

        System.out.println(drvDetail);
	}
}

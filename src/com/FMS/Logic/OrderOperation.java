package com.FMS.Logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.FMS.ValidData.OrderValidator;
import com.FMS.dbconnector.FMSConnection;
import com.FMS.utils.FmsException;
import com.FMS.DataType.OrderInfo;

public class OrderOperation implements OrderValidator{
	
	public static OrderInfo ordrInfo = new OrderInfo();
	
	public static void createOrderDatabase(int ordrNumb, String clientName, String ordrDate, String billingDate, String dlvryDate, String destnAddress) throws FmsException
	{
	    Connection connection = null;
	    Statement statement = null;

	 
		
        String query = "insert into OrderDetails(OrderNumber, ClientName, OrderDate, BillingDate, DeliveryDate, DestinationAddress) values(" + ordrNumb + ",'" +clientName + "','" + ordrDate + "','" + billingDate + "','" + dlvryDate + "','" + destnAddress + "');";
        try {          
            connection = FMSConnection.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
             
        } catch (SQLException e) {
            e.printStackTrace();
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
	public static void updateOrderInfo() throws FmsException
	{
        Connection connection = null;
        Statement statement = null;
         
		String fieldToUpdate = JOptionPane.showInputDialog("Which Field you want to modify\n OrderNumber \n ClientName\n OrderDate\n BillingDate\n DeliveryDate\n DeliveryDate");
		if("ClientName".equals(fieldToUpdate))
		{
			String ordrNumb = JOptionPane.showInputDialog("Enter the Order Number for which Client Name field needs to be modified");
			String updatedClientName = JOptionPane.showInputDialog("Enter Client New Name");
			String query = "update OrderDetails set ClientName='" + updatedClientName + "' where OrderNumber='" + ordrNumb +"';";
			try{
				connection = FMSConnection.getConnection();
				statement = connection.createStatement();
				statement.executeUpdate(query);
			} //try
			catch (SQLException e) {
	            e.printStackTrace();
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
		else if("OrderDate".equals(fieldToUpdate))
		{
			String ordrNumb = JOptionPane.showInputDialog("Enter the Order Number for which Order Date field needs to be modified");
			String updatedOrderDate = JOptionPane.showInputDialog("Enter New Order Date");
			String query = "update OrderDetails set OrderDate='" + updatedOrderDate + "' where OrderNumber='" + ordrNumb +"';";
			try{
				connection = FMSConnection.getConnection();
				statement = connection.createStatement();
				statement.executeUpdate(query);
			} //try
			catch (SQLException e) {
	            e.printStackTrace();
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
		else if("BillingDate".equals(fieldToUpdate))
		{
			String ordrNumb = JOptionPane.showInputDialog("Enter the Order Number for which Billing Date field needs to be modified");
			String updatedBillingDate = JOptionPane.showInputDialog("Enter New Billing Date");
			String query = "update OrderDetails set BillingDate='" + updatedBillingDate + "' where OrderNumber='" + ordrNumb +"';";
			try{
				connection = FMSConnection.getConnection();
				statement = connection.createStatement();
				statement.executeUpdate(query);
			} //try
			catch (SQLException e) {
	            e.printStackTrace();
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
		else if("DeliveryDate".equals(fieldToUpdate))
		{
			String ordrNumb = JOptionPane.showInputDialog("Enter the Order Number for which Delivery date field needs to be modified");
			String updatedDeliveryDate = JOptionPane.showInputDialog("Enter New Delivery Date");
			String query = "update OrderInfo set DeliveryDate='" + updatedDeliveryDate + "' where OrderNumber='" + ordrNumb +"';";
			try{
				connection = FMSConnection.getConnection();
				statement = connection.createStatement();
				statement.executeUpdate(query);
			} //try
			catch (SQLException e) {
	            e.printStackTrace();
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
		else if("DestinationAddress".equals(fieldToUpdate))
		{
			String ordrNumb = JOptionPane.showInputDialog("Enter the Order Number for which Destination Address field needs to be modified");
			String updatedDestinationAddress = JOptionPane.showInputDialog("Enter New destination Address");
			String query = "update OrderInfo set DestinationAddress='" + updatedDestinationAddress + "' where OrderNumber='" + ordrNumb +"';";
			try{
				connection = FMSConnection.getConnection();
				statement = connection.createStatement();
				statement.executeUpdate(query);
			} //try
			catch (SQLException e) {
	            e.printStackTrace();
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
	
	public static void deleteOrderInfo(String ordrNumber) throws FmsException
	{
        Connection connection = null;
        Statement statement = null;
 
		String query = "delete from OrderInfo where OrderNumber =" + ordrNumber + ";";
		try{
			connection = FMSConnection.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} //try
		catch (SQLException e) {
            e.printStackTrace();
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
	
	public static void getOrderInfo(String orderNum) throws FmsException
	{
		ResultSet rs = null;
	    Connection connection = null;
	    Statement statement = null;

		
        OrderInfo ordrDetail = null;
        String query = "SELECT * FROM OrderInfo WHERE OrderNumber='" + orderNum +"'";
        try {          
            connection = FMSConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
             
            if (rs.next()) {
            	ordrDetail = new OrderInfo();
            	ordrDetail.setOrderNumber(rs.getInt("OrderNumber"));
            	ordrDetail.setClientName(rs.getString("ClientName"));
            	ordrDetail.setOrderDate(rs.getDate("OrderDate"));
            	ordrDetail.setBillingDate(rs.getDate("BillingDate"));
            	ordrDetail.setDeliveryDate(rs.getDate("DeliveryDate"));
            	ordrDetail.setDestinationAddress(rs.getString("DestinationAddress"));
            	ordrInfo = ordrDetail;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		JOptionPane.showMessageDialog(null,ordrInfo.toString(),"Output", JOptionPane.PLAIN_MESSAGE);

        System.out.println(ordrDetail);
        /*String repeatVar = JOptionPane.showInputDialog("Do you want to continue(Y/N)");
        if("Y".equals(repeatVar) | "y".equals(repeatVar))
        	selectedOrderOperation();
        else if("N".equals(repeatVar) | "n".equals(repeatVar))
        	break;*/
	}
	public void validateCreateOperation() throws FmsException{
		
	}
	
	public void validateUpdateOperation() throws FmsException{
		
	}
	
	public void validateDeleteOperation() throws FmsException{
		
	}
	
	public void validateSelectOperation() throws FmsException{
		
	}
}

package com.FMS.Top;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import com.FMS.Logic.ClientOperation;
import com.FMS.Logic.DriverOperation;
import com.FMS.Logic.OrderOperation;
import com.FMS.Logic.VehicalOperation;
import com.FMS.ValidData.ClientValidatorImpl;
import com.FMS.dbconnector.FMSConnection;
import com.FMS.utils.FMSUtils;
import com.FMS.utils.FmsException;

public class Top {

	public static ClientOperation clientOpern = new ClientOperation();
	public static DriverOperation driverOpern = new DriverOperation();
	public static VehicalOperation vehicalOpern = new VehicalOperation();
	public static OrderOperation orderOpern = new OrderOperation();
	static FMSUtils utils = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 try {
			 String repeatVar = JOptionPane.showInputDialog("Do you want to Access Database(Y/N)");
		     if("Y".equals(repeatVar) | "y".equals(repeatVar))
		    	 chooseModeOfOperation();
		     else
		     {
		    	 String consignmentReport = JOptionPane.showInputDialog("Do you want to Consignment Report(Y/N)");
		    	 if("Y".equals(consignmentReport) | "y".equals(consignmentReport))
		    		 ConsignmentReport();
		     }
		 } catch (FmsException e)
		 {
			 JOptionPane.showMessageDialog ( null,
		  e.getErrorCode() + " : " + e.getErrorMessage(), "Error",
		  JOptionPane.ERROR_MESSAGE); 
		}
		 
	}


	private static void chooseModeOfOperation() throws FmsException
	{
		// int choice = FMSUtils
		// .validateInteger(JOptionPane
		// .showInputDialog("Select your option\n 1. Driver Related Operation\n
		// 2. Vehical Related Operation\n 3. Client Related Operation\n 4. Order
		// Related Operation"));
		String input = 	JOptionPane.showInputDialog("Select your option\n 1. Driver Related Operation\n 2. Vehical Related Operation\n 3. Client Related Operation\n 4. Order Related Operation");
		int choice = Integer.parseInt(input);
		System.out.println(choice);
		String repeatVar;
		switch (choice)
		{
			case 1:// Driver Related Operation
				selectedDriverOperation();
		        repeatVar = JOptionPane.showInputDialog("Do you want to continue(Y/N)");
		        if("Y".equals(repeatVar) | "y".equals(repeatVar))
		        	chooseModeOfOperation();
		        else if("N".equals(repeatVar) | "n".equals(repeatVar))
		        	break;
			case 2:// Vehical Related Operation
				selectedVehicalOperation();
		        repeatVar = JOptionPane.showInputDialog("Do you want to continue(Y/N)");
		        if("Y".equals(repeatVar) | "y".equals(repeatVar))
		        	chooseModeOfOperation();
		        else if("N".equals(repeatVar) | "n".equals(repeatVar))
		        	break;
			case 3:// Client Related Operation
				selectedClientOperation();
		        repeatVar = JOptionPane.showInputDialog("Do you want to continue(Y/N)");
		        if("Y".equals(repeatVar) | "y".equals(repeatVar))
		        	chooseModeOfOperation();
		        else if("N".equals(repeatVar) | "n".equals(repeatVar))
		        	break;
			case 4:// Order Related Operation
				selectedOrderOperation();
		        repeatVar = JOptionPane.showInputDialog("Do you want to continue(Y/N)");
		        if("Y".equals(repeatVar) | "y".equals(repeatVar))
		        	chooseModeOfOperation();
		        else if("N".equals(repeatVar) | "n".equals(repeatVar))
		        	break;
		}
	}
	
	private static void selectedDriverOperation()
	{
		String input = JOptionPane.showInputDialog("Select Driver Operation\n 1. Create Driver Database\n 2. Update Driver Database\n 3. Delete Driver database\n 4. Get Driver Detail");
		
		int choice = Integer.parseInt(input);
		System.out.println(choice);
		
		switch (choice)
		{
			case 1:// Create Driver Database
			{
				try
				{
					String dName = utils.validateString(JOptionPane.showInputDialog("Enter Driver Name"));
					String dIdProof = utils.validateString(JOptionPane.showInputDialog("Enter Driver Id card name"));
					String dIdNumb = utils.validateString(JOptionPane.showInputDialog("Enter Driver ID Proof Number"));
					String dAddress = utils.validateString(JOptionPane.showInputDialog("Enter Driver's Address"));
					String dStatus = utils.validateString(JOptionPane.showInputDialog("Enter Driver's status"));
					int dPhNumb = utils.validateInteger(JOptionPane.showInputDialog("Enter Driver's 10 digit phone number"));
					driverOpern.createDriverDatabase(dName, dIdProof, dIdNumb, dAddress, dStatus, dPhNumb);
					JOptionPane.showMessageDialog(null, "Driver Information is Successfully Entered", "Message", JOptionPane.PLAIN_MESSAGE);
				}
				catch (FmsException e)
				{
					JOptionPane.showMessageDialog ( 
							null, e.getErrorCode() + " : " + e.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);  
				}
			}
				break;
			case 2:// Update Driver Database
			{
				try
				{
					driverOpern.updateDriverInfo();
					JOptionPane.showMessageDialog(null, "Driver Information is Successfully Updated", "Message", JOptionPane.PLAIN_MESSAGE);
				}
				catch (FmsException e)
				{
					JOptionPane.showMessageDialog ( 
							null, e.getErrorCode() + " : " + e.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);  
				}
			
			}
				break;
			case 3:// Delete Driver database
			{
				try
				{
					String drvrIdNumber = utils.validateString(JOptionPane.showInputDialog("Enter the DriverIdNumber for which data needs to be deleted"));
					driverOpern.deleteDriverInfo(drvrIdNumber);
					JOptionPane.showMessageDialog(null, "Driver Information is Successfully Deleted", "Message", JOptionPane.PLAIN_MESSAGE);
				}
				catch (FmsException e)
				{
					JOptionPane.showMessageDialog ( 
							null, e.getErrorCode() + " : " + e.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);  
				}
			}
				break;
			case 4:// Get Driver Detail
			{
				try
				{
					String dvrName = JOptionPane.showInputDialog("Enter Driver's Name");
					driverOpern.getDriverInfo(dvrName);
					JOptionPane.showMessageDialog(null, "Driver Information is Successfully Retrived", "Message", JOptionPane.PLAIN_MESSAGE);
				}
				catch (FmsException e)
				{
					JOptionPane.showMessageDialog ( 
							null, e.getErrorCode() + " : " + e.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);  
				}
			}
				break;
		}
	}	
	

	private static void selectedVehicalOperation()
	{
		String input = JOptionPane.showInputDialog("Select Vehical Operation\n 1. Create Vehical Database\n 2. Update Vehical Database\n 3. Delete Vehical database\n 4. Get Vehical Detail");
		
		int choice = Integer.parseInt(input);
		System.out.println(choice);
		
		switch (choice)
		{
			case 1:
			{
				try
				{
					String vUIdString = utils.validateString(JOptionPane.showInputDialog("Enter Vehical Unique ID"));
					String vRegNumbString = utils.validateString(JOptionPane.showInputDialog("Enter Vehical Registration Number"));
					String vModelName = utils.validateString(JOptionPane.showInputDialog("Enter Vehical Model Name"));
					String vInsurExpdate = utils.validateString(JOptionPane.showInputDialog("Enter Vehical Insurance Expiry Date(YYYY-MM-DD)"));
					String vStatus = utils.validateString(JOptionPane.showInputDialog("Enter Vehical Status"));
					String vLocation = utils.validateString(JOptionPane.showInputDialog("Enter Vehical Location"));
					String vKmReadingString = utils.validateString(JOptionPane.showInputDialog("Enter Vehical Kilometer Reading"));
					vehicalOpern.createVehicalDatabase(vUIdString, vRegNumbString, vModelName, vInsurExpdate, vStatus, vLocation, vKmReadingString);
					JOptionPane.showMessageDialog(null, "Vehical Information is Successfully Entered", "Message", JOptionPane.PLAIN_MESSAGE);
				}
				catch (FmsException e)
				{
					JOptionPane.showMessageDialog ( 
							null, e.getErrorCode() + " : " + e.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);  
				}
			}
				break;
			case 2:
			{
				try
				{
					vehicalOpern.updateVehicalInfo();
					JOptionPane.showMessageDialog(null, "Vehical Information is Successfully Updated", "Message", JOptionPane.PLAIN_MESSAGE);

				}
				catch (FmsException e)
				{
					JOptionPane.showMessageDialog ( 
							null, e.getErrorCode() + " : " + e.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);  
				}
			}
				break;
			case 3:
			{
				try
				{
					String vehicalRegNumb = utils.validateString(JOptionPane.showInputDialog("Enter the VehicalRegistrationNumber for which data needs to be deleted"));
					vehicalOpern.deleteVehicalInfo(vehicalRegNumb);
					JOptionPane.showMessageDialog(null, "Vehical Information is Successfully Deleted", "Message", JOptionPane.PLAIN_MESSAGE);
					
				}
				catch (FmsException e)
				{
					JOptionPane.showMessageDialog ( 
							null, e.getErrorCode() + " : " + e.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);  
				}
			}
				break;
			case 4:
			{
				try
				{
					String dvrName = utils.validateString(JOptionPane.showInputDialog("Enter Driver's Name"));
					vehicalOpern.getVehicalInfo(dvrName);
				}
				catch (FmsException e)
				{
					JOptionPane.showMessageDialog ( 
							null, e.getErrorCode() + " : " + e.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);  
				}
			}
		        break;
		}
	}
	

	private static void selectedClientOperation()
	{
		String input = JOptionPane.showInputDialog("Select Client Operation\n 1. Create Client database\n 2. Update Client Detail\n 3. Delete Client Detail\n 4. Get Client Detail");
		
		int choice = Integer.parseInt(input);
		System.out.println(choice);
		
		switch (choice)
		{
			case 1:
			{
				try
				{
					String cName = utils.validateString(JOptionPane.showInputDialog("Enter Client Name"));
					String cAddress = utils.validateString(JOptionPane.showInputDialog("Enter Client Address"));
					String lastTradingDate = utils.validateString(JOptionPane
						.showInputDialog("Enter Last Trading Date(YYYY-MM-DD)"));
					int cPhNumb = utils.validateInteger(JOptionPane
						.showInputDialog("Enter Client 10 digit Phone Number"));
		
					clientOpern.createClientDatabase(cName, cAddress, lastTradingDate, cPhNumb);
					JOptionPane.showMessageDialog(null, "Client Information is Successfully Entered", "Message", JOptionPane.PLAIN_MESSAGE);
				}
				catch(FmsException e)
				{
					JOptionPane.showMessageDialog ( 
							null, e.getErrorCode() + " : " + e.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);  
				}
			}	
				break;
			case 2:
			{
				try
				{
					clientOpern.updateClientInfo();
					JOptionPane.showMessageDialog(null, "Client Information is Successfully Updated", "Message", JOptionPane.PLAIN_MESSAGE);

				}
				catch(FmsException e)
				{
					JOptionPane.showMessageDialog ( 
							null, e.getErrorCode() + " : " + e.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);  
				}
			}
				break;
			case 3:
			{
				try
				{
					String clientName = utils.validateString(JOptionPane
					.showInputDialog("Enter the ClientName for which data needs to be deleted"));
					clientOpern.deleteClientInfo(clientName);
					JOptionPane.showMessageDialog(null, "Client Information is Successfully Deleted", "Message", JOptionPane.PLAIN_MESSAGE);

				}
				catch(FmsException e)
				{
					JOptionPane.showMessageDialog ( 
							null, e.getErrorCode() + " : " + e.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);  
				}
			}
				break;
			case 4:
			{
				try
				{
					String cName = utils.validateString(JOptionPane.showInputDialog("Enter Client Name"));
					clientOpern.getClientInfo(cName);
				}
				catch(FmsException e)
				{
					JOptionPane.showMessageDialog ( 
							null, e.getErrorCode() + " : " + e.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);  
				}
			}
				break;
		}
	}
	

	private static void selectedOrderOperation()
	{
		String input = JOptionPane.showInputDialog("Select Order Operation\n 1. Create Order Database\n 2. Update Order Detail\n 3. Delete Order Detail\n 4. Get Order Detail");
		
		int choice = Integer.parseInt(input);
		System.out.println(choice);
       
		switch (choice)
		{
			case 1:
			{
				try
				{
					int ordrNumb = utils.validateInteger(JOptionPane.showInputDialog("Enter Order Number"));
				   	String clientName = utils.validateString(JOptionPane.showInputDialog("Enter Client Name"));
				   	String ordrDate = utils.validateString(JOptionPane.showInputDialog("Enter Order Date(YYYY-MM-DD)"));
				   	String billingDate = utils.validateString(JOptionPane.showInputDialog("Enter Billing Date(YYYY-MM-DD)"));
				   	String dlvryDate = utils.validateString(JOptionPane.showInputDialog("Enter Delivery Date(YYYY-MM-DD)"));
				   	String destnAddress = utils.validateString(JOptionPane.showInputDialog("Enter Destination Address"));
				   	
					orderOpern.createOrderDatabase(ordrNumb, clientName, ordrDate, billingDate, dlvryDate, destnAddress);
					JOptionPane.showMessageDialog(null, "Order Information is Successfully Entered", "Message", JOptionPane.PLAIN_MESSAGE);
				}
				catch(FmsException e)
				{
					JOptionPane.showMessageDialog ( 
							null, e.getErrorCode() + " : " + e.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);  
				}
			}
				break;
			case 2:
			{
				try
				{
					orderOpern.updateOrderInfo();
					JOptionPane.showMessageDialog(null, "Order Information is Successfully Updated", "Message", JOptionPane.PLAIN_MESSAGE);
				}
				catch(FmsException e)
				{
					JOptionPane.showMessageDialog ( 
							null, e.getErrorCode() + " : " + e.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);  
				}
			}
				break;
			case 3:
			{
				try
				{
					String ordrNumber = JOptionPane.showInputDialog("Enter the OrderNumber for which data needs to be deleted");
					orderOpern.deleteOrderInfo(ordrNumber);
					JOptionPane.showMessageDialog(null, "Order Information is Successfully Deleted", "Message", JOptionPane.PLAIN_MESSAGE);
				}catch(FmsException e)
				{
					JOptionPane.showMessageDialog ( 
							null, e.getErrorCode() + " : " + e.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);  
				}
			}
				break;
			case 4:
			{
				try
				{
					String orderNum = JOptionPane.showInputDialog("Enter Order Number");
					orderOpern.getOrderInfo(orderNum);

				}catch(FmsException e)
				{
					JOptionPane.showMessageDialog ( 
							null, e.getErrorCode() + " : " + e.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);  
				}
			}
				break;
		        
		}	
	}
	private static void ConsignmentReport()
	{
		String DepartureDate = null;
		String ArrivalDate = null;
		String DriverName = null;
		int VehicalRegistrationNumber = 0;
		String SourceLocation = null;
		String DestinationLocation = null;
		
		Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
         
        String query = "select VehicalRegistrationNumber from vehicalInfo where VehicalStatus = 'Available'";
        try {          
            connection = FMSConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            if(rs.next()) {
            	VehicalRegistrationNumber = rs.getInt("VehicalRegistrationNumber");
            	System.out.println(VehicalRegistrationNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        query = "select DriverName from DriverInfo where DriverStatus='Available'";
        try {          
            connection = FMSConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            if(rs.next()) {
            	DriverName = rs.getString("DriverName");
            	System.out.println(DriverName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        query = "select DestinationAddress from OrderInfo where OrderDate = current_date";
        try{
        	connection = FMSConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            if(rs.next()) {
            	DestinationLocation = rs.getString("DestinationAddress");
            	System.out.println(DestinationLocation);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        //Arrival date and current location can be calculated using google API(future enhancement)
        query = "insert into ConsignmentReport(DepartureDate, ArrivalDate, DriverName, VehicalRegistrationNumber, SourceLocation, DestinationLocation) values (current_date, '2014-06-30 ', '" + DriverName + "', " + VehicalRegistrationNumber +", 'Indore', '" + DestinationLocation + "');"; 
        try{
        	connection = FMSConnection.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Consignment Details are :\n DepartureDate = " + Calendar.getInstance().getTime() + " ArrivalDate = 2014-06-30" +  " DriverName = " + DriverName + " VehicalRegistrationNumber = " + VehicalRegistrationNumber + " SourceLocation = Indore" + " DestinationLocation = " + DestinationLocation, "Message", JOptionPane.PLAIN_MESSAGE);
	}
}
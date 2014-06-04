package com.FMS.Logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.FMS.ValidData.ClientValidator;
import com.FMS.dbconnector.FMSConnection;
import com.FMS.utils.FmsException;
import com.FMS.DataType.ClientInfo;
import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;

public class ClientOperation {

	public static ClientInfo oClientInfo = new ClientInfo();

	public void createClientDatabase(String cName, String cAddress, String lastTradingDate, int cPhNumb) throws FmsException{
		Connection connection = null;
		Statement statement = null;

		
		String query = "insert into ClientInfo(ClientName, ClientAddress, ClientPhoneNumber, LastTradingDate) values('"
				+ cName
				+ "','"
				+ cAddress
				+ "',"
				+ cPhNumb
				+ ",'"
				+ lastTradingDate + "');";
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

	public void updateClientInfo() throws FmsException
	{
		Connection connection = null;
		Statement statement = null;

		String fieldToUpdate = JOptionPane
				.showInputDialog("Which Field you want to modify\n ClientName \n ClientAddress\n ClientPhoneNumber\n LastTradingDate");
		if ("ClientAddress".equals(fieldToUpdate)) {
			String name = JOptionPane
					.showInputDialog("Enter the Client Name for which Address field needs to be modified");
			String updatedClientAddress = JOptionPane
					.showInputDialog("Enter Client New Address");
			String query = "update ClientInfo set ClientAddress='"
					+ updatedClientAddress + "' where ClientName='" + name
					+ "';";
			try {
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
		else if ("ClientPhoneNumber".equals(fieldToUpdate)) {
			String name = JOptionPane
					.showInputDialog("Enter the Client Name for which Phone Number field needs to be modified");
			String updatedClientPhoneNumber = JOptionPane
					.showInputDialog("Enter Client New Phone Number");
			String query = "update ClientInfo set ClientPhoneNumber='"
					+ updatedClientPhoneNumber + "' where ClientName='" + name
					+ "';";
			try {
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
		else if ("LastTradingDate".equals(fieldToUpdate)) {
			String name = JOptionPane
					.showInputDialog("Enter the Client Name for which Last Trading Date field needs to be modified");
			String updatedLastTradingDate = JOptionPane
					.showInputDialog("Enter Client Last Trading Date");
			String query = "update ClientInfo set LastTradingDate='"
					+ updatedLastTradingDate + "' where ClientName='" + name
					+ "';";
			try {
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

	public void deleteClientInfo(String clientName) throws FmsException
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		String query = "delete from clientInfo where ClientName ='"
				+ clientName + "';";
		try {
			connection = FMSConnection.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} //try
		catch (SQLException e) {
			e.printStackTrace();
			throw new FmsException(e.getErrorCode(),e.getMessage());
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

	public void getClientInfo(String cName) throws FmsException
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		ClientInfo cInfo = null;
		String query = "SELECT * FROM ClientInfo WHERE ClientName='" + cName
				+ "'";
		try {
			connection = FMSConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);

			if (rs.next()) {
				cInfo = new ClientInfo();
				cInfo.setClientName(rs.getString("ClientName"));
				cInfo.setClientAddress(rs.getString("ClientAddress"));
				cInfo.setClientPhoneNumber(rs.getInt("ClientPhoneNumber"));
				cInfo.setLastTradingDate(rs.getDate("LastTradingDate"));
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
		oClientInfo = cInfo;
		JOptionPane.showMessageDialog(null,oClientInfo.toString(),"Output", JOptionPane.PLAIN_MESSAGE);
		System.out.println(cInfo);
	}

}

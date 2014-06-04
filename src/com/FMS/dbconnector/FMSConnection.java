package com.FMS.dbconnector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.FMS.constants.FMSConstants;
//import com.FMS.utils.WritePropertiesFile;
//import com.FMS.utils.FMSConstant;
public class FMSConnection {

	//static reference to itself
    private static FMSConnection instance = new FMSConnection();
    
	private FMSConnection(){
		 try {
	            //Step 2: Load MySQL Java driver
	            //System.out.println("DB_DRIVER IS " + WritePropertiesFile.prop.getProperty("dbDriver"));
	            Class.forName(FMSConstants.DB_DRIVER.getValue());
	            //Class.forName(FMSConstant.DB_DRIVER);

	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	     }
	}
	private static Connection createConnection() {
		
	        Connection connection = null;
	        try {
	            //Step 3: Establish Java MySQL connection
				//System.out.println("INSIDE CONNECTION: " + WritePropertiesFile.prop.getProperty("dbUrl"));

	            connection = DriverManager.getConnection(FMSConstants.DB_URL.getValue(), FMSConstants.DB_USER.getValue(), FMSConstants.DB_PASSWORD.getValue());
	            //connection = DriverManager.getConnection(FMSConstant.DB_URL, FMSConstant.DB_USER, FMSConstant.DB_PASSWORD);

	        } catch (SQLException e) {
	            System.out.println("ERROR: Unable to Connect to Database.");
	            e.printStackTrace();
	        }
	        return connection;
	}
	
	public static Connection getConnection() {
        return instance.createConnection();
    }
}

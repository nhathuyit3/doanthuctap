/**
*
*Date 	Aug 5, 2019
*
*	DATE	     AUTHOR	
*----------------------------
*   Aug 5, 2019	     TinhNH9
*/

/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author TinhNH9
 *
 */
public class SQLServerConnUtils{
	public static Connection getSQLServerConnection() throws ClassNotFoundException, SQLException {
		String hostName = "localhost";
		String database = "QlyThuCung";
		String userName = "sa";
		String password = "sa";
		return getSQLServerConnection(hostName,database,userName,password);
	}
	private static Connection getSQLServerConnection(String hostName, String database, String userName, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionURL = "jdbc:sqlserver://"+hostName+":1433;databaseName="+database;
		Connection conn = DriverManager.getConnection(connectionURL,userName,password);
		return conn;
	}
}

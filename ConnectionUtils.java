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
import java.sql.SQLException;

/**
 * @author TinhNH9
 *
 */
public class ConnectionUtils {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		return SQLServerConnUtils.getSQLServerConnection();
	}
	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void rollbackQuietly(Connection conn) {
		try {
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}

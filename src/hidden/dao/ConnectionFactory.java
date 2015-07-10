package hidden.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    
	public Connection getConnection() {
	     try {
	    	 Class.forName("com.mysql.jdbc.Driver");
	         return DriverManager.getConnection("jdbc:mysql://localhost:3306/heroes", "root", "");
	     } catch (Exception e) {
	         throw new RuntimeException(e);
	     }
	 }
	
    public Connection getConnection(String database, String user, String pass) {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database, user, pass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package edu.mum.project.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DBConnection {

	
	public Connection conn;
    public static DBConnection db;
    private DBConnection() throws SQLException {
    	System.out.println("Called from localhost");
        String url= "jdbc:mysql://localhost/";
        String dbName = "carpoolingdb";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
        try {
            Class.forName(driver).newInstance();
           
            
        }
        catch (Exception sqle) {
        	System.out.println("No driver found");
            sqle.printStackTrace();
        }
        this.conn = DriverManager.getConnection(url+dbName,userName,password);

    }
    
    
    public static synchronized DBConnection getConnection() throws SQLException {
    	System.out.println("db is" + db);
        if ( db == null ) {
            db = new DBConnection();
        }
        return db;
 
    }
}

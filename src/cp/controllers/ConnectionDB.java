package cp.controllers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionDB {	
	static String url =  "jdbc:postgresql:dbprueba";
	static String user = "postgres";
	static String pass = "masterkey";
	private static Connection conn = null;
	
	public static Connection startConn(){
			
			try {
				Class.forName("org.postgresql.Driver");
				
				System.out.println(" marico el que lo lea bd");
			} catch(Exception e) {
				e.printStackTrace();
				return null;
			}	
			
			
			try {
				conn = DriverManager.getConnection(url, user, pass);
				System.out.println("conecte");
				return conn;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		
		}
}
	


package cp.controllers;
import java.sql.*;
public class ConnectionDB {	
	static String url =  "jdbc:postgresql://localhost:5432/dbprueba";
	static String user = "postgres";
	static String pass = "masterkey";
	private static Connection conn = null;
	
	public static Connection startConn(){
			
			try {
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(url, user, pass);
				System.out.println("Estableci conexion");
				return conn;
			} catch(Exception e) {
				e.printStackTrace();
				return null;
			}	
		}
}
	


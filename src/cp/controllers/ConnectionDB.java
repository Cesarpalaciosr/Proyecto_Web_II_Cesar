package cp.controllers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {	
	static String url =  "jdbc:postgresql://ec2-3-222-11-129.compute-1.amazonaws.com:5432/de511gfgus123n";
	static String user = "tryqteclkftanp";
	static String pass = "05db7b52ac66289538be68d886f33753a8839d2de5c81f0272ec20f8760a8fd8";
		private static Connection conn = null;
		
		public static Connection startConn() throws SQLException{
				
				try {
					Class.forName("org.postgresql.Driver");
					System.out.println("intento conectar");
					
				} catch(ClassNotFoundException e ) {
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
		

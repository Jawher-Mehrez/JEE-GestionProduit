package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionBD {
	private static Connection connection ;
	
	private ConnectionBD() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost/gestioncomm","root","");
		System.out.println("connexion etablie..");
		}catch(ClassNotFoundException e) {
			System.out.println("Probleme chargement pilote..");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("Probleme etablissement connexion..");
			e.printStackTrace();
			
		}	
			
		}
	public static Connection getConnection()
	{
		if(connection==null)
			new ConnectionBD();
		return connection;
		}
		
	}



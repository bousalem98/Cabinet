package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
	
	// Params de la connexion
	private static String url = "jdbc:postgresql://localhost:5432/Cabinet";
	private static String user = "postgres";
	private static String passwd = "2011";
	private static Connection cn = null;

	// Constructeur privé pour limiter l'instanciation
	private ConnexionBD() {
		try { 
			cn = DriverManager.getConnection(url, user, passwd);
		} 
		catch ( Exception e ) {
			//e.printStackTrace(); 
	    	 System.out.println("erreur base");

		}
	}

	// On n'instancie la connexion que si le cn est different de null
	public static Connection getConnection() {
		if (cn == null) {
			new ConnexionBD();
		}
		return cn;
	}
	// Méthode de fermeture de la connexion
	public static void Fermer() {
		if (cn != null) {
			try {  cn.close(); }
			catch (SQLException e) { 
				//e.printStackTrace();  
		    	 System.out.println("erreur base");

			}
		}
	}	
}

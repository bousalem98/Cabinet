package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LogIn {

	public LogIn() {
	// TODO Auto-generated constructor stub
	}
	// Connexion à la BD
	static Connection c = ConnexionBD.getConnection();
	static  Boolean connect = false;
	public static boolean Chekuserandpass(String user,String pass,String type) throws ClassNotFoundException, SQLException
	 {
		if (c != null) {
				try {
				     Statement stmt=c.createStatement();
			            String check="select * from "+type+" where nom='"+user+"' and password='"+pass+"'";
			            ResultSet rs=stmt.executeQuery(check);
			            while(rs.next())
			            {
			            	connect = true;
			                return connect;

			            }
			        }
			     catch(SQLException ex)
			        {
			           // ex.printStackTrace();
			    	 System.out.println("erreur log in");
			        }
			}
	     return connect;

		
	 }
	}

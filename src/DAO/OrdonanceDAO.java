package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import OO.Ordonance;

public class OrdonanceDAO {

	public Ordonance Ajouter(Ordonance md) {
		// Connexion à la BD
		Connection c = ConnexionBD.getConnection();
		// Définition et exécution de la requête d'insertion
		if (c != null) {
			try {
				c.setAutoCommit(false);
				PreparedStatement ps = c.prepareStatement("insert into ordonance(nom,nbprise,nbboite,conscode) values (?,?,?,?);");
				ps.setString(1, md.getNom());
				ps.setInt(2, md.getNbprise());				
				ps.setInt(3, md.getNbboite());				
				ps.setInt(4, md.getConscode());				
				int res = ps.executeUpdate();
				if (res != 0) { // Activer le commit uniquement si la requête s'est exécuté sans problème
					c.commit();
					return md;
				}
			} catch (SQLException e) { e.printStackTrace();  }
			catch (Exception e) { e.printStackTrace();  }
		}
		return null;
	}
	
	 public static void fillToTable(int id,JTable table) throws ClassNotFoundException{
			Connection c = ConnexionBD.getConnection();
			if (c != null) {
				try {
				c.setAutoCommit(false);
	            int nbr=table.getColumnCount();
	            ResultSet rs;
	            String strselect;
	            strselect="select nom,nbprise,nbboite from ordonance where conscode=?;";
	            
	            PreparedStatement ps = c.prepareStatement(strselect);		
				ps.setInt(1, id);
				ResultSet res = ps.executeQuery();
	            ResultSetMetaData rsmd=res.getMetaData();
	            int cn=rsmd.getColumnCount();
	            DefaultTableModel model=(DefaultTableModel)table.getModel();
	            Vector row=new Vector();
	            model.setRowCount(0);
	            while(res.next())
	            {
	                row=new Vector(nbr);
	                for(int i=1;i<=nbr;i++)
	                {
	                    row.add(res.getString(i));
	                }
	                model.addRow(row);
	            }
	            if(table.getColumnCount()!=cn){
	            	JOptionPane.showMessageDialog(null,"JTable Culomns Count Not Equal To Query Columns Count\nJTable Culomns :"+table.getColumnCount()+"\nQuery Columns :"+c);
	            }
	        }
	        catch(SQLException ex)
	        {
	        	JOptionPane.showMessageDialog(null,ex.getMessage());
	        }
	    }
	
	 }
}

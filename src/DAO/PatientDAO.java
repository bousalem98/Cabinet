package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import OO.Patient;

public class PatientDAO {
	
	
	public Patient Modifier(Patient p,int id) {
		// Connexion à la BD
		
		Connection c = ConnexionBD.getConnection();
		// Définition et exécution de la requête de modification
		if (c != null) {
			try {
				c.setAutoCommit(false);
				PreparedStatement ps = c.prepareStatement("update patient set nom=?, prenom=?, sexe=? , addresse=? , datenaissance=? , tel=?, gs=?, poids=?, taille=? where code=?;");
				ps.setString(1, p.getNom() );
				ps.setString(2, p.getPrenom());				
				ps.setString(3, p.getSexe());
				ps.setString(4, p.getAdresse());
				ps.setDate(5,(Date) p.getDateNaissance() );
				ps.setString(6, p.getTel());	
				ps.setString(7, p.getgS());				
				ps.setInt(8, p.getPoids());
				ps.setInt(9, p.getTaille());
				ps.setInt(10, id);
				

				int res = ps.executeUpdate();
				if (res != 0) { // Activer le commit uniquement si la requête s'est exécuté sans problème
					c.commit();
					return p;
				}
			} catch (SQLException e) { e.printStackTrace();  }
			catch (Exception e) { e.printStackTrace();  }
		}
		return null;
	}
	public Patient Ajouter(Patient p) {
		// Connexion à la BD
		Connection c = ConnexionBD.getConnection();
		// Définition et exécution de la requête d'insertion
		if (c != null) {
			try {
				c.setAutoCommit(false);
				PreparedStatement ps = c.prepareStatement("insert into patient(nom,prenom,sexe,addresse,datenaissance,tel,gs,poids,taille) values (?,?,?,?,?,?,?,?,?);");
				ps.setString(1, p.getNom() );
				ps.setString(2, p.getPrenom());				
				ps.setString(3, p.getSexe());
				ps.setString(4, p.getAdresse());
				ps.setDate(5,(Date) p.getDateNaissance() );
				ps.setString(6, p.getTel());	
				ps.setString(7, p.getgS());				
				ps.setInt(8, p.getPoids());
				ps.setInt(9, p.getTaille());
				int res = ps.executeUpdate();
				if (res != 0) { // Activer le commit uniquement si la requête s'est exécuté sans problème
					c.commit();
					return p;
				}
			} catch (SQLException e) { e.printStackTrace();  }
			catch (Exception e) { e.printStackTrace();  }
		}
		return null;
	}

	 public static void fillToJtable(int id,JTable table) throws ClassNotFoundException{
			Connection c = ConnexionBD.getConnection();
			if (c != null) {
				try {
				c.setAutoCommit(false);
	            int nbr=table.getColumnCount();
	           
	            ResultSet rs;
	            String strselect;
	            strselect="select * from patient where code=?;";
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
	            	JOptionPane.showMessageDialog(null,"JTable Culomns Count Not Equal To Query Columns Count\nJTable Culomns :"+table.getColumnCount()+"\nQuery Columns :"+cn);
	            }
	        }
	        catch(SQLException ex)
	        {
	        	JOptionPane.showMessageDialog(null,ex.getMessage());
	        }
	    }
	
	 }
	public static void fillToJtablenom(String id, JTable table)throws ClassNotFoundException {
		Connection c = ConnexionBD.getConnection();
		if (c != null) {
			try {
				c.setAutoCommit(false);
	            int nbr=table.getColumnCount();
	           
	            ResultSet rs;
	            String strselect;
	            strselect="select * from patient where nom=?;";
	            PreparedStatement ps = c.prepareStatement(strselect);	
	            // or nom=? or prenom=?
				ps.setString(1, id);
				
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
	            	JOptionPane.showMessageDialog(null,"JTable Culomns Count Not Equal To Query Columns Count\nJTable Culomns :"+table.getColumnCount()+"\nQuery Columns :"+cn);
	            }
			}
	        catch(SQLException ex)
	        {
	        	JOptionPane.showMessageDialog(null,ex.getMessage());
	        }
		}
	}
	public Patient supprimer   (Patient p,int id) {
        // Connexion à la BD
        Connection c = ConnexionBD.getConnection();
        // Définition et exécution de la requête 
        if (c != null) {
            try {
                c.setAutoCommit(false);
                PreparedStatement ps = c.prepareStatement("delete from  patient where code = ? ;");
                ps.setLong(1, id );

                int res = ps.executeUpdate();
                if (res != 0) { // Activer le commit uniquement si la requête s'est exécuté sans problème
                    c.commit();
                    return p;
                }

            } catch (SQLException e) { e.printStackTrace();  }
            catch (Exception e) { e.printStackTrace();  }
        }
        return null;
    }
	public static void fillToJtableprenom(String id, JTable table)throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection c = ConnexionBD.getConnection();
		if (c != null) {
			try {
			c.setAutoCommit(false);
            int nbr=table.getColumnCount();
           
            ResultSet rs;
            String strselect;
            strselect="select * from patient where prenom = ?;";
            PreparedStatement ps = c.prepareStatement(strselect);	
			ps.setString(1, id);
			
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
            	JOptionPane.showMessageDialog(null,"JTable Culomns Count Not Equal To Query Columns Count\nJTable Culomns :"+table.getColumnCount()+"\nQuery Columns :"+cn);
            }
        }
        catch(SQLException ex)
        {
        	JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
	}	
	
	public static void fillToJtablenomprenom(String nom,String prenom, JTable table)throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection c = ConnexionBD.getConnection();
		if (c != null) {
			try {
			c.setAutoCommit(false);
            int nbr=table.getColumnCount();
           
            ResultSet rs;
            String strselect;
            strselect="select * from patient where nom=? and prenom=?;";
            PreparedStatement ps = c.prepareStatement(strselect);	
			ps.setString(1, nom);
			ps.setString(2, prenom);

			
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
            	JOptionPane.showMessageDialog(null,"JTable Culomns Count Not Equal To Query Columns Count\nJTable Culomns :"+table.getColumnCount()+"\nQuery Columns :"+cn);
            }
        }
        catch(SQLException ex)
        {
        	JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
	}	
}


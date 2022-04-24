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

import OO.Consultation;

public class ConsultationDAO {
	
	public Consultation Modifier(Consultation co,String rq) {
		// Connexion à la BD
		
		Connection c = ConnexionBD.getConnection();
		// Définition et exécution de la requête de modification
		if (c != null) {
			try {
				c.setAutoCommit(false);
				PreparedStatement ps = c.prepareStatement("update consultation set date=?, remarque=?, type=? where remarque=?;");
				ps.setDate(1,(Date) co.getDate() );
				ps.setString(4, rq);				
				ps.setString(2, co.getRemarques());
				ps.setString(3, co.getType());

				int res = ps.executeUpdate();
				if (res != 0) { // Activer le commit uniquement si la requête s'est exécuté sans problème
					c.commit();
					return co;
				}
			} catch (SQLException e) { e.printStackTrace();  }
			catch (Exception e) { e.printStackTrace();  }
		}
		return null;
	}
	
	public Consultation Ajouter(Consultation co) {
		// Connexion à la BD
		Connection c = ConnexionBD.getConnection();
		// Définition et exécution de la requête d'insertion
		if (c != null) {
			try {
				c.setAutoCommit(false);
				PreparedStatement ps = c.prepareStatement("insert into consultation(date,remarque,pcode,type) values (?,?,?,?);");
				ps.setDate(1,(Date) co.getDate() );
				ps.setString(4, co.getType());
				ps.setString(2, co.getRemarques());
				ps.setInt(3, co.getPcode());				
				int res = ps.executeUpdate();
				if (res != 0) { // Activer le commit uniquement si la requête s'est exécuté sans problème
					c.commit();
					return co;
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
	            strselect="select code,date,type,remarque from consultation where pcode=?;";
	            
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

	 public static void fillToJtablenom(String id, JTable table)throws ClassNotFoundException {
			Connection c = ConnexionBD.getConnection();
			if (c != null) {
				try {
					c.setAutoCommit(false);
		            int nbr=table.getColumnCount();
		           
		            ResultSet rs;
		            String strselect;
		            strselect="select c.code,c.date,c.type,c.remarque from consultation c, patient p where p.code=c.pcode and p.nom=?;";
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
		public static void fillToJtableprenom(String id, JTable table)throws ClassNotFoundException {
			// TODO Auto-generated method stub
			Connection c = ConnexionBD.getConnection();
			if (c != null) {
				try {
					c.setAutoCommit(false);
		            int nbr=table.getColumnCount();
		           
		            ResultSet rs;
		            String strselect;
		            strselect="select c.code,c.date,c.type,c.remarque from consultation c, patient p where p.code=c.pcode and p.prenom=?;";
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
				Connection c = ConnexionBD.getConnection();
				if (c != null) {
					try {
						c.setAutoCommit(false);
			            int nbr=table.getColumnCount();
			           
			            ResultSet rs;
			            String strselect;
			            strselect="select c.code,c.date,c.type,c.remarque from consultation c, patient p where p.code=c.pcode and p.nom=? and p.prenom=?;";
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

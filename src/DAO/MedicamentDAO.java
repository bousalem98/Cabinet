package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MedicamentDAO {

	
	 public static ArrayList fillToListe(JList liste) throws ClassNotFoundException{
		 	ArrayList lesElements = new ArrayList();
			Connection c = ConnexionBD.getConnection();
			if (c != null) {
				try {
				c.setAutoCommit(false);
	            ResultSet rs;
	            String strselect,s;
	            strselect="select id,denomination_commune_internationale from medicament;";
	            
	            PreparedStatement ps = c.prepareStatement(strselect);		
				ResultSet res = ps.executeQuery();
	            ResultSetMetaData rsmd=res.getMetaData();
                DefaultListModel dlm=new DefaultListModel();

	            while(res.next())
	            {
	            	s="";
	            	s=s+res.getInt("id")+" - ";
	            	s=s+res.getString("denomination_commune_internationale").toLowerCase();
                    dlm.addElement(s);
                    lesElements.add(s);

	            }
	            liste.setModel(dlm);
	            return lesElements;

	        }
	        catch(SQLException ex)
	        {
	        	JOptionPane.showMessageDialog(null,ex.getMessage());
	        }
	    }
            return lesElements;

	
	 }
	 public static void fillJtablemedchoisi(int id,JTable table)throws ClassNotFoundException {
			// TODO Auto-generated method stub
			Connection c = ConnexionBD.getConnection();
				if (c != null) {
					try {
					c.setAutoCommit(false);
		            int nbr=table.getColumnCount();
		            //System.out.println(nbr);
		            ResultSet rs;
		            String strselect;
		            strselect="select denomination_commune_internationale,nom_de_marque,forme,dosage from medicament where id=?;";
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
		                    row.add(res.getString(i).toLowerCase());
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

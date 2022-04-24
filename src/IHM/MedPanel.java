package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import DAO.ConsultationDAO;
import DAO.MedicamentDAO;
import DAO.OrdonanceDAO;
import DAO.PatientDAO;
import OO.Consultation;
import OO.Ordonance;

public class MedPanel extends JPanel implements ActionListener,MouseListener,KeyListener {

	
	private JPanel pannelcenter;

	private JPanel p1;
	private JLabel lblnbmed;
	private JLabel lblnbboite;
	private JButton btnajout;
	private JScrollPane sc1;
	private JPanel p2;

	private JPanel p;
	
	private JTable medTab;
	private JLabel backlbl;
	private JTextField txtnommed;
	private JTextField txtnbboite;
	private JTextField txtnbmed;
	private JLabel lblrech;
	private JTextField txtrech;
	private JLabel lblPharnacie;
	private JList liste1;
	private JScrollPane scrollpane;
	private JLabel lblmedchoix;
	private ArrayList lesElements = new ArrayList();
	private static String Medicamentchoisi=null;

	
	private JButton btnmemorise;

	private String s;

	private JLabel jLabel1;

	private JPanel jpanel1;

	private JTable medchoixTab;

	private JScrollPane sc;
	private JLabel lblmedordo;

	/**
	 * Create the panel.
	 */
	public MedPanel() {
		this.setLayout(new BorderLayout());
		jpanel1 = new JPanel();
		jpanel1.setBackground(new Color(255, 255, 255));
		jLabel1 = new JLabel();
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/med.png"))); // NOI18N
        backlbl=new JLabel();
		backlbl.setIcon(new ImageIcon(getClass().getResource("/Img/icons8-back-arrow-32.png")));
		backlbl.addMouseListener(this);
		jpanel1.add(backlbl);
        jpanel1.add(jLabel1);

		//jpanel1.add(backlbl,FlowLayout.LEFT);
        this.add(jpanel1,BorderLayout.NORTH);
        
        
		pannelcenter = new JPanel();
		pannelcenter.setLayout(new FlowLayout());
		pannelcenter.setBackground(new Color(255, 255, 255));

		
		p=new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setBackground(new Color(255, 255, 255));
		lblrech = new JLabel();
		lblrech.setText("Recherche Rapide");
		txtrech = new JTextField(10);
		txtrech.setBorder(BorderFactory.createLineBorder(Color.black));
		txtrech.addKeyListener(this);
		p.add(lblrech);
		p.add(txtrech);
		lblPharnacie = new JLabel();
		lblPharnacie.setText("Pharnacie");
		liste1=new JList();
		liste1.setSelectionMode (ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		liste1.setSelectionBackground(Color.gray);
		liste1.setBorder(BorderFactory.createLineBorder(Color.black));
		
		scrollpane=new JScrollPane(liste1);
		MedicamentDAO mDAO=new MedicamentDAO();
		try {
			lesElements=MedicamentDAO.fillToListe(liste1);

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		liste1.addMouseListener(this);
		scrollpane.setPreferredSize(new Dimension(400,100));
		p.add(lblPharnacie);
		p.add(scrollpane);
		lblmedchoix = new JLabel();
		lblmedchoix.setText("Medicament Choisi Info");
	
		
		p.add(lblmedchoix);
		medchoixTab=new JTable();
		medchoixTab.setBackground(new Color(255, 255, 255));
		medchoixTab.setBorder(BorderFactory.createLineBorder(Color.black));
		medchoixTab.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		               // {null, null, null}
		                
		            },
		            new String [] {
		            	"Nom", "Marque", "Forme","Dosage"
		            }
				));
		sc=new JScrollPane(medchoixTab);
		sc.setPreferredSize(new Dimension(800,50));
		p.add(sc);
		lblmedordo = new JLabel();
		lblmedordo.setText("Ordonance");
		p.add(lblmedordo);
	    p1=new JPanel();
	    p1.setBackground(new Color(255, 255, 255));
	    lblnbmed = new JLabel();
	    lblnbmed.setText("Nb prise");
	    txtnbmed = new JTextField(5);
	    txtnbmed.setBorder(BorderFactory.createLineBorder(Color.black));

	    p1.add(lblnbmed);
	    p1.add(txtnbmed);
		medTab=new JTable();
	    medTab.setBackground(new Color(255, 255, 255));
	    medTab.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    medTab.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	               // {null, null, null}
	                
	            },
	            new String [] {
	            	"Nom medicament", "Nombre de prise", "Nombre de boite"
	            }
	    ));
	    sc1=new JScrollPane(medTab);
	    sc1.setPreferredSize(new Dimension(800,180));

	    p1.add(sc1);
	    lblnbboite = new JLabel();
	    lblnbboite.setText("Nb boite");
	    txtnbboite = new JTextField(5);
	    txtnbboite.setBorder(BorderFactory.createLineBorder(Color.black));

	    p1.add(lblnbboite);
	    p1.add(txtnbboite);
	    p.add(p1);
	    p2=new JPanel();
	    p2.setBackground(new Color(255, 255, 255));
	    p2.setLayout(new FlowLayout());
	    btnajout = new JButton();
	    btnajout.setText("Ajouter");
	    btnajout.addActionListener(this);
	    btnmemorise = new JButton();
	    btnmemorise.setText("Ordonance mémorisée");
	    btnmemorise.addActionListener(this);
	    
	    p2.add(btnajout);
	    p2.add(btnmemorise);
	    
	    
	    p.add(p2);
		pannelcenter.add(p);
        this.add(pannelcenter);
        

        

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == btnajout) {
			try {
			String nbprise= txtnbmed.getText().toString();
			String nbboite= txtnbboite.getText().toString();
			int code =Integer.parseInt(ConsulPanel.getconsultCode());
			
			Ordonance md = new Ordonance(Medicamentchoisi,Integer.parseInt(nbprise),Integer.parseInt(nbboite),code);
			//Utiliser la classe DAO pour ajouter c dans la BD
			OrdonanceDAO mDAO = new OrdonanceDAO();
			Ordonance majouter = mDAO.Ajouter(md);
			System.out.println(majouter);
			// Vérifier si l'ajout a bien été effectué ou non
			if (majouter != null) {
	            mDAO.fillToTable(code, medTab);
				JOptionPane.showMessageDialog(null, "Medicament ajouter avec succès");
				txtnbboite.setText("");
				viderJtable(medchoixTab);
				txtnbmed.setText("");
				txtrech.setText("");
				try {
					lesElements=MedicamentDAO.fillToListe(liste1);

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//txtnommed.setText("");
			}
			
			else
				JOptionPane.showMessageDialog(null, "Problème d'ajout du medicament");
			}
			catch(Exception ex) { //ex.printStackTrace();
				System.out.println(ex);
				JOptionPane.showMessageDialog(null, "Veuillez vérifier les données du medicament");
			}
		}
		if(source == btnmemorise) {
			int code = Integer.parseInt(ConsulPanel.getconsultCode());

			OrdonanceDAO mDAO = new OrdonanceDAO();
			try {
            mDAO.fillToTable(code, medTab);
			}
			catch(Exception ex) { //ex.printStackTrace();
	           JOptionPane.showMessageDialog(null, "Veuillez vérifier les données du medicament");
				
			}
		}
		
	}

	 public void viderJtable(JTable table) {
	 DefaultTableModel model=(DefaultTableModel)table.getModel();
     for(int i = model.getRowCount(); i > 0; --i)
    	 model.removeRow(i-1);
     }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == backlbl) 
		{
		txtnbboite.setText("");
		txtnbmed.setText("");
		txtrech.setText("");
		try {
			lesElements=MedicamentDAO.fillToListe(liste1);

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		viderJtable(medTab);
		viderJtable(medchoixTab);
		MainFrame.openNextTab(1);
		}
		if (source == liste1) {
			int i= liste1.getSelectedIndex();
			try {
				deplece_info(i);
				
			} catch (Exception e1) {
		
			}
		}
		
	}

	private void deplece_info(int i) {
		// TODO Auto-generated method stub
		String med = liste1.getModel().getElementAt(i).toString();
		int nbindex=med.indexOf("-");
		String s=med.substring(0, nbindex-1);
		Medicamentchoisi = med.substring(nbindex+2, med.length()-1).toLowerCase();
		int nb=Integer.parseInt(s);
		
		MedicamentDAO pDAO = new MedicamentDAO();
		try {
			pDAO.fillJtablemedchoisi(nb,medchoixTab);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		DefaultListModel model = new DefaultListModel();//creation dun nouveau model pour une JList
		String enteredText = txtrech.getText();	//On recupere le texte entree dans le JtextField					
		for (int i = 0; i< lesElements.size();i++) {
			//Comparaison des elements contenu dans l ArrayList et du texte entree 
			if (lesElements.get(i).toString().indexOf(enteredText) != -1) {
				model.addElement(lesElements.get(i).toString());//ajout de lelement dans le nouveau model
			}
		}					
		getJList0().setModel(model);//On definie ce nouveau model pour la JList
		
	}
	private JList getJList0() {
		if (liste1 == null) {
			liste1 = new JList();
			DefaultListModel listModel = new DefaultListModel();
			try {
				lesElements=MedicamentDAO.fillToListe(liste1);

			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//Ajouts des Elements de l'arrayList dans la JList
		}
		return liste1;
	}
}

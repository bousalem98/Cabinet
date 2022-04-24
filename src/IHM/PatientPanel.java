package IHM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import DAO.PatientDAO;
import OO.Patient;

public class PatientPanel extends JPanel implements ActionListener,MouseListener {

	private static Patient patient;
	private JPanel jpanel1;
	private JLabel jLabel1;
	private JPanel pannelcenter;
	private JPanel pannelbigcenter;
	private JPanel pannelNorth;
	private JTextField txtprenom;
	private JTextField txtnom;
	private JPanel pannelright;
	private JTable patientTab;
	private JPanel pannelcentern;
	private JScrollPane sc1;
	private JPanel pannelbigsouth;
	private JButton butmodif;
	private JButton btnsupp;
	private JButton buttajout;
	private JPanel pnsouth;
	private JLabel lblnom;
	private JLabel lblprenom;
	private JLabel lblcode;
	private JTextField txtcode;
	private JComboBox ComboSexe;
	private JLabel lbladdress;
	private JTextField txtadress;
	private JLabel lbldate;
	private JDateChooser calender;
	private JTextField txtage;
	private JLabel lblage;
	private JLabel lblgrpsang;
	private JComboBox Combogrpsang;
	private JLabel lbltaille;
	private JTextField txttaille;
	private JLabel lblpoids;
	private JTextField txtpoids;
	private JButton btnconsultation;
	private JPanel p;
	private JPanel pane;
	private JButton butnrech;
	private String user;
	private JLabel lbltel;
	private JTextField txttel;
	private JButton butNvPatient;
	private JTextField txtnomrech;
	private JTextField txtprenomrech;

	/**
	 * Create the panel.
	 */
	public PatientPanel() {
		user = ConnFrame.getUserType();
		this.setLayout(new BorderLayout());
		jpanel1 = new JPanel();
		jpanel1.setBackground(new Color(255, 255, 255));
		jLabel1 = new JLabel();
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/Img/patient.png"))); // NOI18N
        jpanel1.add(jLabel1);
        this.add(jpanel1,BorderLayout.NORTH);
		
        pannelbigcenter = new JPanel(new BorderLayout());
        pannelbigcenter.setBackground(new Color(255, 255, 255));
        
        pannelNorth= new JPanel(new BorderLayout());
	    pane= new JPanel();
	   // pane.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
	    pane.setBorder(BorderFactory.createLineBorder(Color.black));
	    pane.setBackground(new Color(255, 255, 255));

	    p = new JPanel();
	    p.setBackground(new Color(255, 255, 255));
	    
	    p.setLayout(new FlowLayout());
	    txtnomrech = new JTextField (10);
	    txtnomrech.setBorder(BorderFactory.createLineBorder(Color.black));
    	JLabel labelnom = new JLabel ("Nom ");
    	
    	txtprenomrech = new JTextField (10);
    	txtprenomrech.setBorder(BorderFactory.createLineBorder(Color.black));
    	JLabel labelprenom = new JLabel ("Prenom ");
    	p.add(labelprenom);
    	p.add(txtprenomrech);
    	p.add(labelnom);
    	p.add(txtnomrech);
    	pane.add(p);
    	butnrech = new JButton("rechercher");
    	butnrech.setFocusPainted(false);
    	butnrech.addActionListener(this);
    	pane.add(butnrech);
    	butNvPatient = new JButton("    Nouvelle Patient    ");
 	    //butNvConsult.setBackground(SystemColor.control);
    	butNvPatient.addActionListener(this);
    	pane.add(butNvPatient);
    	pannelNorth.add(pane);
        pannelbigcenter.add(pannelNorth,BorderLayout.NORTH);
    	
    	pannelcenter = new JPanel();
    	pannelcenter.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(0, 153, 204), new Color(0, 153, 204)), "Listes des Patients", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new Font("Garamond", 1, 16), new Color(51, 102, 255))); // NOI18N
    	patientTab = new JTable();
	    patientTab.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	               // {null, null, null}
	                
	            },
	            new String [] {
	            		"Code", "Nom", "prenom","Sexe","Adresse", "DateNaissance","Telephone","Groupe sanguin",
	        			 "Poids","Taille"
	        			 }
	        ));
	    patientTab.addMouseListener(this);

	    patientTab.setPreferredScrollableViewportSize(new Dimension(400, 270));
	    patientTab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    pannelcentern=new JPanel();
	    
	    sc1=new JScrollPane(patientTab);
	    pannelcentern.add(sc1,BorderLayout.CENTER);
	    pannelcentern.setBackground(new Color(255, 255, 255));
	    pannelcenter.setBackground(new Color(255, 255, 255));
	    
	    pannelcenter.add(pannelcentern,BorderLayout.CENTER);
	    

    	pannelbigcenter.add(pannelcenter,BorderLayout.WEST);
    	
    	pannelright = new JPanel();
    	pannelright.setBackground(new Color(255, 255, 255));
		pannelright.setLayout(new GridLayout(11,2,1,1));

    	
    	lblcode = new JLabel ("Code");
    	pannelright.add(lblcode);
		txtcode = new JTextField (10);
		txtcode.setEditable(false);

		txtcode.setBorder(BorderFactory.createLineBorder(Color.black));
		pannelright.add(txtcode);

    	
    	lblnom = new JLabel ("Nom");
		txtnom = new JTextField (10);
		txtnom.setBorder(BorderFactory.createLineBorder(Color.black));
		lblprenom = new JLabel ("Prenom");
		txtprenom = new JTextField (10);
		txtprenom.setBorder(BorderFactory.createLineBorder(Color.black));
		pannelright.add(lblprenom);
		pannelright.add(txtprenom);
		pannelright.add(lblnom);
		pannelright.add(txtnom);
		
    	lblnom = new JLabel ("Sexe");
    	pannelright.add(lblnom);
    	String[] sexe ={"Homme","Femme"};
		ComboSexe = new JComboBox();
		ComboSexe.setBackground(new Color(255, 255, 255));
		ComboSexe.setBorder(BorderFactory.createLineBorder(Color.black));
		ComboSexe.addItem(sexe[0]);
		ComboSexe.addItem(sexe[1]);
		pannelright.add(ComboSexe);
		lbladdress = new JLabel ("Adresse");
		pannelright.add(lbladdress);
		txtadress = new JTextField (10);
		txtadress.setBorder(BorderFactory.createLineBorder(Color.black));
		pannelright.add(txtadress);
		
		
		lbldate = new JLabel("Date de Naissance");
		pannelright.add(lbldate);
		calender = new JDateChooser();
		calender.setDateFormatString("dd-MM-yyyy");
		calender.setBorder(BorderFactory.createLineBorder(Color.black));
		calender.setPreferredSize(new Dimension(100, 20));
		pannelright.add(calender);
		lblage = new JLabel ("Age");
		pannelright.add(lblage);
		txtage = new JTextField (5);
		//txtage.addActionListener(this);
		txtage.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				java.util.Date utilDate = calender.getDate();
				java.sql.Date datenaissace = new java.sql.Date(utilDate.getTime());
				txtage.setText(String.valueOf(getAge(datenaissace)));
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
		txtage.setBorder(BorderFactory.createLineBorder(Color.black));
		pannelright.add(txtage);
		
		lbltel = new JLabel ("Telephone");
		txttel = new JTextField (5);
		txttel.setBorder(BorderFactory.createLineBorder(Color.black));
		pannelright.add(lbltel);
		pannelright.add(txttel);
		
		lblgrpsang = new JLabel("Groupe sanguin");
		pannelright.add(lblgrpsang);
		String[] etat ={"A","B","O","AB"};
		Combogrpsang=new JComboBox();
		Combogrpsang.setBackground(new Color(255, 255, 255));
		Combogrpsang.setBorder(BorderFactory.createLineBorder(Color.black));
		Combogrpsang.addItem(etat[0]);
		Combogrpsang.addItem(etat[1]);
		Combogrpsang.addItem(etat[2]);
		Combogrpsang.addItem(etat[3]);
		pannelright.add(Combogrpsang);
		
		lbltaille = new JLabel ("Taille");
		txttaille = new JTextField (5);
		txttaille.setBorder(BorderFactory.createLineBorder(Color.black));
		lblpoids = new JLabel ("Poids");
		txtpoids = new JTextField (5);
		txtpoids.setBorder(BorderFactory.createLineBorder(Color.black));
		pannelright.add(lbltaille);
		pannelright.add(txttaille);
		pannelright.add(lblpoids);
		pannelright.add(txtpoids);
		
    	pannelright.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(0, 153, 204), new Color(0, 153, 204)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new Font("Garamond", 1, 16), new Color(51, 102, 255))); // NOI18N
    	pannelbigcenter.add(pannelright,BorderLayout.CENTER);

    	pannelbigsouth = new JPanel();
	    pannelbigsouth.setBorder(BorderFactory.createLineBorder(Color.black));
		butmodif= new JButton();
        butmodif.setFont(new Font("Georgia", 0, 18)); // NOI18N
        butmodif.setIcon(new ImageIcon(getClass().getResource("/Img/user_male_edit_1.png"))); // NOI18N
        butmodif.setText("Modifier");
        butmodif.addActionListener(this);
        
        btnsupp= new JButton();
        btnsupp.setFont(new Font("Georgia", 0, 18)); // NOI18N
        btnsupp.setIcon(new ImageIcon(getClass().getResource("/Img/if_Remove_27874.png"))); // NOI18N
        btnsupp.setText("Supprimer");
        btnsupp.addActionListener(this);

        buttajout= new JButton();
        buttajout.setFont(new Font("Georgia", 0, 18)); // NOI18N
        buttajout.setIcon(new ImageIcon(getClass().getResource("/Img/ok.png"))); // NOI18N
        buttajout.setText("Ajouter");
        buttajout.addActionListener(this);
        
        btnconsultation= new JButton();
        btnconsultation.setFont(new Font("Georgia", 0, 18)); // NOI18N
        btnconsultation.setIcon(new ImageIcon(getClass().getResource("/Img/stock.png"))); // NOI18N
        btnconsultation.setText("Consultation");
        btnconsultation.addActionListener(this);

        GroupLayout jPanel4Layout = new GroupLayout(pannelbigsouth);
        pannelbigsouth.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttajout, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(butmodif, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnsupp, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnconsultation, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttajout, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(butmodif, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnsupp, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnconsultation, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
            );
        pnsouth = new JPanel();
        pnsouth.setBackground(new Color(255, 255, 255));
        pannelbigsouth.setBackground(new Color(255, 255, 255));

        pnsouth.setLayout(new FlowLayout());
        pnsouth.add(pannelbigsouth);
        
        pannelbigcenter.add(pnsouth,BorderLayout.SOUTH);
    	
        this.add(pannelbigcenter,BorderLayout.CENTER);
        
		btnsupp.setEnabled(false);
		btnconsultation.setEnabled(false);
		butmodif.setEnabled(false);


        


	        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		// Gestion de l'event selon son déclencheur
		if (source == buttajout) {
			try {				
				//int code = Integer.parseInt(txtcode.getText().toString());
				String nom = txtnom.getText().toString();
				String prenom = txtprenom.getText().toString();
				String sexe = ComboSexe.getSelectedItem().toString(); 
				String adresse = txtadress.getText().toString();
				String tel = txttel.getText().toString();
				String gS = Combogrpsang.getSelectedItem().toString(); 
				int poids = Integer.parseInt(txtpoids.getText().toString());
				int taille = Integer.parseInt(txttaille.getText().toString());
				java.util.Date utilDate = calender.getDate();
				java.sql.Date datenaissace = new java.sql.Date(utilDate.getTime());
				
				Patient p = new Patient(nom,prenom,sexe,adresse,datenaissace,tel,gS,poids,taille);
				//Utiliser la classe DAO pour ajouter c dans la BD
				PatientDAO pDAO = new PatientDAO();
				Patient pajouter = pDAO.Ajouter(p);
				//System.out.println(pajouter);
				// Vérifier si l'ajout a bien été effectué ou non
				if (pajouter != null) {
					pDAO.fillToJtablenomprenom(nom, prenom, patientTab);
					JOptionPane.showMessageDialog(null, "Patient ajouter avec succès"+pajouter.getCode());
					
				}
				
				else
					JOptionPane.showMessageDialog(null, "Problème d'ajout du Patient");
			}
			catch(Exception ex) { //ex.printStackTrace();
	           //JOptionPane.showMessageDialog(null, "Veuillez vérifier les données du Patient");
				System.out.println(ex);
			}
		}
		
		if (source == btnsupp) {
			  try {
		            int code = Integer.parseInt(txtcode.getText().toString());

		            Patient p = new Patient();
		            p.setCode(code);
		            PatientDAO pDAO = new PatientDAO();
		            Patient psupp = pDAO.supprimer(p, code);
		            if (psupp != null) {

						pDAO.fillToJtable(code,patientTab);

		                btnsupp.setEnabled(false);

		                calender.setDate(null);
		                txtnom.setText("");
		                txtprenom.setText("");
		                txtadress.setText("");
		                txttel.setText("");
		                txtpoids.setText("");
		                txttaille.setText("");
		                txtcode.setText("");
		                txtage.setText("");
		                JOptionPane.showMessageDialog(null, "Patient supprimé avec succès"+psupp.getCode());

		            }

		            else
		                JOptionPane.showMessageDialog(null, "Problème de supprimer  du Patient");
		        }
		        catch(Exception ex) { //ex.printStackTrace();
		           //JOptionPane.showMessageDialog(null, "Veuillez vérifier les données du Patient");
		            System.out.println(ex);
		        }
		}
		if (source == butmodif) {
			try {				
				int code = Integer.parseInt(txtcode.getText().toString());
				String nom = txtnom.getText().toString();
				String prenom = txtprenom.getText().toString();
				String sexe = ComboSexe.getSelectedItem().toString(); 
				String adresse = txtadress.getText().toString();
				String tel = txttel.getText().toString();
				String gS = Combogrpsang.getSelectedItem().toString(); 
				int poids = Integer.parseInt(txtpoids.getText().toString());
				int taille = Integer.parseInt(txttaille.getText().toString());
				java.util.Date utilDate = calender.getDate();
				java.sql.Date datenaissace = new java.sql.Date(utilDate.getTime());
				
				Patient p = new Patient(nom,prenom,sexe,adresse,datenaissace,tel,gS,poids,taille);
				//Utiliser la classe DAO pour ajouter c dans la BD
				PatientDAO pDAO = new PatientDAO();
				Patient pModifie = pDAO.Modifier(p,code);
				// Vérifier si l'ajout a bien été effectué ou non
				if (pModifie != null) {
					pDAO.fillToJtable(code,patientTab);
					JOptionPane.showMessageDialog(null, "patient modifié avec succès");
					butmodif.setEnabled(false);
					calender.setDate(null);
					txtnom.setText("");
					txtprenom.setText("");
					txtadress.setText("");
					txttel.setText("");
					txtpoids.setText("");
					txttaille.setText("");
					txtcode.setText("");
	
				}
				
				else
					JOptionPane.showMessageDialog(null, "Problème de modification du patient");
			}
			catch(Exception ex) { //ex.printStackTrace();
	           JOptionPane.showMessageDialog(null, "Veuillez vérifier les données du patient à modifier!");
			
			}
		}
	
		if (source == butnrech) {
			String nom = txtnomrech.getText().toString();
			String prenom = txtprenomrech.getText().toString();
			PatientDAO pDAO = new PatientDAO();

			if (!nom.equals("") && !prenom.equals("")) {
				try {
					pDAO.fillToJtablenomprenom(nom,prenom,patientTab);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (!nom.equals("")) {
				try {
					pDAO.fillToJtablenom(nom,patientTab);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				try {
					pDAO.fillToJtableprenom(prenom,patientTab);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
		
		}
		
		if (source == btnconsultation) {
	        ConsulPanel.setcodeField(String.valueOf(getpatient().getCode()));
	        ConsulPanel.setnomField(getpatient().getNom());
	        ConsulPanel.setprenomField(getpatient().getPrenom());
	        ConsulPanel.setageField(getpatient().getAge());
	        String sexe = "Mr";
	        if (getpatient().getSexe()=="Homme")
	        	sexe="Mr";
		    if (getpatient().getSexe()=="Femme")
		    	sexe="Mme";
	        ConsulPanel.setComboSexe(sexe);

	        
			MainFrame.openNextTab(1);


	        
		}
		if (source == butNvPatient) {
		butmodif.setEnabled(false);
		btnsupp.setEnabled(false);
		btnconsultation.setEnabled(false);
		buttajout.setEnabled(true);
		txtage.setText("");
		calender.setDate(null);
		txtnom.setText("");
		txtprenom.setText("");
		txtadress.setText("");
		txttel.setText("");
		txtpoids.setText("");
		txttaille.setText("");
		txtcode.setText("");
		txtnomrech.setText("");
		txtprenomrech.setText("");

		}
		

			
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		// Gestion de l'event selon son déclencheur
		if (source == patientTab) {
			int i= patientTab.getSelectedRow();
			if (user.equals("medecin")) {
				btnsupp.setEnabled(true);
			}
			btnconsultation.setEnabled(true);
			butmodif.setEnabled(true);
			buttajout.setEnabled(false);
			try {
				deplece_info(i);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

	private void deplece_info(int i) throws ParseException {
		// TODO Auto-generated method stub
        txtcode.setText(patientTab.getValueAt(i, 0).toString());

        String strDate = patientTab.getValueAt(i, 5).toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new  java.util.Date(sdf.parse(strDate).getTime());
		butmodif.setEnabled(true);
		buttajout.setEnabled(false);
		calender.setDate(date);
        txtnom.setText(patientTab.getValueAt(i, 1).toString());
        txtprenom.setText(patientTab.getValueAt(i, 2).toString());
		ComboSexe.getModel().setSelectedItem(patientTab.getValueAt(i, 3).toString());
        txtadress.setText(patientTab.getValueAt(i, 4).toString());
        txttel.setText(patientTab.getValueAt(i, 6).toString());
        txtpoids.setText(patientTab.getValueAt(i, 8).toString());
        txttaille.setText(patientTab.getValueAt(i, 9).toString());
        
        String age=String.valueOf(getAge(date));
        Patient p =new Patient(Integer.parseInt(patientTab.getValueAt(i, 0).toString()),patientTab.getValueAt(i, 1).toString(),patientTab.getValueAt(i, 2).toString(),patientTab.getValueAt(i, 3).toString(),age);
        setpatient(p);




		Combogrpsang.getModel().setSelectedItem(patientTab.getValueAt(i, 7).toString());
       
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
	/*public static String getpatientCode() {
		return patientCode;
	}

	public void setpatientCode(String patientCode) {
		this.patientCode = patientCode;
	}*/
	
	
	public Integer getAge(Date dateNaissance) {
		Calendar maintenant = Calendar.getInstance();
        Calendar dateN = Calendar.getInstance();
		dateN.setTime(dateNaissance);
		int age = maintenant.get(Calendar.YEAR) - dateN.get(Calendar.YEAR);
		if ((dateN.get(Calendar.MONTH) > maintenant.get(Calendar.MONTH))
				|| (dateN.get(Calendar.MONTH) == maintenant.get(Calendar.MONTH)
						&& dateN.get(Calendar.DAY_OF_MONTH) > maintenant.get(Calendar.DAY_OF_MONTH))) {
			age--;
		}
		return age;
	}
	public static Patient getpatient() {
		return patient;
	}

	public void setpatient(Patient patient) {
		this.patient = patient;
	}
	
	
}
		
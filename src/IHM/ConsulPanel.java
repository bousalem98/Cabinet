package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import DAO.ConsultationDAO;
import OO.Consultation;

import java.awt.SystemColor;

public class ConsulPanel extends JPanel implements ActionListener,MouseListener{

	private JPanel panelNorth;
	private JPanel panelLeft;
	private JPanel panelCenter;
	private JLabel lbltitre;
	private JLabel lblprenom;
	private JLabel lblnom;
	private JLabel lblage;
	private JTable consultTab;
	private JLabel lblnum;
	private static JTextField txtnum,txtprenom,txtnom,txtage;
	private JComboBox ComboEtat;
	private JLabel lbletat;
	private JButton butNvConsult;
	private JScrollPane sc1;
	private JLabel lbldate;
	private JLabel lblhonoraires;
	private JButton butCnam;
	private JLabel lblclichet;
	private JTextField txtclichet;
	private JLabel lblt;
	private JComboBox ComboType;
	private static String consultCode;


	/**
	 * Create the panel.
	 */
	private JTextArea txtcon;
	private JLabel lblcon;
	private JButton butmodif;
	private JButton btnordonance;
	private JButton buttajout;
	private JDateChooser calender;
	private JComboBox ComboHonoraire;
	private JButton btnrech;
	private String rq,user;
	private JLabel backlbl;
	private static JComboBox ComboSexe;

	public ConsulPanel() {
		user = ConnFrame.getUserType();
		this.setLayout(new BorderLayout());
		
		panelNorth = new JPanel();
		//panelNorth.setBackground(new Color(255, 255, 255));
		this.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBorder(BorderFactory.createLineBorder(Color.black));
		backlbl=new JLabel();
		backlbl.setIcon(new ImageIcon(getClass().getResource("/Img/icons8-back-arrow-32.png")));
		backlbl.addMouseListener(this);
		panelNorth.add(backlbl,FlowLayout.LEFT);
		lblnum = new JLabel("N°");
		panelNorth.add(lblnum);
		txtnum = new JTextField(5);
		txtnum.setEditable(false);

		panelNorth.add(txtnum);
		
		lbltitre = new JLabel("Titre");
		panelNorth.add(lbltitre);
		String[] sexe ={"Mr","Mme"};
		ComboSexe = new JComboBox();
		ComboSexe.setBackground(new Color(255, 255, 255));
		ComboSexe.addItem(sexe[0]);
		ComboSexe.addItem(sexe[1]);
		ComboSexe.setEnabled(false);
		panelNorth.add(ComboSexe);
		
		lblprenom = new JLabel("Prenom");
		panelNorth.add(lblprenom);
		txtprenom = new JTextField(10);
		panelNorth.add(txtprenom);
		
		lblnom = new JLabel("Nom");
		panelNorth.add(lblnom);
		txtnom = new JTextField(10);
		panelNorth.add(txtnom);
		
		lblage = new JLabel("Age");
		panelNorth.add(lblage);
		txtage = new JTextField(5);
		txtage.setEditable(false);
		panelNorth.add(txtage);
		
		lbletat = new JLabel("Etat");
		panelNorth.add(lbletat);
		String[] etat ={"Normal","Autre"};
		ComboEtat=new JComboBox();
		ComboEtat.setBackground(new Color(255, 255, 255));
		ComboEtat.addItem(etat[0]);
		ComboEtat.addItem(etat[1]);
		panelNorth.add(ComboEtat);
		btnrech = new JButton("Rechercher");
		btnrech.addActionListener(this);
		panelNorth.add(btnrech);


		

		panelLeft= new JPanel();
		panelLeft.setLayout((LayoutManager) new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
		panelLeft.setPreferredSize(new Dimension(200, 480));
		consultTab = new JTable();
	    consultTab.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	               // {null, null, null}
	                
	            },
	            new String [] {
	            	"Code", "Date", "Titre", "Consultation"
	            }
	        ));
	    consultTab.addMouseListener(this);
	    panelLeft.setBorder(BorderFactory.createLineBorder(Color.black));
	    butNvConsult = new JButton("    Nouvelle Consultation    ");
	    //butNvConsult.setBackground(SystemColor.control);
	    butNvConsult.addActionListener(this);
	    panelLeft.add(butNvConsult);
	    panelLeft.add(consultTab); 
	    //consultTab.setPreferredScrollableViewportSize(new Dimension(400, 270));
	    consultTab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    sc1=new JScrollPane(consultTab);
	    panelLeft.add(sc1);
		this.add(panelLeft, BorderLayout.WEST);

	    

		panelCenter = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelCenter.getLayout();
		flowLayout.setVgap(2);
		
		//panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));

		JPanel p1= new JPanel();
		p1.setLayout(new FlowLayout());
		lbldate = new JLabel("Date : ");
		p1.add(lbldate);
		calender = new JDateChooser();
		calender.setDateFormatString("dd-MM-yyyy");
		calender.setPreferredSize(new Dimension(100, 20));
		p1.add(calender);
		lblhonoraires = new JLabel("Honoraires : ");
		p1.add(lblhonoraires);
		String[] price ={"60.00","50.00"};
		ComboHonoraire = new JComboBox();
		ComboHonoraire.setBackground(new Color(255, 255, 255));
		ComboHonoraire.addItem(price[0]);
		ComboHonoraire.addItem(price[1]);
		p1.add(ComboHonoraire);
		butCnam = new JButton("Cnam");
		butCnam.setBackground(SystemColor.control);
		p1.add(butCnam);
		lblclichet = new JLabel("Cliché : ");
		p1.add(lblclichet);
		txtclichet = new JTextField(10);
		p1.add(txtclichet);
		panelCenter.add(p1);

		JPanel p2= new JPanel();
		p2.setLayout(new FlowLayout());
		lblt = new JLabel("Titre : ");
		p2.add(lblt);
		String[] type ={"Controle","Consultation"};
		ComboType=new JComboBox();
		ComboType.setBackground(new Color(255, 255, 255));
		ComboType.addItem(type[0]);
		ComboType.addItem(type[1]);
		ComboType.setPreferredSize(new Dimension(1000, 30));
		p2.add(ComboType);
		panelCenter.add(p2);
		
		JPanel p3= new JPanel();
		p3.setLayout(new FlowLayout());
		lblcon = new JLabel("Consultation : ");
		p3.add(lblcon);
		txtcon=new JTextArea();
		txtcon.setPreferredSize(new Dimension(930,350));
		sc1=new JScrollPane(txtcon);
		sc1.setPreferredSize(new Dimension(930,350));
		p3.add(sc1);
		panelCenter.add(p3);
		
		JPanel p4= new JPanel();
		p4.setBorder(BorderFactory.createLineBorder(Color.black));
		butmodif= new JButton();
        butmodif.setFont(new Font("Georgia", 0, 18)); // NOI18N
        butmodif.setIcon(new ImageIcon(getClass().getResource("/Img/user_male_edit_1.png"))); // NOI18N
        butmodif.setText("Modifier");
        butmodif.addActionListener(this);
        
        btnordonance= new JButton();
        btnordonance.setFont(new Font("Georgia", 0, 18)); // NOI18N
        btnordonance.setIcon(new ImageIcon(getClass().getResource("/Img/stock.png"))); // NOI18N
        btnordonance.setText("Ordonnance");
        btnordonance.addActionListener(this);

        buttajout= new JButton();
        buttajout.setFont(new Font("Georgia", 0, 18)); // NOI18N
        buttajout.setIcon(new ImageIcon(getClass().getResource("/Img/ok.png"))); // NOI18N
        buttajout.setText("Ajouter");
        buttajout.addActionListener(this);


        GroupLayout jPanel4Layout = new GroupLayout(p4);
        p4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttajout, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(butmodif, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnordonance, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttajout, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(butmodif, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnordonance, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
            );
		panelCenter.add(p4);
		
		butmodif.setEnabled(false);
		btnordonance.setEnabled(false);

		
		
		
		this.add(panelCenter, BorderLayout.CENTER);
		

		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		// Gestion de l'event selon son déclencheur
		if (source == btnrech) {
			String nom = txtnom.getText().toString();
			String prenom = txtprenom.getText().toString();
			ConsultationDAO cDAO = new ConsultationDAO();

			if (!txtnum.getText().toString().equals("")) {
				
				try {
					int id = Integer.parseInt(txtnum.getText());

					cDAO.fillToJtable(id,consultTab);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (!nom.equals("") && !prenom.equals("")) {
				
				try {
					cDAO.fillToJtablenomprenom(nom,prenom,consultTab);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (!nom.equals("")) {
				
				try {
					cDAO.fillToJtablenom(nom,consultTab);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			else {
				
				try {
					cDAO.fillToJtableprenom(prenom,consultTab);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			 
		}
		if (source == butmodif) {
			try {				
				int pcode = Integer.parseInt(txtnum.getText());
				java.util.Date utilDate = calender.getDate();
				java.sql.Date date = new java.sql.Date(utilDate.getTime());
				String type = ComboType.getSelectedItem().toString(); 
				String remarque = txtcon.getText();
				
				Consultation co = new Consultation(date, remarque,type);
				//Utiliser la classe DAO pour ajouter c dans la BD
				ConsultationDAO cDAO = new ConsultationDAO();
				Consultation cModifie = cDAO.Modifier(co,rq);
				// Vérifier si l'ajout a bien été effectué ou non
				if (cModifie != null) {
					cDAO.fillToJtable(pcode,consultTab);
					JOptionPane.showMessageDialog(null, "consultation modifié avec succès");
					butmodif.setEnabled(false);
					calender.setDate(null);
					txtcon.setText("");

	
				}
				
				else
					JOptionPane.showMessageDialog(null, "Problème de modification du consultation");
			}
			catch(Exception ex) { //ex.printStackTrace();
	           JOptionPane.showMessageDialog(null, "Veuillez vérifier les données du consultation à modifier!");
			
			}
		}
		if (source == btnordonance) {
            MainFrame.openNextTab(2);
            //MedPanel.setTextField(getconsultCode());
            //medicament.affiche(id);
            

		}
		if (source == buttajout) {
			try {				
				int pcode = Integer.parseInt(txtnum.getText());
				java.util.Date utilDate = calender.getDate();
				java.sql.Date date = new java.sql.Date(utilDate.getTime());
				String type = ComboType.getSelectedItem().toString(); 
				String remarque = txtcon.getText();
				
				Consultation co = new Consultation(date, remarque,pcode,type);
				//Utiliser la classe DAO pour ajouter c dans la BD
				ConsultationDAO cDAO = new ConsultationDAO();
				Consultation cajouter = cDAO.Ajouter(co);
				System.out.println(cajouter);
				// Vérifier si l'ajout a bien été effectué ou non
				if (cajouter != null) {
					JOptionPane.showMessageDialog(null, "Consultation ajouter avec succès");
					cDAO.fillToJtable(pcode,consultTab);
					
				}
				
				else
					JOptionPane.showMessageDialog(null, "Problème d'ajout du consultation");
			}
			catch(Exception ex) { //ex.printStackTrace();
	           JOptionPane.showMessageDialog(null, "Veuillez vérifier les données du consultation");
				
			}
		}
		if (source == butNvConsult) {
			java.util.Date date = new java.util.Date(); 
			calender.setDate(date);
			txtcon.setText("");
			buttajout.setEnabled(true);
			butmodif.setEnabled(false);
		}

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == consultTab) {
			int i= consultTab.getSelectedRow();
			if (user.equals("medecin")) {
				btnordonance.setEnabled(true);
			}
			try {
				deplece_info(i);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (source == backlbl) {
			txtnum.setText("");
			txtnom.setText("");
			txtprenom.setText("");
			txtage.setText("");
			txtclichet.setText("");
			txtcon.setText("");
			calender.setDate(null);
			viderJtable(consultTab);
			MainFrame.openNextTab(0);
			
		}
		
	}
	private void deplece_info(int i) throws ParseException {
        String strDate = consultTab.getValueAt(i, 1).toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new  java.util.Date(sdf.parse(strDate).getTime());
		butmodif.setEnabled(true);
		buttajout.setEnabled(false);
		rq=consultTab.getValueAt(i, 3).toString();
		calender.setDate(date);
		ComboType.getModel().setSelectedItem(consultTab.getValueAt(i, 2).toString());
        txtcon.setText(rq);
        setconsultCode(consultTab.getValueAt(i, 0).toString());
       
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
	public static String getconsultCode() {
		return consultCode;
	}

	public void setconsultCode(String consultCode) {
		this.consultCode = consultCode;
	}
	public static JTextField getcodeField() {
		return txtnum;
	}

	public static void setcodeField(String text){
		 txtnum.setText(text);
	}
	public void viderJtable(JTable table) {
		 DefaultTableModel model=(DefaultTableModel)table.getModel();
	     for(int i = model.getRowCount(); i > 0; --i)
	    	 model.removeRow(i-1);
	}

	public static  void setnomField(String nom) {
		// TODO Auto-generated method stub
		txtnom.setText(nom);

		
	}
	public static JTextField getnomField() {
		return txtnom;
	}
	public static void setprenomField(String prenom) {
		// TODO Auto-generated method stub
		txtprenom.setText(prenom);
	}
	public static JTextField getprenomField() {
		return txtprenom;
	}
	public static void setageField(String age) {
		// TODO Auto-generated method stub
		txtage.setText(age);

	}
	public static JTextField getageField() {
		return txtage;
	}
	public static void setComboSexe(String sexe) {
		// TODO Auto-generated method stub
		ComboSexe.getModel().setSelectedItem(sexe);

	}
	public static JComboBox getComboSexe() {
		return ComboSexe;
	}
	

}

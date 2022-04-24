package IHM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;

public class MainFrame extends JFrame implements ActionListener{

	private JPanel pMain,pnSouth,pn2,pn3,pn4;
	private JMenuBar mBar,mBar2;
	private JMenu fichierMenu, paramMenu, gestionMenu, consultMenu, statMenu, editMenu, fenetMenu, outilMenu, intMenu;
	private static JTabbedPane tabbedPane;

	private ButtonGroup bg;
	private JButton btndeconnect;
	private static int code=-1;
	
	public MainFrame() {
		// TODO Auto-generated constructor stub
		String user = ConnFrame.getUserType();
		this.setResizable(true);
		pMain = new JPanel();
		pMain.setLayout(new BorderLayout());
		mBar = new JMenuBar();
		fichierMenu = new JMenu("Fichier");
		paramMenu = new JMenu("Paramétrage");
		gestionMenu = new JMenu("Gestion");
		consultMenu = new JMenu("Consultation");
		statMenu = new JMenu("Statistique");
		editMenu = new JMenu("Edition");
		fenetMenu = new JMenu("Fenetre");
		outilMenu = new JMenu("Outils");
		intMenu = new JMenu("?");
		mBar.add(fichierMenu);
		mBar.add(paramMenu);
		mBar.add(gestionMenu);
		mBar.add(consultMenu);
		mBar.add(statMenu);
		mBar.add(editMenu);
		mBar.add(fenetMenu);
		mBar.add(outilMenu);
		mBar.add(intMenu);
		this.setJMenuBar(mBar);
		
		tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(new Color(0, 204, 204));
		tabbedPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		tabbedPane.setForeground(new Color(255, 255, 255));
		tabbedPane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		tabbedPane.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
		
        PatientPanel patientPanel = new PatientPanel();
        // patientPanel.add(new JLabel("gestion des patients"));
        patientPanel.setBackground(new Color(255, 255, 255));

        // Add Dashboard Tab
        tabbedPane.addTab("Gestion des Patients", new javax.swing.ImageIcon(getClass().getResource("/Img/male_user_1.png")),patientPanel);

        ConsulPanel consultationPanel = new ConsulPanel();
        //consultationPanel.add(new JLabel("Consultation"));
        consultationPanel.setBackground(new Color(255, 255, 255));

        // Add Transactions Tab
        tabbedPane.addTab("Gestion des Consultation",new javax.swing.ImageIcon(getClass().getResource("/Img/medicament1.png")), consultationPanel);
        if (user.equals("medecin")) {
        MedPanel medicamentPanel = new MedPanel();
        //medicamentPanel.add(new JLabel("Medicament"));
        medicamentPanel.setBackground(new Color(255, 255, 255));

        // Add Account Tab
        tabbedPane.addTab("Gestion des Medicaments",new javax.swing.ImageIcon(getClass().getResource("/Img/consultation.png")), medicamentPanel);
       
        }
    
		pMain.add(tabbedPane, BorderLayout.CENTER);

		
		btndeconnect = new JButton("Deconnecter");
		btndeconnect.setFont(new java.awt.Font("Garamond", 3, 20)); 
		btndeconnect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logout.png"))); 
		btndeconnect.setBorder(BorderFactory.createLineBorder(Color.black));
		btndeconnect.addActionListener(this);

		JLabel lbluser=new JLabel(user);
		lbluser.setFont(new java.awt.Font("Garamond", 1, 24)); 
        lbluser.setForeground(new Color(255, 255, 255));
        lbluser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/status.png"))); 
        lbluser.setBorder(BorderFactory.createLineBorder(Color.black));
        //lbluser.setPreferredSize(new Dimension(80, 20));
        pnSouth=new JPanel();
        pn2=new JPanel();
        pnSouth.setLayout(new BorderLayout());
        pnSouth.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnSouth.setForeground(Color.GRAY);
		//pnSouth.setBackground(SystemColor.activeCaption);
		pnSouth.setBackground(new Color(0, 204, 204));

		pnSouth.setPreferredSize(new Dimension(800,50));
		pMain.add(pnSouth, BorderLayout.SOUTH);

		pnSouth.setOpaque(true); 
		pnSouth.setLayout(new BorderLayout(0, 0));
		
		pnSouth.add(lbluser, BorderLayout.WEST);
		pnSouth.add(btndeconnect, BorderLayout.EAST);
		

		
		this.setContentPane(pMain);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(1280,720));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		// Gestion de l'event selon son déclencheur
		if (source == btndeconnect) {
			new ConnFrame().setVisible(true);
	        this.dispose();
		}
	}
	public static void openNextTab(int indice) {
		// TODO Auto-generated method stub
		tabbedPane.setSelectedIndex(indice);
		

		
	}
	

}

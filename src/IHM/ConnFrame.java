package IHM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import DAO.*;

public class ConnFrame extends JFrame implements ActionListener{
	
	private JPanel pMain,pn1,pn2,pn3,pn4;
	private JLabel user;
	private JRadioButton rdmed,rdsec;
	private ButtonGroup bg;
	private JButton btnconn,btnquit;
	private JLabel motp,login;
	private JPasswordField pass_field;
	private JTextField usertext;
	private JCheckBox jCheckBox1;
	private static String userType;

	public ConnFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 320);
		pMain = new JPanel();
		pMain.setBackground(new Color(255, 255, 255));
		pMain.setBorder(BorderFactory.createEtchedBorder());
		pn1=new JPanel();
		pn1.setBackground(new Color(255, 255, 255));
		pn1.setBounds(90, 28, 461, 31);
		pn1.setLayout(null);
		user=new JLabel("User");
		user.setBounds(42, 11, 100, 20);
		user.setFont(new Font("Garamond", 1, 16)); // NOI18N
		user.setForeground(new Color(51, 0, 204));
		user.setPreferredSize(new Dimension(100,20));
		pn1.add(user);
		rdmed=new JRadioButton("Medecin");
		rdmed.setBounds(134, 5, 97, 33);
		rdmed.setFont(new Font("Garamond", 1, 16)); // NOI18N
		rdmed.setForeground(new Color(51, 0, 204));
		rdmed.setBackground(new Color(255, 255, 255));
		rdsec=new JRadioButton("Secretaire");
		rdsec.setBounds(269, 5, 123, 33);
		rdsec.setFont(new Font("Garamond", 1, 16)); // NOI18N
		rdsec.setForeground(new Color(51, 0, 204));
		rdsec.setBackground(new Color(255, 255, 255));
		bg=new ButtonGroup();
		pMain.setLayout(null);
		bg.add(rdmed);
		bg.add(rdsec);
		pn1.add(rdmed);
		pn1.add(rdsec);
		pMain.add(pn1);
		
		pn3 = new JPanel();
		
		pn3.setBounds(90, 69, 461, 59);
		pn3.setLayout(null);
		login=new JLabel("Login");

		login.setBounds(42, 27, 49, 24);
		login.setFont(new Font("Garamond", 1, 16)); // NOI18N
		login.setForeground(new Color(51, 0, 204));
		
		pn3.add(login);
		usertext=new JTextField(10);
		usertext.setBounds(196, 27, 172, 24);
		usertext.setFont(new Font("Garamond", 1, 16)); // NOI18N
		usertext.setBorder(null);
		pn3.add(usertext);
		pMain.add(pn3);	
		JLabel jLabel3 = new JLabel();
		jLabel3.setBounds(376, 10, 43, 41);
		pn3.add(jLabel3);
		jLabel3.setIcon(new ImageIcon(getClass().getResource("/Img/male_user_1.png")));

		
		pn4 = new JPanel();
		pn4.setBounds(90, 138, 461, 57);
		pn4.setLayout(null);
		motp=new JLabel("Mot de passe");
		motp.setBounds(42, 23, 121, 24);
		motp.setFont(new Font("Garamond", 1, 16)); // NOI18N
		motp.setForeground(new Color(51, 0, 204));
		pn4.add(motp);
		pass_field=new JPasswordField(10);
		pass_field.setBounds(196, 23, 172, 24);
		pass_field.setFont(new Font("Garamond", 1, 16)); // NOI18N
        pass_field.setBorder(null);
        pass_field.setEchoChar('*');
		pn4.add(pass_field);	
		jCheckBox1 = new JCheckBox();
		jCheckBox1.setBounds(367, 26, 21, 21);
        jCheckBox1.setBackground(SystemColor.control);
		jCheckBox1.addActionListener(this);
		pn4.add(jCheckBox1);
		pMain.add(pn4);
		
		JLabel jLabel4 = new JLabel();
		jLabel4.setBounds(378, 10, 55, 37);
		pn4.add(jLabel4);
		jLabel4.setIcon(new ImageIcon(getClass().getResource("/Img/if_Privacy_2921800(1).png")));

		
		pn2=new JPanel();
		pn2.setBackground(new Color(255, 255, 255));
		pn2.setBounds(65, 227, 515, 59);
		btnconn=new JButton("Connecter");
		btnconn.setBounds(125, 5, 145, 28);

		btnconn.setFont(new Font("Garamond", 1, 16)); // NOI18N
		btnconn.setIcon(new ImageIcon(getClass().getResource("/Img/if_check_1930264.png"))); // NOI18N
		btnconn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 2, true));
		btnconn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnconn.setFocusPainted(false);
		btnconn.addActionListener(this);
		pn2.setLayout(null);
		pn2.add(btnconn);
		
		btnquit=new JButton("Quitter");
		btnquit.setBounds(275, 5, 118, 28);
		btnquit.setFont(new Font("Garamond", 1, 16)); // NOI18N
		btnquit.setIcon(new ImageIcon(getClass().getResource("/Img/if_Remove_27874.png"))); // NOI18N
		btnquit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 2, true));
		btnquit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnquit.setFocusPainted(false);
		btnquit.addActionListener(this);
	
		pn2.add(btnquit);
		pMain.add(pn2);
		
		this.setContentPane(pMain);
		//getContentPane().setBackground(SystemColor.activeCaption);



	}
	public static String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Déterminer la source de l'évènement
				Object source = e.getSource();
				// Gestion de l'event selon son déclencheur
				if (source == btnconn) {
					String username=usertext.getText();
		            String password=pass_field.getText();
		            if (rdmed.isSelected()) {userType="medecin";setUserType(userType);}
		            if (rdsec.isSelected()) {userType="secretaire";setUserType(userType);}	
					try {
						if (LogIn.Chekuserandpass(username, password,userType)){
							
									MainFrame m = new MainFrame(); 
									m.setVisible(true);
								    this.dispose();
						}
						else
						{
						   JOptionPane.showMessageDialog(null, "Invalid Username Or Password!!");
						   usertext.setText("");
						   pass_field.setText("");
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
					}
				}
		       
				else if (source == btnquit) {
					this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
				}
				if (source == jCheckBox1) {
				    if(jCheckBox1.isSelected())
				    {
				    	pass_field.setEchoChar((char)0);
	
				    }
				    else
				    {
				    	pass_field.setEchoChar('*');
	
				    }
			    }
			
	}
}

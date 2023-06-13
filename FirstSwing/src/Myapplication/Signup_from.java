package Myapplication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Signup_from extends JFrame {

	private JPanel contentPane;
	private JTextField usernameR;
	private JTextField emailR;
	private JTextField phoneR;
	private JPasswordField passwordR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup_from frame = new Signup_from();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Signup_from() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,841,441);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameR = new JTextField();
		usernameR.setText("Username");
		usernameR.setBounds(124, 122, 207, 28);
		contentPane.add(usernameR);
		usernameR.setColumns(10);
		
		emailR = new JTextField();
		emailR.setText("Email");
		emailR.setBounds(124, 179, 207, 28);
		contentPane.add(emailR);
		emailR.setColumns(10);
		
		phoneR = new JTextField();
		phoneR.setText("Phone");
		phoneR.setBounds(124, 237, 207, 28);
		contentPane.add(phoneR);
		phoneR.setColumns(10);
		
		passwordR = new JPasswordField();
		passwordR.setText("Password");
		passwordR.setBounds(124, 303, 207, 28);
		contentPane.add(passwordR);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(51, 128, 66, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(51, 174, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(51, 243, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(51, 309, 66, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sign up");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_4.setBounds(187, 46, 102, 28);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(427, -24, 414, 480);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Hello,Friend !");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(144, 152, 227, 42);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Enter your details and start journey with us");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(82, 191, 310, 35);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("x");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"are you sure you want to close this application?","confiramtion",JOptionPane.YES_NO_OPTION)==0){
					Signup_from.this.dispose();
				}
			}
		});
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(398, 26, 16, 14);
		panel.add(lblNewLabel_7);
		
		JButton signupbtF = new JButton("Sign up");
		signupbtF.setBounds(124, 364, 207, 25);
		contentPane.add(signupbtF);
		signupbtF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				       Class.forName("com.mysql.cj.jdbc.Driver");
				       Connection cox=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
				       if(cox!=null){
				       String sql="insert into users(UserName,Email,Phone,Password) values(?,?,?,?)";
				       PreparedStatement ps=cox.prepareStatement(sql);
				      ps.setString(1,usernameR.getText());
				      ps.setString(2,emailR.getText());
				      ps.setString(3,phoneR.getText());
				      ps.setString(4,passwordR.getText());
				      int rs=ps.executeUpdate();
				     JOptionPane.showMessageDialog(null,"sign up successful");
				           Login_form login=new Login_form();
				           login.setVisible(true);
				           setVisible(false);
				       
				       }
				       else{
				       
				        JOptionPane.showMessageDialog(null,"sign up failed");
				       
				       }
				       
				       }
				       catch(Exception e2){
				    	   e2.printStackTrace();
				       }
				       
				                
				               
				    } 
			
		});
		signupbtF.setForeground(Color.WHITE);
		signupbtF.setBackground(new Color(0, 102, 204));
		signupbtF.setFont(new Font("Tahoma", Font.BOLD, 14));
	}
}

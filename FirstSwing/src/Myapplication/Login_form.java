package Myapplication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFormattedTextField;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login_form extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_form frame = new Login_form();
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
	public Login_form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841,441 );
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.setForeground(new Color(0, 102, 204));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		username = new JTextField();
		username.setBounds(534, 167, 207, 28);
		username.setSelectionColor(new Color(0, 120, 215));
		username.setForeground(new Color(0, 0, 0));
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(534, 237, 207, 28);
		contentPane.add(password);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.setBounds(534, 306, 205, 28);
		loginbtn.setBackground(new Color(0, 102, 255));
		loginbtn.setForeground(new Color(255, 255, 255));
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       
			           try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					
			           Connection cox;
					
						cox = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
					
			           String sql="select * from users where UserName=? and Password=?";
			           PreparedStatement ps=cox.prepareStatement(sql);
			          ps.setString(1,username.getText());
			          ps.setString(2,password.getText());
			          ResultSet rs=ps.executeQuery();
			         if(rs.next()){
			        	 if (rs.getString("username").equals("admin")) {Userdata users=new Userdata();
				         users.setVisible(true);
				         setVisible(false);}
			        	 else {
			         JOptionPane.showMessageDialog(null,"login successful");
			        Home home=new Home();
			         home.setVisible(true);
			         setVisible(false);
			         }}
			         else{
			         JOptionPane.showMessageDialog(null,"login failed ");
			         
			         }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			          
			          
			          }
			         
			           
			          
		
	});
		
		loginbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(loginbtn);
		
		JButton signupbtn = new JButton("Sign up");
		signupbtn.setBounds(671, 370, 70, 23);
		signupbtn.setBorder(null);
		signupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Signup_from register=new Signup_from();
			      register.setVisible(true);
			      setVisible(false);
			}
			
		});
		signupbtn.setForeground(new Color(0, 102, 204));
		signupbtn.setBackground(new Color(255, 255, 255));
		signupbtn.setActionCommand("");
		signupbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(signupbtn);
		
		JLabel lblNewLabel = new JLabel("Login Account");
		lblNewLabel.setBounds(555, 70, 165, 28);
		lblNewLabel.setForeground(new Color(0, 102, 204));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(466, 173, 67, 14);
		lblNewLabel_1.setForeground(UIManager.getColor("Button.darkShadow"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(466, 243, 67, 14);
		lblNewLabel_2.setForeground(UIManager.getColor("Button.darkShadow"));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 399, 423);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Login_form.class.getResource("/image/login.jpg")));
		
		lblNewLabel_3.setBounds(0, 0, 399, 423);
		panel.add(lblNewLabel_3);
	
		JLabel lblNewLabel_4 = new JLabel("D'ont have an account?");
		lblNewLabel_4.setBounds(534, 375, 146, 14);
		lblNewLabel_4.setForeground(UIManager.getColor("Button.darkShadow"));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("X");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"are you sure you want to close this application?","confiramtion",JOptionPane.YES_NO_OPTION)==0){
			Login_form.this.dispose();
		}
			}
		});
		lblNewLabel_5.setForeground(new Color(0, 102, 204));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(827, 0, 14, 14);
		contentPane.add(lblNewLabel_5);

	}
}

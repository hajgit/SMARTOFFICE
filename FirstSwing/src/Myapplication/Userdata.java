package Myapplication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Userdata extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Userdata frame = new Userdata();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection cox=null;
	private JTextField username;
	private JTextField email;
	private JTextField phone;
	private JTextField password;
	private JTextField id;
	/**
	 * Create the frame.
	 */
	public Userdata() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			cox = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,841,441);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JButton btndisplaydata = new JButton("load user data");
		btndisplaydata.setForeground(new Color(255, 255, 255));
		btndisplaydata.setBackground(new Color(0, 102, 204));
		btndisplaydata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
		           String sql="select * from users where id!=1; ";
		           try {
		        	   Statement st=cox.createStatement();
		        	   ResultSet rs=st.executeQuery(sql);
		        	   table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
		           
			}
		});
		btndisplaydata.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btndisplaydata.setBounds(523, 33, 143, 23);
		contentPane.add(btndisplaydata);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(361, 67, 457, 235);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		username = new JTextField();
		username.setBounds(193, 145, 158, 23);
		contentPane.add(username);
		username.setColumns(10);
		
		email = new JTextField();
		email.setBounds(193, 191, 158, 23);
		contentPane.add(email);
		email.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(193, 238, 158, 23);
		contentPane.add(phone);
		phone.setColumns(10);
		
		password = new JTextField();
		password.setBounds(193, 279, 158, 23);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setForeground(UIManager.getColor("Button.darkShadow"));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(122, 149, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("email");
		lblNewLabel_1.setForeground(UIManager.getColor("Button.darkShadow"));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(122, 195, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("phone");
		lblNewLabel_2.setForeground(UIManager.getColor("Button.darkShadow"));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_2.setBounds(122, 242, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("password");
		lblNewLabel_3.setForeground(UIManager.getColor("Button.darkShadow"));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3.setBounds(121, 283, 62, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("update");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 102, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
				       Connection cox=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
				       if(cox!=null){
				       String sql="update  users set UserName='"+username.getText()+"',Email='"+email.getText()+"',Phone='"+phone.getText()+"',Password='"+password.getText()+"' where id='"+id.getText()+"'";
				       PreparedStatement ps=cox.prepareStatement(sql);
				    
				      int rs=ps.executeUpdate();
				      JOptionPane.showMessageDialog(null,"data updated");}
					}
				       catch(Exception e2){
				    	   e2.printStackTrace();
				       }
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton.setBounds(85, 327, 83, 35);
		contentPane.add(btnNewButton);
		
		JButton btnCreate = new JButton("create");
		btnCreate.setForeground(new Color(255, 255, 255));
		btnCreate.setBackground(new Color(0, 102, 204));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				Class.forName("com.mysql.cj.jdbc.Driver");
			       Connection cox=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
			       if(cox!=null){
			       String sql="insert into users(UserName,Email,Phone,Password) values(?,?,?,?)";
			       PreparedStatement ps=cox.prepareStatement(sql);
			      ps.setString(1,username.getText());
			      ps.setString(2,email.getText());
			      ps.setString(3,phone.getText());
			      ps.setString(4,password.getText());
			      int rs=ps.executeUpdate();
			      }
				}
			       catch(Exception e2){
			    	   e2.printStackTrace();
			       }
			}
		});
		btnCreate.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnCreate.setBounds(182, 327, 83, 35);
		contentPane.add(btnCreate);
		
		JButton btnNewButton_1_1 = new JButton("delete");
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setBackground(new Color(0, 102, 204));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
				       Connection cox=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
				       if(cox!=null){
				       String sql="delete  from users  where id='"+id.getText()+"'";
				       PreparedStatement ps=cox.prepareStatement(sql);
				    
				      int rs=ps.executeUpdate();
				      JOptionPane.showMessageDialog(null,"data deleted");}
					}
				       catch(Exception e2){
				    	   e2.printStackTrace();
				       }
			
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(275, 327, 83, 35);
		contentPane.add(btnNewButton_1_1);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(193, 102, 158, 23);
		contentPane.add(id);
		
		JLabel lblNewLabel_4 = new JLabel("id");
		lblNewLabel_4.setForeground(UIManager.getColor("Button.darkShadow"));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_4.setBounds(122, 106, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("x");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				{
					if(JOptionPane.showConfirmDialog(null,"are you sure you want to close this application?","confiramtion",JOptionPane.YES_NO_OPTION)==0){
						Userdata.this.dispose();
			
			}}
			}
		});
		lblNewLabel_5.setForeground(new Color(0, 102, 204));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_5.setBounds(814, 11, 17, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Admin Page");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_6.setForeground(new Color(0, 102, 204));
		lblNewLabel_6.setBounds(156, 23, 148, 35);
		contentPane.add(lblNewLabel_6);
		
		JButton btnhome = new JButton("Home");
		btnhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Home home=new Home();
		         home.setVisible(true);
		         setVisible(false);
			}
		});
		btnhome.setForeground(Color.WHITE);
		btnhome.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnhome.setBackground(new Color(0, 102, 204));
		btnhome.setBounds(182, 373, 83, 35);
		contentPane.add(btnhome);
	}
}

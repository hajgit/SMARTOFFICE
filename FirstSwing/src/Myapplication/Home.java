package Myapplication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fazecast.jSerialComm.SerialPort;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import testbluetooth.ArduinoSerial;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Home extends JFrame {

	
	
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,841,441);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 102, 204));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		Scanner s= new Scanner(System.in);
		Object[] pieces=new Object[] {"pièce 1","pièce 2","pièce 3"};
         contentPane.setLayout(null);
         JComboBox comboBox = new JComboBox();
         comboBox.setBounds(528, 104, 209, 22);
		
		comboBox.setModel(new DefaultComboBoxModel(pieces));
		contentPane.add(comboBox);
		 
		JButton ledonbtn1 = new JButton("on");
		ledonbtn1.setBounds(450, 164, 89, 28);
		ledonbtn1.setVisible(false);
		ledonbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SerialPort comPort = SerialPort.getCommPorts()[0];
				 
				 comPort.openPort();
				 comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		    	OutputStream out=comPort.getOutputStream();
			
		    	String data=s.next();
		    	try {
					out.write(data.getBytes());
					out.flush();
		   	 comPort.closePort();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
		    
				
			
			
		});
		ledonbtn1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		ledonbtn1.setForeground(new Color(0, 0, 0));
		contentPane.add(ledonbtn1);
		
		JButton ledoffbtn1 = new JButton("off");
		ledoffbtn1.setBounds(568, 164, 89, 28);
		ledoffbtn1.setVisible(false);
		ledoffbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SerialPort comPort = SerialPort.getCommPorts()[0];
				 
				 comPort.openPort();
				 comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		    	OutputStream out=comPort.getOutputStream();
			
			
				
		    	String data="a";
		    	try {
					out.write(data.getBytes());
					out.flush();
		   	 comPort.closePort();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
		    
					
			
		});
		ledoffbtn1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(ledoffbtn1);
		
		JLabel lbl2 = new JLabel("Lampe 1");
		lbl2.setBounds(348, 167, 62, 21);
		lbl2.setVisible(false);
		lbl2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lbl2);
		
		JButton voletonbtn = new JButton("on");
		voletonbtn.setBounds(450, 220, 89, 28);
		voletonbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SerialPort comPort = SerialPort.getCommPorts()[0];
				 
				 comPort.openPort();
				 comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		    	OutputStream out=comPort.getOutputStream();
			
		    	String data=s.next();
		    	try {
					out.write(data.getBytes());
					out.flush();
		   	 comPort.closePort();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		    
			}
		});
		voletonbtn.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(voletonbtn);
		
		JLabel lblNewLabel_1 = new JLabel("Climatisation");
		lblNewLabel_1.setBounds(348, 286, 89, 14);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Volet");
		lblNewLabel_2.setBounds(348, 234, 73, 14);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel_2);
		
		JButton clionbtn = new JButton("on");
		clionbtn.setBounds(450, 280, 89, 28);
		clionbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SerialPort comPort = SerialPort.getCommPorts()[0];
				 
				 comPort.openPort();
				 comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		    	OutputStream out=comPort.getOutputStream();
			
		    	String data=s.next();
		    	try {
					out.write(data.getBytes());
					out.flush();
		   	 comPort.closePort();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		    
			}
		});
		clionbtn.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(clionbtn);
		
		JButton clioffbtn = new JButton("off");
		clioffbtn.setBounds(568, 280, 89, 28);
		clioffbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SerialPort comPort = SerialPort.getCommPorts()[0];
				 
				 comPort.openPort();
				 comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		    	OutputStream out=comPort.getOutputStream();
			
		    	String data="e";
		    	try {
					out.write(data.getBytes());
					out.flush();
		   	 comPort.closePort();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				
				}
		    
			}
		});
		clioffbtn.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(clioffbtn);
		
		JButton voletoffbtn = new JButton("off");
		voletoffbtn.setBounds(568, 220, 89, 28);
		voletoffbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SerialPort comPort = SerialPort.getCommPorts()[0];
				 
				 comPort.openPort();
				 comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		    	OutputStream out=comPort.getOutputStream();
			
		    	String data="o";
		    	try {
					out.write(data.getBytes());
					out.flush();
		   	 comPort.closePort();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		    
			}
		});
		voletoffbtn.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(voletoffbtn);
		
		JButton velonbtn = new JButton("on");
		velonbtn.setBounds(450, 340, 89, 28);
		velonbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SerialPort comPort = SerialPort.getCommPorts()[0];
				 
				 comPort.openPort();
				 comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		    	OutputStream out=comPort.getOutputStream();
			
		    	String data=s.next();
		    	try {
					out.write(data.getBytes());
					out.flush();
		   	 comPort.closePort();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		velonbtn.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(velonbtn);
		
		JButton btnNewButton_5 = new JButton("off");
		btnNewButton_5.setBounds(568, 340, 89, 28);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SerialPort comPort = SerialPort.getCommPorts()[0];
				 
				 comPort.openPort();
				 comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		    	OutputStream out=comPort.getOutputStream();
			
		    	String data="e";
		    	try {
					out.write(data.getBytes());
					out.flush();
		   	 comPort.closePort();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		    
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_3 = new JLabel("Ventilateur");
		lblNewLabel_3.setBounds(348, 346, 89, 15);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel_3);
		
		JButton ledonbtn2 = new JButton("on");
		ledonbtn2.setBounds(450, 164, 89, 28);
		ledonbtn2.setVisible(false);
		ledonbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SerialPort comPort = SerialPort.getCommPorts()[0];
				 
				 comPort.openPort();
				 comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		    	OutputStream out=comPort.getOutputStream();
			
		    	String data=s.next();
		    	try {
					out.write(data.getBytes());
					out.flush();
		   	 comPort.closePort();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		    
			}
		});
		ledonbtn2.setForeground(Color.BLACK);
		ledonbtn2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(ledonbtn2);
		
		JButton ledoffbtn2 = new JButton("off");
		ledoffbtn2.setBounds(568, 164, 89, 28);
		ledoffbtn2.setVisible(false);
		ledoffbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SerialPort comPort = SerialPort.getCommPorts()[0];
				 
				 comPort.openPort();
				 comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		    	OutputStream out=comPort.getOutputStream();
			
		    	String data="b";
		    	try {
					out.write(data.getBytes());
					out.flush();
		   	 comPort.closePort();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		    
			}
		});
		ledoffbtn2.setForeground(Color.BLACK);
		ledoffbtn2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(ledoffbtn2);
		
		JLabel lblLampe = new JLabel("Lampe 2");
		lblLampe.setBounds(348, 167, 62, 21);
		lblLampe.setVisible(false);
		lblLampe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblLampe);
		
		JButton ledonbtn3 = new JButton("on");
		ledonbtn3.setBounds(450, 164, 89, 28);
		ledonbtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SerialPort comPort = SerialPort.getCommPorts()[0];
				 
				 comPort.openPort();
				 comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		    	OutputStream out=comPort.getOutputStream();
			
		    	String data=s.next();
		    	try {
					out.write(data.getBytes());
					out.flush();
		   	 comPort.closePort();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		    
			}
		});
		ledonbtn3.setVisible(false);
		ledonbtn3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(ledonbtn3);
		
		JButton ledoffbtn3 = new JButton("off");
		ledoffbtn3.setBounds(568, 164, 89, 28);
		ledoffbtn3.setVisible(false);
		ledoffbtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SerialPort comPort = SerialPort.getCommPorts()[0];
				 
				 comPort.openPort();
				 comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		    	OutputStream out=comPort.getOutputStream();
			
		    	String data="d";
		    	try {
					out.write(data.getBytes());
					out.flush();
		   	 comPort.closePort();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		    
			}
		});
		ledoffbtn3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(ledoffbtn3);
		
		JLabel lblNewLabel_4 = new JLabel("Lampe 3");
		lblNewLabel_4.setBounds(348, 165, 73, 24);
		lblNewLabel_4.setVisible(false);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(-37, -23, 268, 477);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Home");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_5.setBounds(120, 94, 97, 30);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Home.class.getResource("/image/volet.png")));
		lblNewLabel_6.setBounds(292, 210, 46, 48);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Home.class.getResource("/image/airconditioner.png")));
		lblNewLabel_7.setBounds(292, 266, 61, 42);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Home.class.getResource("/image/fan.png")));
		lblNewLabel_8.setBounds(292, 320, 46, 48);
		contentPane.add(lblNewLabel_8);
		
		JLabel icon1l = new JLabel("");
		icon1l.setIcon(new ImageIcon(Home.class.getResource("/image/lampe.png")));
		icon1l.setVisible(false);
		icon1l.setBounds(280, 137, 62, 66);
		contentPane.add(icon1l);
		
		JLabel lblNewLabel = new JLabel("Sélectionnez l'appareil que vous souhaitez contrôler parmi les options disponibles.");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(260, 32, 549, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_9 = new JLabel("x");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				{
					if(JOptionPane.showConfirmDialog(null,"are you sure you want to close this application?","confiramtion",JOptionPane.YES_NO_OPTION)==0){
				Home.this.dispose();
			
			}}}
		});
		lblNewLabel_9.setForeground(new Color(0, 102, 204));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_9.setBounds(813, 0, 28, 22);
		contentPane.add(lblNewLabel_9);
		comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JComboBox<String> comboBox = (JComboBox<String>) event.getSource();

                // Check the selected item
                String selected = (String) comboBox.getSelectedItem();
                if (selected.equals("select")) {
                	ledonbtn1.setVisible(false);
                	ledoffbtn1.setVisible(false);
                	lbl2.setVisible(false);
                	ledonbtn2.setVisible(false);
                	ledoffbtn2.setVisible(false);
                	lblLampe.setVisible(false);
                	icon1l.setVisible(false);
                	// Show the button
                }
                if (selected.equals("pièce 1")) {
                	ledonbtn1.setVisible(true);
                	ledoffbtn1.setVisible(true);
                	lbl2.setVisible(true);
                	icon1l.setVisible(true);
                	// Show the button
                } else {
                	ledonbtn1.setVisible(false);
                	ledoffbtn1.setVisible(false);
                	lbl2.setVisible(false);
                // Hide the button
                }
                if (selected.equals("pièce 2")) {
                	ledonbtn2.setVisible(true);
                	ledoffbtn2.setVisible(true);
                	lblLampe.setVisible(true);
                	icon1l.setVisible(true);
                	// Show the button
                } else {
                	ledonbtn2.setVisible(false);
                	ledoffbtn2.setVisible(false);
                	lblLampe.setVisible(false);
                // Hide the button
                }
                if (selected.equals("pièce 3")) {
                	ledonbtn3.setVisible(true);
                	ledoffbtn3.setVisible(true);
                	lblNewLabel_4.setVisible(true);
                	icon1l.setVisible(true);
                	// Show the button
                } else {
                	ledonbtn3.setVisible(false);
                	ledoffbtn3.setVisible(false);
                	lblNewLabel_4.setVisible(false);
                // Hide the button
                }
                
            }
        });
		
		
	}
}

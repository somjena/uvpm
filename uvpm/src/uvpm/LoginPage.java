package uvpm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

@SuppressWarnings({ "serial", "unused" })
public class LoginPage extends JFrame {
	
	
	Connection con;
    ResultSet rs;


	private JPanel contentPane;
	private JTextField nameTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public LoginPage() {
		
		con=SqlConnection.ConnectDatabase();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 701);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("               University Vechile Parking System");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel_2.setBounds(10, 23, 665, 33);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 889, 77);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginPage.class.getResource("/uvpm/img/icons8_user_100px.png")));
		lblNewLabel.setBounds(530, 200, 96, 93);
		contentPane.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		nameTextField = new JTextField();
		nameTextField.setBounds(620, 239, 241, 28);
		contentPane.add(nameTextField);
		nameTextField.setBackground(new Color(255, 255, 255));
		nameTextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(620, 323, 239, 28);
		contentPane.add(passwordField);
		passwordField.setEchoChar('*');
		passwordField.setColumns(10);
		
		
		JLabel lblNewLabel_pass = new JLabel(" ");
		lblNewLabel_pass.setIcon(new ImageIcon(LoginPage.class.getResource("/uvpm/img/icons8_password_50px.png")));
		lblNewLabel_pass.setBounds(561, 305, 65, 58);
		contentPane.add(lblNewLabel_pass);
		lblNewLabel_pass.setForeground(new Color(0, 0, 0));
		lblNewLabel_pass.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton login = new JButton("Login");
		login.setBounds(552, 426, 96, 28);
		contentPane.add(login);
		login.setBackground(new Color(0, 128, 128));
		login.setFont(new Font("Times New Roman", Font.BOLD, 20));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try
			        {
					 
			            
			            Statement s=con.createStatement();
			            String query="select * from user_info where u_name='"+nameTextField.getText()+"'";
			            ResultSet rs=s.executeQuery(query);
			            Store.name=nameTextField.getText();
			            String uType="";
			            String password="";
			            String pass= String.valueOf(passwordField.getPassword());
			            String type="";
			            while(rs.next()) {
			                password=rs.getString("u_pass");
			                type=rs.getString("u_type");
			            }
			            
			            if( password.equals(pass)) {
			                if(type.equalsIgnoreCase("Student")) {
			                	dispose();
			                	HomeStudent obj=new HomeStudent();
			                	obj.setTitle("Vechile Parking Management");
			                	obj.setVisible(true);
			                	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			                	obj.setResizable(true);
			                }
			                else if(type.equalsIgnoreCase("HOD")) {
			                	dispose();
			                	HomeAdmin obj=new HomeAdmin();
			                	obj.setTitle("Vechile Parking Management");
			                	obj.setVisible(true);
			                	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			                	obj.setResizable(true);
			                }
			                else {
			                	dispose();
			                	HomeSecurity obj=new HomeSecurity();
			                	obj.setTitle("Vechile Parking Management");
			                	obj.setVisible(true);
			                	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			                	obj.setResizable(true);
			                }
			            }

			            else {
			                JOptionPane.showMessageDialog(login, "Wrong Username & Password",password, JOptionPane.WARNING_MESSAGE);
			            }
			        }
			        catch (Exception ex) {
			            System.out.println(ex);
			        }
			}
		});
		login.setForeground(new Color(0, 255, 0));
		
		JButton newAcc = new JButton("New Account");
		newAcc.setBounds(688, 426, 171, 28);
		contentPane.add(newAcc);
		newAcc.setBackground(new Color(0, 128, 128));
		newAcc.setFont(new Font("Times New Roman", Font.BOLD, 20));
		newAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				NewAccount obj=new NewAccount();
                obj.setTitle("Vechile Parking Management");
                obj.setVisible(true);
                obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                obj.setResizable(true);
			}
		});
		newAcc.setForeground(Color.BLACK);
		
		JButton forgot = new JButton("Fogot Password");
		forgot.setBounds(552, 481, 182, 33);
		contentPane.add(forgot);
		forgot.setBackground(new Color(0, 128, 128));
		forgot.setFont(new Font("Times New Roman", Font.BOLD, 18));
		forgot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
            	ForgotPassword obj=new ForgotPassword();
            	obj.setTitle("Vechile Parking Management");
            	obj.setVisible(true);
            	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	obj.setResizable(true);
			}
		});
		forgot.setForeground(Color.BLACK);
		
		JButton reset = new JButton("Reset");
		reset.setBounds(763, 481, 96, 33);
		contentPane.add(reset);
		reset.setBackground(new Color(0, 128, 128));
		reset.setFont(new Font("Times New Roman", Font.BOLD, 20));
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					nameTextField.setText("");
					passwordField.setText("");
			}
		});
		reset.setForeground(Color.BLUE);
		
		
		
		
		
		JLabel lblNewLabel_8 = new JLabel(" ");
		lblNewLabel_8.setBounds(684, 87, 96, 109);
		contentPane.add(lblNewLabel_8);
		lblNewLabel_8.setIcon(new ImageIcon(LoginPage.class.getResource("/uvpm/img/cutm-logo-1.png")));
		
		JCheckBox hide = new JCheckBox("Show");
		hide.setBounds(766, 376, 93, 21);
		contentPane.add(hide);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setIcon(new ImageIcon(LoginPage.class.getResource("/uvpm/img/depositphotos_9885470-stock-illustration-motorcycle-removebg-preview.png")));
		lblNewLabel_1.setBounds(0, 118, 578, 437);
		contentPane.add(lblNewLabel_1);
		hide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(hide.isSelected())
			        {
			            passwordField.setEchoChar((char)0);
			        }
			        // hide password chars
			        else
			        {
			            passwordField.setEchoChar('*');
			        }
			}
		});
	}
}

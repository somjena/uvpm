package uvpm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class HomeStudent extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeStudent frame = new HomeStudent();
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
	public HomeStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 582);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton register = new JButton("Register for Parking Solts");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
                 Registration obj=new Registration();
	                obj.setTitle("Vechile Parking Management");
	                obj.setVisible(true);
	                obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                obj.setResizable(true);
			}
			
		});
		register.setForeground(Color.ORANGE);
		register.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		register.setBounds(367, 139, 243, 35);
		contentPane.add(register);
		
		JButton delete = new JButton("Delete Account");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DeleteAccount obj=new DeleteAccount();
				 obj.setTitle("Vechile Parking Management");
	                obj.setVisible(true);
	                obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                obj.setResizable(true);
				
			}
		});
		delete.setForeground(Color.RED);
		delete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		delete.setBounds(367, 239, 243, 35);
		contentPane.add(delete);
		
		JButton logout = new JButton("LogOut");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
            	LoginPage obj=new LoginPage();
            	obj.setTitle("Vechile Parking Management");
            	obj.setVisible(true);
            	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	obj.setResizable(true);
			}
		});
		logout.setForeground(new Color(0, 255, 0));
		logout.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		logout.setBounds(367, 429, 243, 35);
		contentPane.add(logout);
		
		JButton status = new JButton("View Status");
		status.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
            	ViewStatus obj=new ViewStatus();
            	obj.setTitle("Vechile Parking Management");
            	obj.setVisible(true);
            	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	obj.setResizable(true);
			}
			
		});
		status.setForeground(new Color(255, 0, 153));
		status.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		status.setBounds(367, 329, 243, 35);
		contentPane.add(status);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 884, 61);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vechile Parking Management");
		lblNewLabel.setBounds(320, 16, 327, 35);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setForeground(Color.WHITE);
		
	}
}

package uvpm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddParking extends JFrame {
	
	Connection con;
    ResultSet rs;

	private JPanel contentPane;
	private int id;
    private String t="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddParking frame = new AddParking();
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
	public AddParking() {
		
		con=SqlConnection.ConnectDatabase();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 696);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		 try
	        {
			// String vechileNo=Store.vechileNo;
	            
	            Statement s=con.createStatement();
	            String query="select * from parking_details ORDER BY p_id DESC LIMIT 1 ;";
	            ResultSet rs=s.executeQuery(query);
	            
	            while(rs.next()) {
	                id=rs.getInt("p_id");
	                t=rs.getString("ArrivalDate");
	            }
	        }
		 catch(Exception e) {
			 System.out.println(e);
		 }
		
		JLabel pId = new JLabel("Parking Solt :"+id);
		pId.setForeground(new Color(0, 0, 128));
		pId.setFont(new Font("Times New Roman", Font.BOLD, 22));
		pId.setBackground(Color.WHITE);
		pId.setBounds(43, 108, 340, 31);
		contentPane.add(pId);
		
		JLabel time = new JLabel("Entry Time :"+t);
		time.setForeground(new Color(0, 0, 128));
		time.setFont(new Font("Times New Roman", Font.BOLD, 22));
		time.setBounds(43, 174, 426, 40);
		contentPane.add(time);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomeSecurity obj=new HomeSecurity();
				obj.setVisible(true);
			}
		});
		back.setForeground(new Color(0, 0, 128));
		back.setFont(new Font("Times New Roman", Font.BOLD, 20));
		back.setBounds(53, 265, 124, 31);
		contentPane.add(back);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 849, 66);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Parking");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(302, 10, 204, 43);
		panel.add(lblNewLabel);
	}
}

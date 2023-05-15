package uvpm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Helmet extends JFrame {
	
	Connection con;
    ResultSet rs;


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Helmet frame = new Helmet();
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
	public Helmet() {
		
		con=SqlConnection.ConnectDatabase();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(192, 192, 192));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel hel = new JLabel("Rider Having Helmet");
		hel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		hel.setBounds(99, 127, 259, 56);
		contentPane.add(hel);
		
		JComboBox combo = new JComboBox();
		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String value=combo.getSelectedItem().toString();
				if(value=="YES") {
					try {
	                    
						 String vechileNo=Store.vechileNo;
						 String sName=Store.name2;
		                    String query = "INSERT INTO parking_details (v_no,ArrivalDate,s_name)values('"+vechileNo+"',now(),'"+sName+"' );";
		                    Statement sta = con.createStatement();
		                    int x = sta.executeUpdate(query);
		                    if (x > 0) {
		                        dispose();
		                        AddParking obj=new AddParking();
		       	                obj.setTitle("Vechile Parking Management");
		       	                obj.setVisible(true);
		       	                
		                    } else {
		                        JOptionPane.showMessageDialog(combo,
		                                "NO space available");
		                    }
					 }catch(Exception ea) {
						 System.out.print(ea);
					 }
					
				}
				else {
					JOptionPane.showMessageDialog(combo,
                            "NO Helemt NO parking");
				}
			}
		});
		combo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		combo.setModel(new DefaultComboBoxModel(new String[] {"YES", "NO"}));
		combo.setBounds(339, 149, 62, 21);
		contentPane.add(combo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\motorbike2.png"));
		lblNewLabel.setBounds(330, 266, 341, 197);
		contentPane.add(lblNewLabel);
	}
}

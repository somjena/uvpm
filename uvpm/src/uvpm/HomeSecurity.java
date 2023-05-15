package uvpm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class HomeSecurity extends JFrame {

	private JPanel contentPane;
	private JTextField vNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeSecurity frame = new HomeSecurity();
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
	public HomeSecurity() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 507);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "security home page", TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String name=Store.name;
		JLabel lblNewLabel = new JLabel("Welcome  "+name);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(171, 95, 230, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter vehicle no.");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(171, 152, 151, 25);
		contentPane.add(lblNewLabel_1);
		
		vNo = new JTextField();
		vNo.setBounds(347, 152, 194, 25);
		contentPane.add(vNo);
		vNo.setColumns(10);
		
		JButton submit = new JButton("SUBMIT");
		submit.setForeground(Color.BLUE);
		submit.setBackground(new Color(240, 240, 240));
		submit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Store.vechileNo=vNo.getText();
				dispose();
            	ApplicationStatus obj=new ApplicationStatus();
            	obj.setTitle("Vechile Parking Management");
            	obj.setVisible(true);
            	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	obj.setResizable(true);
			}
		});
		submit.setBounds(279, 225, 126, 23);
		contentPane.add(submit);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\New folder\\MCA 2nd sem\\Java\\uvpm\\src\\uvpm\\img\\policeman.png"));
		lblNewLabel_2.setBounds(30, 108, 131, 140);
		contentPane.add(lblNewLabel_2);
		
		JButton logout = new JButton("Logout");
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
		logout.setForeground(Color.BLUE);
		logout.setFont(new Font("Times New Roman", Font.BOLD, 17));
		logout.setBounds(456, 224, 97, 25);
		contentPane.add(logout);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 850, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Security Page");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setBounds(311, 10, 278, 30);
		panel.add(lblNewLabel_3);
	}
}
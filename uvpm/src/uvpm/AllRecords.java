package uvpm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AllRecords extends JFrame {
	
	Connection con;
    ResultSet rs;

	private JPanel contentPane;
	private JTable table;
	private JTextField txtViewAllRecords;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllRecords frame = new AllRecords();
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
	public AllRecords() {
		
		con=SqlConnection.ConnectDatabase();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 696);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setBounds(10, 73, 615, 203);
		contentPane.add(table);
		
		txtViewAllRecords = new JTextField();
		txtViewAllRecords.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtViewAllRecords.setText("                                VIEW ALL RECORDS");
		txtViewAllRecords.setBounds(74, 37, 503, 19);
		contentPane.add(txtViewAllRecords);
		txtViewAllRecords.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 134, 681, 73);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setBounds(41, 90, 1, 1);
		contentPane.add(table_1);
		scrollPane.setViewportView(table_1);
		
		
		
		try {
			String vechileNo=Store.vechileNo;
			Statement s=con.createStatement();
	        String query="select * from parking_details where v_no='"+vechileNo+"' ;";
	        ResultSet rs=s.executeQuery(query);
		
		    table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception z) {
				System.out.println(z);
			}
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ApplicationStatus obj=new ApplicationStatus();
				obj.setVisible(true);
			}
		});
		btnNewButton.setBounds(246, 331, 115, 21);
		contentPane.add(btnNewButton);
	}
}

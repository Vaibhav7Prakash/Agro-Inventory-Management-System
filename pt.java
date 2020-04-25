import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class pt extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pt frame = new pt();
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
	public pt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"AREA CODE", "AREA NAME", "USERS COUNT"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(122);
		table.getColumnModel().getColumn(1).setPreferredWidth(131);
		table.getColumnModel().getColumn(2).setPreferredWidth(153);
		table.setBounds(215, 103, 442, 105);
		contentPane.add(table);
		
		DefaultTableModel tb=(DefaultTableModel)table.getModel();
		tb.setRowCount(0);
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sqll="Select * from areadetails";
				try
				{
				Class.forName("java.sql.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
				Statement s=con.createStatement();
				ResultSet rs=s.executeQuery(sqll);
				while (rs.next())
				{
					int ac=Integer.parseInt(rs.getString(1));
					String an=rs.getString(2);
					int nou =Integer.parseInt(rs.getString(3));
					
					tb.addRow(new Object[] {ac,an,nou});
				}
				rs.close();
				s.close();
				con.close();
				}
				catch(Exception ex)
				{
				System.out.println(ex);
				}

				
			}
		});

		
		btnView.setBounds(370, 439, 115, 29);
		contentPane.add(btnView);
		
		JLabel lblAreaName = new JLabel("AREA NAME");
		lblAreaName.setBounds(214, 67, 121, 20);
		contentPane.add(lblAreaName);
		
		JLabel lblAreaCode = new JLabel("AREA CODE");
		lblAreaCode.setBounds(370, 67, 99, 20);
		contentPane.add(lblAreaCode);
		
		JLabel lblNoOfUsers = new JLabel("NO OF USERS");
		lblNoOfUsers.setBounds(535, 67, 101, 20);
		contentPane.add(lblNoOfUsers);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new adminhome().setVisible(true);
			}
		});
		btnBack.setBounds(573, 439, 115, 29);
		contentPane.add(btnBack);
	}
}

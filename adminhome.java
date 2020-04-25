import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class adminhome extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnBack;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	static int kzid;
	static String kznam,kzpd,kzrl,kzad,kzpn,kzan;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminhome frame = new adminhome();
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
	public adminhome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnView = new JButton("VIEW ");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tb=(DefaultTableModel)table.getModel();
				tb.setRowCount(0);
				String sql="select * from users";
				try
				{
				Class.forName("java.sql.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
				Statement s=con.createStatement();
				ResultSet rs=s.executeQuery(sql);
				while (rs.next())
				{
					int id=Integer.parseInt(rs.getString(1));
					String nm=rs.getString(2);
					String pswd=rs.getString(3);
					String rl=rs.getString(4);
					String ad=rs.getString(5);
					String phn =rs.getString(6);
					String an=rs.getString(7);
					tb.addRow(new Object[] {id,nm,pswd,rl,ad,phn,an});
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
		btnView.setBounds(53, 596, 115, 29);
		contentPane.add(btnView);
		
		table = new JTable();
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "NAME", "PASSWORD", "ROLE", "ADDRESS", "PHONE", "ACCOUTN NO"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(119);
		table.getColumnModel().getColumn(2).setPreferredWidth(134);
		table.getColumnModel().getColumn(3).setPreferredWidth(105);
		table.getColumnModel().getColumn(4).setPreferredWidth(128);
		table.getColumnModel().getColumn(5).setPreferredWidth(124);
		table.getColumnModel().getColumn(6).setPreferredWidth(136);
		table.setBounds(15, 132, 866, 382);
		contentPane.add(table);
		
		
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
		  public void valueChanged(ListSelectionEvent e) {

		    int selectedRow = table.getSelectedRow();
		    int selectedColumn = table.getSelectedColumn();
		   
		    kzid= (int)(table.getValueAt(selectedRow, 0));
		    kznam = (String)(table.getValueAt(selectedRow, 1));
		    kzpd = (String)table.getValueAt(selectedRow, 2);
		    kzrl = (String)(table.getValueAt(selectedRow, 3));
		    kzad = (String)(table.getValueAt(selectedRow, 4));
		    kzpn = (String)(table.getValueAt(selectedRow, 5));
		    kzan = (String)(table.getValueAt(selectedRow, 6));
		  //  kzad = (String)(table.getValueAt(selectedRow, 4));
		    
		    
		    
		    
		   // System.out.println("Selected: " + selectedData);
		     
		    // =Integer.parseInt(sa[0]);
		    // =Integer.parseInt(sa[1]);
		    // =sa[2];
		    // =Integer.parseInt(sa[3]);
		   //  =Integer.parseInt(sa[4]);
		   //  JOptionPane.showMessageDialog(null, (sa[0]));
		  }

		});

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		btnBack = new JButton("LOGOUT");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new login().setVisible(true);
			}
		});
		btnBack.setBounds(727, 596, 115, 29);
		contentPane.add(btnBack);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new aupd().setVisible(true);
			}
		});
		btnUpdate.setBounds(231, 596, 115, 29);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new adel().setVisible(true);
			}
		});
		btnDelete.setBounds(406, 596, 115, 29);
		contentPane.add(btnDelete);
		
		lblNewLabel = new JLabel("ADMIN PANEL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(366, 16, 195, 38);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(53, 108, 69, 20);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setBounds(155, 108, 69, 20);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("PASSWORD");
		lblNewLabel_3.setBounds(261, 108, 96, 20);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("ROLE");
		lblNewLabel_4.setBounds(391, 108, 69, 20);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("ADDRESS");
		lblNewLabel_5.setBounds(497, 108, 95, 20);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("PHONE");
		lblNewLabel_6.setBounds(633, 108, 69, 20);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("ACCOUTN NO");
		lblNewLabel_7.setBounds(747, 108, 115, 20);
		contentPane.add(lblNewLabel_7);
		
		JButton btnAreaDetails = new JButton("AREA DETAILS");
		btnAreaDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new pt().setVisible(true);
			}
		});
		btnAreaDetails.setBounds(551, 596, 147, 29);
		contentPane.add(btnAreaDetails);
	}
}

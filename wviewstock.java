import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class wviewstock extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wviewstock frame = new wviewstock();
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
	public wviewstock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 719);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStock = new JLabel("STOCK");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblStock.setBounds(411, 59, 179, 20);
		contentPane.add(lblStock);
		
		table = new JTable();
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"GRAIN CODE", "GRAIN NAME", "QUANTITY"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(140);
		table.getColumnModel().getColumn(1).setPreferredWidth(165);
		table.getColumnModel().getColumn(2).setPreferredWidth(143);
		table.setBounds(66, 188, 764, 186);
		contentPane.add(table);
		
		JLabel lblGrainCode = new JLabel("GRAIN CODE");
		lblGrainCode.setBounds(122, 165, 179, 20);
		contentPane.add(lblGrainCode);
		
		JLabel lblGrainName = new JLabel("GRAIN NAME");
		lblGrainName.setBounds(400, 165, 140, 20);
		contentPane.add(lblGrainName);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setBounds(672, 165, 130, 20);
		contentPane.add(lblQuantity);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				new wupd().setVisible(true);
				
				
			}
		});
		btnUpdate.setBounds(98, 423, 115, 29);
		contentPane.add(btnUpdate);
		
		JButton btnViewStock = new JButton("VIEW STOCK");
		btnViewStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel tb=(DefaultTableModel)table.getModel();
				tb.setRowCount(0);
				String sql="select * from wholesalerstock where id="+login.id+"";
				try
				{
				Class.forName("java.sql.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
				Statement s=con.createStatement();
				ResultSet rs=s.executeQuery(sql);
				while (rs.next())
				{
					int gc=Integer.parseInt(rs.getString(2));
					String gn=rs.getString(3);
					int qty =Integer.parseInt(rs.getString(4));
					tb.addRow(new Object[] {gc,gn,qty});
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
		btnViewStock.setBounds(382, 468, 158, 29);
		contentPane.add(btnViewStock);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new wdel().setVisible(true);
			}
		});
		btnDelete.setBounds(98, 513, 115, 29);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new wholesalerhome().setVisible(true);
			}
		});
		btnBack.setBounds(638, 468, 115, 29);
		contentPane.add(btnBack);
		
		JButton btnBuy = new JButton("BUY");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new buy().setVisible(true);
			}
		});
		btnBuy.setBounds(98, 468, 115, 29);
		contentPane.add(btnBuy);
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class fviewstock extends JFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fviewstock frame = new fviewstock();
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
	public fviewstock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 656);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STOCK");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(402, 29, 206, 20);
		getContentPane().add(lblNewLabel);
		
		table = new JTable();
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"GRAIN CODE", "GRAIN NAME", "QUANTITY", "RATE"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(148);
		table.getColumnModel().getColumn(1).setPreferredWidth(173);
		table.getColumnModel().getColumn(2).setPreferredWidth(167);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.setBounds(34, 125, 796, 160);
		getContentPane().add(table);
		
		JButton btnViewStock = new JButton("VIEW STOCK");
		btnViewStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tb=(DefaultTableModel)table.getModel();
				tb.setRowCount(0);
				String sql="select * from farmerstock where id="+login.id+"";
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
					int rt=Integer.parseInt(rs.getString(5));
					tb.addRow(new Object[] {gc,gn,qty,rt});
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
		btnViewStock.setBounds(346, 397, 172, 29);
		getContentPane().add(btnViewStock);
		
		JLabel lblNewLabel_1 = new JLabel("GRAIN CODE");
		lblNewLabel_1.setBounds(71, 100, 132, 20);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("GRAIN NAME");
		lblNewLabel_2.setBounds(265, 100, 116, 20);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("QUANTITY");
		lblNewLabel_3.setBounds(508, 100, 126, 20);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("RATE");
		lblNewLabel_4.setBounds(732, 100, 116, 20);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new farmerhome().setVisible(true);
			}
		});
		btnBack.setBounds(628, 397, 115, 29);
		getContentPane().add(btnBack);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new fupd().setVisible(true);
			}
		});
		btnUpdate.setBounds(71, 358, 115, 29);
		getContentPane().add(btnUpdate);
		
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new fdel().setVisible(true);
			/*	try
				{
					Class.forName("java.sql.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
					Statement s=con.createStatement();
					int gcd=Integer.parseInt(t1.getText());
					String sql="Delete from farmerstock where grain_code="+gcd+" and id="+login.id+"";
					s.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Product Removed.");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					s.close();
					con.close();
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e.getMessage());
				}*/
			}
		});
			
		btnDelete.setBounds(71, 448, 115, 29);
		getContentPane().add(btnDelete);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			new fadd().setVisible(true);
			
			}
		});
		btnAdd.setBounds(71, 403, 115, 29);
		getContentPane().add(btnAdd);
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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

public class wviewprofile extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wviewprofile frame = new wviewprofile();
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
	public wviewprofile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setBounds(94, 147, 69, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("AREA");
		lblNewLabel_1.setBounds(94, 208, 69, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PHONE");
		lblNewLabel_2.setBounds(94, 264, 69, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ACCOUNT NO");
		lblNewLabel_3.setBounds(94, 324, 185, 20);
		contentPane.add(lblNewLabel_3);
		
		t1 = new JTextField();
		t1.setEditable(false);
		t1.setBounds(413, 147, 146, 26);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setEditable(false);
		t2.setBounds(413, 205, 146, 26);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setEditable(false);
		t3.setBounds(413, 261, 146, 26);
		contentPane.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setEditable(false);
		t4.setBounds(413, 321, 146, 26);
		contentPane.add(t4);
		t4.setColumns(10);
		
		JButton btnNewButton = new JButton("VIEW PROFILE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql="select * from users where id="+login.id+"";
				//JOptionPane.showMessageDialog(null, login.id);
				try
				{
				Class.forName("java.sql.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
				Statement s=con.createStatement();
				ResultSet rs=s.executeQuery(sql);
				while (rs.next())
				{
					String nm=rs.getString(2);
					String ar=rs.getString(5);
					String phn=rs.getString(6);
					String acno=rs.getString(7);
					t1.setText(nm);
					t2.setText(ar);
					t3.setText(phn);
					t4.setText(acno);
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
		btnNewButton.setBounds(156, 478, 177, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new wholesalerhome().setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(443, 478, 156, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblProfile = new JLabel("PROFILE");
		lblProfile.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblProfile.setBounds(363, 57, 196, 20);
		contentPane.add(lblProfile);
	}
}

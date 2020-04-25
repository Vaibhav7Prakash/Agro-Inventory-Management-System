import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JPasswordField t2;
	static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		t1 = new JTextField();
		t1.setBounds(528, 179, 146, 26);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JButton btnNewButton = new JButton("LogIn as Admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("java.sql.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
				Statement s=con.createStatement();
				id=Integer.parseInt(t1.getText());
				String admin="admin";
				String sql="select * from users where id='"+t1.getText()+"' and password='"+t2.getText()+"' and role='"+admin+"'";
				ResultSet rs=s.executeQuery(sql);
				if(rs.next())
				{
				JOptionPane.showMessageDialog(null, "Login Successful.");
				dispose();
				new adminhome().setVisible(true);
				}
				else
				{
				JOptionPane.showMessageDialog(null, "Wrong Login Credentials.");
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
		btnNewButton.setBounds(355, 348, 186, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LogIn as Farmer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("java.sql.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
				Statement s=con.createStatement();
				id=Integer.parseInt(t1.getText());
				String sql="select * from users where id='"+t1.getText()+"' and password='"+t2.getText()+"' and role='"+"Farmer"+"'";
				ResultSet rs=s.executeQuery(sql);
				if(rs.next())
				{
				JOptionPane.showMessageDialog(null, "Login Successful.");
				dispose();
				new farmerhome().setVisible(true);
				}
				else
				{
				JOptionPane.showMessageDialog(null, "Wrong Login Credentials.");
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
		btnNewButton_1.setBounds(131, 348, 160, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("LogIn as Wholesaler");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("java.sql.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
				Statement s=con.createStatement();
				id=Integer.parseInt(t1.getText());
				String sql="select * from users where id="+t1.getText()+" and password='"+t2.getText()+"' and role='"+"Wholesaler"+"'";
				ResultSet rs=s.executeQuery(sql);
				if(rs.next())
				{
				JOptionPane.showMessageDialog(null, "Login Successful.");
				dispose();
				new wholesalerhome().setVisible(true);
				}
				else
				{
				JOptionPane.showMessageDialog(null, "Wrong Login Credentials.");
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
		btnNewButton_2.setBounds(607, 348, 186, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnClear = new JButton("RESET");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t1.setText("");
				t2.setText("");
			}
		});
		btnClear.setBounds(275, 470, 115, 29);
		contentPane.add(btnClear);
		
		JLabel lblNewLabel = new JLabel("ENTER YOUR ID");
		lblNewLabel.setBounds(210, 182, 173, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER PASSWORD");
		lblNewLabel_1.setBounds(210, 247, 160, 20);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("SIGN UP");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Signup().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(426, 470, 115, 29);
		contentPane.add(btnNewButton_3);
		
		t2 = new JPasswordField();
		t2.setBounds(528, 244, 146, 26);
		contentPane.add(t2);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLogIn.setBounds(381, 59, 193, 20);
		contentPane.add(lblLogIn);
	}
}

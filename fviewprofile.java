import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
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
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class fviewprofile extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fviewprofile frame = new fviewprofile();
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
	public fviewprofile() {
		getContentPane().setLayout(null);
		
	/*	JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setBounds(45, 36, 124, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("AREA");
		lblNewLabel_1.setBounds(55, 72, 69, 20);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PHONE");
		lblNewLabel_2.setBounds(45, 108, 69, 20);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ACCOUNT NUMBER");
		lblNewLabel_3.setBounds(45, 144, 162, 20);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ACCOUNT BALANCE");
		lblNewLabel_4.setBounds(45, 184, 172, 20);
		getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(219, 33, 146, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(219, 69, 146, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(219, 105, 146, 26);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(222, 141, 146, 26);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(219, 181, 146, 26);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
	*/	
		try
		{
		Class.forName("java.sql.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
		Statement s=con.createStatement();
		s.close();
		con.close();
		}
		catch(Exception ex)
		{
		System.out.println(ex);
		}
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setBounds(138, 136, 69, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("AREA");
		lblNewLabel_1.setBounds(138, 188, 69, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PHONE");
		lblNewLabel_2.setBounds(138, 238, 69, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ACCOUNT NO");
		lblNewLabel_3.setBounds(112, 285, 117, 20);
		contentPane.add(lblNewLabel_3);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new farmerhome().setVisible(true);
			}
		});
		btnBack.setBounds(373, 513, 115, 29);
		contentPane.add(btnBack);
		
		t1 = new JTextField();
		t1.setEditable(false);
		t1.setBounds(396, 133, 146, 26);
		contentPane.add(t1);
		t1.setColumns(10);
		//String sql="select name from users where id= "
		
		
		t2 = new JTextField();
		t2.setEditable(false);
		t2.setBounds(396, 185, 146, 26);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setEditable(false);
		t3.setBounds(396, 235, 146, 26);
		contentPane.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setEditable(false);
		t4.setBounds(396, 282, 146, 26);
		contentPane.add(t4);
		t4.setColumns(10);
		
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
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
				//dispose();
				//new fviewstock().setVisible(true);
			}
		});
		btnView.setBounds(373, 432, 115, 29);
		contentPane.add(btnView);
		
		JLabel lblProfile = new JLabel("PROFILE");
		lblProfile.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblProfile.setBounds(342, 55, 160, 20);
		contentPane.add(lblProfile);
	}
}

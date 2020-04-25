import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JPasswordField;
public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;

	public String username;
	public String accountno;
	static int idd;
	private JPasswordField t5;
	private JPasswordField t6;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(87, 68, 100, 20);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("ADDRESS");
		lblNewLabel.setBounds(87, 104, 115, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PHONE");
		lblNewLabel_1.setBounds(87, 158, 69, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ROLE");
		lblNewLabel_2.setBounds(87, 194, 69, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ACCOUNT NO");
		lblNewLabel_3.setBounds(87, 230, 115, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PASSWORD");
		lblNewLabel_4.setBounds(87, 276, 130, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CONFIRM PASSWORD");
		lblNewLabel_5.setBounds(87, 324, 172, 20);
		contentPane.add(lblNewLabel_5);
		
		t1 = new JTextField();
		t1.setBounds(307, 65, 146, 26);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(307, 104, 146, 26);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(307, 155, 146, 26);
		contentPane.add(t3);
		t3.setColumns(10);
		
		JComboBox cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] {"-select-", "Farmer", "Wholesaler"}));
		cb1.setBounds(307, 191, 189, 26);
		contentPane.add(cb1);
		
		t4 = new JTextField();
		t4.setBounds(307, 227, 146, 26);
		contentPane.add(t4);
		t4.setColumns(10);
		
		 
		
		JButton btnRegister = new JButton("register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("java.sql.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
				Statement s=con.createStatement();
				 username=t1.getText();
				String address=t2.getText();
				String phone=t3.getText();
				if (phone.length()!= 10) 
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid 10 digit number!!!");
					t3.setText("");
					return;
				}
				
				String role=(String)cb1.getSelectedItem();
				 accountno=t4.getText();
				String password=t5.getText();
				String cpassword=t6.getText();
				if (!(password.equals(cpassword)))
				{
					JOptionPane.showMessageDialog(null, "Please confirm with the original password!!!");
					t5.setText("");
					t6.setText("");
					return;
				}
				//Random rand=new Random(1000);
				 int ac=0,bal=10000;
				String sql="insert into users set name='"+(username)+"',address='"+(address)+"',phone='"+(phone)+"',role='"+(role)+"',accountno='"+(accountno)+"',password='"+(password)+"'";
				s.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "successful insertion");
				String rl=role.toLowerCase();
				String x=rl+"details";
				
				//JOptionPane.showMessageDialog(null, x);
				String sql5="Select area_code from areadetails where address='"+(address)+"'";
				ResultSet rss =s.executeQuery(sql5);
				while (rss.next())
				{
					 ac=Integer.parseInt(rss.getString(1));
					
				}
				rss.close();
				String sql6="Select id from users where name='"+(username)+"' and accountno='"+(accountno)+"'";
				ResultSet rsd =s.executeQuery(sql6);
				while (rsd.next())
				{
					 idd=Integer.parseInt(rsd.getString(1));
					
				}
				rsd.close();
				if (role.equals("Wholesaler"))
				{
				String sql1="insert into "+x+" set id="+(idd)+" , area_code="+(ac)+",waccount_number='"+(accountno)+"',waccount_balance="+(bal)+" ";
				s.executeUpdate(sql1);
				
				}
				else
				{
					String sql9="insert into "+x+" set id="+(idd)+" , area_code="+(ac)+",faccount_number='"+(accountno)+"' ,faccount_balance="+(bal)+"";
					s.executeUpdate(sql9);
				}
				s.close();
				con.close();
				dispose();
				new disp().setVisible(true);
		}
				catch(Exception ex)
				{
				System.out.println(ex);
				}
			}
		});
		
		
		btnRegister.setBounds(223, 428, 115, 29);
		contentPane.add(btnRegister);
		
		JButton btnClear = new JButton("clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t1.setText("");
				t2.setText("");

				t3.setText("");
				cb1.setSelectedIndex(0);

				t4.setText("");

				t5.setText("");

				t6.setText("");

			}
		});
		btnClear.setBounds(417, 428, 115, 29);
		contentPane.add(btnClear);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new login().setVisible(true);
			}
		});
		btnBack.setBounds(615, 428, 115, 29);
		contentPane.add(btnBack);
		
		JLabel lblSignUp = new JLabel("SIGN UP");
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSignUp.setBounds(324, 16, 172, 20);
		contentPane.add(lblSignUp);
		
		t5 = new JPasswordField();
		t5.setBounds(307, 273, 146, 26);
		contentPane.add(t5);
		
		t6 = new JPasswordField();
		t6.setBounds(307, 321, 146, 26);
		contentPane.add(t6);
	}
}

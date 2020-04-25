import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class aupd extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aupd frame = new aupd();
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
	public aupd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(132, 182, 69, 20);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(117, 230, 117, 20);
		contentPane.add(lblPassword);
		
		JLabel lblRole = new JLabel("ROLE");
		lblRole.setBounds(132, 272, 69, 20);
		contentPane.add(lblRole);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setBounds(117, 308, 117, 20);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setBounds(132, 354, 69, 20);
		contentPane.add(lblPhone);
		
		JLabel lblAccountNo = new JLabel("ACCOUNT NO");
		lblAccountNo.setBounds(117, 401, 117, 20);
		contentPane.add(lblAccountNo);
		
		t1 = new JTextField();
		t1.setEditable(false);
		t1.setBounds(333, 77, 146, 4);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(401, 182, 146, 26);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(401, 227, 146, 26);
		contentPane.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setEditable(false);
		t4.setBounds(401, 269, 146, 26);
		contentPane.add(t4);
		t4.setColumns(10);
		
		t5 = new JTextField();
		t5.setBounds(401, 305, 146, 26);
		contentPane.add(t5);
		t5.setColumns(10);
		
		t6 = new JTextField();
		t6.setBounds(401, 351, 146, 26);
		contentPane.add(t6);
		t6.setColumns(10);
		
		t7 = new JTextField();
		t7.setEditable(false);
		t7.setBounds(401, 398, 146, 26);
		contentPane.add(t7);
		t7.setColumns(10);
		t2.setText(adminhome.kznam);
		t3.setText(adminhome.kzpd);
		t4.setText(adminhome.kzrl);
		t5.setText(adminhome.kzad);
		t6.setText(adminhome.kzpn);
		t7.setText(adminhome.kzan);
		
		
		
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					Class.forName("java.sql.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
					Statement s=con.createStatement();
					int idgxc=Integer.parseInt(t1.getText());
					String namgxc=(t2.getText());
					String pasgxc=(t3.getText());
					String adrgxc=(t5.getText());
					String phngxc=(t6.getText());
					String angxc=(t7.getText());
					//int balagxc=Integer.parseInt(t8.getText());
					String sql="update users set name='"+namgxc+"' ,password='"+pasgxc+"' , address='"+adrgxc+"', phone='"+phngxc+"', accountno='"+angxc+"' where id="+idgxc+" ";
					s.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Profile Updated.");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t6.setText("");
					t7.setText("");
					//t8.setText("");
					s.close();
					con.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
				
				
				
		btnUpdate.setBounds(289, 568, 115, 29);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new adminhome().setVisible(true);
			}
		});
		btnBack.setBounds(480, 568, 115, 29);
		contentPane.add(btnBack);
		
		JLabel lblUpdateUserDetails = new JLabel("UPDATE USER DETAILS");
		lblUpdateUserDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUpdateUserDetails.setBounds(282, 51, 273, 20);
		contentPane.add(lblUpdateUserDetails);
	}
}

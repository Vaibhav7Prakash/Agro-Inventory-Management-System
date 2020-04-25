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

public class adel extends JFrame {

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
					adel frame = new adel();
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
	public adel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(122, 124, 69, 20);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(122, 170, 69, 20);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(122, 222, 109, 20);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("ROLE");
		lblNewLabel.setBounds(122, 271, 69, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setBounds(122, 317, 109, 20);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setBounds(122, 366, 69, 20);
		contentPane.add(lblPhone);
		
		JLabel lblAccountNo = new JLabel("ACCOUNT NO");
		lblAccountNo.setBounds(122, 410, 142, 20);
		contentPane.add(lblAccountNo);
		
		t1 = new JTextField();
		t1.setBounds(365, 121, 146, 26);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(365, 167, 146, 26);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(365, 219, 146, 26);
		contentPane.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(365, 268, 146, 26);
		contentPane.add(t4);
		t4.setColumns(10);
		
		t5 = new JTextField();
		t5.setBounds(365, 314, 146, 26);
		contentPane.add(t5);
		t5.setColumns(10);
		
		t6 = new JTextField();
		t6.setBounds(365, 363, 146, 26);
		contentPane.add(t6);
		t6.setColumns(10);
		
		t7 = new JTextField();
		t7.setBounds(365, 407, 146, 26);
		contentPane.add(t7);
		t7.setColumns(10);
		t1.setText(String.valueOf(adminhome.kzid));
		t2.setText(adminhome.kznam);
		t3.setText(adminhome.kzpd);
		t4.setText(adminhome.kzrl);
		t5.setText(adminhome.kzad);
		t6.setText(adminhome.kzpn);
		t7.setText(adminhome.kzan);
		
		
		
		
		
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					String ro="";
					Class.forName("java.sql.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
					Statement s=con.createStatement();
					int idgxc=Integer.parseInt(t1.getText());
				//	JOptionPane.showMessageDialog(null,""+idgxc+"");
					String r="select role from users where id="+idgxc+"";
					ResultSet rr=s.executeQuery(r);
				    while (rr.next())
				    {
				    	 ro=rr.getString(1);
				    }
				    if(ro.equals("Farmer"))
					{
				    	String sql8="delete from farmerstock where id="+idgxc+"";
				    	String sql9="delete from farmerdetails where id="+idgxc+"";
						String sql="delete from  users  where id="+idgxc+" ";
						s.executeUpdate(sql9);
						s.executeUpdate(sql8);
						s.executeUpdate(sql);
					}
				    else
				    {
				    	String sql8="delete from wholesalerstock where id="+idgxc+"";
				    	String sql9="delete from wholesalerdetails where id="+idgxc+"";
						String sql="delete from  users  where id="+idgxc+" ";
						s.executeUpdate(sql9);
						s.executeUpdate(sql8);
						s.executeUpdate(sql);
				    }
					
					JOptionPane.showMessageDialog(null,"Deletion Done.");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t6.setText("");
					t7.setText("");
					s.close();
					con.close();
				
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
				
			}
		});
				
				
			
		btnDelete.setBounds(215, 516, 115, 29);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new adminhome().setVisible(true);
			}
		});
		btnBack.setBounds(547, 516, 115, 29);
		contentPane.add(btnBack);
		
		JLabel lblDelete = new JLabel("DELETE");
		lblDelete.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDelete.setBounds(356, 47, 176, 20);
		contentPane.add(lblDelete);
	}
}

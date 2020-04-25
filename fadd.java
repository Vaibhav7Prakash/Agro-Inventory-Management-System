import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class fadd extends JFrame {

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
					fadd frame = new fadd();
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
	public fadd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 732);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddItem = new JLabel("ADD ITEM");
		lblAddItem.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAddItem.setBounds(398, 74, 187, 46);
		contentPane.add(lblAddItem);
		
		JLabel lblEnterGrainCode = new JLabel("ENTER GRAIN CODE");
		lblEnterGrainCode.setBounds(89, 185, 187, 46);
		contentPane.add(lblEnterGrainCode);
		
		JLabel lblEnterGrainName = new JLabel("ENTER GRAIN NAME");
		lblEnterGrainName.setBounds(89, 266, 178, 20);
		contentPane.add(lblEnterGrainName);
		
		JLabel lblEnterQuantity = new JLabel("ENTER QUANTITY");
		lblEnterQuantity.setBounds(89, 336, 187, 20);
		contentPane.add(lblEnterQuantity);
		
		JLabel lblEnterRate = new JLabel("ENTER RATE");
		lblEnterRate.setBounds(89, 402, 163, 20);
		contentPane.add(lblEnterRate);
		
		t1 = new JTextField();
		t1.setBounds(366, 195, 199, 26);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(367, 263, 198, 26);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(366, 333, 146, 26);
		contentPane.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(366, 399, 146, 26);
		contentPane.add(t4);
		t4.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("java.sql.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
					Statement s=con.createStatement();
					int code=Integer.parseInt(t1.getText());
					String gname=t2.getText();
					int q=Integer.parseInt(t3.getText());
					int r=Integer.parseInt(t4.getText());
				//	String sqll="select ";
					String sql1="insert into farmerstock values ("+(login.id)+","+(code)+",'"+(gname)+"',"+(q)+","+(r)+")";
					s.executeUpdate(sql1);
					JOptionPane.showMessageDialog(null,"Insert Successful");
				}
				catch(Exception ex)
				{
					
					System.out.println(ex);
				}
				dispose();
				new fviewstock().setVisible(true);
			}
		});
		btnAdd.setBounds(398, 511, 115, 29);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new fviewstock().setVisible(true);
			}
		});
		btnBack.setBounds(398, 588, 115, 29);
		contentPane.add(btnBack);
	}

}

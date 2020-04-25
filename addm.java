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

public class addm extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addm frame = new addm();
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
	public addm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterUpiId = new JLabel("ENTER UPI ID");
		lblEnterUpiId.setBounds(160, 168, 181, 20);
		contentPane.add(lblEnterUpiId);
		
		JLabel lblAddMoney = new JLabel("ADD MONEY");
		lblAddMoney.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAddMoney.setBounds(348, 63, 181, 20);
		contentPane.add(lblAddMoney);
		
		t1 = new JTextField();
		t1.setBounds(431, 165, 146, 26);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("ENTER PASSWORD");
		lblEnterPassword.setBounds(149, 234, 146, 20);
		contentPane.add(lblEnterPassword);
		
		t2 = new JTextField();
		t2.setBounds(431, 231, 146, 26);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JLabel lblEnterAmount = new JLabel("ENTER AMOUNT");
		lblEnterAmount.setBounds(160, 309, 136, 20);
		contentPane.add(lblEnterAmount);
		
		t3 = new JTextField();
		t3.setBounds(431, 306, 146, 26);
		contentPane.add(t3);
		t3.setColumns(10);
		
		//String upi=t1.getText();
	
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=Integer.parseInt(t3.getText());
				try
				{
				Class.forName("java.sql.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
				Statement s=con.createStatement();
				String st="update wholesalerdetails set waccount_balance = (waccount_balance + "+a+") where id="+login.id+"";
				s.executeUpdate(st);
				JOptionPane.showMessageDialog(null,"Rs "+a+" added to your wallet!!!");
				dispose();
				new wholesalerhome().setVisible(true);
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}		
				
				
				
			}
		});
		btnAdd.setBounds(341, 419, 115, 29);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new wholesalerhome().setVisible(true);
			}
		});
		btnBack.setBounds(341, 483, 115, 29);
		contentPane.add(btnBack);
	}

}

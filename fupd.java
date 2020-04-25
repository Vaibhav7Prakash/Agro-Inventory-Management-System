import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;

public class fupd extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblGrainName;
	private JLabel lblQuantity;
	private JLabel lblRate;
	static int gc;
	private JLabel lblGrainCode;
	private JLabel lblUpdate;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fupd frame = new fupd();
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
	public fupd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList lb1 = new JList();
		lb1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lb1.setBounds(593, 131, 115, 224);
		contentPane.add(lb1);
		
		//
		
		
		
		lb1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				String a=lb1.getSelectedValue().toString();
				int b=Integer.parseInt(a);
				String sql1="Select grain_code,grain_name,f_qty,f_rate from farmerstock where grain_code="+b+" and id="+login.id+"";
					try
					{
						Class.forName("java.sql.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
						Statement s=con.createStatement();
						ResultSet rs=s.executeQuery(sql1);
						while(rs.next())
						{
							
							
							
							int gc=rs.getInt(1);
							String gn=rs.getString(2);
							int fq=rs.getInt(3);
							int fr=rs.getInt(4);
							t1.setText(""+gc);
							t2.setText(""+gn);
							t3.setText(""+fq);
							t4.setText(""+fr);
						}
						rs.close();
						s.close();
						con.close();
					}
					catch(Exception e)
					{
						//JOptionPane.showMessageDialog(null,e.getMessage());
						System.out.println(e);
					}
				
			}
		});
		
		
		
		
		
		
		//
		
		JButton btnNewButton = new JButton("LOAD GRAIN CODE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultListModel lb=new DefaultListModel();
				String sql="Select grain_code from farmerstock where id="+login.id+"";
				try
				{
					Class.forName("java.sql.Driver");
				//	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retail?useSSL=false","root","tushar");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
					Statement s=con.createStatement();
					ResultSet rs=s.executeQuery(sql);
					while(rs.next())
					{
						int gc=rs.getInt(1);
						int ramu=gc;
						//String gn=rs.getString(3);
						//int fq=rs.getInt(4);
						//int fr=rs.getInt(5);
						lb.addElement(gc);
						lb1.setModel(lb);
					}
					rs.close();
					s.close();
					con.close();
				}
				catch(Exception ex)
				{
					//JOptionPane.showMessageDialog(null,ex.getMessage());
					System.out.println(ex);
				}
						
					}
				});
				
				
				
			
		btnNewButton.setBounds(133, 209, 218, 29);
		contentPane.add(btnNewButton);
		
	
		
		t1 = new JTextField();
		t1.setBounds(102, 451, 146, 26);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(305, 451, 146, 26);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(499, 451, 146, 26);
		contentPane.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(714, 451, 146, 26);
		contentPane.add(t4);
		t4.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				
				try
				{
					Class.forName("java.sql.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
					Statement s=con.createStatement();
					int gxc=Integer.parseInt(t1.getText());
					int gqu=Integer.parseInt(t3.getText());
					int gru=Integer.parseInt(t4.getText());
					String sql="update farmerstock set f_qty="+gqu+", f_rate="+gru+" where grain_code="+(gxc)+" and id="+login.id+"";
					s.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Product Updated.");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					s.close();
					con.close();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
				
				
				
			
		btnUpdate.setBounds(269, 549, 115, 29);
		contentPane.add(btnUpdate);
		
		btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new fviewstock().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(569, 549, 115, 29);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("GRAIN CODE");
		lblNewLabel.setBounds(118, 430, 130, 20);
		contentPane.add(lblNewLabel);
		
		lblGrainName = new JLabel("GRAIN NAME");
		lblGrainName.setBounds(320, 430, 109, 20);
		contentPane.add(lblGrainName);
		
		lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setBounds(526, 430, 119, 20);
		contentPane.add(lblQuantity);
		
		lblRate = new JLabel("RATE");
		lblRate.setBounds(753, 430, 69, 20);
		contentPane.add(lblRate);
		
		lblGrainCode = new JLabel("GRAIN CODE");
		lblGrainCode.setBounds(599, 108, 119, 20);
		contentPane.add(lblGrainCode);
		
		lblUpdate = new JLabel("UPDATE");
		lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblUpdate.setBounds(400, 52, 130, 20);
		contentPane.add(lblUpdate);
		
	}
}

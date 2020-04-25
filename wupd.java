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
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class wupd extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	int mtr;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wupd frame = new wupd();
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
	public wupd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 714);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList lb1 = new JList();
		lb1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lb1.setBounds(531, 106, 219, 272);
		contentPane.add(lb1);
		
		
		lb1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				String a=lb1.getSelectedValue().toString();
				int b=Integer.parseInt(a);
				String sql1="Select grain_code,grain_name,w_qty from wholesalerstock where grain_code="+b+" and id="+login.id+"";
					try
					{
						Class.forName("java.sql.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
						Statement s=con.createStatement();
						ResultSet rs=s.executeQuery(sql1);
						while(rs.next())
						{
							
							
							
							  int fgc=rs.getInt(1);
							  mtr=fgc;
							String gn=rs.getString(2);
							int fq=rs.getInt(3);
							
							t1.setText(""+fgc);
							t2.setText(""+gn);
							t3.setText(""+fq);
							
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
		
		
		
		
		JButton btnNewButton = new JButton("LOAD GRAIN CODE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultListModel lb=new DefaultListModel();
				String sql="Select grain_code from wholesalerstock where id="+login.id+"";
				try
				{
					Class.forName("java.sql.Driver");
				//	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/retail?useSSL=false","root","tushar");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
					Statement s=con.createStatement();
					ResultSet rs=s.executeQuery(sql);
					while(rs.next())
					{
						int fgc=rs.getInt(1);
						//String gn=rs.getString(3);
						//int fq=rs.getInt(4);
						//int fr=rs.getInt(5);
						lb.addElement(fgc);
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
		btnNewButton.setBounds(118, 216, 206, 29);
		contentPane.add(btnNewButton);
		
		
		
		t1 = new JTextField();
		t1.setEditable(false);
		t1.setBounds(148, 451, 146, 26);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setEditable(false);
		t2.setBounds(386, 451, 146, 26);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(604, 451, 146, 26);
		contentPane.add(t3);
		t3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new wviewstock().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(515, 535, 115, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					Class.forName("java.sql.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
					Statement s=con.createStatement();
					int gqu=Integer.parseInt(t3.getText());
					
					String sql="update wholesalerstock set w_qty="+gqu+" where grain_code="+(mtr)+" and id="+(login.id)+"";
					s.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Quantity Updated.");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					
					s.close();
					con.close();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
				
				
				
			}
		});
		btnUpdate.setBounds(280, 535, 115, 29);
		contentPane.add(btnUpdate);
		
		JLabel lblUpdate = new JLabel("UPDATE");
		lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblUpdate.setBounds(369, 47, 202, 20);
		contentPane.add(lblUpdate);
		
		JLabel lblGrainCode = new JLabel("GRAIN CODE");
		lblGrainCode.setBounds(176, 426, 118, 20);
		contentPane.add(lblGrainCode);
		
		JLabel lblGrainName = new JLabel("GRAIN NAME");
		lblGrainName.setBounds(411, 426, 97, 20);
		contentPane.add(lblGrainName);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setBounds(636, 426, 102, 20);
		contentPane.add(lblQuantity);
		
		JLabel lblGrainCode_1 = new JLabel("GRAIN CODE");
		lblGrainCode_1.setBounds(593, 80, 107, 20);
		contentPane.add(lblGrainCode_1);
	}
}

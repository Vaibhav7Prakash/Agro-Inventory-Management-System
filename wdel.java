import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class wdel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wdel frame = new wdel();
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
	public wdel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList lb1 = new JList();
		lb1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lb1.setBounds(562, 121, 167, 251);
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



						int gc=rs.getInt(1);
						String gn=rs.getString(2);
						int wq=rs.getInt(3);
						
						textField.setText(""+gc);
						textField_1.setText(""+gn);
						textField_2.setText(""+wq);
						
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
		
		
		
		
		JButton btnLoadGrainCode = new JButton("LOAD GRAIN CODE");
		btnLoadGrainCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultListModel lb=new DefaultListModel();
				String sql="Select grain_code from wholesalerstock where id="+login.id+"";
				try
				{
					Class.forName("java.sql.Driver");

					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
					Statement s=con.createStatement();
					ResultSet rs=s.executeQuery(sql);
					while(rs.next())
					{
						int gc=rs.getInt(1);
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
		btnLoadGrainCode.setBounds(148, 238, 199, 29);
		contentPane.add(btnLoadGrainCode);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(118, 433, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(354, 433, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(583, 433, 146, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Class.forName("java.sql.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
					Statement s=con.createStatement();
					int gcdd=Integer.parseInt(textField.getText());
					//	int gru=Integer.parseInt(t4.getText());

					
					String sql="Delete from wholesalerstock where grain_code="+gcdd+" and id= "+login.id+"";
					s.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Product Deleted.");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					
					s.close();
					con.close();
				}
				catch(Exception exa)
				{
					System.out.println(exa);

				}
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(244, 530, 115, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new wviewstock().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(500, 530, 115, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblGrainCode = new JLabel("GRAIN CODE");
		lblGrainCode.setBounds(137, 408, 113, 20);
		contentPane.add(lblGrainCode);
		
		JLabel lblGrainName = new JLabel("GRAIN NAME");
		lblGrainName.setBounds(375, 408, 110, 20);
		contentPane.add(lblGrainName);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setBounds(614, 408, 115, 20);
		contentPane.add(lblQuantity);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(583, 332, 132, -248);
		contentPane.add(scrollPane);
		
		JLabel lblDelete = new JLabel("DELETE");
		lblDelete.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDelete.setBounds(375, 41, 144, 20);
		contentPane.add(lblDelete);
		
		JLabel lblGrainCode_1 = new JLabel("GRAIN CODE");
		lblGrainCode_1.setBounds(583, 97, 115, 20);
		contentPane.add(lblGrainCode_1);
	}
}

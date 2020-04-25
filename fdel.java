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
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;

public class fdel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton_1;
	private JLabel lblGrainCode;
	private JLabel lblGrainName;
	private JLabel lblQuantity;
	private JLabel lblRate;
	private JLabel lblDelete;
	private JLabel lblGrainCode_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fdel frame = new fdel();
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
	public fdel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JList lb1 = new JList();
		lb1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lb1.setBounds(649, 125, 126, 246);
		contentPane.add(lb1);



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
						textField.setText(""+gc);
						textField_1.setText(""+gn);
						textField_2.setText(""+fq);
						textField_3.setText(""+fr);
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
					public void actionPerformed(ActionEvent e) {

						DefaultListModel lb=new DefaultListModel();
						String sql="Select grain_code from farmerstock where id="+login.id+"";
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
				btnLoadGrainCode.setBounds(118, 240, 254, 29);
				contentPane.add(btnLoadGrainCode);



				textField = new JTextField();
				textField.setEditable(false);
				textField.setBounds(98, 473, 146, 26);
				contentPane.add(textField);
				textField.setColumns(10);

				textField_1 = new JTextField();
				textField_1.setEditable(false);
				textField_1.setBounds(306, 473, 146, 26);
				contentPane.add(textField_1);
				textField_1.setColumns(10);

				textField_2 = new JTextField();
				textField_2.setEditable(false);
				textField_2.setBounds(510, 473, 146, 26);
				contentPane.add(textField_2);
				textField_2.setColumns(10);

				textField_3 = new JTextField();
				textField_3.setEditable(false);
				textField_3.setBounds(698, 473, 146, 26);
				contentPane.add(textField_3);
				textField_3.setColumns(10);

				JButton btnNewButton = new JButton("DELETE");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						//

						try
						{
							JOptionPane.showMessageDialog(null,"");
							Class.forName("java.sql.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
							Statement s=con.createStatement();
							int gcdd=Integer.parseInt(textField.getText());
							//	int gru=Integer.parseInt(t4.getText());

							
							String sql="Delete from farmerstock where grain_code="+gcdd+" and id= "+login.id+"";
							s.executeUpdate(sql);
							JOptionPane.showMessageDialog(null,"Product Deleted.");
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							s.close();
							con.close();
						}
						catch(Exception exa)
						{
							System.out.println(exa);

						}
						//		
					}

				});
				btnNewButton.setBounds(242, 556, 115, 29);
				contentPane.add(btnNewButton);

				JButton btnBack = new JButton("BACK");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						new fviewstock().setVisible(true);
					}
				});
				btnBack.setBounds(524, 556, 115, 29);
				contentPane.add(btnBack);
				
				lblGrainCode = new JLabel("GRAIN CODE");
				lblGrainCode.setBounds(115, 447, 129, 20);
				contentPane.add(lblGrainCode);
				
				lblGrainName = new JLabel("GRAIN NAME");
				lblGrainName.setBounds(331, 447, 111, 20);
				contentPane.add(lblGrainName);
				
				lblQuantity = new JLabel("QUANTITY");
				lblQuantity.setBounds(541, 447, 115, 20);
				contentPane.add(lblQuantity);
				
				lblRate = new JLabel("RATE");
				lblRate.setBounds(729, 447, 69, 20);
				contentPane.add(lblRate);
				
				lblDelete = new JLabel("DELETE");
				lblDelete.setFont(new Font("Tahoma", Font.BOLD, 24));
				lblDelete.setBounds(383, 51, 139, 20);
				contentPane.add(lblDelete);
				
				lblGrainCode_1 = new JLabel("GRAIN CODE");
				lblGrainCode_1.setBounds(665, 100, 96, 20);
				contentPane.add(lblGrainCode_1);
			}
}

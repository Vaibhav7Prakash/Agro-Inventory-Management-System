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
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;

public class buy extends JFrame {

	private JPanel contentPane;
	private JTable table;
    public int isd;
     static int zid;
	 static int zqty;
	 static int zrt;
	 static int zgc;
   static String zgn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buy frame = new buy();
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
	public buy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList lb1 = new JList();
		lb1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lb1.setBounds(581, 81, 181, 195);
		contentPane.add(lb1);
		
		JButton btnLoadAreaCode = new JButton("LOAD AREA CODE");
		btnLoadAreaCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultListModel lb=new DefaultListModel();
				String sql="Select area_code from areadetails";
				try
				{
					Class.forName("java.sql.Driver");
				
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
					Statement s=con.createStatement();
					ResultSet rs=s.executeQuery(sql);
					while(rs.next())
					{
						int gc=rs.getInt(1);
						isd=gc;
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
		
		
		table = new JTable();
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Farmer Id", "Grain Code", "Grain Name", "Quantity", "Rate"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(122);
		table.getColumnModel().getColumn(1).setPreferredWidth(114);
		table.getColumnModel().getColumn(2).setPreferredWidth(136);
		table.getColumnModel().getColumn(3).setPreferredWidth(107);
		table.setBounds(112, 344, 674, 205);
		contentPane.add(table);
		
		
		
		
		lb1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				DefaultTableModel tb=(DefaultTableModel)table.getModel();
				tb.setRowCount(0);
				String a=lb1.getSelectedValue().toString();
				int b=Integer.parseInt(a);
				//JOptionPane.showMessageDialog(null,""+b+"");
				String sql1="Select * from farmerstock where id in (select id from farmerdetails where area_code="+(b)+")";
					try
					{
						Class.forName("java.sql.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
						Statement s=con.createStatement();
						ResultSet rs=s.executeQuery(sql1);
						while(rs.next())
						{
							
							int ir=rs.getInt(1);
							int gcc=rs.getInt(2);
							String gnn=rs.getString(3);
							int qq=rs.getInt(4);
							int rr=rs.getInt(5);
							tb.addRow(new Object[] {ir,gcc,gnn,qq,rr});
							
							
							
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
		
//		class MyListSelectionListener implements ListSelectionListener{
//			public void valueChanged(ListSelectionEvent e) {
//				int row=table.getSelectedRow();
//				int col=table.getSelectedColumn();
//				JOptionPane.showMessageDialog(null, "row"+row+"\t"+col);
//			}
//		};
		
		
	/*	ListSelectionModel cellSelectionModel = table.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
		  public void valueChanged(ListSelectionEvent e) {

		    int selectedRow = table.getSelectedRow();
		    int selectedColumn = table.getSelectedColumn();

		    int selectedData = (int)table.getValueAt(selectedRow, selectedColumn);
		   // System.out.println("Selected: " + selectedData);
		    
		  }

		});*/
		
		
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
		  public void valueChanged(ListSelectionEvent e) {

		    int selectedRow = table.getSelectedRow();
		    int selectedColumn = table.getSelectedColumn();
		   
		    zid= (int)(table.getValueAt(selectedRow, 0));
		    zgc = (int)(table.getValueAt(selectedRow, 1));
		    zgn = (String)table.getValueAt(selectedRow, 2);
		    zqty = (int)(table.getValueAt(selectedRow, 3));
		    zrt = (int)(table.getValueAt(selectedRow, 4));
		    
		    
		    
		    
		   // System.out.println("Selected: " + selectedData);
		     
		    // =Integer.parseInt(sa[0]);
		    // =Integer.parseInt(sa[1]);
		    // =sa[2];
		    // =Integer.parseInt(sa[3]);
		   //  =Integer.parseInt(sa[4]);
		   //  JOptionPane.showMessageDialog(null, (sa[0]));
		  }

		});
		
		
		
		
		
		
		
		
		
		btnLoadAreaCode.setBounds(177, 167, 173, 29);
		contentPane.add(btnLoadAreaCode);
		
		
		
		
		
		JButton btnBuy = new JButton("BUY");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				new buycard().setVisible(true);
			}
		});
		btnBuy.setBounds(222, 584, 115, 29);
		contentPane.add(btnBuy);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new wviewstock().setVisible(true);
			}
		});
		btnBack.setBounds(529, 584, 115, 29);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("GRAIN CODE");
		lblNewLabel.setBounds(278, 319, 96, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GRAIN NAME");
		lblNewLabel_1.setBounds(421, 319, 109, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("FARMER ID");
		lblNewLabel_2.setBounds(134, 319, 109, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("QUANTITY");
		lblNewLabel_3.setBounds(581, 319, 96, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("RATE");
		lblNewLabel_4.setBounds(714, 319, 69, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblBuy = new JLabel("BUY");
		lblBuy.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBuy.setBounds(396, 42, 69, 20);
		contentPane.add(lblBuy);
		
		JLabel lblGrainCode = new JLabel("AREA CODE");
		lblGrainCode.setBounds(613, 56, 115, 20);
		contentPane.add(lblGrainCode);
	}
}

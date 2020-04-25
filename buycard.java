import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.List;

public class buycard extends JFrame {

	private JPanel contentPane;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t1;

	int xy,ch,amount,rtqty,fffid,tid,pankaj;
	int csk;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buycard frame = new buycard();
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
	public buycard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 731);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblGrainCode = new JLabel("Grain Code");
		lblGrainCode.setBounds(107, 194, 124, 20);
		contentPane.add(lblGrainCode);

		t2 = new JTextField();
		t2.setEditable(false);
		t2.setBounds(374, 191, 146, 26);
		contentPane.add(t2);
		t2.setColumns(10);

		JLabel lblGrainName = new JLabel("Grain Name");
		lblGrainName.setBounds(107, 245, 110, 20);
		contentPane.add(lblGrainName);

		t3 = new JTextField();
		t3.setEditable(false);
		t3.setBounds(374, 242, 146, 26);
		contentPane.add(t3);
		t3.setColumns(10);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(117, 293, 69, 20);
		contentPane.add(lblQuantity);

		t4 = new JTextField();
		t4.setBounds(374, 290, 146, 26);
		contentPane.add(t4);
		t4.setColumns(10);

		JLabel lblRate = new JLabel("Rate");
		lblRate.setBounds(129, 353, 69, 20);
		contentPane.add(lblRate);

		t5 = new JTextField();
		t5.setEditable(false);
		t5.setBounds(374, 350, 146, 26);
		contentPane.add(t5);
		t5.setColumns(10);

		JLabel lblFarmerId = new JLabel("Farmer Id");
		lblFarmerId.setBounds(107, 135, 124, 20);
		contentPane.add(lblFarmerId);

		t1 = new JTextField();
		t1.setEditable(false);
		t1.setBounds(374, 132, 146, 26);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t5.setText(String.valueOf(buy.zrt));
		t4.setText(String.valueOf(buy.zqty));
		t3.setText(buy.zgn);
		t2.setText(String.valueOf(buy.zgc));
		t1.setText(String.valueOf(buy.zid));
		

		int yx=(buy.zqty);
		//JOptionPane.showMessageDialog(null,yx);
		int ffid=(buy.zid);
		fffid=ffid;
		int ggcc=(buy.zgc);
		String ggnn=(buy.zgn);
		int ggqty=(buy.zqty);
		int ggrt=(buy.zrt);

		JLabel lblCart = new JLabel("CART");
		lblCart.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCart.setBounds(359, 30, 77, 51);
		contentPane.add(lblCart);

		JButton btnOrder = new JButton("ORDER");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				xy=Integer.parseInt(t4.getText());
				//JOptionPane.showMessageDialog(null,xy);
				ch=yx-xy;
				
				String sql100="select waccount_balance from wholesalerdetails where id="+login.id+"";
				
			
				try
				{
					Class.forName("java.sql.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
					Statement s=con.createStatement();
					ResultSet kkr=s.executeQuery(sql100);
					if (kkr.next())
					{
						csk=kkr.getInt(1);
					}
				
				
				
				String sql404="Select grain_code from wholesalerstock where id="+login.id+"";
				ResultSet rs404=s.executeQuery(sql404);
				int flag=0;
				while(rs404.next())
				{
					if(rs404.getInt(1)==ggcc)
					{
						flag=1;
						break;
					}
				}
				String sql4;
				String sql2;
				try
				{
					Class.forName("java.sql.Driver");
					Connection con12=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
					Statement s12=con12.createStatement();
					if(flag==0)
					{
						if(amount>csk)
						{

							JOptionPane.showMessageDialog(null,"You dont have sufficient balance in your account");
							dispose();
							new buy().setVisible(true);
						}
						sql4="insert into wholesalerstock values ("+(login.id)+","+(ggcc)+",'"+(ggnn)+"',"+(xy)+")";
						s.executeUpdate(sql4);
						
					}
					else
					{
						amount=xy*ggrt;
						if(amount>csk)
						{

							JOptionPane.showMessageDialog(null,"You dont have sufficient balance in your account");
							dispose();
							new buy().setVisible(true);
						}
						
						
						String sql1="select w_qty from wholesalerstock where id="+login.id+" and grain_code="+ggcc+" ";
						ResultSet rs1=s.executeQuery(sql1);
						if(rs1.next())
						{
							int rsqty=(rs1.getInt(1));
							rtqty=rsqty+xy;
						}
						String sql3="update wholesalerstock set w_qty="+rtqty+" where grain_code="+ggcc+" and id="+login.id+"";
						s.executeUpdate(sql3);
					}
					sql2="update farmerstock set f_qty="+ch+" where id="+ffid+" and grain_code="+ggcc+"";
					s.executeUpdate(sql2);
					double extra=(0.10 * amount);
					
					String sql5="update wholesalerdetails set waccount_balance=(waccount_balance - ("+amount+" + "+extra+")) where id="+login.id+"";
					String sql6="update farmerdetails set faccount_balance=(faccount_balance + ("+amount+" + "+extra+")) where id="+ffid+"";
					s.executeUpdate(sql5);
					s.executeUpdate(sql6);
					String sql101="insert into transaction (id) values ("+login.id+")";
					s.executeUpdate(sql101);
					
					String sql102="Select max(last_insert_id(transaction_id)) from transaction";
					ResultSet rs102=s.executeQuery(sql102);
					//int tid;
					if(rs102.next())
					{
						tid=rs102.getInt(1);
						String sql103="call calAmt("+amount+","+tid+")";
						s.executeUpdate(sql103);
					}
					String sank="select amount from transaction where id = "+login.id+" and transaction_id = "+tid+"";
					ResultSet tushar=s.executeQuery(sank);
					if(tushar.next())
					{
						pankaj=tushar.getInt(1);
					}
					JOptionPane.showMessageDialog(null,"Amount paid is "+pankaj+"");
				
				}
				catch(Exception a)
				{
					System.out.println(a);
				}		
				}
				catch(Exception a)
				{
					System.out.println(a);
				}
				dispose();
				new buy().setVisible(true);
			}
		});

		btnOrder.setBounds(248, 477, 115, 29);
		contentPane.add(btnOrder);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new buy().setVisible(true);
			}
		});
		btnBack.setBounds(504, 477, 115, 29);
		contentPane.add(btnBack);
	}
}

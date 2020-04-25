import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class pp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pp frame = new pp();
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
	public pp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoYouReally = new JLabel("Do You Really want to delete ?");
		lblDoYouReally.setBounds(139, 42, 258, 20);
		contentPane.add(lblDoYouReally);
		
		JButton btnYes = new JButton("YES");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String ro="";
					Class.forName("java.sql.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AgroInventory?useSSL=false","root","");
					Statement s=con.createStatement();
					int idgxc=Integer.parseInt(t1.getText());
					JOptionPane.showMessageDialog(null,""+idgxc+"");
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
				dispose();
			}
		});
		btnYes.setBounds(104, 144, 115, 29);
		contentPane.add(btnYes);
		
		JButton btnNo = new JButton("NO");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNo.setBounds(294, 144, 115, 29);
		contentPane.add(btnNo);
	}
}

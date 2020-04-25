import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class wholesalerhome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wholesalerhome frame = new wholesalerhome();
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
	public wholesalerhome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 916, 727);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewProfile = new JButton("VIEW PROFILE");
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new wviewprofile().setVisible(true);
			}
		});
		btnViewProfile.setBounds(348, 204, 227, 29);
		contentPane.add(btnViewProfile);
		//JOptionPane.showMessageDialog(null, login.id);
		JButton btnNewButton = new JButton("VIEW STOCK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new wviewstock().setVisible(true);
			}
		});
		btnNewButton.setBounds(348, 288, 227, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LOG OUT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new login().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(348, 466, 227, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblWelcome.setBounds(362, 83, 241, 20);
		contentPane.add(lblWelcome);
		
		JButton btnAddMoney = new JButton("ADD MONEY");
		btnAddMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new addm().setVisible(true);
			}
		});
		btnAddMoney.setBounds(348, 378, 227, 29);
		contentPane.add(btnAddMoney);
	}
}

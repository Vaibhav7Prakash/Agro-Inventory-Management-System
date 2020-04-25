import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class disp extends JFrame {

	private JPanel contentPane;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					disp frame = new disp();
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
	public disp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWelcome.setBounds(367, 35, 198, 97);
		contentPane.add(lblWelcome);
		
		JLabel lblYourLoginId = new JLabel("YOUR LOGIN ID IS :");
		lblYourLoginId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYourLoginId.setBounds(146, 161, 181, 20);
		contentPane.add(lblYourLoginId);
		
		t1 = new JTextField();
		t1.setEditable(false);
		t1.setBounds(336, 159, 146, 26);
		contentPane.add(t1);
		t1.setColumns(10);
		t1.setText(String.valueOf(Signup.idd));
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new login().setVisible(true);
			}
		});
		btnLogIn.setBounds(367, 445, 115, 29);
		contentPane.add(btnLogIn);
		
		JLabel lblLoginWithThe = new JLabel("LOGIN WITH THE VALID PASSWORD");
		lblLoginWithThe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLoginWithThe.setBackground(Color.BLACK);
		lblLoginWithThe.setBounds(264, 219, 301, 51);
		contentPane.add(lblLoginWithThe);
	}

}

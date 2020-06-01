package ml.tirthankark;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CloudhubLogIn {

	private JFrame frameLogin;
	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CloudhubLogIn window = new CloudhubLogIn();
					window.frameLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CloudhubLogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameLogin = new JFrame();
		frameLogin.setResizable(false);
		frameLogin.setTitle("Anypoint Cloudhub Log Downloader");
		frameLogin.setBounds(100, 100, 683, 438);
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(50, 47, 101, 40);
		frameLogin.getContentPane().add(lblNewLabel);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(170, 56, 204, 31);
		frameLogin.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(50, 110, 101, 40);
		frameLogin.getContentPane().add(lblPassword);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(170, 119, 204, 31);
		frameLogin.getContentPane().add(textFieldPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameLogin.setVisible(false);
				new LogDownloader().setVisible(true);
			}
		});
		btnLogin.setBounds(142, 186, 97, 25);
		frameLogin.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("Anypoint Login");
		lblNewLabel_1.setBounds(246, 13, 123, 16);
		frameLogin.getContentPane().add(lblNewLabel_1);
	}
}

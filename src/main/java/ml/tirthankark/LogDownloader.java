package ml.tirthankark;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.commons.io.IOUtils;

public class LogDownloader extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFAlias;
	private JTextField tfFile;
	LogDownloader frame;
	private JTextField textFieldFile;
	private String location, filename, alias, password;
	private JTextField tfPassword;
	private JTextArea tAOutput, tAError;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogDownloader frame = new LogDownloader();
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
	public LogDownloader() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Alias name");
		lblNewLabel.setBounds(65, 119, 97, 16);
		contentPane.add(lblNewLabel);

		tFAlias = new JTextField();
		tFAlias.setBounds(278, 112, 253, 22);
		contentPane.add(tFAlias);
		tFAlias.setColumns(10);

		
		final JLabel lblOutput = new JLabel("");
		lblOutput.setVerticalAlignment(SwingConstants.TOP);
		lblOutput.setBounds(226, 560, 196, 87);
		contentPane.add(lblOutput);
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filename = tfFile.getText();
				alias = tFAlias.getText();
				password = tfPassword.getText();
				
				
				tAOutput.setText(filename+"\n"+location+"\n"+alias+"\n"+password);
				Process proc = null;
				try {
					String command = "keytool -import -v -trustcacerts -alias " + alias
                            + " -file " + " \"" + location + "\"" + " -keystore " + filename + " -storepass " + password + " -noprompt";
//					tAOutput.setText(command);
                    proc = Runtime.getRuntime().exec(command);
                    // Then retreive the process output
                    InputStream in = proc.getInputStream();
                    InputStream err = proc.getErrorStream();
                    String inputStr = IOUtils.toString(in, "UTF-8");
                    String errStr = IOUtils.toString(err, "UTF-8");
                    tAOutput.setText(inputStr.trim());
                    tAError.setText(errStr.trim());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
			}
		});
		btnNewButton.setBounds(193, 427, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblApplicationName = new JLabel("Trust store filename");
		lblApplicationName.setBounds(65, 72, 127, 16);
		contentPane.add(lblApplicationName);
		
		tfFile = new JTextField();
		tfFile.setText("truststore.ts");
		tfFile.setColumns(10);
		tfFile.setBounds(277, 65, 254, 22);
		contentPane.add(tfFile);
		
		JLabel lblFileSaveLocation = new JLabel("Certificate Location");
		lblFileSaveLocation.setBounds(65, 185, 180, 16);
		contentPane.add(lblFileSaveLocation);
		
		JButton btnNewButton_1 = new JButton("Select");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
	            int option = fileChooser.showSaveDialog(frame);
	            fileChooser.setAcceptAllFileFilterUsed(false);
	            if(option == JFileChooser.APPROVE_OPTION){
	               File file = fileChooser.getSelectedFile();
	               location = file.getAbsolutePath();
	               textFieldFile.setText(location);
	            }else{
	            	textFieldFile.setText("");
	            }
			}
		});
		btnNewButton_1.setBounds(487, 177, 67, 25);
		contentPane.add(btnNewButton_1);
		
		textFieldFile = new JTextField();
		textFieldFile.setColumns(10);
		textFieldFile.setBounds(278, 178, 200, 22);
		contentPane.add(textFieldFile);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldFile.setText("");
				tAError.setText("");
				tAOutput.setText("");
			}
		});
		btnClear.setBounds(434, 427, 97, 25);
		contentPane.add(btnClear);
		
		tAOutput = new JTextArea();
		tAOutput.setLineWrap(true);
		tAOutput.setEditable(false);
		tAOutput.setBounds(277, 215, 254, 87);
		contentPane.add(tAOutput);
		
		JLabel lblKeystorePassword = new JLabel("Keystore password");
		lblKeystorePassword.setBounds(65, 151, 157, 16);
		contentPane.add(lblKeystorePassword);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(278, 144, 253, 22);
		contentPane.add(tfPassword);
		
		JLabel lblOutput_1 = new JLabel("Output");
		lblOutput_1.setBounds(65, 218, 180, 16);
		contentPane.add(lblOutput_1);
		
		JLabel lblOutput_1_1 = new JLabel("Error");
		lblOutput_1_1.setBounds(65, 318, 180, 16);
		contentPane.add(lblOutput_1_1);
		
		tAError = new JTextArea();
		tAError.setBounds(277, 315, 254, 87);
		contentPane.add(tAError);
		
		JLabel lblNewLabel_1 = new JLabel("Certificate Generator");
		lblNewLabel_1.setBounds(213, 13, 180, 16);
		contentPane.add(lblNewLabel_1);
		
		
	}
}

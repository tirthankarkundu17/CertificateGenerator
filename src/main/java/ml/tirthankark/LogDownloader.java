package ml.tirthankark;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import ml.tirthankark.beans.CloudHubLogRequestObj;
import ml.tirthankark.beans.CloudHubLogResponseObj;
import net.sourceforge.jdatepicker.DateModel;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;

public class LogDownloader extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLogSearch;
	private JTextField textFieldEnvId;
	private JTextField textFieldAppName;
	LogDownloader frame;
	private JTextField textFieldFile;
	private String location;
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
		setBounds(100, 100, 675, 755);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Log Search");
		lblNewLabel.setBounds(65, 161, 97, 16);
		contentPane.add(lblNewLabel);

		textFieldLogSearch = new JTextField();
		textFieldLogSearch.setBounds(225, 158, 254, 22);
		contentPane.add(textFieldLogSearch);
		textFieldLogSearch.setColumns(10);

		JLabel lblStartDateTime = new JLabel("Start Date");
		lblStartDateTime.setBounds(65, 206, 97, 16);
		contentPane.add(lblStartDateTime);

		JDatePanelImpl datePanelImpl = new JDatePanelImpl((DateModel) null);
		datePanelImpl.setBounds(222, 204, 200, 140);
		contentPane.add(datePanelImpl);

		List<Integer> itemList = new ArrayList<Integer>();
		int i = 0;
		for (i = 0; i <= 23; i++) {
			itemList.add(i);
		}
		Integer[] itemsHrs = new Integer[24];
		itemList.toArray(itemsHrs);
		JComboBox comboBox_Hrs = new JComboBox(itemsHrs);
		comboBox_Hrs.setBounds(434, 229, 45, 22);
		contentPane.add(comboBox_Hrs);

		itemList = new ArrayList<Integer>();
		for (i = 0; i <= 59; i++) {
			itemList.add(i);
		}

		Integer[] itemsmMins = new Integer[60];
		itemList.toArray(itemsmMins);

		JComboBox comboBox_Mins = new JComboBox(itemsmMins);
		comboBox_Mins.setBounds(434, 290, 45, 22);
		contentPane.add(comboBox_Mins);

		JLabel lblNewLabel_1 = new JLabel("Hours");
		lblNewLabel_1.setBounds(434, 206, 56, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Minutes");
		lblNewLabel_1_1.setBounds(434, 272, 56, 16);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(65, 359, 97, 16);
		contentPane.add(lblEndDate);

		JDatePanelImpl datePanelImpl_1 = new JDatePanelImpl((DateModel) null);
		datePanelImpl_1.setBounds(222, 357, 200, 140);
		contentPane.add(datePanelImpl_1);

		JComboBox comboBox_Hrs_1 = new JComboBox(itemsHrs);
		comboBox_Hrs_1.setBounds(434, 382, 45, 22);
		contentPane.add(comboBox_Hrs_1);

		JLabel lblNewLabel_1_2 = new JLabel("Hours");
		lblNewLabel_1_2.setBounds(434, 359, 56, 16);
		contentPane.add(lblNewLabel_1_2);

		JComboBox comboBox_Mins_1 = new JComboBox(itemsmMins);
		comboBox_Mins_1.setBounds(434, 443, 45, 22);
		contentPane.add(comboBox_Mins_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Minutes");
		lblNewLabel_1_1_1.setBounds(434, 425, 56, 16);
		contentPane.add(lblNewLabel_1_1_1);
		
		final JLabel lblOutput = new JLabel("");
		lblOutput.setVerticalAlignment(SwingConstants.TOP);
		lblOutput.setBounds(226, 560, 196, 87);
		contentPane.add(lblOutput);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String appEnvId = textFieldEnvId.getText();
				String logSearch = textFieldLogSearch.getText();
				String appName = textFieldAppName.getText();

				String auth = "mike1234567" + ":" + "Mike@123";
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
				String authHeader = "Basic " + new String(encodedAuth);

				CloseableHttpClient client = HttpClients.createDefault();
				String url = "https://anypoint.mulesoft.com/cloudhub/api/v2/applications/"+appName+"/logs";
				HttpPost httpPost = new HttpPost(url);
				httpPost.addHeader("Authorization", authHeader);
				httpPost.addHeader("X-ANYPNT-ENV-ID", appEnvId);
				CloudHubLogRequestObj cloudHubLogRequestObj = new CloudHubLogRequestObj();
				cloudHubLogRequestObj.setText(logSearch);
				ObjectMapper mapper = new ObjectMapper();
				// Converting the Object to JSONString
				String json;
				try {
					json = mapper.writeValueAsString(cloudHubLogRequestObj);
					StringEntity postEntity;
					postEntity = new StringEntity(json);
					httpPost.setEntity(postEntity);
					httpPost.setHeader("Accept", "application/json");
					httpPost.setHeader("Content-type", "application/json");

					CloseableHttpResponse response = client.execute(httpPost);
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						InputStream in = entity.getContent();
						FileOutputStream out = new FileOutputStream(location);
						String responseStr = IOUtils.toString(in, "UTF-8");
						Gson responseGsonObj = new Gson();
						CloudHubLogResponseObj[] resObj = responseGsonObj.fromJson(responseStr, CloudHubLogResponseObj[].class);
						for (CloudHubLogResponseObj obj : resObj) {
							String temp = obj.toString() + "\n";
							out.write(temp.getBytes());
							out.flush();
						}
						System.out.println("Complete");
						response.close();
					}
					int code = response.getStatusLine().getStatusCode();
					client.close();
					
					lblOutput.setText("Completed log generation and saved it to file");
					
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(225, 660, 97, 25);
		contentPane.add(btnNewButton);

		JLabel lblEnvironementId = new JLabel("Environement ID");
		lblEnvironementId.setBounds(65, 113, 97, 16);
		contentPane.add(lblEnvironementId);

		textFieldEnvId = new JTextField();
		textFieldEnvId.setText("fe19c00a-6632-43ec-8d9a-4c5f4f1e8c4f");
		textFieldEnvId.setColumns(10);
		textFieldEnvId.setBounds(225, 110, 254, 22);
		contentPane.add(textFieldEnvId);
		
		JLabel lblApplicationName = new JLabel("App Name");
		lblApplicationName.setBounds(65, 72, 97, 16);
		contentPane.add(lblApplicationName);
		
		textFieldAppName = new JTextField();
		textFieldAppName.setText("test-app-jdod");
		textFieldAppName.setColumns(10);
		textFieldAppName.setBounds(225, 69, 254, 22);
		contentPane.add(textFieldAppName);
		
		JLabel lblFileSaveLocation = new JLabel("File Save Location");
		lblFileSaveLocation.setBounds(65, 515, 97, 16);
		contentPane.add(lblFileSaveLocation);
		
		JButton btnNewButton_1 = new JButton("Select");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
	            int option = fileChooser.showSaveDialog(frame);
	            if(option == JFileChooser.APPROVE_OPTION){
	               File file = fileChooser.getSelectedFile();
	               location = file.getAbsolutePath();
	               textFieldFile.setText(location);
	            }else{
	            	textFieldFile.setText("");
	            }
			}
		});
		btnNewButton_1.setBounds(434, 509, 67, 25);
		contentPane.add(btnNewButton_1);
		
		textFieldFile = new JTextField();
		textFieldFile.setColumns(10);
		textFieldFile.setBounds(222, 510, 200, 22);
		contentPane.add(textFieldFile);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				textFieldAppName.setText("");
				textFieldFile.setText("");
				lblOutput.setText("");
				System.out.println("Clear");
			}
		});
		btnClear.setBounds(346, 660, 97, 25);
		contentPane.add(btnClear);
		
		
	}
}

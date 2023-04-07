import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

class Registration extends JFrame {
	
	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;
	private JButton btnCreate;
	private JLabel lblReturn;
	private JLabel lblDetails;
	private JLabel lblAccountError;
	private JPanel panel_1;
	private JLabel lblByte;
	private JLabel lblSized;
	
	public Registration() {
		setTitle("Byte Sized");
		getContentPane().setBackground(new Color(39, 35, 39));
		setForeground(new Color(238, 238, 238));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 347);
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(36, 32, 36));
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 10, 498, 287);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		// Text Labels and Fields 
		textUsername = new HintText("Username");
		textUsername.setBounds(193, 116, 293, 20);
		panel.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(38, 119, 62, 14);
		panel.add(lblUsername);
		
		textPassword = new HintText("Password");
		textPassword.setColumns(10);
		textPassword.setBounds(193, 147, 293, 20);
		panel.add(textPassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(38, 154, 62, 14);
		panel.add(lblPassword);
		
		lblAccountError = new JLabel("");
		lblAccountError.setForeground(Color.RED);
		lblAccountError.setBounds(193, 175, 293, 14);
		lblAccountError.setFont(new Font("Sans Serif", Font.PLAIN, 11));
		panel.add(lblAccountError);

		
		// Go Back
	
		lblReturn = new JLabel("Go Back");
		lblReturn.setBounds(38, 203, 123, 14);
		panel.add(lblReturn);
		
		lblReturn.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		       // you can open a new frame here as
		       // i have assumed you have declared "frame" as instance variable
		       Main frame = new Main();
		       frame.setVisible(true);
		       dispose();
		    }  
		}); 
		
		// Course Detailing
		
		lblDetails = new JLabel("EECS3311 T14 @ 2023");
		lblDetails.setForeground(Color.GRAY);
		lblDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetails.setBounds(181, 260, 136, 14);
		panel.add(lblDetails);
		
		// Submit Button
		
		btnCreate = new JButton("Submit");
		btnCreate.setBounds(257, 199, 89, 23);
		panel.add(btnCreate);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(new Color(36, 32, 36));
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(36, 32, 36));
		panel_1.setBounds(132, 27, 233, 62);
		panel.add(panel_1);
		
		lblByte = new JLabel("BYTE");
		lblByte.setHorizontalAlignment(SwingConstants.CENTER);
		lblByte.setForeground(new Color(243, 244, 245));
		lblByte.setFont(new Font("Arial", Font.PLAIN, 30));
		lblByte.setBounds(10, 11, 110, 45);
		panel_1.add(lblByte);
		
		lblSized = new JLabel("SIZED");
		lblSized.setHorizontalAlignment(SwingConstants.CENTER);
		lblSized.setForeground(new Color(227, 2, 32));
		lblSized.setFont(new Font("Arial", Font.BOLD, 30));
		lblSized.setBounds(101, 11, 110, 45);
		panel_1.add(lblSized);
		

		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				int usrFlag = 0, pasFlag = 0, exist = 1;
				
				if (usrFlag == 0) {textUsername.setBorder(BorderFactory.createLineBorder(Color.gray));}
				if (pasFlag == 0) {textPassword.setBorder(BorderFactory.createLineBorder(Color.gray));}
				
				if (textUsername.getText().equals("") || textUsername.getText().equals("Username Required") || textUsername.getText().equals("Username")) {
					textUsername.setBorder(BorderFactory.createLineBorder(Color.red));
					usrFlag = 1;
				}
				
				if (textPassword.getText().equals("") || textPassword.getText().equals("Password Required") || textPassword.getText().equals("Password")) {
					textPassword.setBorder(BorderFactory.createLineBorder(Color.red));
					pasFlag = 1;
				}
				
				
				if (usrFlag == 0 && pasFlag == 0) {
					User user = new User(textUsername.getText(), textPassword.getText(), "user");
					User loged = user.Signup();
					
					if (loged == null) {
						lblAccountError.setText("Account already exists.");
					} else {
						Main frame = new Main();
						frame.setVisible(true);
						dispose();
					} 
				}
			}	
		});
		
	}
}

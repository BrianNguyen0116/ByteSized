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
	
	RestaurantServer server = new RestaurantServer();
	private JPanel contentPane;
	private JTextField txtRegister;
	private JTextField textUsername;
	private JTextField textPassword;
	private JButton btnCreate;
	private JLabel lblReturn;
	private JLabel lblDetails;
	private JLabel lblAccountError;
	
	public Registration() {
		setTitle("Byte Sized");
		setForeground(new Color(238, 238, 238));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 347);
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 10, 498, 287);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		// Register
		txtRegister = new JTextField();
		txtRegister.setBounds(139, 30, 220, 30);
		txtRegister.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(txtRegister);
		txtRegister.setEditable(false);
		txtRegister.setHighlighter(null);
		txtRegister.setText("Register");
		txtRegister.setOpaque(false);
		txtRegister.setBorder(BorderFactory.createEmptyBorder());
		txtRegister.setFont(new Font("Arial", Font.BOLD, 25));
		txtRegister.setColumns(10);
		
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
				// Code needed to cross check with account DB (exist boolean)
					User account = new User(textUsername.getText(), textPassword.getText());
					exist = 0;
					} else {
						lblAccountError.setText("Account already exists.");
					} 
				
				if (exist == 0) {
					Main frame = new Main();
					frame.setVisible(true);
					dispose();
				}
			}	
		});
		
	}
}

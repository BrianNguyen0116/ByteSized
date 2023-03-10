import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.BevelBorder;
import javax.swing.BorderFactory;
import java.awt.Font;
import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Main extends JFrame {
	
	RestaurantServer server = new RestaurantServer();
	private JPanel contentPane;
	private JTextField txtLogIn;
	private JTextField textUsername;
	private JTextField textPassword;
	private JButton btnLogIn;
	private JLabel lblRegister;
	private JLabel lblDetails;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblAccountError;
	
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Main() {
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
		
		// Log In
		txtLogIn = new JTextField();
		txtLogIn.setBounds(139, 30, 220, 30);
		txtLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(txtLogIn);
		txtLogIn.setEditable(false);
		txtLogIn.setHighlighter(null);
		txtLogIn.setText("Log In");
		txtLogIn.setOpaque(false);
		txtLogIn.setBorder(BorderFactory.createEmptyBorder());
		txtLogIn.setFont(new Font("Arial", Font.BOLD, 25));
		txtLogIn.setColumns(10);
		
		// Text Labels and Fields
		textUsername = new HintText("Username");
		textUsername.setBounds(193, 116, 293, 20);
		panel.add(textUsername);
		textUsername.setColumns(10);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(38, 119, 62, 14);
		panel.add(lblUsername);
		
		textPassword = new HintText("Password");;
		textPassword.setColumns(10);
		textPassword.setBounds(193, 147, 293, 20);
		panel.add(textPassword);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(38, 150, 62, 14);
		panel.add(lblPassword);
		
		lblAccountError = new JLabel("");
		lblAccountError.setForeground(Color.RED);
		lblAccountError.setBounds(193, 175, 293, 14);
		lblAccountError.setFont(new Font("Sans Serif", Font.PLAIN, 11));
		panel.add(lblAccountError);
		

		
		// Registration
	
		lblRegister = new JLabel("Create an Account");
		lblRegister.setBounds(38, 203, 123, 14);
		panel.add(lblRegister);
		
		lblRegister.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		       Registration frame = new Registration();
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
		
		btnLogIn = new JButton("Submit");
		btnLogIn.setBounds(257, 199, 89, 23);
		panel.add(btnLogIn);
		
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
			
				int usrFlag = 0, pasFlag = 0, exist = 0;
				
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
					exist = 1;
				} else {
						lblAccountError.setText("The username or password you entered is incorrect.");
					} 
				if (exist == 1) {
					Ordering frame = new Ordering();
					frame.setVisible(true);
					dispose();
				}
			}	
		});
		
	}
}
	




	
	

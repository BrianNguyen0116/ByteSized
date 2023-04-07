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
import java.io.FileReader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.BevelBorder;
import javax.swing.BorderFactory;
import java.awt.Font;
import javax.swing.JTextField;


public class Main extends JFrame {
	
	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;
	private JButton btnLogIn;
	private JLabel lblRegister;
	private JLabel lblDetails;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblAccountError;
	
	public static String currUsername;
	private JPanel panel_1;
	private JLabel lblByte;
	private JLabel lblSized;
	
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
		panel.setForeground(new Color(36, 32, 36));
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 10, 498, 287);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		// Text Labels and Fields
		textUsername = new HintText("Username");
		textUsername.setBounds(205, 114, 192, 20);
		panel.add(textUsername);
		textUsername.setColumns(10);
		
		lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(221, 221, 221));
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 11));
		lblUsername.setBounds(107, 117, 62, 14);
		panel.add(lblUsername);
		
		textPassword = new HintText("Password");;
		textPassword.setColumns(10);
		textPassword.setBounds(205, 145, 192, 20);
		panel.add(textPassword);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(221, 221, 221));
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPassword.setBounds(107, 148, 62, 14);
		panel.add(lblPassword);
		
		lblAccountError = new JLabel("");
		lblAccountError.setForeground(Color.RED);
		lblAccountError.setBounds(193, 175, 293, 14);
		lblAccountError.setFont(new Font("Sans Serif", Font.PLAIN, 11));
		panel.add(lblAccountError);
		

		
		// Registration
	
		lblRegister = new JLabel("Create an Account");
		lblRegister.setForeground(new Color(221, 221, 221));
		lblRegister.setFont(new Font("Arial", Font.PLAIN, 11));
		lblRegister.setBounds(107, 201, 123, 14);
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
		
		btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLogIn.setForeground(new Color(221, 221, 221));
		btnLogIn.setBackground(new Color(36, 32, 36));
		btnLogIn.setBounds(308, 197, 89, 23);
		panel.add(btnLogIn);
		
		panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setLayout(null);
		panel_1.setForeground(new Color(36, 32, 36));
		panel_1.setBackground(new Color(36, 32, 36));
		panel_1.setBounds(140, 22, 233, 62);
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
		
				
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				
				int usrFlag = 0, pasFlag = 0;
				
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
					User loged = user.Login();


					if (loged == null) {
						lblAccountError.setText("The username or password you entered is incorrect.");
					} else {
						if (user.getRole().equals("user")) {
							System.out.println("Succes 1");
							user.setLoggedIn(true);
							currUsername = textUsername.getText();
							Ordering frame = new Ordering();
							frame.setVisible(true);
							dispose();						
						} else if (loged.getRole().equals("admin")) {
							System.out.println("Succes 2");
							loged.setLoggedIn(true);
							currUsername = textUsername.getText();
							inventoryDisplay frame = new inventoryDisplay("hello");
							frame.setVisible(true);
							dispose();
							}
						} 
					}	
				}
			});
		}
	}

	




	
	

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;


public class Main extends JFrame {
	
	RestaurantServer server = new RestaurantServer();
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Byte Sized");
		setForeground(new Color(238, 238, 238));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 631);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Styling
		 */
		
		
		
		/**
		 * Cart
		 */
		
		JPanel pizza = new JPanel();
		pizza.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pizza.setBounds(-1, 0, 150, 592);
		contentPane.add(pizza);
		pizza.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pizza");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 7, 130, 14);
		pizza.add(lblNewLabel);
		
		JPanel cart = new JPanel();
		cart.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cart.setBounds(10, 29, 130, 518);
		pizza.add(cart);
		cart.setLayout(new BoxLayout(cart, BoxLayout.X_AXIS));
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(11, 558, 127, 23);
		pizza.add(btnCheckout);
		btnCheckout.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JPanel size = new JPanel();
		size.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		size.setBounds(148, 0, 283, 54);
		contentPane.add(size);
		size.setLayout(null);
		
		/**
		 * Size Customization
		 */
		ButtonGroup rbtnSize = new ButtonGroup();
		
		JRadioButton rdbtnS = new JRadioButton("Small");
		rdbtnS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnS.setBounds(10, 24, 69, 23);
		size.add(rdbtnS);
		
		JRadioButton rdbtnM = new JRadioButton("Medium");
		rdbtnM.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnM.setBounds(76, 24, 69, 23);
		size.add(rdbtnM);
		
		JRadioButton rdbtnL = new JRadioButton("Large");
		rdbtnL.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnL.setBounds(147, 24, 59, 23);
		size.add(rdbtnL);
		
		JRadioButton rdbtnXL = new JRadioButton("X-Large");
		rdbtnXL.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnXL.setBounds(207, 24, 69, 23);
		size.add(rdbtnXL);
		
		rbtnSize.add(rdbtnS); rbtnSize.add(rdbtnM); rbtnSize.add(rdbtnL); rbtnSize.add(rdbtnXL);
		
		JLabel lblNewLabel_2 = new JLabel("Size");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 7, 266, 14);
		size.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel crescent = new JPanel();
		crescent.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		crescent.setBounds(148, 53, 283, 62);
		contentPane.add(crescent);
		crescent.setLayout(null);
		
		/**
		 * Crescent Customization
		 */
		ButtonGroup rbtnCrescent = new ButtonGroup();
		
		JRadioButton rdbtnPan = new JRadioButton("Pan");
		rdbtnPan.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnPan.setBounds(208, 30, 60, 23);
		crescent.add(rdbtnPan);
		
		JLabel lblNewLabel_2_1 = new JLabel("Crescent");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(10, 9, 266, 14);
		crescent.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JRadioButton rdbtnStuffed = new JRadioButton("Stuffed");
		rdbtnStuffed.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnStuffed.setBounds(10, 30, 64, 23);
		crescent.add(rdbtnStuffed);
		
		JRadioButton rdbtnHomestyle = new JRadioButton("Homestyle");
		rdbtnHomestyle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnHomestyle.setBounds(76, 30, 75, 23);
		crescent.add(rdbtnHomestyle);
		
		JRadioButton rdbtnThin = new JRadioButton("Thin");
		rdbtnThin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnThin.setBounds(149, 30, 57, 23);
		crescent.add(rdbtnThin);
		
		rbtnCrescent.add(rdbtnPan); rbtnCrescent.add(rdbtnStuffed); rbtnCrescent.add(rdbtnHomestyle); rbtnCrescent.add(rdbtnThin);
		
		JPanel sauces = new JPanel();
		sauces.setLayout(null);
		sauces.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sauces.setBounds(149, 115, 282, 90);
		contentPane.add(sauces);
		
		/**
		 * Sauce Customization
		 */
		
		ButtonGroup rdbtnSauce = new ButtonGroup();
		
		JRadioButton rdbtnNoSauce = new JRadioButton("No Sauce");
		rdbtnNoSauce.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnNoSauce.setBounds(151, 56, 129, 23);
		sauces.add(rdbtnNoSauce);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Sauce");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1.setBounds(11, 10, 268, 14);
		sauces.add(lblNewLabel_2_1_1);
		
		JRadioButton rdbtnTomato = new JRadioButton("Tomato Sauce");
		rdbtnTomato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnTomato.setBounds(11, 28, 138, 23);
		sauces.add(rdbtnTomato);
		
		JRadioButton rdbtnAlfredoSauce = new JRadioButton("Alfredo Sauce");
		rdbtnAlfredoSauce.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnAlfredoSauce.setBounds(11, 56, 138, 23);
		sauces.add(rdbtnAlfredoSauce);
		
		JRadioButton rdbtnBbqSauce = new JRadioButton("BBQ Sauce");
		rdbtnBbqSauce.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnBbqSauce.setBounds(151, 28, 129, 23);
		sauces.add(rdbtnBbqSauce);
		
		rdbtnSauce.add(rdbtnBbqSauce); rdbtnSauce.add(rdbtnAlfredoSauce); rdbtnSauce.add(rdbtnTomato); rdbtnSauce.add(rdbtnNoSauce);
		
		JPanel toppings = new JPanel();
		toppings.setLayout(null);
		toppings.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		toppings.setBounds(148, 204, 283, 265);
		contentPane.add(toppings);
		
		/**
		 * Topping Customization
		 */
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Topping");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_1.setBounds(12, 11, 264, 14);
		toppings.add(lblNewLabel_2_1_1_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(208, 40, 63, 23);
		toppings.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Pepperoni");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(12, 43, 146, 14);
		toppings.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Bacon");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_1.setBounds(12, 67, 146, 14);
		toppings.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Italian Sausage");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_1_1.setBounds(12, 92, 146, 14);
		toppings.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Jalapeno");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_1_1_1.setBounds(12, 117, 146, 14);
		toppings.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Mushroom");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_1_1_1_1.setBounds(12, 142, 146, 14);
		toppings.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Pineapple");
		lblNewLabel_3_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_1_1_1_1_1.setBounds(12, 167, 146, 14);
		toppings.add(lblNewLabel_3_1_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1_1 = new JLabel("Parmesan Cheese");
		lblNewLabel_3_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_1_1_1_1_1_1.setBounds(12, 192, 146, 14);
		toppings.add(lblNewLabel_3_1_1_1_1_1_1);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1.setBounds(208, 64, 63, 23);
		toppings.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_2.setBounds(208, 89, 63, 23);
		toppings.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_3.setBounds(208, 114, 63, 23);
		toppings.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Add");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_4.setBounds(208, 139, 63, 23);
		toppings.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Add");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_5.setBounds(208, 164, 63, 23);
		toppings.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Add");
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_6.setBounds(208, 189, 63, 23);
		toppings.add(btnNewButton_6);
		
		JLabel lblNewLabel_3_1_1_1_1_1_1_1 = new JLabel("Tomato");
		lblNewLabel_3_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_1_1_1_1_1_1_1.setBounds(12, 217, 146, 14);
		toppings.add(lblNewLabel_3_1_1_1_1_1_1_1);
		
		JButton btnNewButton_7 = new JButton("Add");
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_7.setBounds(208, 213, 63, 23);
		toppings.add(btnNewButton_7);
		
		JLabel lblNewLabel_3_1_1_1_1_1_1_1_1 = new JLabel("Roasted Garlic");
		lblNewLabel_3_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_1_1_1_1_1_1_1_1.setBounds(12, 242, 146, 14);
		toppings.add(lblNewLabel_3_1_1_1_1_1_1_1_1);
		
		JButton btnNewButton_8 = new JButton("Add");
		btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_8.setBounds(208, 238, 63, 23);
		toppings.add(btnNewButton_8);
		
		JPanel sauces_1 = new JPanel();
		sauces_1.setLayout(null);
		sauces_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sauces_1.setBounds(148, 469, 283, 123);
		contentPane.add(sauces_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Special Instructions");
		lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1_1_2.setBounds(10, 5, 268, 14);
		sauces_1.add(lblNewLabel_2_1_1_2);
		
		JPanel instructions = new JPanel();
		instructions.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		instructions.setBounds(10, 22, 263, 90);
		sauces_1.add(instructions);
		instructions.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(1, 1, 260, 87);
		instructions.add(textArea);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}

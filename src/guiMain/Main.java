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
		setBounds(100, 100, 476, 560);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pizza = new JPanel();
		pizza.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pizza.setBounds(0, 30, 150, 475);
		contentPane.add(pizza);
		pizza.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pizza");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 130, 14);
		pizza.add(lblNewLabel);
		
		JPanel cart = new JPanel();
		cart.setBounds(10, 29, 130, 435);
		pizza.add(cart);
		cart.setLayout(new BoxLayout(cart, BoxLayout.X_AXIS));
		
		JPanel size = new JPanel();
		size.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		size.setBounds(148, 30, 286, 54);
		contentPane.add(size);
		size.setLayout(null);
		
		/**
		 * Size Customization
		 */
		ButtonGroup rbtnSize = new ButtonGroup();
		
		JRadioButton rdbtnS = new JRadioButton("S");
		rdbtnS.setBounds(10, 24, 54, 23);
		size.add(rdbtnS);
		
		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setBounds(66, 24, 73, 23);
		size.add(rdbtnM);
		
		JRadioButton rdbtnL = new JRadioButton("L");
		rdbtnL.setBounds(141, 24, 60, 23);
		size.add(rdbtnL);
		
		JRadioButton rdbtnXL = new JRadioButton("XL");
		rdbtnXL.setBounds(203, 24, 73, 23);
		size.add(rdbtnXL);
		
		rbtnSize.add(rdbtnS); rbtnSize.add(rdbtnM); rbtnSize.add(rdbtnL); rbtnSize.add(rdbtnXL);
		
		JLabel lblNewLabel_2 = new JLabel("Size");
		lblNewLabel_2.setBounds(10, 7, 266, 14);
		size.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel crescent = new JPanel();
		crescent.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		crescent.setBounds(148, 83, 286, 62);
		contentPane.add(crescent);
		crescent.setLayout(null);
		
		/**
		 * Crescent Customization
		 */
		ButtonGroup rbtnCrescent = new ButtonGroup();
		
		JRadioButton rdbtnPan = new JRadioButton("Pan");
		rdbtnPan.setBounds(227, 30, 53, 23);
		crescent.add(rdbtnPan);
		
		JLabel lblNewLabel_2_1 = new JLabel("Crescent");
		lblNewLabel_2_1.setBounds(10, 9, 266, 14);
		crescent.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JRadioButton rdbtnStuffed = new JRadioButton("Stuffed");
		rdbtnStuffed.setBounds(10, 30, 69, 23);
		crescent.add(rdbtnStuffed);
		
		JRadioButton rdbtnHomestyle = new JRadioButton("Homestyle");
		rdbtnHomestyle.setBounds(81, 30, 87, 23);
		crescent.add(rdbtnHomestyle);
		
		JRadioButton rdbtnThin = new JRadioButton("Thin");
		rdbtnThin.setBounds(170, 30, 55, 23);
		crescent.add(rdbtnThin);
		
		rbtnCrescent.add(rdbtnPan); rbtnCrescent.add(rdbtnStuffed); rbtnCrescent.add(rdbtnHomestyle); rbtnCrescent.add(rdbtnThin);
		
		JPanel sauces = new JPanel();
		sauces.setLayout(null);
		sauces.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sauces.setBounds(148, 145, 286, 86);
		contentPane.add(sauces);
		
		/**
		 * Sauce Customization
		 */
		
		ButtonGroup rdbtnSauce = new ButtonGroup();
		
		JRadioButton rdbtnNoSauce = new JRadioButton("No Sauce");
		rdbtnNoSauce.setBounds(152, 52, 128, 23);
		sauces.add(rdbtnNoSauce);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Sauce");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setBounds(6, 5, 43, 14);
		sauces.add(lblNewLabel_2_1_1);
		
		JRadioButton rdbtnTomato = new JRadioButton("Tomato Sauce");
		rdbtnTomato.setBounds(6, 24, 143, 23);
		sauces.add(rdbtnTomato);
		
		JRadioButton rdbtnAlfredoSauce = new JRadioButton("Alfredo Sauce");
		rdbtnAlfredoSauce.setBounds(6, 52, 143, 23);
		sauces.add(rdbtnAlfredoSauce);
		
		JRadioButton rdbtnBbqSauce = new JRadioButton("BBQ Sauce");
		rdbtnBbqSauce.setBounds(151, 24, 129, 23);
		sauces.add(rdbtnBbqSauce);
		
		rdbtnSauce.add(rdbtnBbqSauce); rdbtnSauce.add(rdbtnAlfredoSauce); rdbtnSauce.add(rdbtnTomato); rdbtnSauce.add(rdbtnNoSauce);
		
		JPanel toppings = new JPanel();
		toppings.setLayout(null);
		toppings.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		toppings.setBounds(148, 230, 286, 244);
		contentPane.add(toppings);
		
		/**
		 * Topping Customization
		 */
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Topping");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setBounds(12, 11, 43, 14);
		toppings.add(lblNewLabel_2_1_1_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(194, 40, 63, 23);
		toppings.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Pepperoni");
		lblNewLabel_3.setBounds(12, 43, 146, 14);
		toppings.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Bacon");
		lblNewLabel_3_1.setBounds(12, 67, 146, 14);
		toppings.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Italian Sausage");
		lblNewLabel_3_1_1.setBounds(12, 92, 146, 14);
		toppings.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Jalapenos");
		lblNewLabel_3_1_1_1.setBounds(12, 117, 146, 14);
		toppings.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Mushroom");
		lblNewLabel_3_1_1_1_1.setBounds(12, 142, 146, 14);
		toppings.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Pineapple");
		lblNewLabel_3_1_1_1_1_1.setBounds(12, 167, 146, 14);
		toppings.add(lblNewLabel_3_1_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1_1 = new JLabel("Parmesan Cheese");
		lblNewLabel_3_1_1_1_1_1_1.setBounds(12, 192, 146, 14);
		toppings.add(lblNewLabel_3_1_1_1_1_1_1);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBounds(194, 64, 63, 23);
		toppings.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Add");
		btnNewButton_1_1.setBounds(194, 89, 63, 23);
		toppings.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Add");
		btnNewButton_1_1_1.setBounds(194, 114, 63, 23);
		toppings.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Add");
		btnNewButton_1_1_1_1.setBounds(194, 139, 63, 23);
		toppings.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Add");
		btnNewButton_1_1_1_1_1.setBounds(194, 164, 63, 23);
		toppings.add(btnNewButton_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1_1 = new JButton("Add");
		btnNewButton_1_1_1_1_1_1.setBounds(194, 189, 63, 23);
		toppings.add(btnNewButton_1_1_1_1_1_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(148, 472, 286, 33);
		contentPane.add(panel);
		
		/**
		 *  Checkout
		 */
		panel.setLayout(null);
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(104, 5, 77, 23);
		panel.add(btnCheckout);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}

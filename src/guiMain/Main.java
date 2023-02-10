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
import javax.swing.JTextArea;


public class Main extends JFrame implements ActionListener {
	
	RestaurantServer server = new RestaurantServer();
	
	Pizza pizzaOrder = new Pizza();
	String cartList, size, crescent, sauce, ingredients;
	JRadioButton rdbtnS, rdbtnM, rdbtnL, rdbtnXL;
	JRadioButton rdbtnStuffed, rdbtnPan, rdbtnHomestyle, rdbtnThin;
	JRadioButton rdbtnTomato, rdbtnBbqSauce, rdbtnAlfredoSauce, rdbtnNoSauce;
	JButton btnPepperoni, btnBacon, btnItalianS, btnJalapenos, btnMushroom, btnPineapple, btnMozzarella, btnGreenPeppers, btnOlives;
	JButton btnrPepperoni, btnrBacon, btnrItalianS, btnrJalapenos, btnrMushroom, btnrPineapple, btnrMozzarella, btnrGreenPeppers, btnrOlives;

	int total = 0;
	
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
	 Main() {
		setTitle("Byte Sized");
		setForeground(new Color(238, 238, 238));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 694);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Shopping
		 */
		JPanel pizza = new JPanel();
		pizza.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pizza.setBounds(-1, 0, 150, 655);
		contentPane.add(pizza);
		pizza.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pizza");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 7, 130, 14);
		pizza.add(lblNewLabel);
		
		JPanel cart = new JPanel();
		cart.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cart.setBounds(10, 29, 130, 558);
		pizza.add(cart);
		cart.setLayout(new BoxLayout(cart, BoxLayout.X_AXIS));
		
		JTextArea receipt = new JTextArea(
				"Size:\n" + pizzaOrder.getSize() + 
				"\n\nCrescent:\n" + pizzaOrder.getCrust() + 
				"\n\nSauce:\n" + pizzaOrder.getSauces() + 
				"\n\nToppings:\n" + pizzaOrder.getToppings()
				);
		
		receipt.setEditable(false);
		cart.add(receipt);
		
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(11, 621, 127, 23);
		pizza.add(btnCheckout);
		btnCheckout.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 587, 130, 23);
		pizza.add(panel);
		panel.setLayout(null);
		
		JLabel lblTotal = new JLabel("Total: $" + total);
		lblTotal.setBounds(10, 4, 110, 14);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.add(lblTotal);
		
		JPanel size = new JPanel();
		size.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		size.setBounds(148, 0, 344, 87);
		contentPane.add(size);
		size.setLayout(null);
		
		/**
		 * Size Customization
		 */
		ButtonGroup rbtnSize = new ButtonGroup();
		
		/**
		 * Sizing Customization
		 */
		JRadioButton rdbtnS = new JRadioButton("Small");
		rdbtnS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnS.setBounds(10, 24, 69, 23);
		size.add(rdbtnS);
	
		
		JRadioButton rdbtnM = new JRadioButton("Medium");
		rdbtnM.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnM.setBounds(173, 24, 69, 23);
		size.add(rdbtnM);
		
		JRadioButton rdbtnL = new JRadioButton("Large");
		rdbtnL.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnL.setBounds(10, 57, 59, 23);
		size.add(rdbtnL);
		
		JRadioButton rdbtnXL = new JRadioButton("X-Large");
		rdbtnXL.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnXL.setBounds(173, 57, 69, 23);
		size.add(rdbtnXL);
		
		rbtnSize.add(rdbtnS); rbtnSize.add(rdbtnM); rbtnSize.add(rdbtnL); rbtnSize.add(rdbtnXL);
		
		JLabel lblNewLabel_2 = new JLabel("Size");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 7, 266, 14);
		size.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblPrice1 = new JLabel("$3");
		lblPrice1.setBounds(121, 28, 46, 14);
		size.add(lblPrice1);
		
		JLabel lblPrice1_1 = new JLabel("$6");
		lblPrice1_1.setBounds(121, 61, 46, 14);
		size.add(lblPrice1_1);
		
		JLabel lblPrice1_2 = new JLabel("$4");
		lblPrice1_2.setBounds(288, 28, 46, 14);
		size.add(lblPrice1_2);
		
		JLabel lblPrice1_2_1 = new JLabel("$8");
		lblPrice1_2_1.setBounds(288, 61, 46, 14);
		size.add(lblPrice1_2_1);
		
		JPanel crescent = new JPanel();
		crescent.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		crescent.setBounds(148, 85, 344, 87);
		contentPane.add(crescent);
		crescent.setLayout(null);
		
		/**
		 * Crescent Customization
		 */
		ButtonGroup rbtnCrescent = new ButtonGroup();
		
		rdbtnPan = new JRadioButton("Pan");
		rdbtnPan.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnPan.setBounds(173, 30, 60, 23);
		crescent.add(rdbtnPan);
		
		JLabel lblNewLabel_2_1 = new JLabel("Dough");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(10, 9, 266, 14);
		crescent.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		rdbtnStuffed = new JRadioButton("Stuffed");
		rdbtnStuffed.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnStuffed.setBounds(10, 30, 64, 23);
		crescent.add(rdbtnStuffed);
		
		rdbtnHomestyle = new JRadioButton("Homestyle");
		rdbtnHomestyle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnHomestyle.setBounds(10, 57, 75, 23);
		crescent.add(rdbtnHomestyle);
		
		rdbtnThin = new JRadioButton("Thin");
		rdbtnThin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnThin.setBounds(173, 57, 57, 23);
		crescent.add(rdbtnThin);
		
		rbtnCrescent.add(rdbtnPan); rbtnCrescent.add(rdbtnStuffed); rbtnCrescent.add(rdbtnHomestyle); rbtnCrescent.add(rdbtnThin);
 
 JLabel lblPrice1_2_1_1 = new JLabel("$5");
 lblPrice1_2_1_1.setBounds(121, 34, 46, 14);
 crescent.add(lblPrice1_2_1_1);
 
 JLabel lblPrice1_2_1_1_1 = new JLabel("$3");
 lblPrice1_2_1_1_1.setBounds(288, 34, 46, 14);
 crescent.add(lblPrice1_2_1_1_1);
 
 JLabel lblPrice1_2_1_1_1_1 = new JLabel("$3");
 lblPrice1_2_1_1_1_1.setBounds(288, 61, 46, 14);
 crescent.add(lblPrice1_2_1_1_1_1);
 
 JLabel lblPrice1_2_1_1_1_1_1 = new JLabel("$3");
 lblPrice1_2_1_1_1_1_1.setBounds(121, 61, 46, 14);
 crescent.add(lblPrice1_2_1_1_1_1_1);
		
		JPanel sauces = new JPanel();
		sauces.setLayout(null);
		sauces.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sauces.setBounds(149, 172, 343, 87);
		contentPane.add(sauces);
		
		/**
		 * Sauce Customization
		 */
		
		ButtonGroup rdbtnSauce = new ButtonGroup();
		
		JLabel lblPrice1_2_1_1_1_1_1_1_1_1_1 = new JLabel("$0");
		lblPrice1_2_1_1_1_1_1_1_1_1_1.setBounds(287, 60, 46, 14);
		sauces.add(lblPrice1_2_1_1_1_1_1_1_1_1_1);
		
		JLabel lblPrice1_2_1_1_1_1_1_1_1 = new JLabel("$3");
		lblPrice1_2_1_1_1_1_1_1_1.setBounds(121, 60, 46, 14);
		sauces.add(lblPrice1_2_1_1_1_1_1_1_1);
		
		JLabel lblPrice1_2_1_1_1_1_1_1_1_1 = new JLabel("$3");
		lblPrice1_2_1_1_1_1_1_1_1_1.setBounds(287, 32, 46, 14);
		sauces.add(lblPrice1_2_1_1_1_1_1_1_1_1);
		
		JLabel lblPrice1_2_1_1_1_1_1_1 = new JLabel("$3");
		lblPrice1_2_1_1_1_1_1_1.setBounds(121, 32, 46, 14);
		sauces.add(lblPrice1_2_1_1_1_1_1_1);
		
		rdbtnNoSauce = new JRadioButton("No Sauce");
		rdbtnNoSauce.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnNoSauce.setBounds(173, 56, 129, 23);
		sauces.add(rdbtnNoSauce);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Sauce");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1.setBounds(11, 10, 268, 14);
		sauces.add(lblNewLabel_2_1_1);
		
		rdbtnTomato = new JRadioButton("Tomato Sauce");
		rdbtnTomato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnTomato.setBounds(11, 28, 138, 23);
		sauces.add(rdbtnTomato);
		
		rdbtnAlfredoSauce = new JRadioButton("Alfredo Sauce");
		rdbtnAlfredoSauce.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnAlfredoSauce.setBounds(11, 56, 138, 23);
		sauces.add(rdbtnAlfredoSauce);
		
		rdbtnBbqSauce = new JRadioButton("BBQ Sauce");
		rdbtnBbqSauce.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnBbqSauce.setBounds(173, 28, 129, 23);
		sauces.add(rdbtnBbqSauce);
		
		rdbtnSauce.add(rdbtnBbqSauce); rdbtnSauce.add(rdbtnAlfredoSauce); rdbtnSauce.add(rdbtnTomato); rdbtnSauce.add(rdbtnNoSauce);
		
		JPanel toppings = new JPanel();
		toppings.setLayout(null);
		toppings.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		toppings.setBounds(148, 259, 344, 274);
		contentPane.add(toppings);
		
		/**
		 * Topping Customization
		 */
		
		JLabel lblToppings = new JLabel("Topping");
		lblToppings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblToppings.setHorizontalAlignment(SwingConstants.LEFT);
		lblToppings.setBounds(12, 11, 264, 14);
		toppings.add(lblToppings);
		
		
		//Pepperoni
		JLabel lblPepperoni = new JLabel("Pepperoni");
		lblPepperoni.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPepperoni.setBounds(12, 43, 109, 14);
		toppings.add(lblPepperoni);
		
		btnPepperoni = new JButton("Add");
		btnPepperoni.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPepperoni.setBounds(121, 38, 71, 23);
		toppings.add(btnPepperoni);
		
		btnrPepperoni = new JButton("Remove");
		btnrPepperoni.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnrPepperoni.setBounds(197, 38, 71, 23);
		toppings.add(btnrPepperoni);
		
		//Bacon
		JLabel lblBacon = new JLabel("Bacon");
		lblBacon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBacon.setBounds(12, 67, 109, 14);
		toppings.add(lblBacon);
		
		btnBacon = new JButton("Add");
		btnBacon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBacon.setBounds(121, 63, 71, 23);
		toppings.add(btnBacon);
		
		btnrBacon = new JButton("Remove");
		btnrBacon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnrBacon.setBounds(197, 63, 71, 23);
		toppings.add(btnrBacon);
		
		//Italian Sausage
		JLabel lblItalianSausage = new JLabel("Italian Sausage");
		lblItalianSausage.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblItalianSausage.setBounds(12, 92, 109, 14);
		toppings.add(lblItalianSausage);
		
		btnItalianS = new JButton("Add");
		btnItalianS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnItalianS.setBounds(121, 88, 71, 23);
		toppings.add(btnItalianS);

		btnrItalianS = new JButton("Remove");
		btnrItalianS.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnrItalianS.setBounds(197, 88, 71, 23);
		toppings.add(btnrItalianS);
		
		//Jalapenos
		JLabel lblJalapenos = new JLabel("Jalapenos");
		lblJalapenos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblJalapenos.setBounds(12, 117, 109, 14);
		toppings.add(lblJalapenos);
		
		btnJalapenos = new JButton("Add");
		btnJalapenos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnJalapenos.setBounds(121, 113, 71, 23);
		toppings.add(btnJalapenos);
		
		btnrJalapenos = new JButton("Remove");
		btnrJalapenos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnrJalapenos.setBounds(197, 113, 71, 23);
		toppings.add(btnrJalapenos);
		
		//Mushrooms
		JLabel lblMushroom = new JLabel("Mushroom");
		lblMushroom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMushroom.setBounds(12, 142, 109, 14);
		toppings.add(lblMushroom);
		
		btnrMushroom = new JButton("Remove");
		btnrMushroom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnrMushroom.setBounds(197, 138, 71, 23);
		toppings.add(btnrMushroom);
		
		btnMushroom = new JButton("Add");
		btnMushroom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMushroom.setBounds(121, 138, 71, 23);
		toppings.add(btnMushroom);
		
		//Pineapple
		JLabel lblPineapple = new JLabel("Pineapple");
		lblPineapple.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPineapple.setBounds(12, 167, 109, 14);
		toppings.add(lblPineapple);
		
		btnPineapple = new JButton("Add");
		btnPineapple.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPineapple.setBounds(121, 164, 71, 23);
		toppings.add(btnPineapple);
		
		btnrPineapple = new JButton("Remove");
		btnrPineapple.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnrPineapple.setBounds(197, 164, 71, 23);
		toppings.add(btnrPineapple);
		
		//Mozzarella Cheese
		JLabel lblMozzarellaCheese = new JLabel("Mozzarella Cheese");
		lblMozzarellaCheese.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMozzarellaCheese.setBounds(12, 192, 109, 14);
		toppings.add(lblMozzarellaCheese);
		
		btnMozzarella = new JButton("Add");
		btnMozzarella.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMozzarella.setBounds(121, 188, 71, 23);
		toppings.add(btnMozzarella);
		
		btnrMozzarella = new JButton("Remove");
		btnrMozzarella.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnrMozzarella.setBounds(197, 188, 71, 23);
		toppings.add(btnrMozzarella);
		
		//Green Peppers
		JLabel lblGreenPeppers = new JLabel("Green Peppers");
		lblGreenPeppers.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGreenPeppers.setBounds(12, 217, 109, 14);
		toppings.add(lblGreenPeppers);
		
		btnGreenPeppers = new JButton("Add");
		btnGreenPeppers.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGreenPeppers.setBounds(121, 214, 71, 23);
		toppings.add(btnGreenPeppers);
		
		btnrGreenPeppers = new JButton("Remove");
		btnrGreenPeppers.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnrGreenPeppers.setBounds(197, 214, 71, 23);
		toppings.add(btnrGreenPeppers);
		
		//Olives
		JLabel lblOlives = new JLabel("Olives");
		lblOlives.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOlives.setBounds(12, 242, 109, 14);
		toppings.add(lblOlives);
		
		btnOlives = new JButton("Add");
		btnOlives.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnOlives.setBounds(121, 238, 71, 23);
		toppings.add(btnOlives);
		
		btnrOlives = new JButton("Remove");
		btnrOlives.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnrOlives.setBounds(197, 238, 71, 23);
		toppings.add(btnrOlives);
		
		JLabel lblPrice1_2_1_1_1_1_1_1_1_1_1_1 = new JLabel("$0.5");
		lblPrice1_2_1_1_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice1_2_1_1_1_1_1_1_1_1_1_1.setBounds(278, 43, 46, 14);
		toppings.add(lblPrice1_2_1_1_1_1_1_1_1_1_1_1);
		
		JLabel lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1 = new JLabel("$0.5");
		lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1.setBounds(278, 67, 46, 14);
		toppings.add(lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1);
		
		JLabel lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_1 = new JLabel("$0.5");
		lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_1.setBounds(278, 92, 46, 14);
		toppings.add(lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_1);
		
		JLabel lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_2 = new JLabel("$0.5");
		lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_2.setBounds(278, 117, 46, 14);
		toppings.add(lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_2);
		
		JLabel lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_3 = new JLabel("$0.5");
		lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_3.setBounds(278, 142, 46, 14);
		toppings.add(lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_3);
		
		JLabel lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_4 = new JLabel("$0.5");
		lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_4.setBounds(278, 167, 46, 14);
		toppings.add(lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_4);
		
		JLabel lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_5 = new JLabel("$0.5");
		lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_5.setBounds(278, 192, 46, 14);
		toppings.add(lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_5);
		
		JLabel lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_6 = new JLabel("$0.5");
		lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_6.setBounds(278, 217, 46, 14);
		toppings.add(lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_6);
		
		JLabel lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_7 = new JLabel("$0.5");
		lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_7.setBounds(278, 242, 46, 14);
		toppings.add(lblPrice1_2_1_1_1_1_1_1_1_1_1_1_1_7);
		

		
		/**
		 * Miscellaneous
		 */
		
		JPanel sauces_1 = new JPanel();
		sauces_1.setLayout(null);
		sauces_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sauces_1.setBounds(148, 532, 344, 123);
		contentPane.add(sauces_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Special Instructions");
		lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1_1_2.setBounds(10, 5, 268, 14);
		sauces_1.add(lblNewLabel_2_1_1_2);
		
		JPanel instructions = new JPanel();
		instructions.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		instructions.setBounds(10, 22, 324, 90);
		sauces_1.add(instructions);
		instructions.setLayout(null);
		
		JTextArea textInstructions = new JTextArea();
		textInstructions.setBounds(2, 2, 322, 85);
		instructions.add(textInstructions);
		textInstructions.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnrPepperoni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}

		});
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// Size
		if(rdbtnS.isSelected()) {
			pizzaOrder.setSize("small");
		}
		if(rdbtnM.isSelected()) {
			pizzaOrder.setSize("medium");
		}
		if(rdbtnL.isSelected()) {
			pizzaOrder.setSize("large");
		}
		if(rdbtnXL.isSelected()) {
			pizzaOrder.setSize("extra large");
		}
		
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JTextArea;


public class Main extends JFrame {
	
	RestaurantServer server = new RestaurantServer();
	
	Pizza pizzaOrder = new Pizza();
	String cartList, sizeList, crescentList, sauceList, ingredientsList;
	JLabel lblTotal = new JLabel();
	JTextArea receipt = new JTextArea();
	JRadioButton rdbtnS, rdbtnM, rdbtnL, rdbtnXL;
	JRadioButton rdbtnStuffed, rdbtnPan, rdbtnHomestyle, rdbtnThin;
	JRadioButton rdbtnTomato, rdbtnBbqSauce, rdbtnAlfredoSauce, rdbtnPestoSauce;
	JButton btnPepperoni, btnBacon, btnItalianS, btnJalapenos, btnMushroom, btnPineapple, btnMozzarella, btnGreenPeppers, btnOlives;
	JButton btnrPepperoni, btnrBacon, btnrItalianS, btnrJalapenos, btnrMushroom, btnrPineapple, btnrMozzarella, btnrGreenPeppers, btnrOlives;
	
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
	 * Create the frame (JFrame)
	 */
	 public Main() {
		setTitle("Byte Sized");
		setForeground(new Color(238, 238, 238));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 694);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * JPanel (Content)
		 */
		JPanel pizza = new JPanel();
		pizza.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pizza.setBounds(-1, 0, 220, 655);
		contentPane.add(pizza);
		pizza.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pizza");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 7, 130, 14);
		pizza.add(lblNewLabel);
		
		JPanel cart = new JPanel();
		cart.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cart.setBounds(10, 29, 200, 558);
		pizza.add(cart);
		cart.setLayout(new BoxLayout(cart, BoxLayout.X_AXIS));
		receipt.setWrapStyleWord(true);
		receipt.setLineWrap(true);
		
		receipt.setText("Size:\n" + 
				"\n\nCrust:\n" + 
				"\n\nSauce:\n" + 
				"\n\nToppings:\n" + 
				"\n\nInstructions"
				); 
				
		receipt.setEditable(false);
		cart.add(receipt);
		
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(46, 621, 127, 23);
		pizza.add(btnCheckout);
		btnCheckout.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 587, 200, 23);
		pizza.add(panel);
		panel.setLayout(null);
		
		lblTotal.setText("Total: $");
		lblTotal.setBounds(10, 4, 110, 14);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.add(lblTotal);
		
		JPanel size = new JPanel();
		size.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		size.setBounds(220, 0, 344, 87);
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
		
		JLabel lblpriceSmall = new JLabel("$3");
		lblpriceSmall.setBounds(121, 28, 46, 14);
		size.add(lblpriceSmall);
		
		JLabel lblpriceLarge = new JLabel("$6");
		lblpriceLarge.setBounds(121, 61, 46, 14);
		size.add(lblpriceLarge);
		
		JLabel lblpriceMedium = new JLabel("$4");
		lblpriceMedium.setBounds(288, 28, 46, 14);
		size.add(lblpriceMedium);
		
		JLabel lblpriceXLarge = new JLabel("$8");
		lblpriceXLarge.setBounds(288, 61, 46, 14);
		size.add(lblpriceXLarge);
		
		JPanel crescent = new JPanel();
		crescent.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		crescent.setBounds(220, 85, 344, 87);
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
 
 JLabel lblpriceStuffed = new JLabel("$5");
 lblpriceStuffed.setBounds(121, 34, 46, 14);
 crescent.add(lblpriceStuffed);
 
 JLabel lblpricePan = new JLabel("$3");
 lblpricePan.setBounds(288, 34, 46, 14);
 crescent.add(lblpricePan);
 
 JLabel lblpriceThin = new JLabel("$3");
 lblpriceThin.setBounds(288, 61, 46, 14);
 crescent.add(lblpriceThin);
 
 JLabel lblpriceHomestyle = new JLabel("$3");
 lblpriceHomestyle.setBounds(121, 61, 46, 14);
 crescent.add(lblpriceHomestyle);
		
		JPanel sauces = new JPanel();
		sauces.setLayout(null);
		sauces.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sauces.setBounds(221, 172, 343, 87);
		contentPane.add(sauces);
		
		/**
		 * Sauce Customization
		 */

		
		JLabel lblpriceNoSauce = new JLabel("$0");
		lblpriceNoSauce.setBounds(287, 60, 46, 14);
		sauces.add(lblpriceNoSauce);
		
		JLabel lblpriceAlfredo = new JLabel("$3");
		lblpriceAlfredo.setBounds(121, 60, 46, 14);
		sauces.add(lblpriceAlfredo);
		
		JLabel lblpriceBBQ = new JLabel("$3");
		lblpriceBBQ.setBounds(287, 32, 46, 14);
		sauces.add(lblpriceBBQ);
		
		JLabel lblpriceTomato = new JLabel("$3");
		lblpriceTomato.setBounds(121, 32, 46, 14);
		sauces.add(lblpriceTomato);
		
		rdbtnPestoSauce = new JRadioButton("Pesto Sauce");
		rdbtnPestoSauce.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnPestoSauce.setBounds(173, 56, 102, 23);
		sauces.add(rdbtnPestoSauce);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Sauce");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1.setBounds(11, 10, 268, 14);
		sauces.add(lblNewLabel_2_1_1);
		
		rdbtnTomato = new JRadioButton("Tomato Sauce");
		rdbtnTomato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnTomato.setBounds(11, 28, 102, 23);
		sauces.add(rdbtnTomato);
		
		rdbtnAlfredoSauce = new JRadioButton("Alfredo Sauce");
		rdbtnAlfredoSauce.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnAlfredoSauce.setBounds(11, 56, 104, 23);
		sauces.add(rdbtnAlfredoSauce);
		
		rdbtnBbqSauce = new JRadioButton("BBQ Sauce");
		rdbtnBbqSauce.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnBbqSauce.setBounds(173, 28, 102, 23);
		sauces.add(rdbtnBbqSauce);
		
		JPanel toppings = new JPanel();
		toppings.setLayout(null);
		toppings.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		toppings.setBounds(220, 259, 344, 274);
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
	
		btnPepperoni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(lblToppings, lblPepperoni);;
		}
	 });
		
		btnrPepperoni = new JButton("Remove");
		btnrPepperoni.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnrPepperoni.setBounds(197, 38, 71, 23);
		toppings.add(btnrPepperoni);
		 
		toppingLabel(toppings, "Bacon", 63, 50);
		toppingLabel(toppings, "Italian Sausage", 88, 50);
		toppingLabel(toppings, "Jalapenos", 113, 50);
		toppingLabel(toppings, "Mushroom", 138, 50);
		toppingLabel(toppings, "Pineapple", 163, 50);
		toppingLabel(toppings, "Mozzarella Cheese", 188, 50);
		toppingLabel(toppings, "Green Peppers", 213, 50);
		toppingLabel(toppings, "Olives", 238, 50);

		// Topping Pricing
		JLabel lblpricePepperoni = new JLabel("$0.5");
		lblpricePepperoni.setHorizontalAlignment(SwingConstants.CENTER);
		lblpricePepperoni.setBounds(278, 43, 46, 14);
		toppings.add(lblpricePepperoni);
		
		/**
		 * Miscellaneous
		 */
		
		JPanel sauces_1 = new JPanel();
		sauces_1.setLayout(null);
		sauces_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sauces_1.setBounds(220, 532, 344, 80);
		contentPane.add(sauces_1);
		
		JLabel lblSpecialInstructions = new JLabel("Special Instructions");
		lblSpecialInstructions.setHorizontalAlignment(SwingConstants.LEFT);
		lblSpecialInstructions.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSpecialInstructions.setBounds(10, 5, 268, 14);
		sauces_1.add(lblSpecialInstructions);
		
		JPanel instructions = new JPanel();
		instructions.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		instructions.setBounds(10, 22, 324, 47);
		sauces_1.add(instructions);
		instructions.setLayout(null);
		
		JTextArea textInstructions = new JTextArea();
		textInstructions.setBounds(2, 2, 322, 45);
		instructions.add(textInstructions);
		textInstructions.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(220, 612, 344, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(126, 10, 92, 23);
		panel_1.add(btnSubmit);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		/**
		 * Cart Function
		 */
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int total = 0, priceSize = 0, priceCrust = 0, priceSauce = 0, priceTopping = 0;
				
				// Size
				if(rdbtnS.isSelected()) {
					pizzaOrder.setSize("small");
					priceSize = 3;
				}
				if(rdbtnM.isSelected()) {
					pizzaOrder.setSize("medium");
					priceSize = 4;
				}
				if(rdbtnL.isSelected()) {
					pizzaOrder.setSize("large");
					priceSize = 6;
				}
				if(rdbtnXL.isSelected()) {
					pizzaOrder.setSize("extra large");
					priceSize = 8;
				}
				
				// Crescent
				if(rdbtnStuffed.isSelected()) {
					pizzaOrder.setCrust("stuffed");
					priceCrust = 5;
				}
				if(rdbtnPan.isSelected()) {
					pizzaOrder.setCrust("pan");
					priceCrust = 3;
				}
				if(rdbtnHomestyle.isSelected()) {
					pizzaOrder.setCrust("homestyle");
					priceCrust = 3;
				}
				if(rdbtnThin.isSelected()) {
					pizzaOrder.setCrust("thin");
					priceCrust = 3;
				}
				
				// Sauce
				String[] sauces = new String[4];
				int count = 0;
				
				if(rdbtnTomato.isSelected()) {
					sauces[count] = "tomato sauce";
					priceSauce += 3;
					count++;
				}
				if(rdbtnBbqSauce.isSelected()) {
					sauces[count] = "bbq sauce";
					priceSauce += 3;
					count++;
				}
				if(rdbtnAlfredoSauce.isSelected()) {
					sauces[count] = "alfredo sauce";
					priceSauce += 3;
					count++;
				}
				if(rdbtnPestoSauce.isSelected()) {
					sauces[count] = "pesto sauce";
					priceSauce += 3;
					count++;
				}
				
				pizzaOrder.setSauces(sauces);
				
				
				
				// Construct
				total = priceSize + priceCrust + priceSauce + priceTopping;
				
				if (pizzaOrder.getCrust() == null) {
					pizzaOrder.setCrust("none");
				}
				
				if (pizzaOrder.getSauces() == null) {
					sauces[0] = "none";
					pizzaOrder.setSauces(sauces);
				}
				
				receipt.setText(
						"Size:\n" + pizzaOrder.getSize() + 
						"\n\nCrust:\n" + pizzaOrder.getCrust().getName() + 
						"\n\nSauce:\n" + Arrays.toString(sauces) + 
						"\n\nToppings:\n" + pizzaOrder.getToppings() +
						"\n\nInstructions:\n" + textInstructions.getText()
						);
				
				lblTotal.setText("Total: $" + total);
			}	
			
		});
		
	}

	private void toppingLabel(JPanel host, String name, int coord, int price) {
		JLabel lbl = new JLabel(name);
		Font text = new Font("Tahoma", Font.PLAIN, 11);
		lbl.setFont(text);
		lbl.setBounds(12, coord + 4, 109, 14);
		host.add(lbl);
		
		JButton btnl = new JButton("Add");
		btnl.setFont(text);
		btnl.setBounds(121, coord, 71, 23);
		host.add(btnl);
		
		JButton btnr = new JButton("Remove");
		btnr.setFont(text);
		btnr.setBounds(197, coord, 71, 23);
		host.add(btnr);
		
		JLabel plbl = new JLabel(intTo$(price));
		plbl.setHorizontalAlignment(SwingConstants.CENTER);
		plbl.setBounds(278, coord + 4, 46, 14);
		host.add(plbl);

	 }
	
	private String intTo$(int amount) {//a bit too much of a util for my comfort
		int dollars = amount / 100;
		int cents = amount % 100;
		return "$"+dollars+"."+String.format("%02d", cents);
	}
}
	

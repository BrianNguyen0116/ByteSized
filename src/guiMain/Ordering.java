import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class Ordering extends JFrame {
	
	Pizza pizzaOrder = new Pizza();
	JLabel lblTotal = new JLabel();
	JTextArea receipt = new JTextArea();
	JTextArea textInstructions = new JTextArea();
	
	HashMap<String, Integer> topmap= new HashMap<String, Integer>();
	
	int tcount = 0; int total = 0, priceSize = 0, priceCrust = 0, priceSauce = 0, priceTopping = 0;
	float discount = 0;
	
	private JPanel contentPane;
	private JTextField textCoupon;

	 public Ordering() {
		
		setTitle("Byte Sized");
		setForeground(new Color(238, 238, 238));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 694);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * JPanel (Content)
		 */
		JPanel pizza = new JPanel();
		pizza.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pizza.setBounds(-1, 43, 220, 612);
		contentPane.add(pizza);
		pizza.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pizza");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 7, 130, 14);
		pizza.add(lblNewLabel);
		
		JPanel cart = new JPanel();
		cart.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cart.setBounds(10, 29, 200, 482);
		pizza.add(cart);
		cart.setLayout(new BoxLayout(cart, BoxLayout.X_AXIS));
		receipt.setWrapStyleWord(true);
		receipt.setLineWrap(true);
		
		receipt.setText("Size:\r\n\r\n\r\nCrust:\r\n\r\n\r\nSauce:\r\n\r\n\r\nToppings:\r\n\r\n\r\nInstructions:"
				); 
				
		receipt.setEditable(false);
		cart.add(receipt);
		
		
		// Checkout
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(123, 522, 87, 23);
		pizza.add(btnCheckout);
		btnCheckout.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (pizzaOrder.getSize() == null) {
					btnCheckout.setText("Submit Pizza First!");
					return;
				}
				
				SerializedInventory.getInstance().getInventory().putOrder(pizzaOrder);
				SerializedInventory.getInstance().saveInventory();
				
				JOptionPane.showMessageDialog(cart, "Purchased!");
				Ordering frame = new Ordering();
				frame.setVisible(true);
				dispose();
		}
	 });
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 522, 107, 23);
		pizza.add(panel);
		panel.setLayout(null);
		
		//lblTotal.setText(test);
		lblTotal.setText("Total: $");
		lblTotal.setBounds(10, 4, 84, 14);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.add(lblTotal);
		
		
		JPanel size = new JPanel();
		size.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		size.setBounds(220, 0, 415, 87);
		contentPane.add(size);
		size.setLayout(null);
		
		/**
		 * Size Customization
		 */
		
		JLabel lblNewLabel_2 = new JLabel("Size");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 7, 33, 14);
		size.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
	
		
		
		 
		int width = 2;
		int sizeheight = 2;
		HashMap<String, Integer> sizeprice = getSizePrices();
		ArrayList<Item> sortedsize = sortedBy(sizeprice, true);
		JRadioButton[] sizes = new JRadioButton[width*sizeheight];

		
		for (int y = 0, i = 0; i < sortedsize.size() && (y < sizeheight); y++) {
			for (int x = 0; x < width && i < sortedsize.size(); x++) {
				sizes[i] = radioLabel(size, sortedsize.get(i).getName(), x *230 , y * 33, sizeprice.get(sortedsize.get(i).getName()));
				i++;
			}
		}
		
		ButtonGroup rbtnSize = toBtnGroup(sizes);
		
		 
		JPanel crescent = new JPanel();
		crescent.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		crescent.setBounds(220, 85, 415, 87);
		contentPane.add(crescent);
		crescent.setLayout(null);


		/**
		 * Crescent Customization
		 */
		JLabel lblDough = new JLabel("Dough");
		lblDough.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDough.setBounds(10, 9, 49, 14);
		crescent.add(lblDough);
		lblDough.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		
		//int width = 2;
		int doughheight = 2;
		HashMap<String, Integer> doughprice = getDoughPrices();
		ArrayList<Item> sorteddough = sortedBy(doughprice, true);
		JRadioButton[] doughs = new JRadioButton[width*doughheight];

		
		for (int y = 0, i = 0; i < sorteddough.size() && (y < doughheight); y++) {
			for (int x = 0; x < width && i < sorteddough.size(); x++) {
				doughs[i] = radioLabel(crescent, sorteddough.get(i).getName(), x *230 , y * 33, doughprice.get(sorteddough.get(i).getName()));
				i++;
			}
		}
		
		ButtonGroup rbtnCrescent = toBtnGroup(doughs);
		
		JPanel sauces = new JPanel();
		sauces.setLayout(null);
		sauces.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sauces.setBounds(220, 172, 415, 87);
		contentPane.add(sauces);
		
		/**
		 * Sauce Customization
		 */
		
		JLabel lblSauce = new JLabel("Sauce");
		lblSauce.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSauce.setHorizontalAlignment(SwingConstants.LEFT);
		lblSauce.setBounds(10, 10, 44, 14);
		sauces.add(lblSauce);
		
		
		
		int sauceheight = 2;
		HashMap<String, Integer> sauceprice = getSaucePrices();
		ArrayList<Item> sortedsauce = sortedBy(sauceprice, true);
		JRadioButton[] saucebuts = new JRadioButton[width*doughheight];

		
		for (int y = 0, i = 0; i < sortedsauce.size() && (y < sauceheight); y++) {
			for (int x = 0; x < width && i < sortedsauce.size(); x++) {
				saucebuts[i] = radioLabel(sauces, sortedsauce.get(i).getName(), x *230 , y * 33, sauceprice.get(sortedsauce.get(i).getName()));
				i++;
			}
		}
		
		JPanel toppings = new JPanel();
		toppings.setLayout(null);
		toppings.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		toppings.setBounds(220, 259, 415, 274);
		contentPane.add(toppings);
		
		/**
		 * Topping Customization
		 */

		JLabel lblToppings = new JLabel("Topping");
		lblToppings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblToppings.setHorizontalAlignment(SwingConstants.LEFT);
		lblToppings.setBounds(12, 11, 51, 14);
		toppings.add(lblToppings);
	
	
		HashMap<String, Integer> toppingdata = getToppingPrices();
		
		int tindex = 0;
		for (String k : toppingdata.keySet()) {
			toppingLabel(toppings, k, 38 + tindex * 25, toppingdata.get(k));
			tindex++;
		}
		
		/**
		 * Miscellaneous
		 */
		
		JPanel sauces_1 = new JPanel();
		sauces_1.setLayout(null);
		sauces_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sauces_1.setBounds(220, 532, 415, 80);
		contentPane.add(sauces_1);
		
		JLabel lblSpecialInstructions = new JLabel("Special Instructions");
		lblSpecialInstructions.setHorizontalAlignment(SwingConstants.LEFT);
		lblSpecialInstructions.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSpecialInstructions.setBounds(10, 5, 268, 14);
		sauces_1.add(lblSpecialInstructions);
		
		JPanel instructions = new JPanel();
		instructions.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		instructions.setBounds(10, 22, 395, 47);
		sauces_1.add(instructions);
		instructions.setLayout(null);
		
		textInstructions.setBounds(2, 2, 391, 45);
		instructions.add(textInstructions);
		textInstructions.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(220, 612, 415, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		

		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.add(btnClear);
		
		btnClear.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rbtnSize.clearSelection();
				rbtnCrescent.clearSelection();
				topmap.clear();
				tcount = 0;
				for (JRadioButton i: saucebuts) {
					i.setSelected(false);
				}
			}
		});
		
			
		
		/**
		 * Cart Function
		 */
		
		JButton btnSubmit = new JButton("Submit");
		panel_1.add(btnSubmit);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(-1, 0, 220, 43);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome Back");
		lblWelcome.setBounds(69, 9, 82, 14);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_2.add(lblWelcome);
		
		JLabel lblcurrUsername = new JLabel(Main.currUsername);
		lblcurrUsername.setBounds(10, 22, 200, 14);
		lblcurrUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblcurrUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_2.add(lblcurrUsername);
		
		// Admin 

						if (lblcurrUsername.getText() == "admin") {	
						RoundText lblinvTopping = new RoundText("i");
						lblinvTopping.setHorizontalAlignment(SwingConstants.CENTER);
						lblinvTopping.setBounds(387, 11, 18, 14);
						toppings.add(lblinvTopping);
						
						RoundText lblinvSize = new RoundText("i");
						lblinvSize.setHorizontalAlignment(SwingConstants.CENTER);
						lblinvSize.setBounds(387, 7, 18, 14);
						size.add(lblinvSize);
						
						RoundText lblinvDough = new RoundText("i");
						lblinvDough.setHorizontalAlignment(SwingConstants.CENTER);
						lblinvDough.setBounds(387, 9, 18, 14);
						crescent.add(lblinvDough);
						
						JLabel lblinvSauce = new RoundText("i");
						lblinvSauce.setHorizontalAlignment(SwingConstants.CENTER);
						lblinvSauce.setBounds(387, 10, 18, 14);
						sauces.add(lblinvSauce);
						}
		
						
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				total = 0; priceSize = 0; priceCrust = 0; priceSauce = 0; priceTopping = 0;
				
				if (rbtnSize.getSelection() == null ) {
					btnSubmit.setText("Need Size!");
					return;
				}
				if (rbtnCrescent.getSelection() == null ) {
					btnSubmit.setText("No Dough!");
					return;
				}
				
				// Size
				String finalsize = rbtnSize.getSelection().getActionCommand();
				pizzaOrder.setSize(finalsize);
				priceSize = sizeprice.get(finalsize);
				
				// Crescent
				String finalcrust = rbtnCrescent.getSelection().getActionCommand();
				pizzaOrder.setCrust(finalcrust);
				priceCrust = doughprice.get(finalcrust);
				
				// Sauce
				String[] sauces = new String[4];
				int scount = 0;
				
				for (JRadioButton i: saucebuts) {
					if (i.isSelected()) {
						sauces[scount] = i.getActionCommand();
						priceSauce += sauceprice.get(sauces[scount]);
						scount++;
					}
				}

				pizzaOrder.setSauces(sauces);
				
				// Readability Improvement
			    List<String> list = new ArrayList<String>();

			    for(String s : sauces) {
			       if(s != null && s.length() > 0) {
			          list.add(s);
			       }
			    }

			    sauces = list.toArray(new String[list.size()]);
			    
			    //Topping processing
				String[] temp = new String[tcount];
				int c = 0;
				for (String i : topmap.keySet()) {
					for (int z = topmap.get(i); z > 0; z--) {
						temp[c] = i;
						priceTopping += toppingdata.get(i);
						c++;
					}
				}
				
				pizzaOrder.setToppings(temp);
				
				// Construct
				total = (priceSize + priceCrust + priceSauce + priceTopping);
				
				if (discount != 0) {
					total *= discount;
				}
				
				System.out.println(priceSize);
				System.out.println(priceSauce);
				System.out.println(priceCrust);
				System.out.println(priceTopping);
				System.out.println(discount);

				
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
						"\n\nToppings:\n" + Arrays.toString(pizzaOrder.getToppingnames()) +
						"\n\nInstructions:\n" + textInstructions.getText()
						);
				
				lblTotal.setText("Total: " + intTo$(total));
				
				btnSubmit.setText("Submit");
				//SerializedInventory.getInstance().getInventory().getItem("Pepperoni").setPrice(690);
			}	
			
		});
		
		// Coupon Feature
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 556, 107, 23);
		pizza.add(panel_3);
				
		textCoupon = new HintText("Enter Code");
		textCoupon.setBounds(1, 1, 105, 21);
		panel_3.add(textCoupon);
		textCoupon.setColumns(10);
				
		JButton btnCoupon = new JButton("Apply");
		btnCoupon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCoupon.setBounds(123, 556, 87, 23);
		pizza.add(btnCoupon);
		
		JLabel lblError = new JLabel("");
		btnCoupon.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblError.setBackground(new Color(255, 255, 255));
		lblError.setBounds(20, 587, 177, 14);
		pizza.add(lblError);
				
		btnCoupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String input = textCoupon.getText();
				
				try {
				SerializedInventory.getInstance().getCoupon(input);
				} catch (Exception e) {
					lblError.setForeground(Color.red);
					lblError.setText("The code you entered is not recognized.");
					return;
				}
				
				discount = SerializedInventory.getInstance().getCoupon(input).getDiscount();
				System.out.println(discount);
				discount = Math.abs(discount - 100); 
				System.out.println(discount);
				discount /= 100;
				System.out.println(discount);

				lblError.setForeground(Color.black);
				lblError.setText("Coupon successful!");
					
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
		plbl.setBounds(288, coord + 4, 46, 14);
		host.add(plbl);
		
		btnl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (topmap.get(name) == null) {
					topmap.put(name,1);
				} else {
					topmap.put(name, topmap.get(name)+1);
				}
				tcount++;
			}
		});
		
		btnr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (topmap.get(name) != null && topmap.get(name) > 0) {
					topmap.put(name, topmap.get(name)-1);
					tcount--;
				}
			}
		});
		

	 }
	
	private JRadioButton radioLabel(JPanel host, String name, int xcoord, int ycoord, int price) {
		JLabel lblprice = new JLabel(intTo$(price));
		lblprice.setBounds(121 + xcoord, 28 + ycoord, 46, 14);
		host.add(lblprice);
		
		JRadioButton rdbtn = new JRadioButton(name);
		rdbtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtn.setBounds(10 + xcoord, 24 + ycoord, 102, 23);
		rdbtn.setActionCommand(name);
		host.add(rdbtn);
		
		//group.add(rdbtn);
		return rdbtn;
	}
	
	public static String intTo$(int amount) {//a bit too much of a util for my comfort
		int dollars = amount / 100;
		int cents = amount % 100;
		return "$"+dollars+"."+String.format("%02d", cents);
	}
	
	
	
	
	public static HashMap<String, Integer> getToppingPrices() {
		
		SerializedInventory database = SerializedInventory.getInstance();
		HashMap<String, Integer> result= database.getInventory().getpricemap("toppings");
		
		//HashMap<String, Integer> result = new HashMap<String, Integer>();
		
		//HashMap<String, Integer> result = new HashMap<String, Integer>();
		/*
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		result.put("Pepperoni", 50);
		result.put("Bacon", 50);
		result.put("Italian Sausage", 50);
		result.put("Jalapenos", 125);
		result.put("Mushroom", 75);
		result.put("Pineapple", 290);
		result.put("Mozzarella Cheese", 35);
		result.put("Green Peppers", 90);
		result.put("Olives", 45);
		*/
		
		return result;
	}
	
	public static HashMap<String, Integer> getDoughPrices() {
		
		SerializedInventory database = SerializedInventory.getInstance();
		HashMap<String, Integer> result= database.getInventory().getpricemap("dough");
		
		/*
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		result.put("Stuffed", 500);
		result.put("Pan", 300);
		result.put("Homestyle", 300);
		result.put("Thin", 300);
		*/
		
		return result;
	}
	
	public static HashMap<String, Integer> getSizePrices() {		
		
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		result.put("Small", 300);
		result.put("Medium", 400);
		result.put("Large", 600);
		result.put("X-Large", 800);
		
		
		return result;
	}
	
	public static HashMap<String, Integer> getSaucePrices() {
		
		SerializedInventory database = SerializedInventory.getInstance();
		HashMap<String, Integer> result= database.getInventory().getpricemap("sauce");
		//HashMap<String, Integer> result= database.getInventory().getSaucepricemap();
		
		/*
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		result.put("Tomato Sauce", 300);
		result.put("BBQ Sauce", 300);
		result.put("Alfredo Sauce", 300);
		result.put("Pesto Sauce", 300);
		*/
		
		return result;
	}
	
	public static ArrayList<Item> sortedBy(HashMap<String,Integer> pricemap, Boolean byprice){
		if (pricemap == null) return null;
		
		ArrayList<Item> buffer = new ArrayList<Item>();
		if (pricemap.size() == 0) return buffer;
		
		for (String k : pricemap.keySet()) {
			buffer.add(new Item(k));
		}
		
		ArrayList<Item> result= new ArrayList<Item>();
		
		for (result.add(buffer.remove(0)); buffer.size() > 0;) {
			Item comparison = buffer.remove(0);
			int i = 0;
			for (; i < result.size() ;i++) {
				if (byprice && pricemap.get(comparison.getName()) < pricemap.get(result.get(i).getName())) break; //sort by price
				else if (!byprice && comparison.getName().compareTo(result.get(i).getName()) < 0 ) break; //sort alphabetically
			}
			result.add(i, comparison);
		}
		
		return result;
	}
	
	public static ButtonGroup toBtnGroup(JRadioButton[] input) {
		ButtonGroup output = new ButtonGroup();
		
		for (JRadioButton i:input) {
			if (i==null)break;
			output.add(i);
		}
		return output;
	}
}

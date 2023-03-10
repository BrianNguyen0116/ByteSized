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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JTextArea;


public class Main extends JFrame {
	
	RestaurantServer server = new RestaurantServer();
	
	Pizza pizzaOrder = new Pizza();
	JLabel lblTotal = new JLabel();
	JTextArea receipt = new JTextArea();
	JTextArea textInstructions = new JTextArea();
	
	HashMap<String, Integer> topmap= new HashMap<String, Integer>();
	
	int tcount = 0;
	
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
		
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(cart, "Purchased!");
				Main frame = new Main();
				frame.setVisible(true);
				dispose();
		}
	 });
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 587, 200, 23);
		pizza.add(panel);
		panel.setLayout(null);
		
		//lblTotal.setText(test);
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
		
		JLabel lblNewLabel_2 = new JLabel("Size");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 7, 266, 14);
		size.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		 
		int width = 2;
		int sizeheight = 2;
		HashMap<String, Integer> sizeprice = getSizePrices();
		ArrayList<Item> sortedsize = sortedBy(sizeprice, true);
		JRadioButton[] sizes = new JRadioButton[width*sizeheight];

		
		for (int y = 0, i = 0; i < sortedsize.size() && (y < sizeheight); y++) {
			for (int x = 0; x < width && i < sortedsize.size(); x++) {
				sizes[i] = radioLabel(size, sortedsize.get(i).getName(), x *167 , y * 33, sizeprice.get(sortedsize.get(i).getName()));
				i++;
			}
		}
		
		ButtonGroup rbtnSize = toBtnGroup(sizes);
		
		 
		JPanel crescent = new JPanel();
		crescent.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		crescent.setBounds(220, 85, 344, 87);
		contentPane.add(crescent);
		crescent.setLayout(null);
		
		/**
		 * Crescent Customization
		 */
		
		
		JLabel lblNewLabel_2_1 = new JLabel("Dough");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(10, 9, 266, 14);
		crescent.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		//int width = 2;
		int doughheight = 2;
		HashMap<String, Integer> doughprice = getDoughPrices();
		ArrayList<Item> sorteddough = sortedBy(doughprice, true);
		JRadioButton[] doughs = new JRadioButton[width*doughheight];

		
		for (int y = 0, i = 0; i < sorteddough.size() && (y < doughheight); y++) {
			for (int x = 0; x < width && i < sorteddough.size(); x++) {
				doughs[i] = radioLabel(crescent, sorteddough.get(i).getName(), x *167 , y * 33, doughprice.get(sorteddough.get(i).getName()));
				i++;
			}
		}
		
		ButtonGroup rbtnCrescent = toBtnGroup(doughs);
		
		JPanel sauces = new JPanel();
		sauces.setLayout(null);
		sauces.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sauces.setBounds(221, 172, 343, 87);
		contentPane.add(sauces);
		
		/**
		 * Sauce Customization
		 */
		
		JLabel lblSauce = new JLabel("Sauce");
		lblSauce.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSauce.setHorizontalAlignment(SwingConstants.LEFT);
		lblSauce.setBounds(11, 10, 268, 14);
		sauces.add(lblSauce);
		
		int sauceheight = 2;
		HashMap<String, Integer> sauceprice = getSaucePrices();
		ArrayList<Item> sortedsauce = sortedBy(sauceprice, true);
		JRadioButton[] saucebuts = new JRadioButton[width*doughheight];

		
		for (int y = 0, i = 0; i < sortedsauce.size() && (y < sauceheight); y++) {
			for (int x = 0; x < width && i < sortedsauce.size(); x++) {
				saucebuts[i] = radioLabel(sauces, sortedsauce.get(i).getName(), x *167 , y * 33, sauceprice.get(sortedsauce.get(i).getName()));
				i++;
			}
		}
		
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
						"\n\nToppings:\n" + Arrays.toString(pizzaOrder.getToppingnames()) +
						"\n\nInstructions:\n" + textInstructions.getText()
						);
				
				lblTotal.setText("Total: " + intTo$(total));
				
				btnSubmit.setText("Submit");
				//SerializedInventory.getInstance().getInventory().getItem("Pepperoni").setPrice(690);
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
	
	private String intTo$(int amount) {//a bit too much of a util for my comfort
		int dollars = amount / 100;
		int cents = amount % 100;
		return "$"+dollars+"."+String.format("%02d", cents);
	}
	
	
	
	
	public HashMap<String, Integer> getToppingPrices() {
		
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
	
	public HashMap<String, Integer> getDoughPrices() {
		
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
	
	public HashMap<String, Integer> getSizePrices() {		
		
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		result.put("Small", 300);
		result.put("Medium", 400);
		result.put("Large", 600);
		result.put("X-Large", 800);
		
		
		return result;
	}
	
	public HashMap<String, Integer> getSaucePrices() {
		
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
	
	public ArrayList<Item> sortedBy(HashMap<String,Integer> pricemap, Boolean byprice){
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
	
	public ButtonGroup toBtnGroup(JRadioButton[] input) {
		ButtonGroup output = new ButtonGroup();
		
		for (JRadioButton i:input) {
			if (i==null)break;
			output.add(i);
		}
		return output;
	}
}

	
	

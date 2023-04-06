import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileReader;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.BevelBorder;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextField;


public class inventoryDisplay extends JFrame{
	
	private JPanel contentPane;

	public inventoryDisplay(String s) {
		
		/**
		 * Basic Page initialization
		 */
		
		setTitle("Admin");
		setForeground(new Color(238, 238, 238));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 694);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Initializing contents panel which will host the displayed database info
		 */
		
		JPanel contents = new JPanel();
		contents.setLayout(null);
		contents.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contents.setBounds(25, 53, 580, 450);
		contentPane.add(contents);
		
		/**
		 * Initializing tabs panel which will host buttons to access different categories of database entries
		 */
		
		JPanel tabs = new JPanel();
		tabs.setLayout(null);
		tabs.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		tabs.setBounds(25, 25, 651, 27);
		contentPane.add(tabs);
		
		/**
		 * Populating tabs panel with buttons.
		 * 
		 * All except the Toppings button is commented out for clarity. Every other button 
		 * follows the same basic format of this one
		 * 
		 * Code is functional if uncommented, though other buttons currently only erase the
		 * contents panel
		 * 
		 * This section is basically done though, it's simply necessary to add
		 * an implementation for all the drawX(host) functions. Then we can 
		 * uncomment it
		 */

		
		
		Font text = new Font("Tahoma", Font.PLAIN, 11);
		
		JButton accounttab = new JButton("Accounts");
		accounttab.setFont(text);
		accounttab.setBounds(0, 2, 80, 23);
		tabs.add(accounttab);
		
		accounttab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				contents.removeAll();
				drawAccounts(contents, null);
				setBounds(100, 100, 651, 693); //changing size twice redraws the table
				setBounds(100, 100, 651, 694);
			}
		});
		
		JButton ordertab = new JButton("Orders");
		ordertab.setFont(text);
		ordertab.setBounds(85, 2, 80, 23);
		tabs.add(ordertab);
		
		ordertab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				contents.removeAll();
				drawOrders(contents, null);
				setBounds(100, 100, 651, 693); //changing size twice redraws the table
				setBounds(100, 100, 651, 694);
			}
		});
		
		JButton toppingtab = new JButton("Toppings");
		toppingtab.setFont(text);
		toppingtab.setBounds(170, 2, 80, 23);
		tabs.add(toppingtab);
		
		toppingtab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				contents.removeAll();
				drawItems(contents, SerializedInventory.getInstance().getInventory().toppings , "Topping");
				setBounds(100, 100, 651, 693); //changing size twice redraws the table
				setBounds(100, 100, 651, 694);
			}
		});
		
		
		JButton doughtab = new JButton("Doughs");
		doughtab.setFont(text);
		doughtab.setBounds(255, 2, 80, 23);
		tabs.add(doughtab);
		
		doughtab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				contents.removeAll();
				drawItems(contents, SerializedInventory.getInstance().getInventory().dough , "Dough");
				setBounds(100, 100, 651, 693); //changing size twice redraws the table
				setBounds(100, 100, 651, 694);
			}
		});
		
		
		JButton saucetab = new JButton("Sauces");
		saucetab.setFont(text);
		saucetab.setBounds(340, 2, 80, 23);
		tabs.add(saucetab);
		
		saucetab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				contents.removeAll();
				drawItems(contents, SerializedInventory.getInstance().getInventory().sauces , "Sauce");
				setBounds(100, 100, 651, 693); //changing size twice redraws the table
				setBounds(100, 100, 651, 694);
			}
		});
		
		JButton itemtab = new JButton("Shop Items");
		itemtab.setFont(text);
		itemtab.setBounds(425, 2, 100, 23);
		tabs.add(itemtab);
		
		itemtab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				contents.removeAll();
				drawShopItems(contents, null);
				setBounds(100, 100, 651, 693); //changing size twice redraws the table
				setBounds(100, 100, 651, 694);
			}
		});
		
	
		
	}
	
	private void drawAccounts(JPanel host, Inventory type) {
		//awaiting implementation
	}
	
	private void drawOrders(JPanel host, Inventory type) {
		//awaiting implementation
	}
	
	private void drawShopItems(JPanel host, Inventory type) {
		//awaiting implementation
	}
	
	
	private void drawItems(JPanel host, HashMap<String, Item> type, String typename) {
		
		Font text = new Font("Tahoma", Font.PLAIN, 11);
				
		JPanel entry = new JPanel();
		entry.setLayout(null);
		entry.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		entry.setBounds(0, 0, 580, 40);
		host.add(entry);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setBounds(12, 12, 51, 14);
		entry.add(lblName);
		
		JTextArea inputname = new JTextArea();
		inputname.setBounds(60, 12, 109, 15);
		entry.add(inputname);
		inputname.setFont(text);
		
		JButton add = new JButton("Add Entry");
		add.setFont(text);
		add.setBounds(180, 8, 100, 23);
		entry.add(add);
		
		JButton delete = new JButton("Delete Entry");
		delete.setFont(text);
		delete.setBounds(284, 8, 100, 23);
		entry.add(delete);
		
		JLabel lblError = new JLabel("");
		lblError.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblError.setHorizontalAlignment(SwingConstants.LEFT);
		lblError.setBounds(400, 12, 200, 14);
		entry.add(lblError);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String newname = inputname.getText();
				if (newname.equals("")) {
					lblError.setText("Error: No name entered");
					return;
				}
				
				try {
					SerializedInventory.getInstance().getInventory().getItem(newname);//If item does not exist, will return an error
					lblError.setText("Error: Item already exists");
					return;
				}
				catch(IllegalArgumentException e){//This error will be caught, and that way we know we aren't overwriting an old item
					type.put(newname, new Item (newname));
					SerializedInventory.getInstance().saveInventory() ;
				}
				
				host.removeAll();
				drawItems(host, type, typename);
				setBounds(100, 100, 651, 693); //changing size twice redraws the table
				setBounds(100, 100, 651, 694);
			}
		});
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String newname = inputname.getText();
				if (newname.equals("")) {
					lblError.setText("Error: No name entered");
					return;
				}
				
				if (type.remove(newname) == null) {
					lblError.setText("Error: Item doesn't exist");
					return;
				}
				SerializedInventory.getInstance().saveInventory();
				
				host.removeAll();
				drawItems(host, type, typename);
				setBounds(100, 100, 651, 693); //changing size twice redraws the table
				setBounds(100, 100, 651, 694);
			}
		});
		
		
		
		JPanel table = new JPanel();
		table.setLayout(null);
		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table.setBounds(0, 40, 580, 410);
		host.add(table);
		

		JLabel lblToppings = new JLabel(typename);
		lblToppings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblToppings.setHorizontalAlignment(SwingConstants.LEFT);
		lblToppings.setBounds(12, 11, 51, 14);
		table.add(lblToppings);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblAmount.setBounds(130, 11, 51, 14);
		table.add(lblAmount);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setBounds(190, 11, 51, 14);
		table.add(lblPrice);
		
		JLabel lblChangeP = new JLabel("Change Amount");
		lblChangeP.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblChangeP.setHorizontalAlignment(SwingConstants.LEFT);
		lblChangeP.setBounds(290, 11, 100, 14);
		table.add(lblChangeP);
		
		JLabel lblChangeA = new JLabel("Change Price");
		lblChangeA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblChangeA.setHorizontalAlignment(SwingConstants.LEFT);
		lblChangeA.setBounds(440, 11, 90, 14);
		table.add(lblChangeA);
	
		//dynamically creates buttons for each entry 1 at a time
		int tindex = 0;
		for (String k : type.keySet()) {
			makeLabel(table, type.get(k), 38 + tindex * 25);
			tindex++;
		}
		
		
	}
	
	private void makeLabel(JPanel host, Item item, int coord) {
		String name = item.getName();
		int price = item.getPrice();
		int amount = item.getTotal();
		
		Insets margin = new Insets(1, 1, 1, 1);
		
		
		Font text = new Font("Tahoma", Font.PLAIN, 11);
		
		
		JLabel lbl = new JLabel(name);
		
		lbl.setFont(text);
		lbl.setBounds(17, coord + 4, 109, 14);
		host.add(lbl);
	
		
		JButton plus = new JButton("+");
		plus.setFont(text);
		plus.setBounds(240, coord, 20, 23);
		plus.setMargin(margin);
		host.add(plus);
		
		//buttons quantity
		
		JButton one = new JButton("1");
		one.setFont(text);
		one.setBounds(280, coord, 35, 23);
		one.setMargin(margin);
		host.add(one);
		
		JButton ten = new JButton("10");
		ten.setFont(text);
		ten.setBounds(320, coord, 35, 23);
		ten.setMargin(margin);
		host.add(ten);
		
		JButton hundred = new JButton("100");
		hundred.setFont(text);
		hundred.setBounds(360, coord, 35, 23);
		hundred.setMargin(margin);
		host.add(hundred);
		
		
		//buttons price
		
		JButton cent = new JButton("$0.01");
		cent.setFont(text);
		cent.setBounds(415, coord, 45, 23);
		cent.setMargin(margin);
		host.add(cent);
		
		JButton dime = new JButton("$0.10");
		dime.setFont(text);
		dime.setBounds(465, coord, 45, 23);
		dime.setMargin(margin);
		host.add(dime);
		
		JButton loonie = new JButton("$1.00");
		loonie.setFont(text);
		loonie.setBounds(515, coord, 45, 23);
		loonie.setMargin(margin);
		host.add(loonie);
				
		
		
		JLabel albl = new JLabel("("+amount+")");
		albl.setHorizontalAlignment(SwingConstants.CENTER);
		albl.setBounds(128, coord + 4, 46, 14);
		host.add(albl);
		
		
		JLabel plbl = new JLabel(Ordering.intTo$(price));
		plbl.setHorizontalAlignment(SwingConstants.CENTER);
		plbl.setBounds(180, coord + 4, 46, 14);
		host.add(plbl);
		
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (plus.getText().equals("+")) plus.setText("-");
				else plus.setText("+");
			}
		});
		
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//increase or decrease price in database. Awaiting implementation.
				int change = plus.getText().equals("-") ? -1 : 1;
				changeQuantity(item, change, albl);		
				
				
			}
		});
		
		ten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//increase or decrease price in database. Awaiting implementation.
				int change = plus.getText().equals("-") ? -10 : 10;
				changeQuantity(item, change, albl);		
				
				
			}
		});
		
		hundred.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//increase or decrease price in database. Awaiting implementation.
				int change = plus.getText().equals("-") ? -100 : 100;
				changeQuantity(item, change, albl);		
				
				
			}
		});
		
		
		cent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//increase or decrease price in database.
				int change = plus.getText().equals("-") ? -1 : 1;
				changePrice(item, change, plbl);		
				
				
			}
		});
		
		dime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//increase or decrease price in database.
				int change = plus.getText().equals("-") ? -10 : 10;
				changePrice(item, change, plbl);		
				
				
			}
		});
		
		loonie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//increase or decrease price in database.
				int change = plus.getText().equals("-") ? -100 : 100;
				changePrice(item, change, plbl);		
				
				
			}
		});
		
		/*
		decrease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//Remove -0.10 price from database. Awaiting implementation
				changePrice(item, -10, plbl);		
			}
		});*/
	}
	
	private void changePrice(Item item, int amount, JLabel label) {
		if (item == null) return;
		
		int oldprice = item.getPrice();
		int newprice = oldprice + amount < 0 ? 0 : oldprice + amount;
		
		item.setPrice(newprice);
		label.setText(Ordering.intTo$(newprice));
		SerializedInventory.getInstance().saveInventory();
	}
	
	private void changeQuantity(Item item, int amount, JLabel label) {
		if (item == null) return;
		
		int oldtotal = item.getTotal();
		int newtotal = oldtotal + amount < 0 ? 0 : oldtotal + amount;
		
		item.setTotal(newtotal);
		label.setText("("+newtotal+")");
		SerializedInventory.getInstance().saveInventory();
	}
	
}

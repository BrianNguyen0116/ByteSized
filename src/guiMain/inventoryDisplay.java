import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import javax.swing.border.BevelBorder;
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
		setBounds(100, 100, 714, 558);
	
		contentPane = new JPanel();
		contentPane.setBackground(new Color(62, 55, 62));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Initializing contents panel which will host the displayed database info
		 */
		
		JPanel contents = new JPanel();
		contents.setBackground(new Color(36, 32, 36));
		contents.setLayout(null);
		contents.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contents.setBounds(25, 53, 651, 450);
		contentPane.add(contents);
		
		/**
		 * Initializing tabs panel which will host buttons to access different categories of database entries
		 */
		
		JPanel tabs = new JPanel();
		tabs.setBackground(new Color(36, 32, 36));
		tabs.setLayout(null);
		tabs.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		tabs.setBounds(25, 25, 651, 27);
		contentPane.add(tabs);
		
		/**
		 * Populating tabs panel with buttons.
		 * 
		 */

		Font text = new Font("Tahoma", Font.PLAIN, 11);
		
		 int count = 0;

		
		JButton accounttab = new JButton("Accounts");
		accounttab.setForeground(new Color(221, 221, 221));
		accounttab.setBackground(new Color(36, 32, 36));
		accounttab.setFont(text);
		accounttab.setBounds(5, 3, 80, 23);
		tabs.add(accounttab);
		
		accounttab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				contents.removeAll();
				String jsonText = null;
				JsonArray jsonObject = null;
				
				try {
					jsonText = new String(Files.readAllBytes(Paths.get("users.json")));
				}catch(IOException e) {
					throw new RuntimeException();
				}
				
				try {
					jsonObject = (JsonArray)Jsoner.deserialize(jsonText);
				}catch(JsonException e) {
					throw new RuntimeException();
				}
				
				drawAccounts(contents, jsonObject, "Accounts");
				setBounds(100, 100, 714, 557); //changing size twice redraws the table
				setBounds(100, 100, 714, 558);
			}
		});
		
		JButton ordertab = new JButton("Orders");
		ordertab.setForeground(new Color(221, 221, 221));
		ordertab.setBackground(new Color(36, 32, 36));
		ordertab.setFont(text);
		ordertab.setBounds(90, 3, 80, 23);
		tabs.add(ordertab);
		
		ordertab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				contents.removeAll();
				drawOrders(contents, SerializedInventory.getInstance().getInventory().getOrders(), "Order");
				setBounds(100, 100, 714, 557); //changing size twice redraws the table
				setBounds(100, 100, 714, 558);
			}
		});
		
		JButton toppingtab = new JButton("Toppings");
		toppingtab.setForeground(new Color(221, 221, 221));
		toppingtab.setBackground(new Color(36, 32, 36));
		toppingtab.setFont(text);
		toppingtab.setBounds(175, 3, 80, 23);
		tabs.add(toppingtab);
		
		toppingtab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				contents.removeAll();
				drawItems(contents, SerializedInventory.getInstance().getInventory().toppings , "Topping");
				setBounds(100, 100, 714, 557); //changing size twice redraws the table
				setBounds(100, 100, 714, 558);
			}
		});
		
		
		JButton doughtab = new JButton("Doughs");
		doughtab.setForeground(new Color(221, 221, 221));
		doughtab.setBackground(new Color(36, 32, 36));
		doughtab.setFont(text);
		doughtab.setBounds(260, 3, 80, 23);
		tabs.add(doughtab);
		
		doughtab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				contents.removeAll();
				drawItems(contents, SerializedInventory.getInstance().getInventory().dough , "Dough");
				setBounds(100, 100, 714, 557); //changing size twice redraws the table
				setBounds(100, 100, 714, 558);
			}
		});
		
		
		JButton saucetab = new JButton("Sauces");
		saucetab.setForeground(new Color(221, 221, 221));
		saucetab.setBackground(new Color(36, 32, 36));
		saucetab.setFont(text);
		saucetab.setBounds(345, 3, 80, 23);
		tabs.add(saucetab);
		
		saucetab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				contents.removeAll();
				drawItems(contents, SerializedInventory.getInstance().getInventory().sauces , "Sauce");
				setBounds(100, 100, 714, 557); //changing size twice redraws the table
				setBounds(100, 100, 714, 558);
			}
		});
		
		JButton itemtab = new JButton("Shop Items");
		itemtab.setForeground(new Color(221, 221, 221));
		itemtab.setBackground(new Color(36, 32, 36));
		itemtab.setFont(text);
		itemtab.setBounds(430, 3, 100, 23);
		tabs.add(itemtab);
		
		itemtab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				contents.removeAll();
				drawItems(contents, SerializedInventory.getInstance().getInventory().drinks , "Shop Items");
				setBounds(100, 100, 714, 557); //changing size twice redraws the table
				setBounds(100, 100, 714, 558);
			}
		});
		
		JButton discounttab = new JButton("Discounts");
		discounttab.setForeground(new Color(221, 221, 221));
		discounttab.setBackground(new Color(36, 32, 36));
		discounttab.setFont(new Font("Tahoma", Font.PLAIN, 11));
		discounttab.setBounds(534, 3, 112, 23);
		tabs.add(discounttab);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5.setLayout(null);
		panel_5.setForeground(new Color(36, 32, 36));
		panel_5.setBackground(new Color(36, 32, 36));
		panel_5.setBounds(292, 5, 114, 19);
		contentPane.add(panel_5);
		
		JLabel lblByte = new JLabel("BYTE");
		lblByte.setHorizontalAlignment(SwingConstants.CENTER);
		lblByte.setForeground(new Color(243, 244, 245));
		lblByte.setFont(new Font("Arial", Font.PLAIN, 18));
		lblByte.setBounds(0, 0, 59, 19);
		panel_5.add(lblByte);
		
		JLabel lblSized = new JLabel("SIZED");
		lblSized.setHorizontalAlignment(SwingConstants.CENTER);
		lblSized.setForeground(new Color(227, 2, 32));
		lblSized.setFont(new Font("Arial", Font.BOLD, 18));
		lblSized.setBounds(55, 0, 59, 19);
		panel_5.add(lblSized);
		
		discounttab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				contents.removeAll();
				drawDiscounts(contents, SerializedInventory.getInstance().getInventory().coupons , "Coupons");
				setBounds(100, 100, 714, 557); //changing size twice redraws the table
				setBounds(100, 100, 714, 558);
			}
		});
		
	}
	
	private void drawAccounts(JPanel host, JsonArray type, String typename) {
	
		
		JPanel table = new JPanel();
		table.setLayout(null);
		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table.setBounds(0, 40, 651, 410);
		host.add(table);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setBounds(12, 11, 70, 14);
		table.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setBounds(120, 11, 70, 14);
		table.add(lblPassword);
		
		
			for (Object obj : type) {
				accountLabel(host, (JsonObject)obj, 38 + 25);
			}
	
	}
	
	private void accountLabel(JPanel host, JsonObject obj, int coord) {

		String username = (String) obj.get("username");
		String password = (String) obj.get("password");
		
		JPanel table = new JPanel();
		table.setLayout(null);
		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table.setBounds(0, 40, 651, 410);
		host.add(table);
		
		JLabel ulbl = new JLabel(username);
		ulbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		ulbl.setBounds(17, coord + 4, 109, 14);
		host.add(ulbl);
		
		System.out.println(username);
		System.out.println(password);

		
		JLabel plbl = new JLabel(password);
		plbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		plbl.setBounds(120, coord + 4, 109, 14);
		host.add(plbl);
	}
	
	private void drawShopItems(JPanel host, Inventory type) {
		//awaiting implementation
	}
	
	
	private void drawItems(JPanel host, HashMap<String, Item> type, String typename) {
		
		Font text = new Font("Tahoma", Font.PLAIN, 11);
				
		JPanel entry = new JPanel();
		entry.setLayout(null);
		entry.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		entry.setBounds(0, 0, 651, 40);
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
				setBounds(100, 100, 714, 557); //changing size twice redraws the table
				setBounds(100, 100, 714, 558);
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
				setBounds(100, 100, 714, 557); //changing size twice redraws the table
				setBounds(100, 100, 714, 558);
			}
		});
		
		
		
		JPanel table = new JPanel();
		table.setLayout(null);
		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table.setBounds(0, 40, 651, 410);
		host.add(table);
		

		JLabel lblToppings = new JLabel(typename);
		lblToppings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblToppings.setHorizontalAlignment(SwingConstants.LEFT);
		lblToppings.setBounds(12, 11, 90, 14);
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
	
	private void drawOrders(JPanel host, ArrayList<Pizza> type, String typename) {
		//awaiting implementation
		
		
		
		JPanel table = new JPanel();
		table.setLayout(null);
		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table.setBounds(0, 40, 651, 410);
		host.add(table);
		
		JLabel lblToppings = new JLabel(typename);
		lblToppings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblToppings.setHorizontalAlignment(SwingConstants.LEFT);
		lblToppings.setBounds(12, 11, 51, 14);
		table.add(lblToppings);
		
		JLabel lblAmount = new JLabel("Status");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblAmount.setBounds(120, 11, 51, 14);
		table.add(lblAmount);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setBounds(190, 11, 51, 14);
		table.add(lblPrice);
		
		/*
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
		*/
		
		//dynamically creates buttons for each entry 1 at a time
			//int tindex = 0;
			
			//orderLabel(table, type.get(0), 38 + tindex * 25);
			
			for (int i = 0; i < type.size(); i++) {
				orderLabel(host, table, type.get(i),38 + i * 25, i );
			}
			
			/*
			for (Pizza k : type) {
				orderLabel(table, k, 38 + tindex * 25);
				tindex++;
			}
			*/
	}
	
	private void orderLabel(JPanel superhost, JPanel host, Pizza order, int coord, int index) {
		Inventory database = SerializedInventory.getInstance().getInventory();
		String name = order.getSize() +" "+ order.getCrust().getName();
		int price = 0;
		//String status = order.status;
		
		String size = order.getSize();
		
		//Price calculation should be fixed in refactoring. Ie, prices should be determined upon ordering
		if (size.equals("Small")) price += 300;
		if (size.equals("Medium")) price += 400;
		if (size.equals("Large")) price += 600;
		if (size.equals("X-Large")) price += 800;
		
		price += database.getItem(order.getCrust().getName()).getPrice();
		
		System.out.println(order.getSauces()[0].getName());
		System.out.println(database.getItem( "Tomato Sauce" ));
		System.out.println(database.getItem( order.getSauces()[0].getName() ));
		System.out.println(database.getItem( order.getSauces()[0].getName() ).getPrice() );
		
		
		for (Item i : order.getSauces()) {
			System.out.println(i);
			if (i.getName() == null) continue; //need to find the root cause of null sauces
			price += database.getItem( i.getName() ).getPrice();
			//price += i.getPrice();
		}
		
		for (Item i : order.getToppings()) {
			System.out.println(i);
			price += database.getItem(i.getName()).getPrice();
			//price += i.getPrice();
		}
				
		Insets margin = new Insets(1, 1, 1, 1);
		
		Font text = new Font("Tahoma", Font.PLAIN, 11);
		
		JButton prep = new JButton("Prepping");
		prep.setFont(text);
		prep.setBounds(240, coord, 60, 23);
		prep.setMargin(margin);
		host.add(prep);
		
		JButton transit = new JButton("In-transit");
		transit.setFont(text);
		transit.setBounds(305, coord, 60, 23);
		transit.setMargin(margin);
		host.add(transit);
		
		JButton deliver = new JButton("Delivered");
		deliver.setFont(text);
		deliver.setBounds(370, coord, 60, 23);
		deliver.setMargin(margin);
		host.add(deliver);
		
		
		//buttons price
		
		
		JButton view = new JButton("View");
		view.setFont(text);
		view.setBounds(450, coord, 45, 23);
		view.setMargin(margin);
		host.add(view);
		
		JButton erase = new JButton("Delete");
		erase.setFont(text);
		erase.setBounds(500, coord, 45, 23);
		erase.setMargin(margin);
		host.add(erase);
		
		
		/*
		
		JButton loonie = new JButton("$1.00");
		loonie.setFont(text);
		loonie.setBounds(515, coord, 45, 23);
		loonie.setMargin(margin);
		host.add(loonie);
		*/
		
		
		
		JLabel lbl = new JLabel(name);
		
		lbl.setFont(text);
		lbl.setBounds(17, coord + 4, 109, 14);
		host.add(lbl);
		
		JLabel slbl = new JLabel(order.status);
		slbl.setHorizontalAlignment(SwingConstants.CENTER);
		slbl.setBounds(100, coord + 4, 80, 16);
		host.add(slbl);
		
		
		JLabel plbl = new JLabel(Ordering.intTo$(price));
		plbl.setHorizontalAlignment(SwingConstants.CENTER);
		plbl.setBounds(180, coord + 4, 46, 16);
		host.add(plbl);
		
		prep.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				order.status = prep.getText();
				slbl.setText(order.status);
				SerializedInventory.getInstance().saveInventory();
			}
		});
		
		transit.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				order.status = transit.getText();
				slbl.setText(order.status);
				SerializedInventory.getInstance().saveInventory();
			}
		});
		
		deliver.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				order.status = deliver.getText();
				slbl.setText(order.status);
				SerializedInventory.getInstance().saveInventory();
			}
		});
		
		erase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//increase or decrease price in database.
				SerializedInventory.getInstance().getInventory().getOrders().remove(index);
				SerializedInventory.getInstance().saveInventory();
				
				//refresh screen
				superhost.removeAll();
				drawOrders(superhost, SerializedInventory.getInstance().getInventory().getOrders(), "Order");
				setBounds(100, 100, 714, 557); //changing size twice redraws the table
				setBounds(100, 100, 714, 558);
			}
		});
		
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
	
	private void drawDiscounts(JPanel host, HashMap<String, Discount> type, String typename) {
	//awaiting implementation
	
		Font text = new Font("Tahoma", Font.PLAIN, 11);
		
		JPanel entry = new JPanel();
		entry.setLayout(null);
		entry.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		entry.setBounds(0, 0, 651, 40);
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
					SerializedInventory.getInstance().getInventory().getCoupon(newname);//If item does not exist, will return an error
					lblError.setText("Error: Item already exists");
					return;
				}
				catch(IllegalArgumentException e){//This error will be caught, and that way we know we aren't overwriting an old item
					type.put(newname, new Discount (newname));
					SerializedInventory.getInstance().saveInventory() ;
				}
				
				host.removeAll();
				drawDiscounts(host, type, typename);
				setBounds(100, 100, 714, 557); //changing size twice redraws the table
				setBounds(100, 100, 714, 558);
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
				drawDiscounts(host, type, typename);
				setBounds(100, 100, 714, 557); //changing size twice redraws the table
				setBounds(100, 100, 714, 558);
			}
		});
	
	JPanel table = new JPanel();
	table.setLayout(null);
	table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
	table.setBounds(0, 40, 651, 410);
	host.add(table);
	
	JLabel lblDiscounts = new JLabel(typename);
	lblDiscounts.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblDiscounts.setHorizontalAlignment(SwingConstants.LEFT);
	lblDiscounts.setBounds(12, 11, 51, 14);
	table.add(lblDiscounts);
	
	JLabel lblAmount = new JLabel("Status");
	lblAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblAmount.setHorizontalAlignment(SwingConstants.LEFT);
	lblAmount.setBounds(120, 11, 51, 14);
	table.add(lblAmount);
	
	JLabel lblDiscount = new JLabel("Discount");
	lblDiscount.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblDiscount.setHorizontalAlignment(SwingConstants.LEFT);
	lblDiscount.setBounds(190, 11, 51, 14);
	table.add(lblDiscount);
	
	int tindex = 0;
	for (String k : type.keySet()) {
		discountLabel(table, type.get(k), 38 + tindex * 25);
		tindex++;
		}
	}
	
	
	private void discountLabel(JPanel host, Discount item, int coord) {
		String name = item.getName();
		String state = "";
		int percent = item.getDiscount();
		boolean expire = item.getExpirationState();
		
		if (expire == true) { 
			state  = "Unavailable";
		} else if (expire == false){ 
			state = "Available";
		}
		
		Insets margin = new Insets(1, 1, 1, 1);
		
		Font text = new Font("Tahoma", Font.PLAIN, 11);
		
		JButton avail = new JButton("On");
		avail.setFont(text);
		avail.setBounds(240, coord, 60, 23);
		avail.setMargin(margin);
		host.add(avail);
		
		JButton expired = new JButton("Off");
		expired.setFont(text);
		expired.setBounds(305, coord, 60, 23);
		expired.setMargin(margin);
		host.add(expired);
		
		JButton set = new JButton("Set");
		set.setFont(text);
		set.setBounds(400, coord, 60, 23);
		set.setMargin(margin);
		host.add(set);
		
		JTextField discount = new JTextField();
		discount.setFont(text);
		discount.setBounds(465, coord, 60, 23);
		discount.setMargin(margin);
		host.add(discount);
		
		
		//buttons 
		JButton view = new JButton("View");
		view.setFont(text);
		view.setBounds(550, coord, 45, 23);
		view.setMargin(margin);
		host.add(view);
		
		JLabel lbl = new JLabel(name);
		
		lbl.setFont(text);
		lbl.setBounds(17, coord + 4, 109, 14);
		host.add(lbl);
		
		JLabel elbl = new JLabel(state);
		elbl.setHorizontalAlignment(SwingConstants.CENTER);
		elbl.setBounds(100, coord + 4, 80, 16);
		host.add(elbl);
		
		
		JLabel plbl = new JLabel(String.valueOf(percent));
		plbl.setHorizontalAlignment(SwingConstants.CENTER);
		plbl.setBounds(180, coord + 4, 46, 16);
		host.add(plbl);
		
		avail.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				item.setExpirationState(false);
				elbl.setText("Available");
				SerializedInventory.getInstance().saveInventory();
			}
		});
		
		expired.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				item.setExpirationState(true);
				elbl.setText("Unavailable");
				SerializedInventory.getInstance().saveInventory();
			}
		});
		
		set.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int change = Integer.parseInt(discount.getText());
				changeDiscount(item, change, plbl);
			}
		});
		
	}
	
	private void changeDiscount(Discount item, int amount, JLabel label) {
		if (item == null) return;
		
		item.setDiscount(amount);
		int newpercent = item.getDiscount();
		
		item.setDiscount(newpercent);
		label.setText("("+newpercent+"%)");
		SerializedInventory.getInstance().saveInventory();
	}
}

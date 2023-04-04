import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
		contents.setBounds(25, 125, 450, 450);
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
		/*
		JButton accounttab = new JButton("Accounts");
		accounttab.setFont(text);
		accounttab.setBounds(0, 2, 80, 23);
		tabs.add(accounttab);
		
		accounttab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				contents.removeAll();
				drawAccounts(contents);
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
				drawOrders(contents);
				setBounds(100, 100, 651, 693); //changing size twice redraws the table
				setBounds(100, 100, 651, 694);
			}
		});*/
		
		JButton toppingtab = new JButton("Toppings");
		toppingtab.setFont(text);
		toppingtab.setBounds(170, 2, 80, 23);
		tabs.add(toppingtab);
		
		toppingtab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				contents.removeAll();
				drawToppings(contents);
				setBounds(100, 100, 651, 693); //changing size twice redraws the table
				setBounds(100, 100, 651, 694);
			}
		});
		
		/*
		JButton sizetab = new JButton("Sizes");
		sizetab.setFont(text);
		sizetab.setBounds(255, 2, 80, 23);
		tabs.add(sizetab);
		
		sizetab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				contents.removeAll();
				drawSizes(contents);
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
				drawSizes(contents);
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
				drawShopItems(contents);
				setBounds(100, 100, 651, 693); //changing size twice redraws the table
				setBounds(100, 100, 651, 694);
			}
		});
		*/
	
		
	}
	
	private void drawAccounts(JPanel host) {
		//awaiting implementation
	}
	
	private void drawOrders(JPanel host) {
		//awaiting implementation
	}
	
	private void drawSizes(JPanel host) {
		//awaiting implementation
	}
	
	private void drawSauces(JPanel host) {
		//awaiting implementation
	}
	
	private void drawShopItems(JPanel host) {
		//awaiting implementation
	}
	
	
	private void drawToppings(JPanel host) {
				
		/**
		 * Topping Customization
		 */

		JLabel lblToppings = new JLabel("Topping");
		lblToppings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblToppings.setHorizontalAlignment(SwingConstants.LEFT);
		lblToppings.setBounds(12, 11, 51, 14);
		host.add(lblToppings);
	
	
		HashMap<String, Integer> toppingdata = Ordering.getToppingPrices();
		
		//dynamically creates buttons for each entry 1 at a time
		int tindex = 0;
		for (String k : toppingdata.keySet()) {
			toppingLabel(host, k, 38 + tindex * 25, toppingdata.get(k));
			tindex++;
		}
		
		
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
		
		JLabel plbl = new JLabel(Ordering.intTo$(price));
		plbl.setHorizontalAlignment(SwingConstants.CENTER);
		plbl.setBounds(288, coord + 4, 46, 14);
		host.add(plbl);
		
		btnl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//Add +1 quantity to database. Awaiting implementation.
				//Right now it just resizes the window as a demonstration of dynamic sizing
				setBounds(100, 100, 300, 300);
			}
		});
		
		btnr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//Remove +1 quantity from database. Awaiting implementation
			}
		});
	}
	
}

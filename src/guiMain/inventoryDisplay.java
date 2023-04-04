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
		
		setTitle("Admin");
		setForeground(new Color(238, 238, 238));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 694);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		drawToppings();
		drawSizes();
		drawSauces();
		
	}
	
	
	private void drawSizes() {
		//awaiting implementation
	}
	
	private void drawSauces() {
		//awaiting implementation
	}
	
	private void drawToppings() {
		JPanel toppings = new JPanel();
		toppings.setLayout(null);
		toppings.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		toppings.setBounds(25, 125, 415, 274);
		contentPane.add(toppings);
		
		/**
		 * Topping Customization
		 */

		JLabel lblToppings = new JLabel("Topping");
		lblToppings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblToppings.setHorizontalAlignment(SwingConstants.LEFT);
		lblToppings.setBounds(12, 11, 51, 14);
		toppings.add(lblToppings);
	
	
		HashMap<String, Integer> toppingdata = Ordering.getToppingPrices();
		
		int tindex = 0;
		for (String k : toppingdata.keySet()) {
			toppingLabel(toppings, k, 38 + tindex * 25, toppingdata.get(k));
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

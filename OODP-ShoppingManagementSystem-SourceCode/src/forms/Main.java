package forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Box;
import java.awt.Component;

import classes.*;

public class Main {

	private JFrame frame;
	private JTable productsTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 635, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(0, 0, 619, 40);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 47, 619, 311);
		scrollPane.setViewportBorder(null);
		
		JButton btnClothesCategory = new JButton("Clothes");
		btnClothesCategory.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				MenuComponent clothes = new Category("Clothes");
				clothes.add(new Product("Shirt", "Style: super comfortable, relaxed fit, lightweight and fashionable.", 200, 20));
				clothes.add(new Product("Shoes", "Upper Material:Genuine Leather", 150, 10));
				clothes.add(new Product("T-Shirt", "Men Crew Neck T-Shirt with Short Sleeves - DARK BLACK", 120, 15));
				clothes.add(new Product("Jacket", "Cotton material, Zipper closure, Long Sleeve and Side pockets", 200, 5));
				
				DefaultTableModel defaultTableModel = new DefaultTableModel();
				
				defaultTableModel.addColumn("Name");
				defaultTableModel.addColumn("Description");
				defaultTableModel.addColumn("Price");
				
				for(MenuComponent menuComponent : clothes.getProducts()) {
					defaultTableModel.addRow(new Object[] {
							menuComponent.getName(), menuComponent.getDescription(),
							menuComponent.getPrice()
					});
				}
				productsTable.setModel(defaultTableModel);
			}
		});
		horizontalBox.add(btnClothesCategory);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		horizontalBox.add(verticalStrut);
		
		productsTable = new JTable();
		productsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		productsTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		productsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(productsTable);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(horizontalBox);
		frame.getContentPane().add(scrollPane);
	}
}

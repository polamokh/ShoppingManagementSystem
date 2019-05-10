package forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Box;
import java.awt.Component;

import classes.*;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	private JFrame frame;
	private JTable productsTable;
	private Customer customer;
	ArrayList<Product> products;
	private ArrayList<String> cart = new ArrayList<String>();
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
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				customer = new Customer();
				products = customer.getProducts();

				DefaultTableModel defaultTableModel = new DefaultTableModel();

				defaultTableModel.addColumn("Name");
				defaultTableModel.addColumn("Description");
				defaultTableModel.addColumn("Price");
				defaultTableModel.addColumn("Number in Stock");

				for(Product menuComponent : products) {
					defaultTableModel.addRow(new Object[] {
							menuComponent.getName(), menuComponent.getDescription(),
							menuComponent.getPrice(), menuComponent.getQuantity()
					});
				}
				productsTable.setModel(defaultTableModel);
			}
		});
		frame.setBounds(100, 100, 786, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Box horizontalBox = Box.createHorizontalBox();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);

		JButton btnReturnProduct = new JButton("Return Product");

		JButton btnViewCart = new JButton("View Cart");
		btnViewCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new Cart(cart).setVisible(true);
			}
		});

		JButton btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(productsTable.getSelectedRow() != -1) {
					cart.add(products.get(productsTable.getSelectedRow()).getName());
				}
				else {
					JOptionPane.showMessageDialog(null, "Please select a product to add to the cart.");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(horizontalBox, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
										.addGap(4)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(btnAddToCart, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnViewCart, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnReturnProduct, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(horizontalBox, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnAddToCart)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnViewCart)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnReturnProduct))
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
						.addContainerGap())
				);

		JButton btnClothes = new JButton("Clothes");
		btnClothes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				products = customer.getCategoryProducts("Clothes");


				DefaultTableModel defaultTableModel = new DefaultTableModel();

				defaultTableModel.addColumn("Name");
				defaultTableModel.addColumn("Description");
				defaultTableModel.addColumn("Price");
				defaultTableModel.addColumn("Number in Stock");

				for(Product menuComponent : products) {
					defaultTableModel.addRow(new Object[] {
							menuComponent.getName(), menuComponent.getDescription(),
							menuComponent.getPrice(), menuComponent.getQuantity()
					});
				}
				productsTable.setModel(defaultTableModel);
			}
		});

		JButton btnAllCategories = new JButton("All Categories");
		btnAllCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				products = customer.getProducts();

				DefaultTableModel defaultTableModel = new DefaultTableModel();

				defaultTableModel.addColumn("Name");
				defaultTableModel.addColumn("Description");
				defaultTableModel.addColumn("Price");
				defaultTableModel.addColumn("Number in Stock");

				for(Product menuComponent : products) {
					defaultTableModel.addRow(new Object[] {
							menuComponent.getName(), menuComponent.getDescription(),
							menuComponent.getPrice(), menuComponent.getQuantity()
					});
				}
				productsTable.setModel(defaultTableModel);
			}
		});
		horizontalBox.add(btnAllCategories);
		horizontalBox.add(btnClothes);

		JButton btnPhones = new JButton("Phones");
		btnPhones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				products = customer.getCategoryProducts("Phones");


				DefaultTableModel defaultTableModel = new DefaultTableModel();

				defaultTableModel.addColumn("Name");
				defaultTableModel.addColumn("Description");
				defaultTableModel.addColumn("Price");
				defaultTableModel.addColumn("Number in Stock");

				for(Product menuComponent : products) {
					defaultTableModel.addRow(new Object[] {
							menuComponent.getName(), menuComponent.getDescription(),
							menuComponent.getPrice(), menuComponent.getQuantity()
					});
				}
				productsTable.setModel(defaultTableModel);
			}
		});
		horizontalBox.add(btnPhones);

		JButton btnElectronics = new JButton("Electronics");
		btnElectronics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				products = customer.getCategoryProducts("Electronics");


				DefaultTableModel defaultTableModel = new DefaultTableModel();

				defaultTableModel.addColumn("Name");
				defaultTableModel.addColumn("Description");
				defaultTableModel.addColumn("Price");
				defaultTableModel.addColumn("Number in Stock");

				for(Product menuComponent : products) {
					defaultTableModel.addRow(new Object[] {
							menuComponent.getName(), menuComponent.getDescription(),
							menuComponent.getPrice(), menuComponent.getQuantity()
					});
				}
				productsTable.setModel(defaultTableModel);
			}
		});
		horizontalBox.add(btnElectronics);

		JButton btnComputing = new JButton("Computing");
		btnComputing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				products = customer.getCategoryProducts("Computing");


				DefaultTableModel defaultTableModel = new DefaultTableModel();

				defaultTableModel.addColumn("Name");
				defaultTableModel.addColumn("Description");
				defaultTableModel.addColumn("Price");
				defaultTableModel.addColumn("Number in Stock");

				for(Product menuComponent : products) {
					defaultTableModel.addRow(new Object[] {
							menuComponent.getName(), menuComponent.getDescription(),
							menuComponent.getPrice(), menuComponent.getQuantity()
					});
				}
				productsTable.setModel(defaultTableModel);
			}
		});
		horizontalBox.add(btnComputing);

		Component verticalStrut = Box.createVerticalStrut(20);
		horizontalBox.add(verticalStrut);

		JButton btnRegister = new JButton("Register");
		horizontalBox.add(btnRegister);

		JButton btnLogin = new JButton("Login");
		horizontalBox.add(btnLogin);

		productsTable = new JTable();
		productsTable.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent arg0)
			{

			}
		});
		productsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		productsTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
				));
		productsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(productsTable);
		frame.getContentPane().setLayout(groupLayout);
	}
}

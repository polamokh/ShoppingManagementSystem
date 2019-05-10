package forms;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Customer;
import classes.Manager;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserName.setForeground(new Color(255, 255, 255));
		lblUserName.setBounds(10, 101, 98, 37);
		contentPane.add(lblUserName);

		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 16));
		username.setBounds(118, 109, 200, 20);
		contentPane.add(username);
		username.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(10, 149, 95, 30);
		contentPane.add(lblPassword);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(118, 66, 200, 20);
		comboBox.addItem("Customer");
		comboBox.addItem("Manger");
		contentPane.add(comboBox);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(comboBox.getSelectedItem()=="Customer")
				{
					Customer customer = new Customer(username.getText(), password.getText());
					customer = customer.checkExist();
					if(customer != null)
					{
						JOptionPane.showMessageDialog(null,"Welcome");
						Main mainForm = new Main(customer);
						mainForm.frame.setVisible(true);
						Login.this.setVisible(false);
					}
					else JOptionPane.showMessageDialog(null,"Wrong Username or Password");
				}
				else
				{
					Manager manger=new Manager();
					if(manger.login(username.getText(), password.getText())==true)
					{
						JOptionPane.showMessageDialog(null,"Welcome");
						//Manger Form open
					}
					else JOptionPane.showMessageDialog(null,"Wrong Username or Password");
				}
			}

		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setForeground(new Color(70, 130, 180));
		btnLogin.setBounds(319, 223, 115, 37);
		contentPane.add(btnLogin);



		JLabel lblLoginAs = new JLabel("Login as:");
		lblLoginAs.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoginAs.setForeground(Color.WHITE);
		lblLoginAs.setBackground(Color.WHITE);
		lblLoginAs.setBounds(10, 60, 74, 33);
		contentPane.add(lblLoginAs);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Register().setVisible(true);
			}
		});
		btnRegister.setForeground(new Color(70, 130, 180));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegister.setBounds(194, 223, 115, 37);
		contentPane.add(btnRegister);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogin.setBackground(Color.WHITE);
		lblLogin.setBounds(10, 11, 74, 33);
		contentPane.add(lblLogin);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		password.setBounds(118, 156, 200, 20);
		contentPane.add(password);
	}
}

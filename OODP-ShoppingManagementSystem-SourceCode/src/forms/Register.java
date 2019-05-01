package forms;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.io.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JPasswordField password;
	private JTextField Mobile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name = new JTextField();
		name.setBounds(149, 46, 96, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(149, 92, 96, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegister.setForeground(new Color(70, 130, 180));
		btnRegister.setBackground(new Color(255, 255, 255));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Customer c=new Customer(name.getText(),Mobile.getText(),password.getText(),username.getText());
				String fileName = "Customers.txt";
				 try {
			            // Assume default encoding.
			            FileWriter fileWriter =
			                new FileWriter(fileName);

			            // Always wrap FileWriter in BufferedWriter.
			            BufferedWriter bufferedWriter =
			                new BufferedWriter(fileWriter);

			            // Note that write() does not automatically
			            // append a newline character.
			            bufferedWriter.write(name.getText());
			            bufferedWriter.newLine();
			            bufferedWriter.write(username.getText());
			            bufferedWriter.newLine();
			            bufferedWriter.write(password.getText());
			            bufferedWriter.newLine();
			            bufferedWriter.write(Mobile.getText());

			            // Always close files.
			            bufferedWriter.close();
			        }
			        catch(IOException ex) {
			            System.out.println(
			                "Error writing to file '"
			                + fileName + "'");
			            // Or we could just do this:
			            // ex.printStackTrace();
			        }
			}
		});
		btnRegister.setBounds(271, 212, 119, 38);
		contentPane.add(btnRegister);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(10, 40, 68, 29);
		contentPane.add(lblName);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBackground(new Color(255, 255, 255));
		lblUsername.setBounds(10, 81, 119, 38);
		contentPane.add(lblUsername);
		
		JLabel lblRedister = new JLabel("Redister");
		lblRedister.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblRedister.setForeground(new Color(255, 255, 255));
		lblRedister.setBounds(161, 11, 96, 24);
		contentPane.add(lblRedister);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(10, 124, 119, 20);
		contentPane.add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(149, 126, 96, 20);
		contentPane.add(password);
		
		JLabel lblMobile = new JLabel("Mobile:");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMobile.setForeground(new Color(255, 255, 255));
		lblMobile.setBackground(new Color(255, 255, 255));
		lblMobile.setBounds(10, 161, 102, 20);
		contentPane.add(lblMobile);
		
		Mobile = new JTextField();
		Mobile.setBounds(149, 163, 96, 20);
		contentPane.add(Mobile);
		Mobile.setColumns(10);
	}
}

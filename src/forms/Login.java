package forms;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

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
		lblUserName.setBounds(28, 69, 98, 37);
		contentPane.add(lblUserName);
		
		username = new JTextField();
		username.setBounds(151, 79, 96, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(31, 143, 95, 30);
		contentPane.add(lblPassword);
		
		password = new JTextField();
		password.setBounds(151, 150, 96, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				 // The name of the file to open.
//				//List<Customer> customers = new ArrayList<Customer>();
//		       // String fileName = "Customers.txt";
//
//		        // This will reference one line at a time
//		        String line = null;
//                
//		        try {
//		            // FileReader reads text files in the default encoding.
//		            FileReader fileReader = 
//		                new FileReader(fileName);
//
//		            // Always wrap FileReader in BufferedReader.
//		            BufferedReader bufferedReader = 
//		                new BufferedReader(fileReader);
//		            int namee=0,passwordd=0;
//		            String n=username.getText().toString();
//		            String pass=password.getText().toString();
//		            while((line = bufferedReader.readLine()) != null) {
//		            	 System.out.println(line);
//		            	 System.out.println(username.getText().toString());
//		            	 String l=line;
//		                if(l==n)
//		                {
//		                	namee=1;
//		                }
//		                if(l==pass)
//		                {
//		                	passwordd=1;
//		                }
//		            }   
//		            System.out.println(namee);
//		            System.out.println(passwordd);
//                    if(namee==1&&passwordd==1)
//                    {
//                    	JOptionPane.showMessageDialog(null, username.getText());
//                    }
//		            // Always close files.
//		            bufferedReader.close();         
//		        }
//		        catch(FileNotFoundException ex) {
//		            System.out.println(
//		                "Unable to open file '" + 
//		                fileName + "'");                
//		        }
//		        catch(IOException ex) {
//		            System.out.println(
//		                "Error reading file '" 
//		                + fileName + "'");                  
//		            // Or we could just do this: 
//		            // ex.printStackTrace();
//		        }
//
			}
			
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setForeground(new Color(70, 130, 180));
		btnLogin.setBounds(280, 213, 115, 37);
		contentPane.add(btnLogin);
	}

}

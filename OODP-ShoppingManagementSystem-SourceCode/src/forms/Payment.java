package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Card;
import classes.Category;
import classes.MenuComponent;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;

public class Payment extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
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
	public Payment() {
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 635, 405);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		//frame.add(contentPane);
		setContentPane(contentPane);
		
		JButton btnPay = new JButton("Pay Cash on Delivery");
		btnPay.setBounds(110, 135, 183, 51);
		btnPay.setVisible(true);
		contentPane.add(btnPay);
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane.showMessageDialog(null, "Done");
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnPay);
		
		JButton btnNewButton = new JButton("Pay by Card ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				pay_in_Card payy=new pay_in_Card();
				payy.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(110, 71, 183, 51);
		contentPane.add(btnNewButton);
		
		JLabel lblChoosePaymentMethod = new JLabel("Choose Payment Method");
		lblChoosePaymentMethod.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChoosePaymentMethod.setBounds(22, 26, 202, 16);
		contentPane.add(lblChoosePaymentMethod);
	}
}

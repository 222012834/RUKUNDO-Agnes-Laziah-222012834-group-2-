package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.function.Supplier;
import java.awt.event.ActionEvent;

public class Allformssystem {

	static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Allformssystem window = new Allformssystem();
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
	public Allformssystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 28));
		frame.getContentPane().setBackground(new Color(69, 69, 69));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ALL FORMS IN SYSTEM ");
		lblNewLabel.setBounds(80, 28, 540, 43);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnproducts = new JButton("Products");
		btnproducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				products pro=new products();
				pro.frame.setVisible(true);
				frame.dispose();
			
			}
		});
		btnproducts.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnproducts.setBounds(78, 129, 206, 68);
		frame.getContentPane().add(btnproducts);
		
		JButton btnemployee = new JButton("Employee");
		btnemployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee emp=new Employee();
				emp.setVisible(true);
				frame.dispose();
			}
		});
		btnemployee.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnemployee.setBounds(78, 257, 206, 63);
		frame.getContentPane().add(btnemployee);
		
		JButton btnsupplier = new JButton("Supplier");
		btnsupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supplier sup=new supplier();
				sup.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnsupplier.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnsupplier.setBounds(323, 129, 281, 68);
		frame.getContentPane().add(btnsupplier);
		
		JButton btncustomerorders = new JButton("Customerorders");
		btncustomerorders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerorders cst=new customerorders();
				cst.frame.setVisible(true);
				frame.dispose();
			}
		});
		btncustomerorders.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btncustomerorders.setBounds(323, 257, 281, 63);
		frame.getContentPane().add(btncustomerorders);
		
		JButton btnstocks = new JButton("Stocks");
		btnstocks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stocks stock=new stocks();
				stock.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnstocks.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnstocks.setBounds(78, 374, 206, 63);
		frame.getContentPane().add(btnstocks);
		
		JButton btnpayments = new JButton("Payments");
		btnpayments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payments emp=new payments();
				emp.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnpayments.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnpayments.setBounds(323, 374, 281, 63);
		frame.getContentPane().add(btnpayments);
		
		JButton btnNewButton = new JButton("LOGOUT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login llo= new Login();
				llo.setVisible(true);
				Allformssystem.frame.dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(534, 11, 132, 43);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 690, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

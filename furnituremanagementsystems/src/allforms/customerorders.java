package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.TableColumnModelEvent;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTextField;
import javax.print.CancelablePrintJob;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class customerorders<DefaultTableModel> {

	 JFrame frame;
	private JTextField ordidtxf;
	private JTextField custntxf;
	private JTextField qtytxf;
	private JTextField amtxf;
	private JTextField dattxf;
	private JTextField phontxf;
	private JTextField prd_nmtxf;
	protected String id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerorders window = new customerorders();
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
	public customerorders() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUSTOMER_ORDERS");
		lblNewLabel.setBounds(0, 0, 600, 32);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setForeground(new Color(0, 255, 0));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel ordidlb = new JLabel("order_id");
		ordidlb.setBounds(0, 123, 89, 25);
		ordidlb.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().add(ordidlb);
		
		JLabel custnlb = new JLabel("customer_name");
		custnlb.setBounds(0, 168, 142, 25);
		custnlb.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().add(custnlb);
		
		JLabel qtylb = new JLabel("Quantity");
		qtylb.setBounds(0, 250, 142, 29);
		qtylb.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().add(qtylb);
		
		JLabel pytlb = new JLabel("Amounts");
		pytlb.setBounds(0, 305, 111, 25);
		pytlb.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().add(pytlb);
		
		JLabel datlb = new JLabel("date");
		datlb.setBounds(0, 353, 111, 25);
		datlb.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().add(datlb);
		
		JLabel phonlb = new JLabel("phone");
		phonlb.setBounds(0, 403, 111, 25);
		phonlb.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().add(phonlb);
		
		ordidtxf = new JTextField();
		ordidtxf.setBounds(192, 123, 331, 26);
		frame.getContentPane().add(ordidtxf);
		ordidtxf.setColumns(10);
		
		custntxf = new JTextField();
		custntxf.setBounds(192, 174, 331, 25);
		frame.getContentPane().add(custntxf);
		custntxf.setColumns(10);
		
		qtytxf = new JTextField();
		qtytxf.setBounds(192, 256, 331, 25);
		frame.getContentPane().add(qtytxf);
		qtytxf.setColumns(10);
		
		amtxf = new JTextField();
		amtxf.setBounds(194, 308, 329, 26);
		frame.getContentPane().add(amtxf);
		amtxf.setColumns(10);
		
		dattxf = new JTextField();
		dattxf.setBounds(194, 356, 329, 26);
		frame.getContentPane().add(dattxf);
		dattxf.setColumns(10);
		
		phontxf = new JTextField();
		phontxf.setBounds(194, 403, 329, 25);
		frame.getContentPane().add(phontxf);
		phontxf.setColumns(10);
		
		JButton btnSUBMIT = new JButton("SUBMIT");
		btnSUBMIT.setForeground(new Color(128, 0, 128));
		btnSUBMIT.setBounds(203, 454, 104, 23);
		btnSUBMIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furnituremanagementsystems","root","");
					String query= "INSERT INTO customer_orders VALUES (?,?,?,?,?,?,?)";
					PreparedStatement pst= (PreparedStatement) connection.prepareStatement(query);
					pst.setInt(1, Integer.parseInt(ordidtxf.getText()));
					pst.setString(2,custntxf.getText());
					pst.setString(3,prd_nmtxf.getText());
					pst.setInt(4, Integer.parseInt(qtytxf.getText()));
					pst.setInt(5, Integer.parseInt(amtxf.getText()));
					pst.setString(6,dattxf.getText());
					pst.setString(7,phontxf.getText());
				    pst.executeUpdate();
				    JOptionPane.showMessageDialog(btnSUBMIT, "inserted successfully!!!!!!!!!");
				    pst.close();
				    connection.close();

				
				
				} catch (Exception e2) {
					
				}
			}
		});
		btnSUBMIT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		frame.getContentPane().add(btnSUBMIT);
		
		
				
	
		
		JButton btnEXIT = new JButton("EXIT");
		btnEXIT.setForeground(new Color(255, 0, 0));
		btnEXIT.setBounds(333, 454, 89, 23);
		btnEXIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ordidtxf.setText(null);
				custntxf.setText(null);
				qtytxf.setText(null);
				amtxf.setText(null);
				dattxf.setText(null);
				phontxf.setText(null);
				prd_nmtxf.setText(null);
			}
		});
		btnEXIT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		frame.getContentPane().add(btnEXIT);
		
		JLabel prd_nmlb = new JLabel("product_name");
		prd_nmlb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		prd_nmlb.setBounds(0, 217, 142, 25);
		frame.getContentPane().add(prd_nmlb);
		
		prd_nmtxf = new JTextField();
		prd_nmtxf.setBounds(192, 222, 331, 20);
		frame.getContentPane().add(prd_nmtxf);
		prd_nmtxf.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Allformssystem more=new Allformssystem();
				more.frame.setVisible(true);
			   dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(450, 454, 89, 23);
		frame.getContentPane().add(btnNewButton);
		frame.setForeground(new Color(64, 128, 128));
		frame.setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 614, 569);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}
}

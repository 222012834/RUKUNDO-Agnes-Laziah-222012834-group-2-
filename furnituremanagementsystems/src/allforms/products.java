package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class products {

	static JFrame frame;
	private JTextField pdtxf;
	private JTextField nmtxf;
	private JTextField qtytxf;
	private JTextField unptxf;
	private JTextField tptxf;
	private JTextField dsctxf;
	protected Object All;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					products window = new products();
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
	public products() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(64, 128, 128));
		frame.setBounds(100, 100, 450, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRODUCTS");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(53, 11, 386, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel pdlb = new JLabel("Product_id");
		pdlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		pdlb.setBounds(10, 62, 137, 25);
		frame.getContentPane().add(pdlb);
		
		JLabel nmlb = new JLabel("Name");
		nmlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		nmlb.setBounds(10, 98, 137, 25);
		frame.getContentPane().add(nmlb);
		
		JLabel qtylb = new JLabel("Quantity");
		qtylb.setFont(new Font("Tahoma", Font.BOLD, 16));
		qtylb.setBounds(10, 134, 137, 25);
		frame.getContentPane().add(qtylb);
		
		JLabel unplb = new JLabel("Unit_Price");
		unplb.setFont(new Font("Tahoma", Font.BOLD, 16));
		unplb.setBounds(10, 170, 137, 25);
		frame.getContentPane().add(unplb);
		
		JLabel tplb = new JLabel("Total_price");
		tplb.setFont(new Font("Tahoma", Font.BOLD, 16));
		tplb.setBounds(10, 206, 137, 25);
		frame.getContentPane().add(tplb);
		
		JLabel dsclb = new JLabel("Description");
		dsclb.setFont(new Font("Tahoma", Font.BOLD, 16));
		dsclb.setBounds(10, 242, 137, 25);
		frame.getContentPane().add(dsclb);
		
		pdtxf = new JTextField();
		pdtxf.setBounds(157, 64, 224, 25);
		frame.getContentPane().add(pdtxf);
		pdtxf.setColumns(10);
		
		nmtxf = new JTextField();
		nmtxf.setColumns(10);
		nmtxf.setBounds(157, 102, 224, 25);
		frame.getContentPane().add(nmtxf);
		
		qtytxf = new JTextField();
		qtytxf.setColumns(10);
		qtytxf.setBounds(157, 138, 224, 25);
		frame.getContentPane().add(qtytxf);
		
		unptxf = new JTextField();
		unptxf.setColumns(10);
		unptxf.setBounds(157, 174, 224, 25);
		frame.getContentPane().add(unptxf);
		
		tptxf = new JTextField();
		tptxf.setColumns(10);
		tptxf.setBounds(157, 210, 224, 25);
		frame.getContentPane().add(tptxf);
		
		dsctxf = new JTextField();
		dsctxf.setColumns(10);
		dsctxf.setBounds(157, 246, 224, 25);
		frame.getContentPane().add(dsctxf);
		
		JButton btnadd = new JButton("ADD");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/furnituremanagementsystems","root","");
					String query="INSERT INTO products VALUES(?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setInt(1, Integer.parseInt(pdtxf.getText()));
					ps.setString(2, nmtxf.getText());
					ps.setInt(3, Integer.parseInt(qtytxf.getText()));
					ps.setInt(4, Integer.parseInt(unptxf.getText()));
					ps.setInt(5, Integer.parseInt(tptxf.getText()));
					ps.setString(6, dsctxf.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(btnadd, "Inserted successfully!!");
					ps.close();
					con.close();
					
				} catch (Exception e2) {
				
				}
			}
		});
		btnadd.setBounds(57, 293, 89, 23);
		frame.getContentPane().add(btnadd);
		JButton btnDelete = new JButton("EXIT");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pdtxf.setText(null);
				nmtxf.setText(null);
				qtytxf.setText(null);
				unptxf.setText(null);
				tptxf.setText(null);
				dsctxf.setText(null);
			}
		});
		btnDelete.setBounds(180, 293, 89, 23);
		frame.getContentPane().add(btnDelete);
	    JButton btnNewButton = new JButton("Back");
	    btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Allformssystem all=new Allformssystem();
				all. frame.setVisible(true);
			   frame.dispose();
			}
		});
	    btnNewButton .setBounds(290, 293, 89, 23);
		frame.getContentPane().add(btnNewButton );
	}
}
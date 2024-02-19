package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class supplier {

	 JFrame frame;
	private JTextField suptxf;
	private JTextField ntxf;
	private JTextField teltxf;
	private JTextField qutxf;
	private JTextField protxf;
	private JTextField stotxf;
	private JButton exbtn;
	protected Component btnenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supplier window = new supplier();
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
	public supplier() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(64, 128, 128));
		frame.setBounds(100, 100, 495, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SUPPLIERS");
		lblNewLabel.setForeground(new Color(128, 255, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(168, 11, 154, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel suplb = new JLabel("supplier_id");
		suplb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		suplb.setBounds(10, 74, 94, 27);
		frame.getContentPane().add(suplb);
		
		JLabel nlb = new JLabel("name");
		nlb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nlb.setBounds(10, 107, 94, 27);
		frame.getContentPane().add(nlb);
		
		JLabel tellb = new JLabel("telephone");
		tellb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tellb.setBounds(10, 142, 94, 27);
		frame.getContentPane().add(tellb);
		
		JLabel qulb = new JLabel("quantity");
		qulb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		qulb.setBounds(10, 173, 94, 27);
		frame.getContentPane().add(qulb);
		
		JLabel prolb = new JLabel("product_id");
		prolb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		prolb.setBounds(10, 205, 94, 27);
		frame.getContentPane().add(prolb);
		
		JLabel stolb = new JLabel("stock_id");
		stolb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stolb.setBounds(10, 242, 94, 27);
		frame.getContentPane().add(stolb);
		
		suptxf = new JTextField();
		suptxf.setBounds(111, 79, 334, 20);
		frame.getContentPane().add(suptxf);
		suptxf.setColumns(10);
		
		ntxf = new JTextField();
		ntxf.setHorizontalAlignment(SwingConstants.LEFT);
		ntxf.setColumns(10);
		ntxf.setBounds(111, 112, 334, 20);
		frame.getContentPane().add(ntxf);
		
		teltxf = new JTextField();
		teltxf.setColumns(10);
		teltxf.setBounds(111, 147, 334, 20);
		frame.getContentPane().add(teltxf);
		
		qutxf = new JTextField();
		qutxf.setColumns(10);
		qutxf.setBounds(111, 178, 334, 20);
		frame.getContentPane().add(qutxf);
		
		protxf = new JTextField();
		protxf.setColumns(10);
		protxf.setBounds(111, 211, 334, 20);
		frame.getContentPane().add(protxf);
		
		stotxf = new JTextField();
		stotxf.setColumns(10);
		stotxf.setBounds(111, 247, 334, 20);
		frame.getContentPane().add(stotxf);
		
		JButton enbtn = new JButton("ENTER");
		enbtn.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/furnituremanagementsystems","root","");
					String querry="INSERT INTO suppliers VALUES(?,?,?,?,?,?)";
					PreparedStatement pSt=con.prepareStatement(querry);
					pSt.setInt(1,Integer.parseInt(suptxf.getText()));
					pSt.setString(2, ntxf.getText());
					pSt.setString(3, teltxf.getText());
					pSt.setInt(4,Integer.parseInt(qutxf.getText()));
					pSt.setInt(5, Integer.parseInt(protxf.getText()));
					pSt.setInt(6, Integer.parseInt(stotxf.getText()));
					pSt.executeUpdate();
					JOptionPane.showMessageDialog(enbtn,"Inserted successfully!!");
					pSt.close();
					con.close();
				} catch (Exception e2) {
					
				}
			}
		});
		enbtn.setBackground(new Color(192, 192, 192));
		enbtn.setBounds(137, 309, 89, 35);
		frame.getContentPane().add(enbtn);
		
		exbtn = new JButton("EXIT");
		exbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ntxf.setText(null);
				protxf.setText(null);
				qutxf.setText(null);
				stotxf.setText(null);
				suptxf.setText(null);
				teltxf.setText(null);
				
			}
		});
		exbtn.setBackground(new Color(192, 192, 192));
		exbtn.setBounds(322, 309, 89, 35);
		frame.getContentPane().add(exbtn);
		
	    JButton btnNewButton = new JButton("Back");
	    btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Allformssystem all=new Allformssystem();
				all. frame.setVisible(true);
			   frame.dispose();
			}
		});
	    btnNewButton .setBounds(350, 366, 89, 23);
		frame.getContentPane().add(btnNewButton );
	}
}






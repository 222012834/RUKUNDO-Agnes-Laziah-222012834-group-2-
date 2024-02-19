package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.UpdatableResultSet;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.awt.event.ActionEvent;

public class stocks {

 JFrame frame;
	private JTextField sttxf;
	private JTextField prtxf;
	private JTextField qutxf;
	private JTextField quotxf;
	protected Component btnADD;
	private JTextField UpdatableResultSet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stocks window = new stocks();
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
	public stocks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(64, 128, 128));
		frame.setBounds(100, 100, 515, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STOCK");
		lblNewLabel.setForeground(new Color(128, 255, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBackground(new Color(64, 128, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(114, 11, 217, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel stlb = new JLabel("stock_id");
		stlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		stlb.setBounds(10, 68, 115, 24);
		frame.getContentPane().add(stlb);
		
		JLabel prlb = new JLabel("product_id");
		prlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		prlb.setBounds(10, 103, 115, 24);
		frame.getContentPane().add(prlb);
		
		JLabel qulb = new JLabel("quantity_in");
		qulb.setFont(new Font("Tahoma", Font.BOLD, 15));
		qulb.setBounds(10, 138, 115, 24);
		frame.getContentPane().add(qulb);
		
		JLabel quolb = new JLabel("quantity_out");
		quolb.setFont(new Font("Tahoma", Font.BOLD, 15));
		quolb.setBounds(10, 173, 115, 24);
		frame.getContentPane().add(quolb);
		
		sttxf = new JTextField();
		sttxf.setBounds(114, 72, 303, 20);
		frame.getContentPane().add(sttxf);
		sttxf.setColumns(10);
		
		prtxf = new JTextField();
		prtxf.setColumns(10);
		prtxf.setBounds(114, 107, 303, 20);
		frame.getContentPane().add(prtxf);
		
		qutxf = new JTextField();
		qutxf.setColumns(10);
		qutxf.setBounds(114, 138, 303, 20);
		frame.getContentPane().add(qutxf);
		
		quotxf = new JTextField();
		quotxf.setColumns(10);
		quotxf.setBounds(114, 177, 303, 20);
		frame.getContentPane().add(quotxf);
		
		JButton addbtn = new JButton("ADD");
		addbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/furnituremanagementsystems","root","");
					String querry="INSERT INTO stocks VALUES(?,?,?,?)";
					PreparedStatement pS=(PreparedStatement) con.prepareStatement(querry);
					pS.setInt(1, Integer.parseInt(sttxf.getText()));
					pS.setInt(2, Integer.parseInt(prtxf.getText()));
					pS.setInt(3, Integer.parseInt(qutxf.getText()));
					pS.setInt(4, Integer.parseInt(quotxf.getText()));
					pS.executeUpdate();
					JOptionPane.showMessageDialog(btnADD, "Inserted successfully!!");
					pS.close();
					con.close();
	
					
				} catch (Exception e2) {
				System.out.println(e2.getMessage());
				}
			
		}
		});
			
		
		addbtn.setBounds(114, 229, 89, 23);
		frame.getContentPane().add(addbtn);
		
		JButton upbtn = new JButton("UPDATE");
		upbtn.addActionListener(new ActionListener() {
			private Component UPDATEbtn;

			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/furnituremanagementsystems","root","");
					String sql= "UPDATE stocks SET product_id=?,quantity_in=?,quanty_out=? WHERE stock_id=?";
					java.sql.PreparedStatement stm=con.prepareStatement(sql);
					stm.setInt(1, Integer.parseInt(sttxf.getText()));
					stm.setInt(2, Integer.parseInt(prtxf.getText()));
					stm.setInt(1, Integer.parseInt(qutxf.getText()));
					stm.setInt(1, Integer.parseInt(quotxf.getText()));
					
					JOptionPane.showConfirmDialog(UPDATEbtn, "updated successfully!!");
					stm.executeUpdate();
					stm.close();
					con.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		upbtn.setBounds(233, 229, 89, 23);
		frame.getContentPane().add(upbtn);
		
		JButton exbtn = new JButton("EXIT");
		exbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sttxf.setText(null);
				prtxf.setText(null);
				qutxf.setText(null);
				quotxf.setText(null);
				
				
			}
		});
		exbtn.setBounds(332, 229, 89, 23);
		frame.getContentPane().add(exbtn);
	    JButton btnNewButton = new JButton("Back");
	    btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Allformssystem all=new Allformssystem();
				all. frame.setVisible(true);
			   frame.dispose();
			}
		});
	    btnNewButton .setBounds(400, 260, 89, 23);
		frame.getContentPane().add(btnNewButton );
	}
}






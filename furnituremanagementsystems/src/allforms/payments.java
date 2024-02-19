package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import org.w3c.dom.Text;

import com.mysql.jdbc.JDBC4PreparedStatement;
import com.mysql.jdbc.PreparedStatement;

import javax.management.Query;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PseudoColumnUsage;
import java.util.concurrent.ConcurrentHashMap;
import java.awt.event.ActionEvent;

public class payments {

	 static JFrame frame;
	private JTextField pyttxf;
	private JTextField tntxf;
	private JTextField amtxf;
	private JTextField dtxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payments window = new payments();
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
	public payments() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 690, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel dlb = new JLabel("Date");
		dlb.setFont(new Font("Tahoma", Font.PLAIN, 19));
		dlb.setBounds(10, 249, 52, 32);
		frame.getContentPane().add(dlb);
		
		JLabel lblNewLabel_1 = new JLabel("PAYMENTS");
		lblNewLabel_1.setForeground(new Color(0, 255, 0));
		lblNewLabel_1.setBackground(new Color(64, 128, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_1.setBounds(233, 11, 145, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel pytlb = new JLabel("payment_id");
		pytlb.setFont(new Font("Tahoma", Font.PLAIN, 19));
		pytlb.setBounds(10, 98, 102, 32);
		frame.getContentPane().add(pytlb);
		
		JLabel tnlb = new JLabel("transaction_name");
		tnlb.setFont(new Font("Tahoma", Font.PLAIN, 19));
		tnlb.setBounds(10, 152, 151, 26);
		frame.getContentPane().add(tnlb);
		
		JLabel amlb = new JLabel("Amount");
		amlb.setFont(new Font("Tahoma", Font.PLAIN, 19));
		amlb.setBounds(10, 198, 115, 26);
		frame.getContentPane().add(amlb);
		
		pyttxf = new JTextField();
		pyttxf.setBounds(248, 98, 353, 30);
		frame.getContentPane().add(pyttxf);
		pyttxf.setColumns(10);
		
		tntxf = new JTextField();
		tntxf.setBounds(248, 159, 353, 26);
		frame.getContentPane().add(tntxf);
		tntxf.setColumns(10);
		
		amtxf = new JTextField();
		amtxf.setBounds(248, 205, 353, 26);
		frame.getContentPane().add(amtxf);
		amtxf.setColumns(10);
		
		dtxf = new JTextField();
		dtxf.setBounds(248, 259, 353, 26);
		frame.getContentPane().add(dtxf);
		dtxf.setColumns(10);
		
		JButton btninsert = new JButton("INSERT");
		btninsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/furnituremanagementsystems","root","");
					String querry="INSERT INTO payments VALUES(?,?,?,?)";
					PreparedStatement pS=(PreparedStatement) con.prepareStatement(querry);
					pS.setInt(1, Integer.parseInt(pyttxf.getText()));
					pS.setString(2, tntxf.getText());
					pS.setInt(3, Integer.parseInt(amtxf.getText()));
					pS.setString(4, dtxf.getText());
					pS.executeUpdate();
					JOptionPane.showMessageDialog(btninsert, "Inserted successfully!!");
					pS.close();
					con.close();
	
					
					
				} catch (Exception e2) {
					
				}
				
			}
		});
		btninsert.setBackground(new Color(255, 128, 128));
		btninsert.setForeground(new Color(0, 128, 255));
		btninsert.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btninsert.setBounds(170, 336, 102, 32);
		frame.getContentPane().add(btninsert);
		
		JButton btnexit = new JButton("EXIT");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pyttxf.setText(null);
				tntxf.setText(null);
				amtxf.setText(null);
				dtxf.setText(null);
			}
		});
		btnexit.setBackground(new Color(0, 0, 0));
		btnexit.setForeground(new Color(255, 0, 0));
		btnexit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnexit.setBounds(346, 336, 95, 32);
		frame.getContentPane().add(btnexit);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Allformssystem all=new Allformssystem();
				all.frame.setVisible(true);
				 payments.frame.dispose();
			}
		});
		btnNewButton.setBounds(497, 336, 89, 32);
		frame.getContentPane().add(btnNewButton);
	}

}

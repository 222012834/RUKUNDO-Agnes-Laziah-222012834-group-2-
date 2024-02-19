package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Account {

	static JFrame frame;
	private JTextField idtxf;
	private JTextField fntxf;
	private JTextField lntxf;
	private JTextField emtxf;
	private JTextField loctxf;
	private JTextField usntxf;
	private JTextField passtxf;
	private JTextField usttxf;
	protected Component createbtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account window = new Account();
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
	public Account() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACCOUNT");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel.setBounds(231, 11, 194, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel idlb = new JLabel("id");
		idlb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		idlb.setBounds(10, 80, 100, 31);
		frame.getContentPane().add(idlb);
		
		JLabel fnlb = new JLabel("first name");
		fnlb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		fnlb.setBounds(0, 122, 151, 31);
		frame.getContentPane().add(fnlb);
		
		JLabel lnlb = new JLabel("Last name");
		lnlb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lnlb.setBounds(0, 164, 161, 32);
		frame.getContentPane().add(lnlb);
		
		JLabel emlb = new JLabel("Email");
		emlb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		emlb.setBounds(0, 207, 130, 31);
		frame.getContentPane().add(emlb);
		
		JLabel loclb = new JLabel("Location");
		loclb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		loclb.setBounds(0, 249, 151, 36);
		frame.getContentPane().add(loclb);
		
		JLabel usnlb = new JLabel("User name");
		usnlb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		usnlb.setBounds(0, 296, 194, 35);
		frame.getContentPane().add(usnlb);
		
		JLabel passlb = new JLabel("Password");
		passlb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		passlb.setBounds(0, 342, 151, 31);
		frame.getContentPane().add(passlb);
		
		JLabel ustlb = new JLabel("User type");
		ustlb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		ustlb.setBounds(0, 384, 136, 31);
		frame.getContentPane().add(ustlb);
		
		idtxf = new JTextField();
		idtxf.setBounds(231, 92, 355, 25);
		frame.getContentPane().add(idtxf);
		idtxf.setColumns(10);
		
		fntxf = new JTextField();
		fntxf.setBounds(231, 128, 355, 25);
		frame.getContentPane().add(fntxf);
		fntxf.setColumns(10);
		
		lntxf = new JTextField();
		lntxf.setBounds(231, 164, 355, 25);
		frame.getContentPane().add(lntxf);
		lntxf.setColumns(10);
		
		emtxf = new JTextField();
		emtxf.setBounds(231, 207, 355, 25);
		frame.getContentPane().add(emtxf);
		emtxf.setColumns(10);
		
		loctxf = new JTextField();
		loctxf.setBounds(231, 249, 353, 25);
		frame.getContentPane().add(loctxf);
		loctxf.setColumns(10);
		
		usntxf = new JTextField();
		usntxf.setBounds(231, 296, 355, 25);
		frame.getContentPane().add(usntxf);
		usntxf.setColumns(10);
		
		passtxf = new JTextField();
		passtxf.setBounds(231, 334, 355, 25);
		frame.getContentPane().add(passtxf);
		passtxf.setColumns(10);
		
		usttxf = new JTextField();
		usttxf.setBounds(231, 380, 352, 25);
		frame.getContentPane().add(usttxf);
		usttxf.setColumns(10);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/furnituremanagementsystems","root","");
				String querry="INSERT INTO Account VALUES(?,?,?,?,?,?,?,?)";
				PreparedStatement pSt=con.prepareStatement(querry);
				pSt.setInt(1,Integer.parseInt(idtxf.getText()));
				pSt.setString(2, fntxf.getText());
				pSt.setString(3, lntxf.getText());
				pSt.setString(4, emtxf.getText());
				pSt.setString(5, loctxf.getText());
				pSt.setString(6, usntxf.getText());
				pSt.setString(7, passtxf.getText());
				pSt.setString(8, usttxf.getText());
				pSt.executeUpdate();
				JOptionPane.showMessageDialog(createbtn,"created successfully!!");
				Login ll=new Login();
				ll.setVisible(true);
				Account.frame.dispose();
				pSt.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			}
		});
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(248, 428, 109, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idtxf.setText(null);
				fntxf.setText(null);
				lntxf.setText(null);
				emtxf.setText(null);
				loctxf.setText(null);
				usntxf.setText(null);
				passtxf.setText(null);
				usttxf.setText(null);
				
			}
		});
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnCancel.setBounds(446, 428, 109, 34);
		frame.getContentPane().add(btnCancel);
		frame.setBounds(100, 100, 620, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

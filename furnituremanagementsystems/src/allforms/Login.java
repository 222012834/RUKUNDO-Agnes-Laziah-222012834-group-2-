package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usentxf;
	private JTextField usertyptxf;
	private JPasswordField passtxf;

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
		setBounds(100, 100, 608, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN FORM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(23, 21, 615, 43);
		contentPane.add(lblNewLabel);
		
		JLabel username = new JLabel("username");
		username.setFont(new Font("Tahoma", Font.BOLD, 19));
		username.setBounds(23, 108, 167, 43);
		contentPane.add(username);
		
		JLabel password = new JLabel("password");
		password.setFont(new Font("Tahoma", Font.BOLD, 19));
		password.setBounds(23, 196, 167, 43);
		contentPane.add(password);
		
		JLabel usertype = new JLabel("usertype");
		usertype.setFont(new Font("Tahoma", Font.BOLD, 19));
		usertype.setBounds(23, 288, 167, 43);
		contentPane.add(usertype);
		
		usentxf = new JTextField();
		usentxf.setBounds(240, 112, 265, 43);
		contentPane.add(usentxf);
		usentxf.setColumns(10);
		
		usertyptxf = new JTextField();
		usertyptxf.setColumns(10);
		usertyptxf.setBounds(240, 303, 265, 43);
		contentPane.add(usertyptxf);
		
		JButton loginbtn = new JButton("LOGIN");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/furnituremanagementsystems","root","");
					Statement stm=con.createStatement();
					String query="select * from account where username='"+usentxf.getText()+"' and password='"+passtxf.getText().toString()+"' and usertype='"+usertyptxf.getText()+"'";
					ResultSet set=stm.executeQuery(query);
					if (set.next()) {
						JOptionPane.showMessageDialog(loginbtn, "Login Successfully!!!");
						Allformssystem all=new Allformssystem();
						all.frame.setVisible(true);
						dispose();
						
						
					}
					else {
						JOptionPane.showMessageDialog(null, "username or password incorrect");
					}
				} catch (Exception e2) {
					
				}
				
			}
		});
		loginbtn.setFont(new Font("Tahoma", Font.BOLD, 19));
		loginbtn.setBounds(89, 379, 118, 55);
		contentPane.add(loginbtn);
		
		JButton cancelbtn = new JButton("CANCEL");
		cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usentxf.setText(null);
				passtxf.setText(null);
				usertyptxf.setText(null);
			}
		});
		cancelbtn.setFont(new Font("Tahoma", Font.BOLD, 19));
		cancelbtn.setBounds(387, 379, 118, 55);
		contentPane.add(cancelbtn);
		
		JButton signupbtn = new JButton("SIGNUP");
		signupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account account=new Account();
				account.frame.setVisible(true);
				dispose();
			}
		});
		signupbtn.setFont(new Font("Tahoma", Font.BOLD, 19));
		signupbtn.setBounds(217, 379, 160, 55);
		contentPane.add(signupbtn);
		
		passtxf = new JPasswordField();
		passtxf.setBounds(240, 197, 265, 48);
		contentPane.add(passtxf);
	}
}

package allforms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.JDBC4ResultSet;
import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class Employee<DefaultTableModel> extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final Component ADDbtn = null;
	protected static final String con = null;
	private JTextField emtxf;
	private JTextField ntxf;
	private JTextField phntxf;
	private JTextField saltxf;
	private JTextField potxf;
	protected AbstractButton tt;
	 JTable table;
	TableModel mode;
	Object row;
	protected JLabel emp_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
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
	public Employee() {
		getContentPane().setBackground(new Color(64, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1102, 577);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE FORM");
		lblNewLabel.setBounds(0, 11, 1041, 47);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(128, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		getContentPane().add(lblNewLabel);
		
		JLabel emlb = new JLabel("emp_id");
		emlb.setBounds(10, 104, 109, 28);
		emlb.setFont(new Font("Tahoma", Font.PLAIN, 19));
		getContentPane().add(emlb);
		
		JLabel nlb = new JLabel("emp_name");
		nlb.setBounds(10, 177, 109, 28);
		nlb.setFont(new Font("Tahoma", Font.PLAIN, 19));
		getContentPane().add(nlb);
		
		JLabel phn = new JLabel("phone");
		phn.setBounds(10, 247, 109, 28);
		phn.setFont(new Font("Tahoma", Font.PLAIN, 19));
		getContentPane().add(phn);
		
		JLabel sal = new JLabel("salary");
		sal.setBounds(10, 299, 93, 28);
		sal.setFont(new Font("Tahoma", Font.PLAIN, 19));
		getContentPane().add(sal);
		
		JLabel po = new JLabel("position");
		po.setBounds(10, 367, 93, 28);
		po.setFont(new Font("Tahoma", Font.PLAIN, 19));
		getContentPane().add(po);
		
		emtxf = new JTextField();
		emtxf.setBounds(207, 112, 405, 28);
		getContentPane().add(emtxf);
		emtxf.setColumns(10);
		
		ntxf = new JTextField();
		ntxf.setBounds(207, 177, 405, 28);
		getContentPane().add(ntxf);
		ntxf.setColumns(10);
		
		phntxf = new JTextField();
		phntxf.setBounds(207, 247, 405, 28);
		getContentPane().add(phntxf);
		phntxf.setColumns(10);
		
		saltxf = new JTextField();
		saltxf.setBounds(207, 303, 400, 28);
		getContentPane().add(saltxf);
		saltxf.setColumns(10);
		
		potxf = new JTextField();
		potxf.setBounds(212, 368, 400, 35);
		getContentPane().add(potxf);
		potxf.setColumns(10);
		mode=(TableModel) new javax.swing.table.DefaultTableModel();
		Object[] column= {"id","name","phone","salary","position"};
		Object[] row=new Object[5];
		((javax.swing.table.DefaultTableModel) mode).setColumnIdentifiers(column);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(639, 104, 418, 403);
		scrollPane.setViewportView(table);
		getContentPane().add(scrollPane);
		
		JButton btnADD = new JButton("ADD");
		btnADD.setBounds(207, 430, 93, 28);
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/furnituremanagementsystems","root","");
					String query= "INSERT INTO employee VALUES (?,?,?,?,?)";
					PreparedStatement pst=(PreparedStatement) connection.prepareStatement(query);
					pst.setInt(1, Integer.parseInt(emtxf.getText()));
					pst.setString(2,ntxf.getText());
					pst.setString(3,phntxf.getText());
					pst.setInt(4, Integer.parseInt(saltxf.getText()));
					pst.setString(5,potxf.getText());
				    pst.executeUpdate();
				    JOptionPane.showMessageDialog(ADDbtn, "inserted successfully!!!!!!!!!");
				    pst.close();
				    connection.close();
					
				} catch (Exception e2) {
					
				}
			}
		});
		
		table = new JTable();
		table.setBounds(639, 104, 418, 406);
		//table.setModel(mode);
		getContentPane().add(table);
		btnADD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(btnADD);
		
		JButton btnUPDATE = new JButton("UPDATE");
		btnUPDATE.setBounds(399, 428, 102, 35);
		btnUPDATE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/furnituremanagementsystems","root","");
					String sql= "UPDATE employee SET emp_name=?,phone=?,salary=?,position=? WHERE emp_id=?";
					java.sql.PreparedStatement stm=con.prepareStatement(sql);
					stm.setInt(1, Integer.parseInt(emtxf.getText()));
					stm.setString(2, ntxf.getText());
					stm.setString(3, phntxf.getText());
					stm.setString(4, saltxf.getText());
					stm.setString(5, potxf.getText());
					JOptionPane.showConfirmDialog(btnUPDATE, "updated successfully!!");
					stm.executeUpdate();
					stm.close();
					con.close();
				} catch (Exception e2) {
					
				}
			}
		});
		btnUPDATE.setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().add(btnUPDATE);
		
		JButton btnVEIW = new JButton("VEIW");
		btnVEIW.setBounds(211, 482, 89, 28);
		btnVEIW.setForeground(new Color(0, 0, 255));
		btnVEIW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/furnituremanagementsystems","root","");
					Statement stm=con.createStatement();
					String query="Select * from Employee";
					ResultSet rs =stm.executeQuery(query);
					java.sql.ResultSetMetaData rsmd= rs.getMetaData();
					DefaultTableModel mode=(DefaultTableModel) table.getModel();
					int cols=rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0; i<cols; i++)
						colName[i]=rsmd.getColumnName(i+1);
					((javax.swing.table.DefaultTableModel) mode).setColumnIdentifiers(colName);
					String id,name,quantity,unity,price;
					while(rs.next()) {
						id=rs.getString(1);
						name=rs.getString(2);
						quantity=rs.getString(3);
						unity=rs.getString(4);
						price=rs.getString(5);
						String[] row= {id,name,quantity,unity,price};
						((javax.swing.table.DefaultTableModel) mode).addRow(row);
					}
					stm.close();
					con.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}

			}
		});
		btnVEIW.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(btnVEIW);
		
		JButton btnCANCEL = new JButton("CANCEL");
		btnCANCEL.setBounds(399, 482, 102, 29);
		btnCANCEL.setForeground(new Color(255, 0, 0));
		btnCANCEL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emtxf.setText(null);
				ntxf.setText(null);
                phntxf.setText(null);
                potxf.setText(null);
                saltxf.setText(null);
			}
		});
		btnCANCEL.setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().add(btnCANCEL);		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(523, 482, 89, 28);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Allformssystem more=new Allformssystem();
				more.frame.setVisible(true);
			   dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furnituremanagementsystems","root","");
					String query="SELECT * FROM employee WHERE emp_id=?";
					PreparedStatement pSt=(PreparedStatement) connection.prepareStatement(query);
					pSt.setString(1, emtxf.getText());
					ResultSet rs=pSt.executeQuery();
					if(rs.next()==false) {
						JOptionPane.showMessageDialog(null,"please,enter your id");
						
					}
					else {
						ntxf.setText(rs.getString(2));
						phntxf.setText(rs.getString(3));
						potxf.setText(rs.getString(4));
						saltxf.setText(rs.getString(5)); 
					
					};
					} catch (Exception e2) {
					
				}
				
}
				
				
				
		});
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_1.setBounds(939, 11, 139, 35);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\multimedia\\non.png"));
		lblNewLabel_1.setBounds(112, 103, 507, 351);
		getContentPane().add(lblNewLabel_1);
	}
}

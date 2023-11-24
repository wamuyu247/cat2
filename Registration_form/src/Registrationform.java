import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Registrationform extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtusername;
	private JTextField txtemail;
	private JTextField intphone;
	private JTextField txtaddress;
	private JPasswordField txtpassword;
	private JPasswordField txtpassword2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrationform frame = new Registrationform();
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
	public Registrationform() {
		setTitle("Registration Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(33, 21, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("REGISTRATION FORM");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(78, 0, 123, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setBounds(20, 46, 59, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setBounds(20, 71, 59, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password");
		lblNewLabel_4.setBounds(10, 96, 96, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setBounds(30, 133, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phone:");
		lblNewLabel_6.setBounds(30, 158, 39, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address:");
		lblNewLabel_7.setBounds(23, 183, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		txtName = new JTextField();
		txtName.setBounds(102, 18, 227, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtusername = new JTextField();
		txtusername.setBounds(102, 43, 227, 20);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setBounds(101, 130, 228, 20);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		intphone = new JTextField();
		intphone.setBounds(102, 155, 227, 20);
		contentPane.add(intphone);
		intphone.setColumns(10);
		
		txtaddress = new JTextField();
		txtaddress.setBounds(102, 180, 227, 20);
		contentPane.add(txtaddress);
		txtaddress.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(102, 68, 227, 20);
		contentPane.add(txtpassword);
		
		txtpassword2 = new JPasswordField();
		txtpassword2.setBounds(102, 93, 227, 20);
		contentPane.add(txtpassword2);
		
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/User","root", "");
					String query="insert into registration values(?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, txtName.getText());
					ps.setString(2, txtusername.getText());
					ps.setString(3, txtpassword.getText());
					ps.setString(4, txtpassword2.getText());
					ps.setString(5, txtemail.getText());
					ps.setString(6, intphone.getText());
					ps.setString(7, txtaddress.getText());
					int i=ps.executeUpdate();
					JOptionPane.showMessageDialog(btnsubmit,i+"Record added successfully");
					ps.close();
					con.close();
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnsubmit.setBounds(119, 227, 89, 23);
		contentPane.add(btnsubmit);
		
		JButton btnreset = new JButton("reset");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtusername.setText("");
				txtpassword.setText("");
				txtpassword2.setText("");
				txtemail.setText("");
				txtName.setText("");
				intphone.setText("");
				txtaddress.setText("");
			
				
				
			}
		});
		btnreset.setBounds(218, 227, 89, 23);
		contentPane.add(btnreset);
		
		JButton btnclose = new JButton("Close");
		btnclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnclose.setBounds(317, 227, 89, 23);
		contentPane.add(btnclose);
	}
}

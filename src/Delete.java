import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Delete {

	public JFrame frame;
	private JTextField pass;
	private JTextField pass1;
	private JTextField users;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete window = new Delete();
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
	public Delete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 623, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		pass = new JTextField();
		pass.setBounds(243, 112, 116, 22);
		frame.getContentPane().add(pass);
		pass.setColumns(10);
		
		pass1 = new JTextField();
		pass1.setColumns(10);
		pass1.setBounds(243, 145, 116, 22);
		frame.getContentPane().add(pass1);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(159, 81, 72, 16);
		frame.getContentPane().add(lblUsername);
		
		users = new JTextField();
		users.setBounds(243, 77, 116, 22);
		frame.getContentPane().add(users);
		users.setColumns(10);
		users.setEditable(false);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(159, 115, 72, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblPassword_1 = new JLabel("Re-Enter Password");
		lblPassword_1.setBounds(109, 148, 122, 16);
		frame.getContentPane().add(lblPassword_1);
		
		String u=new Login().getUser();
		users.setText(u);
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			//here railways is database name, root is username and password is simar
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * users where username='"+u+"'");  
				rs.first();
				
				String p=pass.getText();
				String p1=pass1.getText();
				if(p.equals(p1)&&rs.getString(2).contentEquals(p))
				{
					Statement stmt2=con.createStatement();  
					stmt2.executeUpdate("delete from users where username='"+u+"'");
					frame.setVisible(false);
					new Login().frame.setVisible(true);
				}
			}
			catch(Exception e11)
			{
				System.out.println(e11);
			}
			}
		});
		btnDelete.setBounds(185, 192, 97, 25);
		frame.getContentPane().add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new MenuOption().frame.setVisible(true);
			}
		});
		btnBack.setBounds(314, 192, 97, 25);
		frame.getContentPane().add(btnBack);
	}
}

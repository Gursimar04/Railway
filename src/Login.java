import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

public class Login {

	public JFrame frame;
	private JTextField user;
	private JPasswordField pass;
	private static String usernames;
	private static String names;
	private JButton btnCheckPnr;
	private JButton btnNewUsersignup;
	
	java.net.URL train = this.getClass().getClassLoader().getResource("images/tt.png");
	ImageIcon I=new ImageIcon(train);
	java.net.URL login = this.getClass().getClassLoader().getResource("images/login3.png");
	ImageIcon II=new ImageIcon(login);
	java.net.URL check = this.getClass().getClassLoader().getResource("images/check.png");
	ImageIcon III=new ImageIcon(check);
	java.net.URL use = this.getClass().getClassLoader().getResource("images/use2.png");
	ImageIcon IV=new ImageIcon(use);
	java.net.URL passw = this.getClass().getClassLoader().getResource("images/passw.png");
	ImageIcon V=new ImageIcon(passw);
	java.net.URL usell = this.getClass().getClassLoader().getResource("images/uselog.png");
	ImageIcon VI=new ImageIcon(usell);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBounds(100, 100, 511, 379);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("");
		lblUsername.setBounds(282, 103, 30, 37);
		frame.getContentPane().add(lblUsername);
		lblUsername.setIcon(IV);
		
		JLabel lblPassword = new JLabel("");
		lblPassword.setBounds(286, 143, 30, 28);
		frame.getContentPane().add(lblPassword);
		lblPassword.setIcon(V);
		
		user = new JTextField();
		user.setBounds(315, 108, 116, 25);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		JButton btnSubmit = new JButton("");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try{  
					Class.forName("com.mysql.cj.jdbc.Driver");  
					Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar");  
					//here railways is database name, root is username and password is simar
					
					Statement stmt=con.createStatement();  
					String u=user.getText();
					usernames=user.getText();
					@SuppressWarnings("deprecation")
					String p=pass.getText();
					ResultSet rs=stmt.executeQuery("select * from users");  
						while (rs.next())
						{
					      String use= rs.getString("username");
					      String passw= rs.getString("password");
					             names= rs.getString("fname")+" "+rs.getString("mname")+" "+rs.getString("lname");
					      if(use.compareTo(u)==0&&passw.compareTo(p)==0)
					      {
					    	  frame.setVisible(false);
					    	  new MenuOption().frame.setVisible(true);
								break;
					      }
					      else if(rs.last()==true)
					      {
					    	  JOptionPane.showMessageDialog(null,"Incorrect username or password\nPlease try again");
					      }
					    } 
					con.close();  
					}
				catch(Exception e){ System.out.println(e);}
			}
			
		});
		btnSubmit.setBounds(259, 175, 91, 37);
		frame.getContentPane().add(btnSubmit);
		btnSubmit.setIcon(II);
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.setBorderPainted(false);
		btnSubmit.setFocusPainted(false); 
		
		pass = new JPasswordField();
		pass.setBounds(315, 146, 116, 22);
		frame.getContentPane().add(pass);
		
		btnCheckPnr = new JButton("Check PNR");
		btnCheckPnr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new pnr().frame_1.setVisible(true);
			}
		});
		btnCheckPnr.setBounds(352, 175, 116, 37);
		frame.getContentPane().add(btnCheckPnr);
		btnCheckPnr.setIcon(III);
		btnCheckPnr.setContentAreaFilled(false);
		btnCheckPnr.setBorderPainted(false);
		btnCheckPnr.setFocusPainted(false); 
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 127, 80), 2, true));
		panel.setBackground(SystemColor.info);
		panel.setBounds(238, 63, 243, 193);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUserLogin = new JLabel("User Login");
		lblUserLogin.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblUserLogin.setForeground(new Color(255, 127, 80));
		lblUserLogin.setBounds(76, 2, 106, 37);
		panel.add(lblUserLogin);
		lblUserLogin.setIcon(VI);
		
		
		
		btnNewUsersignup = new JButton("New User?Signup!");
		btnNewUsersignup.setBounds(43, 155, 164, 25);
		panel.add(btnNewUsersignup);
		btnNewUsersignup.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnNewUsersignup.setForeground(new Color(255, 99, 71));
		btnNewUsersignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new signup().frame.setVisible(true);
			}
		});
		btnNewUsersignup.setContentAreaFilled(false);
		btnNewUsersignup.setBorderPainted(false);
		btnNewUsersignup.setFocusPainted(false);
		
		JLabel imgl = new JLabel("");
		imgl.setBounds(-23, 58, 214, 234);
		frame.getContentPane().add(imgl);
		imgl.setIcon(I);
		
		JLabel lblRailwayReservationSystem = new JLabel("Railway Reservation System");
		lblRailwayReservationSystem.setBackground(new Color(240, 240, 240));
		lblRailwayReservationSystem.setForeground(new Color(255, 99, 71));
		lblRailwayReservationSystem.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 22));
		lblRailwayReservationSystem.setBounds(244, 22, 237, 28);
		frame.getContentPane().add(lblRailwayReservationSystem);
	}
	public String getUser()
	{
		return usernames;
	}
	public String getName()
	{
		return names;
	}
}

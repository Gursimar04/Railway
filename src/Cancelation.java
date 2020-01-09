import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Cancelation {

	public JFrame frame;
	private JTextField pnrs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cancelation window = new Cancelation();
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
	public Cancelation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 765, 581);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterPnrNumber = new JLabel("Enter PNR Number");
		lblEnterPnrNumber.setBounds(84, 97, 115, 16);
		frame.getContentPane().add(lblEnterPnrNumber);
		
		pnrs = new JTextField();
		pnrs.setBounds(274, 94, 176, 22);
		frame.getContentPane().add(pnrs);
		pnrs.setColumns(20);
		
		JButton btnCancel = new JButton("Cancel Ticket");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{  
					Class.forName("com.mysql.cj.jdbc.Driver");  
					Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar");  
					//here railways is database name, root is username and password is simar
					Statement stmt=con.createStatement();  
					ResultSet rs=stmt.executeQuery("select * from chartinfo where pnr='"+pnrs.getText()+"'");  
						rs.first();
						String table=rs.getString(1);
						Integer sea=rs.getInt(7);
						Statement stmt4=con.createStatement();;
						ResultSet rs4=stmt4.executeQuery("Select *from "+table+" where seat="+sea+"");
						rs4.first();
						int i=2;
						while(!rs4.getString(i).equals(new Search().getboards()))
								i++;
						while(!rs4.getString(i).equals(new Search().getdest()))
						{
							Statement stmt3=con.createStatement();;
							stmt3.executeUpdate("Update "+table+" set "+rs4.getString(i)+"='n/a' where seat="+sea);
							i++;
						}
						Statement stmt2=con.createStatement();;
						stmt2.executeUpdate("Delete from chartinfo where PNR="+pnrs.getText()+"'");
						
						
						
					con.close();  
					}
				catch(Exception e1){ System.out.println(e1);}
			}
		});
		btnCancel.setBounds(152, 162, 115, 25);
		frame.getContentPane().add(btnCancel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new MenuOption().frame.setVisible(true);
			}
		});
		btnBack.setBounds(353, 162, 97, 25);
		frame.getContentPane().add(btnBack);
	}

}

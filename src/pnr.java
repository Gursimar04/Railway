import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class pnr {

	public JFrame frame_1;
	private JTextField pnrs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pnr window = new pnr();
					window.frame_1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public pnr() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame_1 = new JFrame();
		frame_1.setBounds(100, 100, 1120, 653);
		frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_1.getContentPane().setLayout(null);
		
		JLabel lblTrainno = new JLabel("TrainNO");
		lblTrainno.setBounds(54, 70, 66, 16);
		frame_1.getContentPane().add(lblTrainno);
		
		JLabel lblBoardingStation = new JLabel("Boarding Station");
		lblBoardingStation.setBounds(234, 70, 104, 16);
		frame_1.getContentPane().add(lblBoardingStation);
		
		JLabel lblDestinationStation = new JLabel("Destination Station");
		lblDestinationStation.setBounds(383, 70, 107, 16);
		frame_1.getContentPane().add(lblDestinationStation);
		
		JLabel lblCoach = new JLabel("Coach");
		lblCoach.setBounds(516, 70, 56, 16);
		frame_1.getContentPane().add(lblCoach);
		
		JLabel lblSeatno = new JLabel("SeatNo");
		lblSeatno.setBounds(596, 70, 56, 16);
		frame_1.getContentPane().add(lblSeatno);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(953, 70, 69, 16);
		frame_1.getContentPane().add(lblDate);
		
		JLabel lblNam = new JLabel("Name");
		lblNam.setBounds(664, 70, 56, 16);
		frame_1.getContentPane().add(lblNam);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(755, 70, 56, 16);
		frame_1.getContentPane().add(lblAge);
		
		JLabel lblPnr = new JLabel("PNR");
		lblPnr.setBounds(821, 70, 56, 16);
		frame_1.getContentPane().add(lblPnr);
		
		JLabel lblTrainName = new JLabel("Train Name");
		lblTrainName.setBounds(132, 70, 77, 16);
		frame_1.getContentPane().add(lblTrainName);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(132, 118, 104, 16);
		frame_1.getContentPane().add(label_1);
		
		JLabel label = new JLabel("");
		label.setBounds(54, 118, 66, 16);
		frame_1.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(246, 118, 104, 16);
		frame_1.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(383, 118, 107, 16);
		frame_1.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(516, 118, 56, 16);
		frame_1.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(596, 118, 56, 16);
		frame_1.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(664, 118, 56, 16);
		frame_1.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(755, 118, 56, 16);
		frame_1.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(821, 118, 146, 16);
		frame_1.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(965, 118, 91, 16);
		frame_1.getContentPane().add(label_9);
		
		JLabel[] arr=new JLabel[40];
		arr[0]=label;
		arr[1]=label_1;
		arr[2]=label_2;
		arr[3]=label_3;
		arr[4]=label_4;
		arr[5]=label_5;
		arr[6]=label_6;
		arr[7]=label_7;
		arr[8]=label_8;
		arr[9]=label_9;
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame_1.setVisible(false);
				new Login().frame.setVisible(true);
			}
		});
		btnBack.setBounds(445, 257, 97, 25);
		frame_1.getContentPane().add(btnBack);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try{  
					Class.forName("com.mysql.cj.jdbc.Driver");  
					Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar");  
					//here railways is database name, root is username and password is simar
					
					Statement stmt=con.createStatement();  
					ResultSet rs=stmt.executeQuery("select * from chartinfo where username='"+new Login().getUser()+"'");  
						rs.first();
						int i=0;
						while(rs.next())
						{
							
							Statement stmt1=con.createStatement();  
								ResultSet rs1=stmt1.executeQuery("select * from chartinfo where PNR='"+pnrs.getText()+"'");  
								rs1.first();
								arr[i].setText(rs.getString(3));i++;
								arr[i].setText(rs1.getString(2));i++;
								arr[i].setText(rs.getString(4));i++;
								arr[i].setText(rs.getString(5));i++;
								arr[i].setText(rs.getString(6));i++;
								arr[i].setText(rs.getString(7));i++;
								arr[i].setText(rs.getString(8));i++;
								arr[i].setText(rs.getString(9));i++;
								arr[i].setText(rs.getString(10));i++;
								arr[i].setText(rs.getString(11));i++;
						}
						
						
						
					con.close();  
					}
				catch(Exception e1){ System.out.println(e1);}
			}
			
		});
		btnSearch.setBounds(323, 257, 97, 25);
		frame_1.getContentPane().add(btnSearch);
		
		pnrs = new JTextField();
		pnrs.setBounds(346, 219, 153, 22);
		frame_1.getContentPane().add(pnrs);
		pnrs.setColumns(10);
		
		JLabel lblEnterPnr = new JLabel("Enter pnr");
		lblEnterPnr.setBounds(246, 225, 56, 16);
		frame_1.getContentPane().add(lblEnterPnr);
		
		
		
		

	}
}

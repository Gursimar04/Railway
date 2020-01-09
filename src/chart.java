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

public class chart {

	public JFrame frame;
	private JTextField tnum;
	private JTextField da;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chart window = new chart();
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
	public chart() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1130, 769);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTrainno = new JLabel("SeatNo");
		lblTrainno.setBounds(54, 70, 66, 16);
		frame.getContentPane().add(lblTrainno);
		
		JLabel lblBoardingStation = new JLabel("Boarding Station");
		lblBoardingStation.setBounds(234, 70, 104, 16);
		frame.getContentPane().add(lblBoardingStation);
		
		JLabel lblDestinationStation = new JLabel("Destination Station");
		lblDestinationStation.setBounds(383, 70, 107, 16);
		frame.getContentPane().add(lblDestinationStation);
		
		JLabel lblCoach = new JLabel("Coach");
		lblCoach.setBounds(516, 70, 56, 16);
		frame.getContentPane().add(lblCoach);
		
		JLabel lblNam = new JLabel("Name");
		lblNam.setBounds(664, 70, 56, 16);
		frame.getContentPane().add(lblNam);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(755, 70, 56, 16);
		frame.getContentPane().add(lblAge);
		
		JLabel lblPnr = new JLabel("PNR");
		lblPnr.setBounds(821, 70, 56, 16);
		frame.getContentPane().add(lblPnr);
		
		JLabel lblTrainName = new JLabel("Username");
		lblTrainName.setBounds(132, 70, 77, 16);
		frame.getContentPane().add(lblTrainName);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(132, 118, 104, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label = new JLabel("");
		label.setBounds(54, 118, 66, 16);
		frame.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(246, 118, 104, 16);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(383, 118, 107, 16);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(516, 118, 56, 16);
		frame.getContentPane().add(label_4);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(664, 118, 56, 16);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(755, 118, 56, 16);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(821, 118, 146, 16);
		frame.getContentPane().add(label_8);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(132, 156, 77, 16);
		frame.getContentPane().add(label_10);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(54, 156, 66, 16);
		frame.getContentPane().add(label_12);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(234, 156, 104, 16);
		frame.getContentPane().add(label_11);
		
		JLabel label_13 = new JLabel("");
		label_13.setBounds(383, 156, 107, 16);
		frame.getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("");
		label_14.setBounds(516, 156, 56, 16);
		frame.getContentPane().add(label_14);
		
		JLabel label_16 = new JLabel("");
		label_16.setBounds(664, 156, 56, 16);
		frame.getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel("");
		label_17.setBounds(755, 156, 56, 16);
		frame.getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("");
		label_18.setBounds(821, 156, 130, 16);
		frame.getContentPane().add(label_18);
		
		JLabel label_21 = new JLabel("");
		label_21.setBounds(132, 189, 77, 16);
		frame.getContentPane().add(label_21);
		
		JLabel label_20 = new JLabel("");
		label_20.setBounds(54, 189, 66, 16);
		frame.getContentPane().add(label_20);
		
		JLabel label_22 = new JLabel("");
		label_22.setBounds(234, 189, 104, 16);
		frame.getContentPane().add(label_22);
		
		JLabel label_23 = new JLabel("");
		label_23.setBounds(383, 189, 107, 16);
		frame.getContentPane().add(label_23);
		
		JLabel label_24 = new JLabel("");
		label_24.setBounds(516, 189, 56, 16);
		frame.getContentPane().add(label_24);
		
		JLabel label_26 = new JLabel("");
		label_26.setBounds(664, 189, 56, 16);
		frame.getContentPane().add(label_26);
		
		JLabel label_27 = new JLabel("");
		label_27.setBounds(755, 189, 56, 16);
		frame.getContentPane().add(label_27);
		
		JLabel label_28 = new JLabel("");
		label_28.setBounds(821, 189, 130, 16);
		frame.getContentPane().add(label_28);
		
		JLabel label_31 = new JLabel("");
		label_31.setBounds(132, 254, 77, 16);
		frame.getContentPane().add(label_31);
		
		JLabel label_30 = new JLabel("");
		label_30.setBounds(54, 254, 66, 16);
		frame.getContentPane().add(label_30);
		
		JLabel label_32 = new JLabel("");
		label_32.setBounds(234, 254, 104, 16);
		frame.getContentPane().add(label_32);
		
		JLabel label_33 = new JLabel("");
		label_33.setBounds(383, 254, 107, 16);
		frame.getContentPane().add(label_33);
		
		JLabel label_34 = new JLabel("");
		label_34.setBounds(516, 254, 56, 16);
		frame.getContentPane().add(label_34);
		
		JLabel label_36 = new JLabel("");
		label_36.setBounds(664, 254, 56, 16);
		frame.getContentPane().add(label_36);
		
		JLabel label_37 = new JLabel("");
		label_37.setBounds(755, 254, 56, 16);
		frame.getContentPane().add(label_37);
		
		JLabel label_38 = new JLabel("");
		label_38.setBounds(821, 254, 130, 16);
		frame.getContentPane().add(label_38);
		
		JLabel[] arr=new JLabel[40];
		arr[0]=label;
		arr[1]=label_1;
		arr[2]=label_2;
		arr[3]=label_3;
		arr[4]=label_4;
		arr[5]=label_6;
		arr[6]=label_7;
		arr[7]=label_8;
		arr[8]=label_12;
		arr[9]=label_10;
		arr[10]=label_11;
		arr[11]=label_13;
		arr[12]=label_14;
		arr[13]=label_16;
		arr[14]=label_17;
		arr[15]=label_18;
		arr[16]=label_20;
		arr[17]=label_21;
		arr[18]=label_22;
		arr[19]=label_23;
		arr[20]=label_24;
		arr[21]=label_26;
		arr[22]=label_27;
		arr[23]=label_28;
		arr[24]=label_30;
		arr[25]=label_31;
		arr[26]=label_32;
		arr[27]=label_33;
		arr[28]=label_34;
		arr[29]=label_36;
		arr[30]=label_37;
		arr[31]=label_38;
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new MenuOption().frame.setVisible(true);
			}
		});
		btnBack.setBounds(447, 532, 97, 25);
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Train Number");
		lblNewLabel.setBounds(246, 461, 91, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(282, 490, 41, 16);
		frame.getContentPane().add(lblDate);
		
		tnum = new JTextField();
		tnum.setBounds(365, 458, 166, 22);
		frame.getContentPane().add(tnum);
		tnum.setColumns(10);
		
		da = new JTextField();
		da.setColumns(10);
		da.setBounds(365, 497, 166, 22);
		frame.getContentPane().add(da);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try{  
					Class.forName("com.mysql.cj.jdbc.Driver");  
					Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar");  
					//here railways is database name, root is username and password is simar
					
					Statement stmt=con.createStatement();  
					String tn=tnum.getText();
					ResultSet rs=stmt.executeQuery("select * from chartinfo where Tnumber='"+tn+"' AND Tdate='"+da.getText()+"'");  
						int i=0;
						while(rs.next())
						{
								arr[i].setText(rs.getString(7));i++;
								arr[i].setText(rs.getString(2));i++;
								arr[i].setText(rs.getString(4));i++;
								arr[i].setText(rs.getString(5));i++;
								arr[i].setText(rs.getString(6));i++;
								arr[i].setText(rs.getString(8));i++;
								arr[i].setText(rs.getString(9));i++;
								arr[i].setText(rs.getString(10));i++;
						}
						
						
						
					con.close();  
					}
				catch(Exception e1){ System.out.println(e1);}
			}
			
		});
		btnSearch.setBounds(338, 532, 97, 25);
		frame.getContentPane().add(btnSearch);
		
		
		
		
	}

}

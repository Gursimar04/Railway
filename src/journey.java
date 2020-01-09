import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class journey {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					journey window = new journey();
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
	public journey() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1120, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTrainno = new JLabel("TrainNO");
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
		
		JLabel lblSeatno = new JLabel("SeatNo");
		lblSeatno.setBounds(596, 70, 56, 16);
		frame.getContentPane().add(lblSeatno);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(953, 70, 69, 16);
		frame.getContentPane().add(lblDate);
		
		JLabel lblNam = new JLabel("Name");
		lblNam.setBounds(664, 70, 56, 16);
		frame.getContentPane().add(lblNam);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(755, 70, 56, 16);
		frame.getContentPane().add(lblAge);
		
		JLabel lblPnr = new JLabel("PNR");
		lblPnr.setBounds(821, 70, 56, 16);
		frame.getContentPane().add(lblPnr);
		
		JLabel lblTrainName = new JLabel("Train Name");
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
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(596, 118, 56, 16);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(664, 118, 56, 16);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(755, 118, 56, 16);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(821, 118, 150, 16);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(965, 118, 91, 16);
		frame.getContentPane().add(label_9);
		
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
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(596, 156, 56, 16);
		frame.getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("");
		label_16.setBounds(664, 156, 56, 16);
		frame.getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel("");
		label_17.setBounds(755, 156, 56, 16);
		frame.getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("");
		label_18.setBounds(821, 156, 150, 16);
		frame.getContentPane().add(label_18);
		
		JLabel label_19 = new JLabel("");
		label_19.setBounds(946, 156, 96, 16);
		frame.getContentPane().add(label_19);
		
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
		
		JLabel label_25 = new JLabel("");
		label_25.setBounds(596, 189, 56, 16);
		frame.getContentPane().add(label_25);
		
		JLabel label_26 = new JLabel("");
		label_26.setBounds(664, 189, 56, 16);
		frame.getContentPane().add(label_26);
		
		JLabel label_27 = new JLabel("");
		label_27.setBounds(755, 189, 56, 16);
		frame.getContentPane().add(label_27);
		
		JLabel label_28 = new JLabel("");
		label_28.setBounds(821, 189, 93, 16);
		frame.getContentPane().add(label_28);
		
		JLabel label_29 = new JLabel("");
		label_29.setBounds(926, 189, 96, 16);
		frame.getContentPane().add(label_29);
		
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
		
		JLabel label_35 = new JLabel("");
		label_35.setBounds(596, 254, 56, 16);
		frame.getContentPane().add(label_35);
		
		JLabel label_36 = new JLabel("");
		label_36.setBounds(664, 254, 56, 16);
		frame.getContentPane().add(label_36);
		
		JLabel label_37 = new JLabel("");
		label_37.setBounds(755, 254, 56, 16);
		frame.getContentPane().add(label_37);
		
		JLabel label_38 = new JLabel("");
		label_38.setBounds(821, 254, 56, 16);
		frame.getContentPane().add(label_38);
		
		JLabel label_39 = new JLabel("");
		label_39.setBounds(926, 254, 69, 16);
		frame.getContentPane().add(label_39);
		
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
		arr[10]=label_10;
		arr[11]=label_11;
		arr[12]=label_12;
		arr[13]=label_13;
		arr[14]=label_14;
		arr[15]=label_15;
		arr[16]=label_16;
		arr[17]=label_17;
		arr[18]=label_18;
		arr[19]=label_19;
		arr[20]=label_20;
		arr[21]=label_21;
		arr[22]=label_22;
		arr[23]=label_23;
		arr[24]=label_24;
		arr[25]=label_25;
		arr[26]=label_26;
		arr[27]=label_27;
		arr[28]=label_28;
		arr[29]=label_29;
		arr[30]=label_30;
		arr[31]=label_31;
		arr[32]=label_32;
		arr[33]=label_33;
		arr[34]=label_34;
		arr[35]=label_35;
		arr[36]=label_36;
		arr[37]=label_37;
		arr[38]=label_38;
		arr[39]=label_39;
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new MenuOption().frame.setVisible(true);
			}
		});
		btnBack.setBounds(446, 446, 97, 25);
		frame.getContentPane().add(btnBack);
		
		
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar");  
			//here railways is database name, root is username and password is simar
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from chartinfo where username='"+new Login().getUser()+"'");  
				int i=0;
				while(rs.next())
				{
					
					Statement stmt1=con.createStatement();  
						ResultSet rs1=stmt1.executeQuery("select * from train where Tnumber='"+rs.getString(3)+"'");  
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
}

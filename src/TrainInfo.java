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

public class TrainInfo {

	public JFrame frame;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainInfo window = new TrainInfo();
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
	public TrainInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 706, 633);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTrainNumber = new JLabel("Train Number");
		lblTrainNumber.setBounds(82, 43, 90, 16);
		frame.getContentPane().add(lblTrainNumber);
		
		id = new JTextField();
		id.setBounds(196, 40, 116, 22);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				new MenuOption().frame.setVisible(true);
			}
		});
		btnBack.setBounds(270, 83, 97, 25);
		frame.getContentPane().add(btnBack);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(141, 138, 40, 16);
		frame.getContentPane().add(lblName);
		
		JLabel Coaches = new JLabel("Coaches");
		Coaches.setBounds(119, 164, 59, 16);
		frame.getContentPane().add(Coaches);
		
		JLabel lblWorkingDays = new JLabel("Working Days");
		lblWorkingDays.setBounds(104, 193, 102, 16);
		frame.getContentPane().add(lblWorkingDays);
		
		JLabel cname = new JLabel("");
		cname.setBounds(223, 138, 116, 16);
		frame.getContentPane().add(cname);
		
		JLabel coach = new JLabel("");
		coach.setBounds(223, 164, 116, 16);
		frame.getContentPane().add(coach);
		
		JLabel days = new JLabel("");
		days.setBounds(218, 193, 273, 16);
		frame.getContentPane().add(days);
		
		JLabel lblStation = new JLabel("Station");
		lblStation.setBounds(130, 240, 51, 16);
		frame.getContentPane().add(lblStation);
		
		JLabel sname1 = new JLabel("");
		sname1.setBounds(223, 240, 89, 16);
		frame.getContentPane().add(sname1);
		
		JLabel etime1 = new JLabel("");
		etime1.setBounds(327, 240, 116, 16);
		frame.getContentPane().add(etime1);
		
		JLabel etime2 = new JLabel("");
		etime2.setBounds(458, 240, 116, 16);
		frame.getContentPane().add(etime2);
		
		JLabel label = new JLabel("");
		label.setBounds(223, 276, 89, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(327, 276, 116, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(458, 276, 116, 16);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(223, 307, 89, 16);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(327, 307, 116, 16);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(458, 307, 116, 16);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(223, 336, 89, 16);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(327, 336, 116, 16);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(458, 336, 116, 16);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(223, 365, 89, 16);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(327, 365, 116, 16);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(458, 365, 116, 16);
		frame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(223, 395, 89, 16);
		frame.getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setBounds(327, 395, 116, 16);
		frame.getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("");
		label_14.setBounds(458, 395, 116, 16);
		frame.getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(223, 426, 89, 16);
		frame.getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("");
		label_16.setBounds(327, 426, 116, 16);
		frame.getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel("");
		label_17.setBounds(458, 426, 116, 16);
		frame.getContentPane().add(label_17);
		JLabel label_18 = new JLabel("");
		label_18.setBounds(223, 458, 89, 16);
		frame.getContentPane().add(label_18);
		
		JLabel label_19 = new JLabel("");
		label_19.setBounds(327, 458, 116, 16);
		frame.getContentPane().add(label_19);
		
		JLabel label_20 = new JLabel("");
		label_20.setBounds(458, 458, 116, 16);
		frame.getContentPane().add(label_20);
		
		JLabel label_21 = new JLabel("");
		label_21.setBounds(223, 487, 89, 16);
		frame.getContentPane().add(label_21);
		
		JLabel label_22 = new JLabel("");
		label_22.setBounds(327, 487, 116, 16);
		frame.getContentPane().add(label_22);
		
		JLabel label_23 = new JLabel("");
		label_23.setBounds(458, 487, 116, 16);
		frame.getContentPane().add(label_23);
		
		JLabel label_24 = new JLabel("");
		label_24.setBounds(223, 516, 89, 16);
		frame.getContentPane().add(label_24);
		
		JLabel label_25 = new JLabel("");
		label_25.setBounds(327, 516, 116, 16);
		frame.getContentPane().add(label_25);
		
		JLabel label_26 = new JLabel("");
		label_26.setBounds(458, 516, 116, 16);
		frame.getContentPane().add(label_26);
		
		JLabel label_27 = new JLabel("");
		label_27.setBounds(223, 557, 89, 16);
		frame.getContentPane().add(label_27);
		
		JLabel label_28 = new JLabel("");
		label_28.setBounds(327, 557, 116, 16);
		frame.getContentPane().add(label_28);
		
		JLabel label_29 = new JLabel("");
		label_29.setBounds(458, 557, 116, 16);
		frame.getContentPane().add(label_29);
		
		JLabel[] arr=new JLabel[40];
		arr[0]=sname1;
		arr[1]=etime1;
		arr[2]=etime2;
		arr[3]=label;
		arr[4]=label_1;
		arr[5]=label_2;
		arr[6]=label_3;
		arr[7]=label_4;
		arr[8]=label_5;
		arr[9]=label_6;
		arr[10]=label_7;
		arr[11]=label_8;
		arr[12]=label_9;
		arr[13]=label_10;
		arr[14]=label_11;
		arr[15]=label_12;
		arr[16]=label_13;
		arr[17]=label_14;
		arr[18]=label_15;
		arr[19]=label_16;
		arr[20]=label_17;
		arr[21]=label_18;
		arr[22]=label_19;
		arr[23]=label_20;
		arr[24]=label_21;
		arr[25]=label_22;
		arr[26]=label_23;
		arr[27]=label_24;
		arr[28]=label_25;
		arr[29]=label_26;
		arr[30]=label_27;
		arr[31]=label_28;
		arr[32]=label_29;
		
	
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ids=id.getText();
				try{  
					Class.forName("com.mysql.cj.jdbc.Driver");  
					Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar");  
					//here railways is database name, root is username and password is simar
					
					Statement stmt=con.createStatement();  
					ResultSet rs=stmt.executeQuery("select * from train where tnumber='"+ids+"'");  
						rs.first();
						cname.setText(rs.getString("name"));
						coach.setText(rs.getString("coaches"));
						
						String day="";
						
						if(rs.getString("Monday").equals("y"))
							day+="Monday ";
						if(rs.getString("Tuesday").equals("y"))
							day+="Tuesday ";
						if(rs.getString("Wednesday").equals("y"))
							day+="Wednesday ";
						if(rs.getString("Thersday").equals("y"))
							day+="Thersday ";
						if(rs.getString("Friday").equals("y"))
							day+="Friday ";
						if(rs.getString("Saturday").equals("y"))
							day+="Saturday ";
						if(rs.getString("Sunday").equals("y"))	
							day+="Sunday ";
						
						days.setText(day);
						
						Statement stmt1=con.createStatement();  
						ResultSet rs1=stmt1.executeQuery("select * from path where Tnumber='"+ids+"'");  
						rs1.first();
						int k=0;
						for(int i=2;!rs1.getString(i).equals("n/a");i=i+3)
						{
							arr[k].setText(rs1.getString(i));k++;
							arr[k].setText(rs1.getString(i+1));k++;
							arr[k].setText(rs1.getString(i+2));k++;
						}
						
						
						
						
					con.close();  
					}
				catch(Exception e1){ System.out.println(e1);}
			}
			
		});
		btnSearch.setBounds(141, 83, 97, 25);
		frame.getContentPane().add(btnSearch);
		
		
		
	}

}

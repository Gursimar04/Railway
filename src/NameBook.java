import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class NameBook {

	public JFrame frame;
	private JTextField name1;
	private JTextField name2;
	private JTextField name3;
	private JTextField name4;
	private JTextField age1;
	private JTextField age2;
	private JTextField age3;
	private JTextField age4;
	private int length;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NameBook window = new NameBook();
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
	public NameBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 250, 250));
		frame.setBounds(100, 100, 665, 698);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		lblName.setBounds(115, 176, 165, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		lblNumber.setBounds(115, 147, 165, 16);
		frame.getContentPane().add(lblNumber);
		
		JLabel lblBoardingDate = new JLabel("Boarding Date & Time");
		lblBoardingDate.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		lblBoardingDate.setBounds(115, 234, 165, 32);
		frame.getContentPane().add(lblBoardingDate);
		
		JLabel lblBoarding = new JLabel("Boarding Station");
		lblBoarding.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		lblBoarding.setBounds(115, 205, 165, 22);
		frame.getContentPane().add(lblBoarding);
		
		JLabel lblDestinationStation = new JLabel("Destination Station");
		lblDestinationStation.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		lblDestinationStation.setBounds(115, 269, 165, 16);
		frame.getContentPane().add(lblDestinationStation);
		
		JLabel lblDestinationDate = new JLabel("Destination Date & Time");
		lblDestinationDate.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		lblDestinationDate.setBounds(115, 298, 165, 16);
		frame.getContentPane().add(lblDestinationDate);
		
		JLabel tnumber = new JLabel("");
		tnumber.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		tnumber.setBounds(311, 147, 191, 16);
		frame.getContentPane().add(tnumber);
		
		JLabel bdate = new JLabel("");
		bdate.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		bdate.setBounds(311, 240, 191, 16);
		frame.getContentPane().add(bdate);
		
		JLabel bstation = new JLabel("");
		bstation.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		bstation.setBounds(311, 205, 191, 22);
		frame.getContentPane().add(bstation);
		
		JLabel dstation = new JLabel("");
		dstation.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		dstation.setBounds(311, 269, 191, 16);
		frame.getContentPane().add(dstation);
		
		JLabel ddate = new JLabel("");
		ddate.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		ddate.setBounds(311, 298, 191, 16);
		frame.getContentPane().add(ddate);
		
		JLabel tname = new JLabel("");
		tname.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		tname.setBounds(311, 176, 191, 16);
		frame.getContentPane().add(tname);
		
		JLabel lcoach = new JLabel("Coach");
		lcoach.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		lcoach.setBounds(115, 327, 165, 16);
		frame.getContentPane().add(lcoach);
	
		JLabel Tcoach = new JLabel("");
		Tcoach.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		Tcoach.setBounds(310, 327, 192, 16);
		frame.getContentPane().add(Tcoach);
		
		Search s=new Search();
		tnumber.setText(s.Trainnum());
		bdate.setText(s.getbDate()+" "+s.getbtime());
		bstation.setText(s.getboards());
		bdate.setText(s.getbDate()+" "+s.getbtime());
		dstation.setText(s.getdest());
		ddate.setText(s.getdDate()+" "+s.getdtime());
		Tcoach.setText(new Booktrain().getcoach());
		
		
		try
		{
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar"); 
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from train where tnumber="+"'"+tnumber.getText()+"'");  
			rs.first();
			tname.setText(rs.getString("name"));
			
			JLabel lblSeatNumber = new JLabel("Seat Number");
			lblSeatNumber.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			lblSeatNumber.setBounds(114, 406, 92, 16);
			frame.getContentPane().add(lblSeatNumber);
			
			JLabel lblName_1 = new JLabel("Name");
			lblName_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			lblName_1.setBounds(235, 406, 118, 16);
			frame.getContentPane().add(lblName_1);
			
			JLabel lblAge = new JLabel("Age");
			lblAge.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			lblAge.setBounds(390, 406, 56, 16);
			frame.getContentPane().add(lblAge);
			
			JLabel num1 = new JLabel("Seat Number");
			num1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			num1.setBounds(114, 435, 92, 16);
			frame.getContentPane().add(num1);
			
			JLabel num2 = new JLabel("Seat Number");
			num2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			num2.setBounds(114, 463, 92, 16);
			frame.getContentPane().add(num2);
			
			JLabel num3 = new JLabel("Seat Number");
			num3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			num3.setBounds(114, 489, 92, 16);
			frame.getContentPane().add(num3);
			
			JLabel num4 = new JLabel("Seat Number");
			num4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			num4.setBounds(114, 519, 92, 16);
			frame.getContentPane().add(num4);
			
			name1 = new JTextField();
			name1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			name1.setBounds(225, 432, 151, 22);
			frame.getContentPane().add(name1);
			name1.setColumns(10);
			
			name2 = new JTextField();
			name2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			name2.setColumns(10);
			name2.setBounds(225, 460, 151, 22);
			frame.getContentPane().add(name2);
			
			name3 = new JTextField();
			name3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			name3.setColumns(10);
			name3.setBounds(225, 486, 151, 22);
			frame.getContentPane().add(name3);
			
			name4 = new JTextField();
			name4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			name4.setColumns(10);
			name4.setBounds(225, 516, 151, 22);
			frame.getContentPane().add(name4);
			
			age1 = new JTextField();
			age1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			age1.setColumns(10);
			age1.setBounds(390, 432, 32, 22);
			frame.getContentPane().add(age1);
			
			age2 = new JTextField();
			age2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			age2.setColumns(10);
			age2.setBounds(390, 460, 32, 22);
			frame.getContentPane().add(age2);
			
			age3 = new JTextField();
			age3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			age3.setColumns(10);
			age3.setBounds(390, 486, 32, 22);
			frame.getContentPane().add(age3);
			
			age4 = new JTextField();
			age4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			age4.setColumns(10);
			age4.setBounds(390, 516, 32, 22);
			frame.getContentPane().add(age4);
			rs.close();
			con.close();
			
			
			JLabel[] arrS=new JLabel[5];
			arrS[0]=num1;
			arrS[1]=num2;
			arrS[2]=num3;
			arrS[3]=num4;
			
			JTextField[] arrN=new JTextField[5];
			arrN[0]=name1;
			arrN[1]=name2;
			arrN[2]=name3;
			arrN[3]=name4;
			
			JTextField[] arrA=new JTextField[5];
			arrA[0]=age1;
			arrA[1]=age2;
			arrA[2]=age3;
			arrA[3]=age4;
			
			for(int i=0;i<4;i++)
			{
				arrS[i].setVisible(false);
				arrN[i].setVisible(false);
				arrA[i].setVisible(false);
			}
			System.out.println(new selectSeat().getCounter());
			char coa=Tcoach.getText().charAt(0);
			System.out.println(new selectSeat().getCounter());
			if(Character.compare(coa, 'H')==0)
			{
				for(int i=0;i<new selectSeath().getCounter();i++)
				{
					length=new selectSeath().getCounter();
					arrS[i].setText(Integer.toString(new selectSeath().getSeat()[i]));
					arrS[i].setVisible(true);
					arrN[i].setVisible(true);
					arrA[i].setVisible(true);
				}
			}
			else if(Character.compare(coa, 'A')==0)
			{
				for(int i=0;i<new selectSeatA().getCounter();i++)
				{
					length=new selectSeatA().getCounter();
					arrS[i].setText(Integer.toString(new selectSeatA().getSeat()[i]));
					arrS[i].setVisible(true);
					arrN[i].setVisible(true);
					arrA[i].setVisible(true);
				}
			}
			
			else if(Character.compare(coa, 'C')==0)
			{
				for(int i=0;i<new selectSeatCC().getCounter();i++)
				{
					length=new selectSeatCC().getCounter();
					arrS[i].setText(Integer.toString(new selectSeatCC().getSeat()[i]));
					arrS[i].setVisible(true);
					arrN[i].setVisible(true);
					arrA[i].setVisible(true);
				}
			}
			else if(Character.compare(coa, 'E')==0)
			{
				for(int i=0;i<new SelectSeatEC().getCounter();i++)
				{
					length=new SelectSeatEC().getCounter();
					arrS[i].setText(Integer.toString(new SelectSeatEC().getSeat()[i]));
					arrS[i].setVisible(true);
					arrN[i].setVisible(true);
					arrA[i].setVisible(true);
				}
			}
			else
			{
				for(int i=0;i<new selectSeat().getCounter();i++)
				{
					length=new selectSeat().getCounter();
					arrS[i].setText(Integer.toString(new selectSeat().getSeat()[i]));
					arrS[i].setVisible(true);
					arrN[i].setVisible(true);
					arrA[i].setVisible(true);
				}
			}
			
			
			JButton btnPay = new JButton("PAY");
			btnPay.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			btnPay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					try
					{
						Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar"); 
						Statement stmt=con.createStatement();
						for(int i=0;i<length;i++)
						{
							int se=Integer.parseInt(arrS[i].getText());
							String na=arrN[i].getText();
							int ag=Integer.parseInt(arrA[i].getText());
							String pn=new Booktrain().gettrainname()+arrS[i].getText();
							String date2=new Search().getbDate();
							JOptionPane.showMessageDialog(null,"PNR number for "+arrN[i].getText()+" is "+pn);
							String query="insert into chartinfo Values('"+new Booktrain().gettrainname()+"','"+
									new Login().getUser()+"','"+tnumber.getText()+"','"+new Search().getboards()+"','"+
									new Search().getdest()+"','"+new Booktrain().getcoach()+"',"+se+",'"+na+"',"+ag+",'"+pn+"','"+date2+"')";
							stmt.executeUpdate(query);
						}
						JOptionPane.showMessageDialog(null,"Your tickets have been booked");
						
						con.close();
						
						frame.setVisible(false);
						new MenuOption().frame.setVisible(true);
					}
					catch(Exception e1)
					{
						System.out.println(e1);
					}
				}
			});
			btnPay.setBounds(256, 551, 97, 25);
			frame.getContentPane().add(btnPay);
			
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(new Color(255, 255, 240));
			panel.setBounds(0, 13, 654, 45);
			frame.getContentPane().add(panel);
			
			JLabel lblPassengerInformation = new JLabel("Passenger Information");
			lblPassengerInformation.setHorizontalAlignment(SwingConstants.CENTER);
			lblPassengerInformation.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 36));
			lblPassengerInformation.setBounds(0, 0, 654, 45);
			panel.add(lblPassengerInformation);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 245, 238));
			panel_1.setBounds(88, 102, 408, 264);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblTrainInformation = new JLabel("Train Information");
			lblTrainInformation.setForeground(new Color(0, 0, 0));
			lblTrainInformation.setBackground(new Color(255, 255, 255));
			lblTrainInformation.setFont(new Font("Tw Cen MT Condensed", Font.ITALIC, 41));
			lblTrainInformation.setHorizontalAlignment(SwingConstants.CENTER);
			lblTrainInformation.setBounds(0, 0, 408, 37);
			panel_1.add(lblTrainInformation);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

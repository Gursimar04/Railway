

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class selectSeatA implements ActionListener {

	public JFrame frame;
	private String traintable;
	private static int seatcounter=0;
	private static int[] seatarr=new int[5];
	
	java.net.URL imageURL = this.getClass().getClassLoader().getResource("images/b3.png");
	java.net.URL imageURL2 = this.getClass().getClassLoader().getResource("images/b5.png");
	ImageIcon I=new ImageIcon(imageURL);
	ImageIcon II=new ImageIcon(imageURL2);
	java.net.URL select = this.getClass().getClassLoader().getResource("images/b1.png");
	ImageIcon red=new ImageIcon(select);
	java.net.URL select1 = this.getClass().getClassLoader().getResource("images/b7.png");
	ImageIcon red1=new ImageIcon(select1);

	java.net.URL booked = this.getClass().getClassLoader().getResource("images/b10.png");
	ImageIcon grey=new ImageIcon(booked);
	java.net.URL booked1 = this.getClass().getClassLoader().getResource("images/b2.png");
	ImageIcon grey1=new ImageIcon(booked1);
	
	
	
	java.net.URL up = this.getClass().getClassLoader().getResource("images/uparow.png");
	ImageIcon u=new ImageIcon(up);
	java.net.URL down = this.getClass().getClassLoader().getResource("images/darow.png");
	ImageIcon d=new ImageIcon(down);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectSeatA window = new selectSeatA();
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
	public selectSeatA()  {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 821, 1083);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Tcoach = new JLabel("");
		Tcoach.setBounds(479, 50, 198, 29);
		frame.getContentPane().add(Tcoach);
		
		JLabel Tname = new JLabel((String) null);
		Tname.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		Tname.setBounds(580, 300, 162, 16);
		frame.getContentPane().add(Tname);
		
		JLabel bdate = new JLabel("null null");
		bdate.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		bdate.setBounds(580, 354, 162, 16);
		frame.getContentPane().add(bdate);
		
		JLabel bstation = new JLabel((String) null);
		bstation.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		bstation.setBounds(580, 325, 162, 16);
		frame.getContentPane().add(bstation);
		
		JLabel tnumber = new JLabel((String) null);
		tnumber.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		tnumber.setBounds(580, 267, 162, 16);
		frame.getContentPane().add(tnumber);
		
		JLabel dstation = new JLabel("Destination Station");
		dstation.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		dstation.setBounds(580, 392, 162, 16);
		frame.getContentPane().add(dstation);
		
		JButton arr[]=new JButton[64];
		
		Search s=new Search();
		Booktrain b=new Booktrain();
		tnumber.setText(s.Trainnum());
		bdate.setText(s.getbDate()+" "+s.getbtime());
		Tcoach.setText(b.getcoach());
		traintable=b.gettrainname();
		try
		{
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar"); 
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from train where tnumber="+"'"+tnumber.getText()+"'");  
			rs.first();
			Tname.setText(rs.getString("name"));
			rs.close();
			ResultSet rs1=stmt.executeQuery("select *from station where id="+"'"+s.getboards()+"'");
			rs1.first();
			bstation.setText(rs1.getString("name"));
			rs1.close();
			ResultSet rs2=stmt.executeQuery("select *from station where id="+"'"+s.getdest()+"'");
			rs2.first();
			dstation.setText(rs2.getString("name"));
			JButton btnBook = new JButton("Book");
			btnBook.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			btnBook.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					for(int i=0;i<48;i++) 
					{
						if(arr[i].getIcon().equals(red)||arr[i].getIcon().equals(red1))
						{
							try
							{
								seatarr[seatcounter]=i+1;seatcounter++;
								
								Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar"); 
								Statement stmt=con.createStatement();
								ResultSet rs=stmt.executeQuery("select *from "+traintable+" where seat="+(i+1));  
								Statement stmt1=con.createStatement();
								ResultSet rs1=stmt1.executeQuery("select *from path where Tnumber='"+s.Trainnum()+"'");  
								rs1.first();
								rs.first();
								int ti=2;
								while(!rs1.getString(ti).equals(s.getboards()))
								{
									ti+=3;
								}
								System.out.println(rs1.getString(ti));
								Statement stmt3=con.createStatement();
								while(!rs1.getString(ti).equals(s.getdest()))
									{
										String use=new Login().getUser();
										stmt3.executeUpdate("Update "+traintable+" set "+rs1.getString(ti)+"='"+use+"' where seat="+(i+1));
										ti=ti+3;
									}
								con.close();
								frame.setVisible(false);
			    				new NameBook().frame.setVisible(true);
							}
							catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}  
						}
					}
				}
			});
			btnBook.setBounds(431, 452, 97, 25);
			frame.getContentPane().add(btnBook);
			
			JButton btnBack = new JButton("Back");
			btnBack.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					new Booktrain().frame.setVisible(true);
				}
			});
			btnBack.setBounds(591, 452, 97, 25);
			frame.getContentPane().add(btnBack);
			
			JLabel label_67 = new JLabel("Number");
			label_67.setBounds(419, 267, 149, 16);
			frame.getContentPane().add(label_67);
			label_67.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			
			JLabel label_66 = new JLabel("Name");
			label_66.setBounds(419, 296, 149, 16);
			frame.getContentPane().add(label_66);
			label_66.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
			
			JLabel label_65 = new JLabel("Boarding Station");
			label_65.setBounds(419, 325, 149, 16);
			frame.getContentPane().add(label_65);
			label_65.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
			
			JLabel label_64 = new JLabel("Boarding Date & Time");
			label_64.setBounds(419, 354, 149, 16);
			frame.getContentPane().add(label_64);
			label_64.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
			
			JLabel lblDestinationStation = new JLabel("Destination Station");
			lblDestinationStation.setBounds(419, 392, 149, 16);
			frame.getContentPane().add(lblDestinationStation);
			lblDestinationStation.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 250, 250));
			panel.setForeground(new Color(255, 255, 240));
			panel.setBounds(60, 111, 300, 912);
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblRacLayout = new JLabel("RAC-2 Layout");
			lblRacLayout.setBounds(-2, 26, 302, 35);
			lblRacLayout.setHorizontalAlignment(SwingConstants.CENTER);
			lblRacLayout.setForeground(Color.LIGHT_GRAY);
			lblRacLayout.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 31));
			panel.add(lblRacLayout);
			
			JLabel label_48 = new JLabel("A");
			label_48.setBounds(137, 234, 67, 81);
			label_48.setHorizontalAlignment(SwingConstants.CENTER);
			label_48.setForeground(new Color(211, 211, 211));
			label_48.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 74));
			panel.add(label_48);
			
			JLabel label_49 = new JLabel("I");
			label_49.setBounds(137, 324, 67, 81);
			label_49.setHorizontalAlignment(SwingConstants.CENTER);
			label_49.setForeground(new Color(211, 211, 211));
			label_49.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 74));
			panel.add(label_49);
			
			JLabel label_50 = new JLabel("S");
			label_50.setBounds(137, 414, 67, 81);
			label_50.setHorizontalAlignment(SwingConstants.CENTER);
			label_50.setForeground(new Color(211, 211, 211));
			label_50.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 74));
			panel.add(label_50);
			
			JLabel label_51 = new JLabel("");
			label_51.setBounds(127, 73, 88, 159);
			label_51.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(label_51);
			label_51.setIcon(u);
			
			JLabel label_52 = new JLabel("L");
			label_52.setBounds(137, 504, 67, 81);
			label_52.setHorizontalAlignment(SwingConstants.CENTER);
			label_52.setForeground(new Color(211, 211, 211));
			label_52.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 74));
			panel.add(label_52);
			
			JLabel label_53 = new JLabel("E");
			label_53.setBounds(137, 594, 67, 81);
			label_53.setHorizontalAlignment(SwingConstants.CENTER);
			label_53.setForeground(new Color(211, 211, 211));
			label_53.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 74));
			panel.add(label_53);
			
			JLabel label_54 = new JLabel("");
			label_54.setBounds(138, 701, 66, 128);
			label_54.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(label_54);
			label_54.setIcon(d);
			
	
			
			JButton s1 = new JButton("");
			s1.setBounds(-15, 62, 65, 45);
			panel.add(s1);
			s1.setContentAreaFilled(false);
			s1.setBorderPainted(false);
			s1.setFocusPainted(false); 
			s1.setIcon(I);
			s1.addActionListener((ActionListener) this);
			s1.setFocusPainted(false); 
			arr[0]=s1;
			
			JButton s2 = new JButton("");
			s2.setBounds(51, 62, 65, 45);
			panel.add(s2);
			s2.setContentAreaFilled(false);
			s2.setBorderPainted(false);
			s2.setFocusPainted(false); 
			s2.setIcon(I);
			s2.addActionListener((ActionListener) this);
			arr[1]=s2;
			
			JButton s3 = new JButton("");
			s3.setBounds(-13, 120, 65, 45);
			panel.add(s3);
			s3.setContentAreaFilled(false);
			s3.setBorderPainted(false);
			s3.setFocusPainted(false); 
			s3.setIcon(II);
			s3.addActionListener((ActionListener) this);
			arr[2]=s3;
			
			JButton s4 = new JButton("");
			s4.setBounds(53, 120, 65, 45);
			panel.add(s4);
			s4.setContentAreaFilled(false);
			s4.setBorderPainted(false);
			s4.setFocusPainted(false); 
			s4.setIcon(II);
			s4.addActionListener((ActionListener) this);
			arr[3]=s4;
			
			JButton s5 = new JButton("");
			s5.setBounds(219, 62, 65, 45);
			panel.add(s5);
			s5.setContentAreaFilled(false);
			s5.setBorderPainted(false);
			s5.setFocusPainted(false); 
			s5.setIcon(I);
			s5.addActionListener((ActionListener) this);
			arr[4]=s5;
			
			JButton s6 = new JButton("");
			s6.setBounds(221, 120, 65, 45);
			panel.add(s6);
			s6.setContentAreaFilled(false);
			s6.setBorderPainted(false);
			s6.setIcon(II);
			s6.addActionListener((ActionListener) this);
			arr[5]=s6;
			
			JButton s7 = new JButton("");
			s7.setBounds(-15, 166, 65, 45);
			panel.add(s7);
			s7.setContentAreaFilled(false);
			s7.setBorderPainted(false);
			s7.setFocusPainted(false); 
			s7.setIcon(I);
			s7.addActionListener((ActionListener) this);
			arr[6]=s7;
			
			JButton s8 = new JButton("");
			s8.setBounds(51, 166, 65, 45);
			panel.add(s8);
			s8.setContentAreaFilled(false);
			s8.setBorderPainted(false);
			s8.setFocusPainted(false); 
			s8.setIcon(I);
			s8.addActionListener((ActionListener) this);
			arr[7]=s8;
			
			JButton s9 = new JButton("");
			s9.setBounds(-13, 224, 65, 45);
			panel.add(s9);
			s9.setContentAreaFilled(false);
			s9.setBorderPainted(false);
			s9.setFocusPainted(false); 
			s9.setIcon(II);
			s9.addActionListener((ActionListener) this);
			arr[8]=s9;
			
			JButton s10 = new JButton("");
			s10.setBounds(53, 224, 65, 45);
			panel.add(s10);
			s10.setContentAreaFilled(false);
			s10.setBorderPainted(false);
			s10.setFocusPainted(false); 
			s10.setIcon(II);
			s10.addActionListener((ActionListener) this);
			arr[9]=s10;
			
			JButton s11 = new JButton("");
			s11.setBounds(219, 166, 65, 45);
			panel.add(s11);
			s11.setContentAreaFilled(false);
			s11.setBorderPainted(false);
			s11.setFocusPainted(false); 
			s11.setIcon(I);
			s11.addActionListener((ActionListener) this);
			arr[10]=s11;
			
			JButton s12 = new JButton("");
			s12.setBounds(221, 224, 65, 45);
			panel.add(s12);
			s12.setContentAreaFilled(false);
			s12.setBorderPainted(false);
			s12.setFocusPainted(false); 
			s12.setIcon(II);
			s12.addActionListener((ActionListener) this);
			arr[11]=s12;
			
			JButton s13 = new JButton("");
			s13.setBounds(-15, 270, 65, 45);
			panel.add(s13);
			s13.setContentAreaFilled(false);
			s13.setBorderPainted(false);
			s13.setFocusPainted(false); 
			s13.setIcon(I);
			s13.addActionListener((ActionListener) this);
			arr[12]=s13;
			
			JButton s14 = new JButton("");
			s14.setBounds(51, 270, 65, 45);
			panel.add(s14);
			s14.setContentAreaFilled(false);
			s14.setBorderPainted(false);
			s14.setFocusPainted(false); 
			s14.setIcon(I);
			s14.addActionListener((ActionListener) this);
			arr[13]=s14;
			
			JButton s15 = new JButton("");
			s15.setBounds(-13, 328, 65, 45);
			panel.add(s15);
			s15.setContentAreaFilled(false);
			s15.setBorderPainted(false);
			s15.setFocusPainted(false); 
			s15.setIcon(II);
			s15.addActionListener((ActionListener) this);
			arr[14]=s15;
			
			JButton s16 = new JButton("");
			s16.setBounds(53, 328, 65, 45);
			panel.add(s16);
			s16.setContentAreaFilled(false);
			s16.setBorderPainted(false);
			s16.setFocusPainted(false); 
			s16.setIcon(II);
			s16.addActionListener((ActionListener) this);
			arr[15]=s16;
			
			JButton s17 = new JButton("");
			s17.setBounds(219, 270, 65, 45);
			panel.add(s17);
			s17.setContentAreaFilled(false);
			s17.setBorderPainted(false);
			s17.setFocusPainted(false); 
			s17.setIcon(I);
			s17.addActionListener((ActionListener) this);
			arr[16]=s17;
			
			JButton s18 = new JButton("");
			s18.setBounds(221, 328, 65, 45);
			panel.add(s18);
			s18.setContentAreaFilled(false);
			s18.setBorderPainted(false);
			s18.setFocusPainted(false); 
			s18.setIcon(II);
			s18.addActionListener((ActionListener) this);
			arr[17]=s18;
			
			JButton s19 = new JButton("");
			s19.setBounds(-15, 375, 65, 45);
			panel.add(s19);
			s19.setContentAreaFilled(false);
			s19.setBorderPainted(false);
			s19.setFocusPainted(false); 
			s19.setIcon(I);
			s19.addActionListener((ActionListener) this);
			arr[18]=s19;
			
			JButton s20 = new JButton("");
			s20.setBounds(51, 375, 65, 45);
			panel.add(s20);
			s20.setContentAreaFilled(false);
			s20.setBorderPainted(false);
			s20.setFocusPainted(false); 
			s20.setIcon(I);
			s20.addActionListener((ActionListener) this);
			arr[19]=s20;
			
			JButton s21 = new JButton("");
			s21.setBounds(-13, 433, 65, 45);
			panel.add(s21);
			s21.setContentAreaFilled(false);
			s21.setBorderPainted(false);
			s21.setFocusPainted(false); 
			s21.setIcon(II);
			s21.addActionListener((ActionListener) this);
			arr[20]=s21;
			
			JButton s22 = new JButton("");
			s22.setBounds(53, 433, 65, 45);
			panel.add(s22);
			s22.setContentAreaFilled(false);
			s22.setBorderPainted(false);
			s22.setFocusPainted(false); 
			s22.setIcon(II);
			s22.addActionListener((ActionListener) this);
			arr[21]=s22;
			
			JButton s23 = new JButton("");
			s23.setBounds(219, 375, 65, 45);
			panel.add(s23);
			s23.setContentAreaFilled(false);
			s23.setBorderPainted(false);
			s23.setFocusPainted(false); 
			s23.setIcon(I);
			s23.addActionListener((ActionListener) this);
			arr[22]=s23;
			
			JButton s24 = new JButton("");
			s24.setBounds(221, 433, 65, 45);
			panel.add(s24);
			s24.setContentAreaFilled(false);
			s24.setBorderPainted(false);
			s24.setFocusPainted(false); 
			s24.setIcon(II);
			s24.addActionListener((ActionListener) this);
			arr[23]=s24;
			
			JButton s25 = new JButton("");
			s25.setBounds(-15, 480, 65, 45);
			panel.add(s25);
			s25.setContentAreaFilled(false);
			s25.setBorderPainted(false);
			s25.setFocusPainted(false); 
			s25.setIcon(I);
			s25.addActionListener((ActionListener) this);
			arr[24]=s25;
			
			JButton s26 = new JButton("");
			s26.setBounds(51, 480, 65, 45);
			panel.add(s26);
			s26.setContentAreaFilled(false);
			s26.setBorderPainted(false);
			s26.setFocusPainted(false); 
			s26.setIcon(I);
			s26.addActionListener((ActionListener) this);
			arr[25]=s26;
			
			JButton s27 = new JButton("");
			s27.setBounds(-13, 538, 65, 45);
			panel.add(s27);
			s27.setContentAreaFilled(false);
			s27.setBorderPainted(false);
			s27.setFocusPainted(false); 
			s27.setIcon(II);
			s27.addActionListener((ActionListener) this);
			arr[26]=s27;
			
			JButton s28 = new JButton("");
			s28.setBounds(53, 538, 65, 45);
			panel.add(s28);
			s28.setContentAreaFilled(false);
			s28.setBorderPainted(false);
			s28.setFocusPainted(false); 
			s28.setIcon(II);
			s28.addActionListener((ActionListener) this);
			arr[27]=s28;
			
			JButton s29 = new JButton("");
			s29.setBounds(219, 480, 65, 45);
			panel.add(s29);
			s29.setContentAreaFilled(false);
			s29.setBorderPainted(false);
			s29.setFocusPainted(false); 
			s29.setIcon(I);
			s29.addActionListener((ActionListener) this);
			arr[28]=s29;
			
			JButton s30 = new JButton("");
			s30.setBounds(221, 538, 65, 45);
			panel.add(s30);
			s30.setContentAreaFilled(false);
			s30.setBorderPainted(false);
			s30.setFocusPainted(false); 
			s30.setIcon(II);
			s30.addActionListener((ActionListener) this);
			arr[29]=s30;
			
			JButton s31 = new JButton("");
			s31.setBounds(-15, 586, 65, 45);
			panel.add(s31);
			s31.setContentAreaFilled(false);
			s31.setBorderPainted(false);
			s31.setFocusPainted(false); 
			s31.setIcon(I);
			s31.addActionListener((ActionListener) this);
			arr[30]=s31;
			
			JButton s32 = new JButton("");
			s32.setBounds(51, 586, 65, 45);
			panel.add(s32);
			s32.setContentAreaFilled(false);
			s32.setBorderPainted(false);
			s32.setFocusPainted(false); 
			s32.setIcon(I);
			s32.addActionListener((ActionListener) this);
			arr[31]=s32;
			
			JButton s33 = new JButton("");
			s33.setBounds(-13, 644, 65, 45);
			panel.add(s33);
			s33.setContentAreaFilled(false);
			s33.setBorderPainted(false);
			s33.setFocusPainted(false); 
			s33.setIcon(II);
			s33.addActionListener((ActionListener) this);
			arr[32]=s33;
			
			JButton s34 = new JButton("");
			s34.setBounds(53, 644, 65, 45);
			panel.add(s34);
			s34.setContentAreaFilled(false);
			s34.setBorderPainted(false);
			s34.setFocusPainted(false); 
			s34.setIcon(II);
			s34.addActionListener((ActionListener) this);
			arr[33]=s34;
			
			JButton s35 = new JButton("");
			s35.setBounds(219, 586, 65, 45);
			panel.add(s35);
			s35.setContentAreaFilled(false);
			s35.setBorderPainted(false);
			s35.setFocusPainted(false); 
			s35.setIcon(I);
			s35.addActionListener((ActionListener) this);
			arr[34]=s35;
			
			JButton s36 = new JButton("");
			s36.setBounds(221, 644, 65, 45);
			panel.add(s36);
			s36.setContentAreaFilled(false);
			s36.setBorderPainted(false);
			s36.setFocusPainted(false); 
			s36.setIcon(II);
			s36.addActionListener((ActionListener) this);
			arr[35]=s36;
			
			JButton s37 = new JButton("");
			s37.setBounds(-15, 691, 65, 45);
			panel.add(s37);
			s37.setContentAreaFilled(false);
			s37.setBorderPainted(false);
			s37.setFocusPainted(false); 
			s37.setIcon(I);
			s37.addActionListener((ActionListener) this);
			arr[36]=s37;
			
			JButton s38 = new JButton("");
			s38.setBounds(51, 691, 65, 45);
			panel.add(s38);
			s38.setContentAreaFilled(false);
			s38.setBorderPainted(false);
			s38.setFocusPainted(false); 
			s38.setIcon(I);
			s38.addActionListener((ActionListener) this);
			arr[37]=s38;
			
			JButton s39 = new JButton("");
			s39.setBounds(-13, 749, 65, 45);
			panel.add(s39);
			s39.setContentAreaFilled(false);
			s39.setIcon(II);
			s39.addActionListener((ActionListener) this);
			arr[38]=s39;
			
			JButton s40 = new JButton("");
			s40.setBounds(53, 749, 65, 45);
			panel.add(s40);
			s40.setContentAreaFilled(false);
			s40.setBorderPainted(false);
			s40.setFocusPainted(false); 
			s40.setIcon(II);
			s40.addActionListener((ActionListener) this);
			arr[39]=s40;
			
			JButton s41 = new JButton("");
			s41.setBounds(219, 691, 65, 45);
			panel.add(s41);
			s41.setContentAreaFilled(false);
			s41.setBorderPainted(false);
			s41.setFocusPainted(false); 
			s41.setIcon(I);
			s41.addActionListener((ActionListener) this);
			arr[40]=s41;
			
			JButton s42 = new JButton("");
			s42.setBounds(221, 749, 65, 45);
			panel.add(s42);
			s42.setContentAreaFilled(false);
			s42.setBorderPainted(false);
			s42.setFocusPainted(false); 
			s42.setIcon(II);
			s42.addActionListener((ActionListener) this);
			arr[41]=s42;
			
			JButton s43 = new JButton("");
			s43.setBounds(-15, 795, 65, 45);
			panel.add(s43);
			s43.setContentAreaFilled(false);
			s43.setBorderPainted(false);
			s43.setFocusPainted(false); 
			s43.setIcon(I);
			s43.addActionListener((ActionListener) this);
			arr[42]=s43;
			
			JButton s44 = new JButton("");
			s44.setBounds(51, 795, 65, 45);
			panel.add(s44);
			s44.setContentAreaFilled(false);
			s44.setBorderPainted(false);
			s44.setFocusPainted(false); 
			s44.setIcon(I);
			s44.addActionListener((ActionListener) this);
			arr[43]=s44;
			
			JButton s45 = new JButton("");
			s45.setBounds(-13, 853, 65, 45);
			panel.add(s45);
			s45.setContentAreaFilled(false);
			s45.setBorderPainted(false);
			s45.setFocusPainted(false); 
			s45.setIcon(II);
			s45.addActionListener((ActionListener) this);
			arr[44]=s45;
			
			JButton s46 = new JButton("");
			s46.setBounds(53, 853, 65, 45);
			panel.add(s46);
			s46.setContentAreaFilled(false);
			s46.setBorderPainted(false);
			s46.setFocusPainted(false); 
			s46.setIcon(II);
			s46.addActionListener((ActionListener) this);
			arr[45]=s46;
			
			JButton s47 = new JButton("");
			s47.setBounds(219, 795, 65, 45);
			panel.add(s47);
			s47.setContentAreaFilled(false);
			s47.setIcon(I);
			s47.addActionListener((ActionListener) this);
			arr[46]=s47;
			
			JButton s48 = new JButton("");
			s48.setBounds(221, 853, 65, 45);
			panel.add(s48);
			s48.setContentAreaFilled(false);
			s48.setBorderPainted(false);
			s48.setFocusPainted(false); 
			s48.setIcon(II);
			s48.addActionListener((ActionListener) this);
			arr[47]=s48;
			
			JLabel label = new JLabel("1");
			label.setBounds(15, 62, 16, 16);
			panel.add(label);
			
			JLabel label_1 = new JLabel("2");
			label_1.setBounds(80, 62, 16, 16);
			panel.add(label_1);
			
			JLabel label_2 = new JLabel("5");
			label_2.setBounds(248, 62, 16, 16);
			panel.add(label_2);
			
			JLabel label_3 = new JLabel("3");
			label_3.setBounds(15, 149, 16, 16);
			panel.add(label_3);
			
			JLabel label_4 = new JLabel("4");
			label_4.setBounds(81, 149, 16, 16);
			panel.add(label_4);
			
			JLabel label_5 = new JLabel("6");
			label_5.setBounds(249, 149, 16, 16);
			panel.add(label_5);
			
			JLabel label_6 = new JLabel("7");
			label_6.setBounds(15, 166, 16, 16);
			panel.add(label_6);
			
			JLabel label_7 = new JLabel("8");
			label_7.setBounds(80, 166, 16, 16);
			panel.add(label_7);
			
			JLabel label_8 = new JLabel("11");
			label_8.setBounds(245, 166, 16, 16);
			panel.add(label_8);
			
			JLabel label_9 = new JLabel("9");
			label_9.setBounds(14, 253, 16, 16);
			panel.add(label_9);
			
			JLabel label_10 = new JLabel("10");
			label_10.setBounds(77, 253, 16, 16);
			panel.add(label_10);
			
			JLabel label_11 = new JLabel("12");
			label_11.setBounds(245, 253, 16, 16);
			panel.add(label_11);
			
			JLabel label_12 = new JLabel("13");
			label_12.setBounds(11, 270, 16, 16);
			panel.add(label_12);
			
			JLabel label_13 = new JLabel("14");
			label_13.setBounds(77, 270, 16, 16);
			panel.add(label_13);
			
			JLabel label_14 = new JLabel("17");
			label_14.setBounds(245, 270, 16, 16);
			panel.add(label_14);
			
			JLabel label_15 = new JLabel("15");
			label_15.setBounds(11, 357, 16, 16);
			panel.add(label_15);
			
			JLabel label_16 = new JLabel("16");
			label_16.setBounds(77, 357, 16, 16);
			panel.add(label_16);
			
			JLabel label_17 = new JLabel("18");
			label_17.setBounds(245, 357, 16, 16);
			panel.add(label_17);
			
			JLabel label_18 = new JLabel("19");
			label_18.setBounds(11, 375, 16, 16);
			panel.add(label_18);
			
			JLabel label_19 = new JLabel("20");
			label_19.setBounds(77, 375, 16, 16);
			panel.add(label_19);
			
			JLabel label_20 = new JLabel("23");
			label_20.setBounds(245, 375, 16, 16);
			panel.add(label_20);
			
			JLabel label_21 = new JLabel("21");
			label_21.setBounds(11, 462, 16, 16);
			panel.add(label_21);
			
			JLabel label_22 = new JLabel("22");
			label_22.setBounds(77, 462, 16, 16);
			panel.add(label_22);
			
			JLabel label_23 = new JLabel("24");
			label_23.setBounds(245, 462, 16, 16);
			panel.add(label_23);
			
			JLabel label_24 = new JLabel("25");
			label_24.setBounds(11, 480, 16, 16);
			panel.add(label_24);
			
			JLabel label_25 = new JLabel("26");
			label_25.setBounds(77, 480, 16, 16);
			panel.add(label_25);
			
			JLabel label_26 = new JLabel("29");
			label_26.setBounds(245, 480, 16, 16);
			panel.add(label_26);
			
			JLabel label_27 = new JLabel("27");
			label_27.setBounds(11, 567, 16, 16);
			panel.add(label_27);
			
			JLabel label_28 = new JLabel("28");
			label_28.setBounds(77, 567, 16, 16);
			panel.add(label_28);
			
			JLabel label_29 = new JLabel("30");
			label_29.setBounds(245, 567, 16, 16);
			panel.add(label_29);
			
			JLabel label_30 = new JLabel("31");
			label_30.setBounds(11, 586, 16, 16);
			panel.add(label_30);
			
			JLabel label_31 = new JLabel("32");
			label_31.setBounds(77, 586, 16, 16);
			panel.add(label_31);
			
			JLabel label_32 = new JLabel("35");
			label_32.setBounds(245, 586, 16, 16);
			panel.add(label_32);
			
			JLabel label_33 = new JLabel("33");
			label_33.setBounds(11, 673, 16, 16);
			panel.add(label_33);
			
			JLabel label_34 = new JLabel("34");
			label_34.setBounds(77, 673, 16, 16);
			panel.add(label_34);
			
			JLabel label_35 = new JLabel("36");
			label_35.setBounds(245, 673, 16, 16);
			panel.add(label_35);
			
			JLabel label_36 = new JLabel("37");
			label_36.setBounds(11, 691, 16, 16);
			panel.add(label_36);
			
			JLabel label_37 = new JLabel("38");
			label_37.setBounds(77, 691, 16, 16);
			panel.add(label_37);
			
			JLabel label_38 = new JLabel("41");
			label_38.setBounds(245, 691, 16, 16);
			panel.add(label_38);
			
			JLabel label_39 = new JLabel("39");
			label_39.setBounds(11, 778, 16, 16);
			panel.add(label_39);
			
			JLabel label_40 = new JLabel("40");
			label_40.setBounds(77, 778, 16, 16);
			panel.add(label_40);
			
			JLabel label_41 = new JLabel("42");
			label_41.setBounds(245, 778, 16, 16);
			panel.add(label_41);
			
			JLabel label_42 = new JLabel("43");
			label_42.setBounds(11, 795, 16, 16);
			panel.add(label_42);
			
			JLabel label_43 = new JLabel("44");
			label_43.setBounds(77, 795, 16, 16);
			panel.add(label_43);
			
			JLabel label_44 = new JLabel("47");
			label_44.setBounds(245, 795, 16, 16);
			panel.add(label_44);
			
			JLabel label_45 = new JLabel("45");
			label_45.setBounds(11, 882, 16, 16);
			panel.add(label_45);
			
			JLabel label_46 = new JLabel("46");
			label_46.setBounds(77, 882, 16, 16);
			panel.add(label_46);
			
			JLabel label_63 = new JLabel("48");
			label_63.setBounds(245, 882, 16, 16);
			panel.add(label_63);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 250, 250));
			panel_1.setBounds(399, 189, 308, 250);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);
			
			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBackground(new Color(255, 255, 240));
			panel_2.setBounds(0, 13, 803, 45);
			frame.getContentPane().add(panel_2);
			
			JLabel label_47 = new JLabel("Book Your Seats");
			label_47.setHorizontalAlignment(SwingConstants.CENTER);
			label_47.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 36));
			label_47.setBounds(0, 0, 803, 45);
			panel_2.add(label_47);
			rs2.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		try
		{
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar"); 
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from "+traintable);  
			Statement stmt1=con.createStatement();
			ResultSet rs1=stmt1.executeQuery("select *from path where Tnumber='"+s.Trainnum()+"'");  
			rs1.first();
			int i=2;
			while(!rs1.getString(i).equals(s.getboards()))
			{
				i+=3;
			}
			while(rs.next())
			{

				int j=i;
				while(!rs1.getString(j).equals(s.getdest()))
				{
					if(!rs.getString(rs1.getString(j)).equals("n/a"))
					{
						int seatnum=Integer.parseInt(rs.getString(1));
						if(arr[seatnum-1].getIcon()==I)
							arr[seatnum-1].setIcon(grey);
						else
							arr[seatnum-1].setIcon(grey1);
						break;
					}
					j+=3;
				}

			}
					

			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		if(((AbstractButton) ae.getSource()).getIcon().equals(II))
		{
			((AbstractButton)ae.getSource()).setIcon(red);
		}
		else if(((AbstractButton) ae.getSource()).getIcon().equals(red))
		{
			((AbstractButton)ae.getSource()).setIcon(II);
		}
		else if(((AbstractButton) ae.getSource()).getIcon().equals(I))
		{
			((AbstractButton)ae.getSource()).setIcon(red1);
		}
		else if(((AbstractButton) ae.getSource()).getIcon().equals(red1))
		{
			((AbstractButton)ae.getSource()).setIcon(I);
		}
	}
	public int[] getSeat()
	{
		return seatarr;
	}
	public int getCounter()
	{
		return seatcounter;
	}
}



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
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class selectSeath implements ActionListener {

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
					selectSeath window = new selectSeath();
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
	public selectSeath() {
		initialize();
		frame.getContentPane().setLayout(null);
		
		JButton s1 = new JButton("");
		s1.setBounds(55, 128, 65, 45);
		frame.getContentPane().add(s1);
		s1.setContentAreaFilled(false);
		s1.setBorderPainted(false);
		s1.setFocusPainted(false); 
		s1.setIcon(I);
		s1.addActionListener((ActionListener) this);
		
		JButton s2 = new JButton("");
		s2.setBounds(199, 128, 65, 45);
		frame.getContentPane().add(s2);
		s2.setContentAreaFilled(false);
		s2.setBorderPainted(false);
		s2.setFocusPainted(false); 
		s2.setIcon(I);
		s2.addActionListener((ActionListener) this);
		
		JButton s3 = new JButton("");
		s3.setBounds(57, 186, 65, 45);
		frame.getContentPane().add(s3);
		s3.setContentAreaFilled(false);
		s3.setBorderPainted(false);
		s3.setFocusPainted(false); 
		s3.setIcon(II);
		s3.addActionListener((ActionListener) this);
		
		JButton s4 = new JButton("");
		s4.setBounds(201, 186, 65, 45);
		frame.getContentPane().add(s4);
		s4.setContentAreaFilled(false);
		s4.setBorderPainted(false);
		s4.setFocusPainted(false); 
		s4.setIcon(II);
		s4.addActionListener((ActionListener) this);
		s1.setFocusPainted(false);
		
		JButton s5 = new JButton("");
		s5.setBounds(55, 232, 65, 45);
		frame.getContentPane().add(s5);
		s5.setContentAreaFilled(false);
		s5.setBorderPainted(false);
		s5.setFocusPainted(false); 
		s5.setIcon(I);
		s5.addActionListener((ActionListener) this);
		
		JButton s6 = new JButton("");
		s6.setBounds(199, 232, 65, 45);
		frame.getContentPane().add(s6);
		s6.setContentAreaFilled(false);
		s6.setBorderPainted(false);
		s6.setFocusPainted(false); 
		s6.setIcon(I);
		s6.addActionListener((ActionListener) this);
		
		JButton s7 = new JButton("");
		s7.setBounds(57, 290, 65, 45);
		frame.getContentPane().add(s7);
		s7.setContentAreaFilled(false);
		s7.setBorderPainted(false);
		s7.setFocusPainted(false); 
		s7.setIcon(II);
		s7.addActionListener((ActionListener) this);
		
		JButton s8 = new JButton("");
		s8.setBounds(201, 290, 65, 45);
		frame.getContentPane().add(s8);
		s8.setContentAreaFilled(false);
		s8.setBorderPainted(false);
		s8.setFocusPainted(false); 
		s8.setIcon(II);
		s8.addActionListener((ActionListener) this);
		
		JButton s9 = new JButton("");
		s9.setBounds(55, 336, 65, 45);
		frame.getContentPane().add(s9);
		s9.setContentAreaFilled(false);
		s9.setBorderPainted(false);
		s9.setFocusPainted(false); 
		s9.setIcon(I);
		s9.addActionListener((ActionListener) this);
		
		JButton s10 = new JButton("");
		s10.setBounds(199, 336, 65, 45);
		frame.getContentPane().add(s10);
		s10.setContentAreaFilled(false);
		s10.setBorderPainted(false);
		s10.setFocusPainted(false); 
		s10.setIcon(I);
		s10.addActionListener((ActionListener) this);
		
		JButton s11 = new JButton("");
		s11.setBounds(57, 394, 65, 45);
		frame.getContentPane().add(s11);
		s11.setContentAreaFilled(false);
		s11.setBorderPainted(false);
		s11.setFocusPainted(false); 
		s11.setIcon(II);
		s11.addActionListener((ActionListener) this);
		
		JButton s12 = new JButton("");
		s12.setBounds(201, 394, 65, 45);
		frame.getContentPane().add(s12);
		s12.setContentAreaFilled(false);
		s12.setBorderPainted(false);
		s12.setFocusPainted(false); 
		s12.setIcon(II);
		s12.addActionListener((ActionListener) this);
		
		JButton s13 = new JButton("");
		s13.setBounds(55, 441, 65, 45);
		frame.getContentPane().add(s13);
		s13.setContentAreaFilled(false);
		s13.setBorderPainted(false);
		s13.setFocusPainted(false); 
		s13.setIcon(I);
		s13.addActionListener((ActionListener) this);
		
		JButton s14 = new JButton("");
		s14.setBounds(199, 441, 65, 45);
		frame.getContentPane().add(s14);
		s14.setContentAreaFilled(false);
		s14.setBorderPainted(false);
		s14.setFocusPainted(false); 
		s14.setIcon(I);
		s14.addActionListener((ActionListener) this);
		
		JButton s15 = new JButton("");
		s15.setBounds(57, 499, 65, 45);
		frame.getContentPane().add(s15);
		s15.setContentAreaFilled(false);
		s15.setBorderPainted(false);
		s15.setFocusPainted(false); 
		s15.setIcon(II);
		s15.addActionListener((ActionListener) this);
		
		JButton s16 = new JButton("");
		s16.setBounds(201, 499, 65, 45);
		frame.getContentPane().add(s16);
		s16.setContentAreaFilled(false);
		s16.setBorderPainted(false);
		s16.setFocusPainted(false); 
		s16.setIcon(II);
		s16.addActionListener((ActionListener) this);
		
		JButton s17 = new JButton("");
		s17.setBounds(55, 546, 65, 45);
		frame.getContentPane().add(s17);
		s17.setContentAreaFilled(false);
		s17.setBorderPainted(false);
		s17.setFocusPainted(false); 
		s17.setIcon(I);
		s17.addActionListener((ActionListener) this);
		
		JButton s18 = new JButton("");
		s18.setBounds(199, 546, 65, 45);
		frame.getContentPane().add(s18);
		s18.setContentAreaFilled(false);
		s18.setBorderPainted(false);
		s18.setFocusPainted(false); 
		s18.setIcon(I);
		s18.addActionListener((ActionListener) this);
		
		JButton s19 = new JButton("");
		s19.setBounds(57, 604, 65, 45);
		frame.getContentPane().add(s19);
		s19.setContentAreaFilled(false);
		s19.setBorderPainted(false);
		s19.setFocusPainted(false); 
		s19.setIcon(II);
		s19.addActionListener((ActionListener) this);
		
		JButton s20 = new JButton("");
		s20.setBounds(201, 604, 65, 45);
		frame.getContentPane().add(s20);
		s20.setContentAreaFilled(false);
		s20.setBorderPainted(false);
		s20.setFocusPainted(false); 
		s20.setIcon(II);
		s20.addActionListener((ActionListener) this);
		
		JButton s21 = new JButton("");
		s21.setBounds(55, 652, 65, 45);
		frame.getContentPane().add(s21);
		s21.setContentAreaFilled(false);
		s21.setBorderPainted(false);
		s21.setFocusPainted(false); 
		s21.setIcon(I);
		s21.addActionListener((ActionListener) this);
		
		JButton s22 = new JButton("");
		s22.setBounds(199, 652, 65, 45);
		frame.getContentPane().add(s22);
		s22.setContentAreaFilled(false);
		s22.setBorderPainted(false);
		s22.setFocusPainted(false); 
		s22.setIcon(I);
		s22.addActionListener((ActionListener) this);
		
		JLabel label = new JLabel("1");
		label.setBounds(85, 128, 16, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("2");
		label_1.setBounds(228, 128, 16, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("3");
		label_2.setBounds(85, 215, 16, 16);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("4");
		label_3.setBounds(229, 215, 16, 16);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("5");
		label_4.setBounds(85, 232, 16, 16);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("6");
		label_5.setBounds(229, 232, 16, 16);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("7");
		label_6.setBounds(84, 319, 16, 16);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("8");
		label_7.setBounds(229, 319, 16, 16);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("9");
		label_8.setBounds(84, 336, 16, 16);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("10");
		label_9.setBounds(225, 336, 16, 16);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("11");
		label_10.setBounds(81, 423, 16, 16);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("12");
		label_11.setBounds(225, 423, 16, 16);
		frame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("13");
		label_12.setBounds(81, 441, 16, 16);
		frame.getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("14");
		label_13.setBounds(225, 441, 16, 16);
		frame.getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("15");
		label_14.setBounds(81, 528, 16, 16);
		frame.getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("16");
		label_15.setBounds(225, 528, 16, 16);
		frame.getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("17");
		label_16.setBounds(81, 546, 16, 16);
		frame.getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel("18");
		label_17.setBounds(225, 546, 16, 16);
		frame.getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("19");
		label_18.setBounds(81, 633, 16, 16);
		frame.getContentPane().add(label_18);
		
		JLabel label_19 = new JLabel("20");
		label_19.setBounds(225, 633, 16, 16);
		frame.getContentPane().add(label_19);
		
		JLabel label_20 = new JLabel("21");
		label_20.setBounds(81, 652, 16, 16);
		frame.getContentPane().add(label_20);
		
		JLabel label_21 = new JLabel("22");
		label_21.setBounds(225, 652, 16, 16);
		frame.getContentPane().add(label_21);
		
		JLabel Tcoach = new JLabel("");
		Tcoach.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		Tcoach.setBounds(378, 180, 198, 29);
		frame.getContentPane().add(Tcoach);
		
		JLabel label_64 = new JLabel("Boarding Date & Time");
		label_64.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		label_64.setBounds(310, 309, 155, 16);
		frame.getContentPane().add(label_64);
		
		JLabel label_65 = new JLabel("Boarding Station");
		label_65.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		label_65.setBounds(310, 280, 155, 16);
		frame.getContentPane().add(label_65);
		
		JLabel label_66 = new JLabel("Name");
		label_66.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		label_66.setBounds(310, 251, 155, 16);
		frame.getContentPane().add(label_66);
		
		JLabel label_67 = new JLabel("Number");
		label_67.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		label_67.setBounds(310, 222, 155, 16);
		frame.getContentPane().add(label_67);
		
		JLabel Tname = new JLabel((String) null);
		Tname.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		Tname.setBounds(473, 255, 216, 16);
		frame.getContentPane().add(Tname);
		
		JLabel bdate = new JLabel("null null");
		bdate.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		bdate.setBounds(473, 309, 208, 16);
		frame.getContentPane().add(bdate);
		
		JLabel bstation = new JLabel((String) null);
		bstation.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		bstation.setBounds(473, 280, 208, 16);
		frame.getContentPane().add(bstation);
		
		JLabel tnumber = new JLabel((String) null);
		tnumber.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		tnumber.setBounds(473, 222, 208, 16);
		frame.getContentPane().add(tnumber);
		
		JLabel dstation = new JLabel("Destination Station");
		dstation.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		dstation.setBounds(473, 347, 238, 16);
		frame.getContentPane().add(dstation);
		
		JLabel lblDestinationStation = new JLabel("Destination Station");
		lblDestinationStation.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
		lblDestinationStation.setBounds(310, 347, 155, 16);
		frame.getContentPane().add(lblDestinationStation);
		
		JButton arr[]=new JButton[64];
		arr[0]=s1;
		arr[1]=s2;
		arr[2]=s3;
		arr[3]=s4;
		arr[4]=s5;
		arr[5]=s6;
		arr[6]=s7;
		arr[7]=s8;
		arr[8]=s9;
		arr[9]=s10;
		arr[10]=s11;
		arr[11]=s12;
		arr[12]=s13;
		arr[13]=s14;
		arr[14]=s15;
		arr[15]=s16;
		arr[16]=s17;
		arr[17]=s18;
		arr[18]=s19;
		arr[19]=s20;
		arr[20]=s21;
		arr[21]=s22;
		
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
					for(int i=0;i<22;i++) 
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
			btnBook.setBounds(331, 389, 97, 25);
			frame.getContentPane().add(btnBook);
			
			JButton btnBack = new JButton("BACK");
			btnBack.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 23));
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					new Booktrain().frame.setVisible(true);
				}
			});
			btnBack.setBounds(479, 389, 97, 25);
			frame.getContentPane().add(btnBack);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 250, 250));
			panel.setBounds(301, 138, 337, 246);
			frame.getContentPane().add(panel);
			
			JLabel label_22 = new JLabel("RAC-2 Layout");
			label_22.setHorizontalAlignment(SwingConstants.CENTER);
			label_22.setForeground(Color.LIGHT_GRAY);
			label_22.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 31));
			label_22.setBounds(42, 91, 241, 35);
			frame.getContentPane().add(label_22);
			
			JLabel label_23 = new JLabel("A");
			label_23.setHorizontalAlignment(SwingConstants.CENTER);
			label_23.setForeground(new Color(211, 211, 211));
			label_23.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 74));
			label_23.setBounds(132, 256, 67, 59);
			frame.getContentPane().add(label_23);
			
			JLabel label_24 = new JLabel("I");
			label_24.setHorizontalAlignment(SwingConstants.CENTER);
			label_24.setForeground(new Color(211, 211, 211));
			label_24.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 74));
			label_24.setBounds(132, 313, 67, 59);
			frame.getContentPane().add(label_24);
			
			JLabel label_25 = new JLabel("S");
			label_25.setHorizontalAlignment(SwingConstants.CENTER);
			label_25.setForeground(new Color(211, 211, 211));
			label_25.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 74));
			label_25.setBounds(132, 368, 67, 64);
			frame.getContentPane().add(label_25);
			
			JLabel label_26 = new JLabel("");
			label_26.setHorizontalAlignment(SwingConstants.CENTER);
			label_26.setBounds(123, 138, 88, 116);
			frame.getContentPane().add(label_26);
			label_26.setIcon(u);
			
			JLabel label_27 = new JLabel("L");
			label_27.setHorizontalAlignment(SwingConstants.CENTER);
			label_27.setForeground(new Color(211, 211, 211));
			label_27.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 74));
			label_27.setBounds(132, 431, 67, 81);
			frame.getContentPane().add(label_27);
			
			JLabel label_28 = new JLabel("E");
			label_28.setHorizontalAlignment(SwingConstants.CENTER);
			label_28.setForeground(new Color(211, 211, 211));
			label_28.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 74));
			label_28.setBounds(132, 499, 67, 81);
			frame.getContentPane().add(label_28);
			
			JLabel label_29 = new JLabel("");
			label_29.setHorizontalAlignment(SwingConstants.CENTER);
			label_29.setBounds(132, 578, 66, 119);
			frame.getContentPane().add(label_29);
			label_29.setIcon(d);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 250, 250));
			panel_1.setBounds(65, 91, 188, 616);
			frame.getContentPane().add(panel_1);
			
			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBackground(new Color(255, 250, 250));
			panel_2.setBounds(0, 13, 824, 45);
			frame.getContentPane().add(panel_2);
			
			JLabel label_30 = new JLabel("Book Your Seats");
			label_30.setHorizontalAlignment(SwingConstants.CENTER);
			label_30.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 36));
			label_30.setBounds(0, 0, 824, 45);
			panel_2.add(label_30);
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
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 842, 959);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Search {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JDateChooser dateboard;
	private static String train;
	private static String bdate;
	private static String ddate;
	private static String boards;
	private static String unboards;
	private static String btime;
	private static String dtime;

	/**
	 * Launch the application.
	 */
	java.net.URL search = this.getClass().getClassLoader().getResource("images/search.png");
	ImageIcon I=new ImageIcon(search);
	java.net.URL exitc = this.getClass().getClassLoader().getResource("images/exitcol.png");
	ImageIcon II=new ImageIcon(exitc);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search window = new Search();
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
	public Search() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(253, 245, 230));
		frame.getContentPane().setBackground(new Color(245, 255, 250));
		frame.getContentPane().setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		frame.setBounds(100, 100, 855, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(316, 84, 252, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblBoarding = new JLabel("Boarding");
		lblBoarding.setFont(new Font("Tw Cen MT Condensed", Font.ITALIC, 22));
		lblBoarding.setBounds(234, 84, 84, 22);
		frame.getContentPane().add(lblBoarding);
		
		JLabel lblUnboarding = new JLabel("Unboarding");
		lblUnboarding.setFont(new Font("Tw Cen MT Condensed", Font.ITALIC, 22));
		lblUnboarding.setBounds(234, 119, 84, 22);
		frame.getContentPane().add(lblUnboarding);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(316, 119, 252, 22);
		frame.getContentPane().add(textField_1);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = new Date();
		Date mindt=new Date();
		Date maxdt=new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, 1);
		mindt = c.getTime();
		c.add(Calendar.DATE, 9);
		maxdt = c.getTime();
		
		dateboard = new JDateChooser();
		dateboard.setBounds(316, 148, 252, 22);
		frame.getContentPane().add(dateboard);
		dateboard.setMinSelectableDate(mindt);
		dateboard.setMaxSelectableDate(maxdt);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tw Cen MT Condensed", Font.ITALIC, 22));
		lblDate.setBounds(234, 154, 84, 16);
		frame.getContentPane().add(lblDate);
		
		
		
		JLabel code = new JLabel("Code");
		code.setFont(new Font("Tw Cen MT Condensed", Font.ITALIC, 18));
		code.setBounds(23, 240, 68, 16);
		frame.getContentPane().add(code);
		code.setVisible(false);
		
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Tw Cen MT Condensed", Font.ITALIC, 18));
		name.setBounds(156, 240, 56, 16);
		frame.getContentPane().add(name);
		name.setVisible(false);
		
		JLabel type = new JLabel("Type");
		type.setFont(new Font("Tw Cen MT Condensed", Font.ITALIC, 18));
		type.setBounds(293, 240, 56, 16);
		frame.getContentPane().add(type);
		type.setVisible(false);
		
		JLabel board = new JLabel("Boarding Time");
		board.setFont(new Font("Tw Cen MT Condensed", Font.ITALIC, 18));
		board.setBounds(431, 240, 83, 16);
		frame.getContentPane().add(board);
		board.setVisible(false);
		
		JLabel unboard = new JLabel("Unboarding Time");
		unboard.setFont(new Font("Tw Cen MT Condensed", Font.ITALIC, 18));
		unboard.setBounds(561, 240, 98, 16);
		frame.getContentPane().add(unboard);
		unboard.setVisible(false);
		
		JLabel book = new JLabel("Reserve");
		book.setFont(new Font("Tw Cen MT Condensed", Font.ITALIC, 18));
		book.setBounds(709, 240, 68, 16);
		frame.getContentPane().add(book);
		book.setVisible(false);
		
		JLabel code1 = new JLabel("Code");
		code1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		code1.setBounds(23, 280, 68, 16);
		frame.getContentPane().add(code1);
		code1.setVisible(false);
		
		JLabel name1 = new JLabel("Name");
		name1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		name1.setBounds(156, 280, 125, 16);
		frame.getContentPane().add(name1);
		name1.setVisible(false);
		
		JLabel type1 = new JLabel("Type");
		type1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		type1.setBounds(293, 280, 115, 16);
		frame.getContentPane().add(type1);
		type1.setVisible(false);
		
		JLabel board1 = new JLabel("Boarding Time");
		board1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		board1.setBounds(431, 280, 83, 16);
		frame.getContentPane().add(board1);
		board1.setVisible(false);
		
		JLabel unboard1 = new JLabel("Unboarding Time");
		unboard1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		unboard1.setBounds(561, 280, 98, 16);
		frame.getContentPane().add(unboard1);
		unboard1.setVisible(false);
		
		JButton book1 = new JButton("Book");
		book1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		book1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				train=code1.getText();
				bdate=dateFormat.format(dateboard.getDate());
				ddate=bdate;
				frame.setVisible(false);
				new Booktrain().frame.setVisible(true);
			}
		});
		book1.setBounds(699, 280, 68, 16);
		frame.getContentPane().add(book1);
		book1.setVisible(false);
		
		JLabel code2 = new JLabel("Code");
		code2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		code2.setBounds(23, 313, 70, 16);
		frame.getContentPane().add(code2);
		code2.setVisible(false);
		
		JLabel name2 = new JLabel("Name");
		name2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		name2.setBounds(155, 313, 126, 16);
		frame.getContentPane().add(name2);
		name2.setVisible(false);
		
		JLabel type2 = new JLabel("Type");
		type2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		type2.setBounds(293, 313, 115, 16);
		frame.getContentPane().add(type2);
		type2.setVisible(false);
		
		JLabel board2 = new JLabel("Boarding Time");
		board2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		board2.setBounds(431, 313, 83, 16);
		frame.getContentPane().add(board2);
		board2.setVisible(false);
		
		JLabel unboard2 = new JLabel("Unboarding Time");
		unboard2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		unboard2.setBounds(561, 313, 98, 16);
		frame.getContentPane().add(unboard2);
		unboard2.setVisible(false);
		
		JButton book2 = new JButton("Book");
		book2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		book2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train=code2.getText();
				bdate=dateFormat.format(dateboard.getDate());
				ddate=bdate;
				frame.setVisible(false);
				new Booktrain().frame.setVisible(true);
			}
		});
		book2.setBounds(699, 313, 68, 16);
		frame.getContentPane().add(book2);
		book2.setVisible(false);
		
		JLabel code3 = new JLabel("Code");
		code3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		code3.setBounds(23, 342, 70, 16);
		frame.getContentPane().add(code3);
		code3.setVisible(false);
		
		JLabel name3 = new JLabel("Name");
		name3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		name3.setBounds(155, 342, 126, 16);
		frame.getContentPane().add(name3);
		name3.setVisible(false);
		
		JLabel type3 = new JLabel("Type");
		type3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		type3.setBounds(293, 342, 115, 16);
		frame.getContentPane().add(type3);
		type3.setVisible(false);
		
		JLabel board3 = new JLabel("Boarding Time");
		board3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		board3.setBounds(431, 342, 83, 16);
		frame.getContentPane().add(board3);
		board3.setVisible(false);
		
		JLabel unboard3 = new JLabel("Unboarding Time");
		unboard3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		unboard3.setBounds(561, 342, 98, 16);
		frame.getContentPane().add(unboard3);
		unboard3.setVisible(false);
		
		JButton book3 = new JButton("Book");
		book3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		book3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train=code3.getText();
				bdate=dateFormat.format(dateboard.getDate());
				ddate=bdate;
				frame.setVisible(false);
				new Booktrain().frame.setVisible(true);
			}
		});
		book3.setBounds(699, 342, 68, 16);
		frame.getContentPane().add(book3);
		book3.setVisible(false);
		
		JLabel code4 = new JLabel("Code");
		code4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		code4.setBounds(23, 375, 70, 16);
		frame.getContentPane().add(code4);
		code4.setVisible(false);
		
		JLabel name4 = new JLabel("Name");
		name4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		name4.setBounds(155, 375, 126, 16);
		frame.getContentPane().add(name4);
		name4.setVisible(false);
		
		JLabel type4 = new JLabel("Type");
		type4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		type4.setBounds(293, 375, 115, 16);
		frame.getContentPane().add(type4);
		type4.setVisible(false);
		
		JLabel board4 = new JLabel("Boarding Time");
		board4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		board4.setBounds(431, 375, 83, 16);
		frame.getContentPane().add(board4);
		board4.setVisible(false);
		
		JLabel unboard4 = new JLabel("Unboarding Time");
		unboard4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		unboard4.setBounds(561, 375, 98, 16);
		frame.getContentPane().add(unboard4);
		unboard4.setVisible(false);
		
		JButton book4 = new JButton("Book");
		book4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		book4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train=code4.getText();
				bdate=dateFormat.format(dateboard.getDate());
				ddate=bdate;
				frame.setVisible(false);
				new Booktrain().frame.setVisible(true);
			}
		});
		book4.setBounds(699, 375, 68, 16);
		frame.getContentPane().add(book4);
		book4.setVisible(false);
		
		JLabel code5 = new JLabel("Code");
		code5.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		code5.setBounds(23, 404, 68, 16);
		frame.getContentPane().add(code5);
		code5.setVisible(false);
		
		JLabel name5 = new JLabel("Name");
		name5.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		name5.setBounds(156, 404, 125, 16);
		frame.getContentPane().add(name5);
		name5.setVisible(false);
		
		JLabel type5 = new JLabel("Type");
		type5.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		type5.setBounds(293, 404, 49, 16);
		frame.getContentPane().add(type5);
		type5.setVisible(false);
		
		JLabel board5 = new JLabel("Boarding Time");
		board5.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		board5.setBounds(431, 404, 83, 16);
		frame.getContentPane().add(board5);
		board5.setVisible(false);
		
		JLabel unboard5 = new JLabel("Unboarding Time");
		unboard5.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		unboard5.setBounds(561, 404, 98, 16);
		frame.getContentPane().add(unboard5);	
		unboard5.setVisible(false);
		
		JButton book5 = new JButton("Book");
		book5.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 17));
		book5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train=code5.getText();
				bdate=dateFormat.format(dateboard.getDate());
				ddate=bdate;
				frame.setVisible(false);
				new Booktrain().frame.setVisible(true);
			}
		});
		book5.setBounds(699, 404, 68, 16);
		frame.getContentPane().add(book5);
		book5.setVisible(false);
		
		JLabel[] array=new JLabel[25];
		array[0]=code1;
		array[1]=name1;
		array[2]=type1;
		array[3]=board1;
		array[4]=unboard1;
		array[5]=code2;
		array[6]=name2;
		array[7]=type2;
		array[8]=board2;
		array[9]=unboard2;
		array[10]=code3;
		array[11]=name3;
		array[12]=type3;
		array[13]=board3;
		array[14]=unboard3;
		array[15]=code4;
		array[16]=name4;
		array[17]=type4;
		array[18]=board4;
		array[19]=unboard4;
		array[20]=code5;
		array[21]=name5;
		array[22]=type5;
		array[23]=board5;
		array[24]=unboard5;
		
		JButton[] barray=new JButton[6];
		barray[0]=book1;
		barray[1]=book2;
		barray[2]=book3;
		barray[3]=book4;
		barray[4]=book5;
		
		btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");  
					Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar");  
					Statement stmt=con.createStatement();  
					
					ResultSet rs=stmt.executeQuery("select * from path");
					
					code.setVisible(true);
					name.setVisible(true);
					type.setVisible(true);
					board.setVisible(true);
					unboard.setVisible(true);
					book.setVisible(true);
					
					int arraycounter=0;
					int barraycounter=0;
					
					int date=11+dateboard.getDate().getDay();
					if(date==11)
						date=18;
					
					for(int i=0;i<25;i++)
					{
						array[i].setVisible(false);
					}
					for(int i=0;i<5;i++)
					{
						barray[i].setVisible(false);
					}
					
					
					while (rs.next())
						{
							Boolean bb=false,ub=false;
							String b = null,u=null;
							
							for(int i=2;!rs.getString(i).equals("n/a");i=i+3)
						      {
								
								
						    	  if(rs.getString(i).contentEquals(textField.getText()))
						    	  {
						    		  boards=textField.getText();
						    		  bb=true;
						    		  b=rs.getString(i+1);
						    		  btime=b;
						    	  }
						    	  else if(rs.getString(i).contentEquals(textField_1.getText())&&bb) 
						    	  {
						    		  unboards=textField_1.getText();
						    		  ub=true;
						    		  u=rs.getString(i+2);
						    		 dtime=u;
						    	  }
						    	  
						    	  
						    	  if(bb&&ub)
						    	  {
						    		  Statement stmt1=con.createStatement();
						    		  ResultSet rs1=stmt1.executeQuery("Select * from train where Tnumber='"+rs.getString(1)+"'");
						    		  rs1.first();
						    		  if(rs1.getString(date).equals("y"))
						    		  {
						    			  array[arraycounter].setText(rs1.getString(1));
							    		  array[arraycounter].setVisible(true);
							    		  arraycounter++;
							    			  	
							    		  array[arraycounter].setText(rs1.getString(2));
							    		  array[arraycounter].setVisible(true);
							    		  arraycounter++;
							    		  
							    		  array[arraycounter].setText(rs1.getString(3));
							    		  array[arraycounter].setVisible(true);
							    		  arraycounter++;
							    		  
							    		  array[arraycounter].setText(b);
							    		  array[arraycounter].setVisible(true);
							    		  arraycounter++;
							    		  
							    		  array[arraycounter].setText(u);
							    		  array[arraycounter].setVisible(true);
							    		  arraycounter++;
							    		  
							    		  barray[barraycounter].setVisible(true);
							    		  barraycounter++;
							    		  rs1.close();
							    		  break;
							    	  }
						    		  }
						      }
					      
					    } 	
					rs.close();	
					con.close(); 
					
					if(arraycounter==0)
						{
							JOptionPane.showMessageDialog(null,"There are no direct trains for your route");
						}
					}
				catch(Exception e)
				{ 
					System.out.println(e);
				}
				}
			
		});
		btnNewButton.setBounds(272, 179, 125, 35);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setIcon(I);
		
		JButton btnBack = new JButton(" Back");
		btnBack.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
				new MenuOption().frame.setVisible(true);
			}
			
		});
		btnBack.setBounds(420, 179, 127, 35);
		frame.getContentPane().add(btnBack);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);
		btnBack.setIcon(II);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 23, 837, 32);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search For Trains");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 0, 837, 32);
		panel.add(lblNewLabel);
	}
	
	public String Trainnum()
	{
        return train;
    }
	public String getbDate()
	{
        return bdate;
    }
	public String getdDate()
	{
        return ddate;
    }
	public String getbtime()
	{
        return btime;
    }
	public String getdtime()
	{
        return dtime;
    }
	public String getboards()
	{
        return boards;
    }
	public String getdest()
	{
        return unboards;
    }
	
}

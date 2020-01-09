

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Booktrain {

	public JFrame frame;
	private static String traintable;
	private static String coachs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booktrain window = new Booktrain();
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
	public Booktrain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 676, 536);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(111, 77, 56, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(111, 48, 56, 16);
		frame.getContentPane().add(lblNumber);
		
		JLabel lblBoardingDate = new JLabel("Boarding Date & Time");
		lblBoardingDate.setBounds(111, 135, 139, 16);
		frame.getContentPane().add(lblBoardingDate);
		
		JLabel lblBoarding = new JLabel("Boarding Station");
		lblBoarding.setBounds(111, 106, 104, 16);
		frame.getContentPane().add(lblBoarding);
		
		JLabel lblDestinationStation = new JLabel("Destination Station");
		lblDestinationStation.setBounds(111, 170, 118, 16);
		frame.getContentPane().add(lblDestinationStation);
		
		JLabel lblDestinationDate = new JLabel("Destination Date & Time");
		lblDestinationDate.setBounds(111, 199, 139, 16);
		frame.getContentPane().add(lblDestinationDate);
		
		JLabel tnumber = new JLabel("");
		tnumber.setBounds(281, 48, 56, 16);
		frame.getContentPane().add(tnumber);
		
		JLabel bdate = new JLabel("");
		bdate.setBounds(281, 135, 189, 16);
		frame.getContentPane().add(bdate);
		
		JLabel bstation = new JLabel("");
		bstation.setBounds(281, 106, 189, 16);
		frame.getContentPane().add(bstation);
		
		JLabel dstation = new JLabel("");
		dstation.setBounds(281, 170, 175, 16);
		frame.getContentPane().add(dstation);
		
		JLabel ddate = new JLabel("");
		ddate.setBounds(281, 199, 139, 16);
		frame.getContentPane().add(ddate);
		
		JLabel tname = new JLabel("");
		tname.setBounds(281, 77, 139, 16);
		frame.getContentPane().add(tname);
		
		JLabel lclass = new JLabel("Coach Selection");
		lclass.setBounds(111, 239, 139, 16);
		frame.getContentPane().add(lclass);
		
		Choice tclass = new Choice();
		tclass.setBounds(289, 233, 112, 22);
		frame.getContentPane().add(tclass);
		
		Search s=new Search();
		tnumber.setText(s.Trainnum());
		bstation.setText(s.getboards());
		bdate.setText(s.getbDate()+" "+s.getbtime());
		dstation.setText(s.getdest());
		ddate.setText(s.getdDate()+" "+s.getdtime());
		
		
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar");  
			//here railways is database name, root is username and password is simar
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from train where tnumber="+"'"+tnumber.getText()+"'");  
				rs.first();
			      tname.setText(rs.getString("name"));
			      int H=rs.getInt(5);
			      int A=rs.getInt(6);
			      int B=rs.getInt(7);
			      int S=rs.getInt(8);
			      int pc=rs.getInt(9);
			      int ec=rs.getInt(10);
			      int cc=rs.getInt(11);
			      for(int i=0;i<H;i++)
			      {
			    	  tclass.add("H"+Integer.toString(i+1));
			      }
			      for(int i=0;i<A;i++)
			      {
			    	  tclass.add("A"+Integer.toString(i+1));
			      }
			      for(int i=0;i<B;i++)
			      {
			    	  tclass.add("B"+Integer.toString(i+1));
			      }
			      for(int i=0;i<S;i++)
			      {
			    	  tclass.add("S"+Integer.toString(i+1));
			      }
			      for(int i=0;i<pc;i++)
			      {
			    	  tclass.add("PC"+Integer.toString(i+1));
			      }
			      for(int i=0;i<ec;i++)
			      {
			    	  tclass.add("EC"+Integer.toString(i+1));
			      }
			      for(int i=0;i<cc;i++)
			      {
			    	  tclass.add("CC"+Integer.toString(i+1));
			      }
			      rs.close();
			      stmt.close();
			      con.close();
			      
			      JButton btnSeatSelection = new JButton("Seat Selection");
			      btnSeatSelection.addActionListener(new ActionListener() {
			      	public void actionPerformed(ActionEvent arg0)
			      	{

			      		java.sql.DatabaseMetaData dbm;
						try {
							Connection c=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar");
							dbm = c.getMetaData();
							StringBuilder sb = new StringBuilder(s.getbDate());
							sb.deleteCharAt(2);
							sb.deleteCharAt(4);
							String tabdate = sb.toString();
							String tablename=tnumber.getText()+"_"+tabdate+"_"+tclass.getSelectedItem();
							traintable=tablename;
							coachs=tclass.getSelectedItem();
				      		ResultSet tables = dbm.getTables(null, null,tablename, null);
				      		if (tables.next()) 
				      		{
				      			char coach=tclass.getSelectedItem().charAt(0);
				      			if(Character.compare(coach,'H')==0)
				      			{
				      				frame.setVisible(false);
				    				new selectSeath().frame.setVisible(true);
				      			}
				      			else if(Character.compare(coach,'A')==0)
				      			{
				      				frame.setVisible(false);
				    				new selectSeatA().frame.setVisible(true);
				      			}
				      			else if(Character.compare(coach,'B')==0)
				      			{
				      				frame.setVisible(false);
				    				new selectSeat().frame.setVisible(true);
				    				
				      			}
				      			
				      			else if(Character.compare(coach,'S')==0)
				      			{
				      				frame.setVisible(false);
				    				new selectSeat().frame.setVisible(true);
				      			}
				      			
				      			else if(Character.compare(coach,'C')==0)
				      			{
				      				frame.setVisible(false);
				    				new selectSeatCC().frame.setVisible(true);
				      			}
				      			else if(Character.compare(coach,'E')==0)
				      			{
				      				frame.setVisible(false);
				    				new SelectSeatEC().frame.setVisible(true);
				      			}
				      		}
				      		else
				      		{
				      			Connection c1=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar");
				      			Statement stmt1=c1.createStatement();
				      			String sql = "CREATE TABLE "+tablename+
				                        "( seat int(2))";
				      			stmt1.executeUpdate(sql);
				      			Statement stmt2=c1.createStatement();
				      			ResultSet rs2=stmt2.executeQuery("select * from path where Tnumber='"+tnumber.getText()+"'");
				      			rs2.first();
				      			for(int i=2;!rs2.getString(i).equals("n/a");i=i+3)
				      			{
				      				String sql2="ALTER TABLE "+tablename+" ADD "+rs2.getString(i)+" VARCHAR(35) Default 'n/a'";
				      				stmt1.executeUpdate(sql2);
				      			}
				      			rs2.close();
				      			stmt2.close();
				      			stmt1.close();
				      			c1.close();
				      			char coach=tclass.getSelectedItem().charAt(0);
				      			if(Character.compare(coach,'H')==0)
				      			{
				      				Connection c2=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar");
				      				Statement stmt4=c2.createStatement();
				    				for(int i=1;i<=22;i++)
				    				{
				    					String sql3 = "insert into "+tablename+"(seat)"+
						                        "Values('"+Integer.toString(i)+"');";
						      			stmt4.executeUpdate(sql3);
				    				}
				      				frame.setVisible(false);
				    				new selectSeath().frame.setVisible(true);
					      			
				      			}
				      			else if(Character.compare(coach,'A')==0)
				      			{
				      				Connection c2=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar");
				      				Statement stmt4=c2.createStatement();
				    				for(int i=1;i<=48;i++)
				    				{
				    					String sql3 = "insert into "+tablename+"(seat)"+
						                        "Values('"+Integer.toString(i)+"');";
						      			stmt4.executeUpdate(sql3);
				    				}
				      				frame.setVisible(false);
				    				new selectSeatA().frame.setVisible(true);
				      			}
				      			else if(Character.compare(coach,'B')==0)
				      			{
				      				Connection c2=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar");
				      				Statement stmt4=c2.createStatement();
				    				for(int i=1;i<=64;i++)
				    				{
				    					String sql3 = "insert into "+tablename+"(seat)"+
						                        "Values('"+Integer.toString(i)+"');";
						      			stmt4.executeUpdate(sql3);
				    				}
				      				frame.setVisible(false);
				    				new selectSeat().frame.setVisible(true);
				      			}
				      			
				      			else if(Character.compare(coach,'S')==0)
				      			{
				      				Connection c2=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar");
				      				Statement stmt4=c2.createStatement();
				    				for(int i=1;i<=64;i++)
				    				{
				    					String sql3 = "insert into "+tablename+"(seat)"+
						                        "Values('"+Integer.toString(i)+"');";
						      			stmt4.executeUpdate(sql3);
				    				}
				      				frame.setVisible(false);
				    				new selectSeat().frame.setVisible(true);
				      			}
				      			
				      			else if(Character.compare(coach,'C')==0)
				      			{
				      				frame.setVisible(false);
				    				new selectSeatCC().frame.setVisible(true);
				      			}
				      			else if(Character.compare(coach,'E')==0)
				      			{
				      				frame.setVisible(false);
				    				new SelectSeatEC().frame.setVisible(true);
				      			}
				      		}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			      		
			      	}
			      });
			      btnSeatSelection.setBounds(210, 286, 127, 25);
			      frame.getContentPane().add(btnSeatSelection);
			      
			      JButton btnBack = new JButton("Back");
			      btnBack.addActionListener(new ActionListener() {
			      	public void actionPerformed(ActionEvent e) {
			      		frame.setVisible(false);
						new Search().frame.setVisible(true);
			      	}
			      });
			      btnBack.setBounds(387, 286, 97, 25);
			      frame.getContentPane().add(btnBack);
			}
		catch(Exception e){ System.out.println(e);}
	}
	
	public String gettrainname()
	{
        return traintable;
    }
	public String getcoach()
	{
        return coachs;
    }
}


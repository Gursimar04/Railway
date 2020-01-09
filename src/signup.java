import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.toedter.calendar.JDateChooser;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Choice;
import java.awt.Color;
import javax.swing.ButtonGroup;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class signup {

	public JFrame frame;
	private JTextField pass1;
	private JTextField user;
	private JTextField fname;
	private JTextField pass2;
	private JTextField mname;
	private JTextField lname;
	private JTextField extension;
	private JTextField number;
	private JTextField address;
	private JTextField state;
	private JTextField city;
	private JTextField pin;
	private JDateChooser Dob;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup window = new signup();
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
	public signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(100, 100, 712, 779);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		pass1 = new JTextField();
		pass1.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		pass1.setBounds(220, 84, 184, 22);
		frame.getContentPane().add(pass1);
		pass1.setColumns(10);
		
		user = new JTextField();
		user.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		user.setColumns(10);
		user.setBounds(220, 37, 184, 22);
		frame.getContentPane().add(user);
		
		fname = new JTextField();
		fname.setToolTipText("First Name");
		fname.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		fname.setColumns(10);
		fname.setBounds(222, 170, 92, 22);
		frame.getContentPane().add(fname);
		
		pass2 = new JTextField();
		pass2.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		pass2.setColumns(10);
		pass2.setBounds(220, 114, 184, 22);
		frame.getContentPane().add(pass2);
		
		mname = new JTextField();
		mname.setToolTipText("Middle Name");
		mname.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		mname.setColumns(10);
		mname.setBounds(319, 170, 74, 22);
		frame.getContentPane().add(mname);
		
		lname = new JTextField();
		lname.setToolTipText("Last Name");
		lname.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lname.setColumns(10);
		lname.setBounds(395, 170, 105, 22);
		frame.getContentPane().add(lname);
		
		extension = new JTextField();
		extension.setEditable(false);
		extension.setText("+91");
		extension.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		extension.setColumns(10);
		extension.setBounds(227, 261, 38, 22);
		frame.getContentPane().add(extension);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblUsername.setBounds(137, 37, 84, 26);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblUsernpasswordme = new JLabel("Password");
		lblUsernpasswordme.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblUsernpasswordme.setBounds(137, 84, 84, 26);
		frame.getContentPane().add(lblUsernpasswordme);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblConfirmPassword.setBounds(78, 112, 143, 26);
		frame.getContentPane().add(lblConfirmPassword);
		
		JLabel lblFirstName = new JLabel("Name");
		lblFirstName.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblFirstName.setBounds(165, 170, 45, 22);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblMobileNumber.setBounds(112, 261, 116, 22);
		frame.getContentPane().add(lblMobileNumber);
		
		number = new JTextField();
		number.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		number.setColumns(10);
		number.setBounds(277, 261, 159, 22);
		frame.getContentPane().add(number);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblGender.setBounds(145, 297, 74, 22);
		frame.getContentPane().add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		rdbtnMale.setBounds(218, 295, 64, 25);
		frame.getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		rdbtnFemale.setBounds(288, 295, 84, 25);
		frame.getContentPane().add(rdbtnFemale);
		
		JRadioButton rdbtnOthers = new JRadioButton("Others");
		rdbtnOthers.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		rdbtnOthers.setBounds(377, 296, 74, 25);
		frame.getContentPane().add(rdbtnOthers);
		
		JLabel lblOccupation = new JLabel("Occupation");
		lblOccupation.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblOccupation.setBounds(135, 325, 84, 22);
		frame.getContentPane().add(lblOccupation);
		
		Choice religion = new Choice();
		religion.setForeground(Color.BLACK);
		religion.setBounds(218, 364, 116, 22);
		frame.getContentPane().add(religion);
		religion.add("Christian");
		religion.add("Hindu");
		religion.add("Muslim");
		religion.add("Sikh");
		religion.add("Agnostic");
		religion.add("Catholic");
		religion.add("Buddhist");
		religion.add("Aethist");
		religion.add("Jain");
		religion.add("Judaist");
		
		JLabel lblReligion = new JLabel("Religion");
		lblReligion.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblReligion.setBounds(154, 364, 55, 22);
		frame.getContentPane().add(lblReligion);
		
		Choice occu = new Choice();
		occu.setForeground(Color.BLACK);
		occu.setBounds(218, 325, 116, 22);
		frame.getContentPane().add(occu);
		occu.add("Government");
		occu.add("Private");
		occu.add("Public");
		occu.add("Professional");
		occu.add("Self Employed");
		occu.add("Student");
		occu.add("Others");
		
		
		Choice national = new Choice();
		national.setForeground(Color.BLACK);
		national.setBounds(224, 396, 116, 22);
		frame.getContentPane().add(national);
		national.add("Afghanistan");
		national.add("Albania");
		national.add("Algeria");
		national.add("Andorra");
		national.add("Angola");
		national.add("Antigua and Barbuda");
		national.add("Argentina");
		national.add("Armenia");
		national.add("Austria");
		national.add("Austrian Empire");
		national.add("Azerbaijan");
		national.add("Baden");
		national.add("Bahrain");
		national.add("Bangladesh");
		national.add("Barbados");
		national.add("Bavaria");
		national.add("Belarus");
		national.add("Belgium");
		national.add("Belize");
		national.add("Benin (Dahomey)");
		national.add("Bolivia");
		national.add("Bosnia and Herzegovina");
		national.add("Botswana");
		national.add("Brazil");
		national.add("Brunei");
		national.add("Brunswick and Lüneburg");
		national.add("Bulgaria");
		national.add("Burkina Faso (Upper Volta)");
		national.add("Burma");
		national.add("Burundi");
		national.add("Cabo Verde");
		national.add("Cambodia");
		national.add("Cameroon");
		national.add("Canada");
		national.add("Central African Republic");
		national.add("Central American Federation");
		national.add("Chad");
		national.add("Chile");
		national.add("China");
		national.add("Colombia");
		national.add("Comoros");
		national.add("Costa Rica");
		national.add("Cote d’Ivoire (Ivory Coast)");
		national.add("Croatia");
		national.add("Cuba");
		national.add("Cyprus");
		national.add("Czechia");
		national.add("Czechoslovakia");
		national.add("Democratic Republic of the Congo");
		national.add("Denmark");
		national.add("Djibouti");
		national.add("Dominica");
		national.add("Dominican Republic");
		national.add("Ecuador");
		national.add("Egypt");
		national.add("El Salvador");
		national.add("Equatorial Guinea");
		national.add("Eritrea");
		national.add("Estonia");
		national.add("Eswatini");
		national.add("Ethiopia");
		national.add("Fiji");
		national.add("Finland");
		national.add("France");
		national.add("Gabon");
		national.add("Georgia");
		national.add("Germany");
		national.add("Ghana");
		national.add("Greece");
		national.add("Grenada");
		national.add("Guatemala");
		national.add("Guinea");
		national.add("Guinea-Bissau");
		national.add("Guyana");
		national.add("Haiti");
		national.add("Hanover");
		national.add("Hanseatic Republics");
		national.add("Hawaii");
		national.add("Hesse");
		national.add("Holy See");
		national.add("Honduras");
		national.add("Hungary");
		national.add("Iceland");
		national.add("India");
		national.add("Indonesia");
		national.add("Iran");
		national.add("Iraq");
		national.add("Ireland");
		national.add("Israel");
		national.add("Italy");
		national.add("Jamaica");
		national.add("Japan");
		national.add("Jordan");
		
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblNationality.setBounds(141, 396, 84, 22);
		frame.getContentPane().add(lblNationality);
		
		JLabel lblMaritalStatus = new JLabel("Marital Status");
		lblMaritalStatus.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblMaritalStatus.setBounds(112, 446, 93, 22);
		frame.getContentPane().add(lblMaritalStatus);
		
		JRadioButton rdbtnMarried = new JRadioButton("Married");
		rdbtnMarried.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		rdbtnMarried.setBounds(217, 445, 92, 25);
		frame.getContentPane().add(rdbtnMarried);
		
		JRadioButton rdbtnUnmarried = new JRadioButton("Unmarried");
		rdbtnUnmarried.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		rdbtnUnmarried.setBounds(307, 445, 105, 25);
		frame.getContentPane().add(rdbtnUnmarried);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblAddress.setBounds(153, 497, 55, 22);
		frame.getContentPane().add(lblAddress);
		
		address = new JTextField();
		address.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		address.setColumns(10);
		address.setBounds(220, 497, 184, 22);
		frame.getContentPane().add(address);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblState.setBounds(170, 527, 38, 22);
		frame.getContentPane().add(lblState);
		
		state = new JTextField();
		state.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		state.setColumns(10);
		state.setBounds(220, 527, 92, 22);
		frame.getContentPane().add(state);
		
		city = new JTextField();
		city.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		city.setColumns(10);
		city.setBounds(362, 527, 92, 22);
		frame.getContentPane().add(city);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblCity.setBounds(334, 527, 38, 22);
		frame.getContentPane().add(lblCity);
		
		JLabel lblPincode = new JLabel("Pincode");
		lblPincode.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblPincode.setBounds(416, 497, 55, 22);
		frame.getContentPane().add(lblPincode);
		
		pin = new JTextField();
		pin.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		pin.setColumns(10);
		pin.setBounds(472, 497, 74, 22);
		frame.getContentPane().add(pin);
		
		JLabel lblDifferentlyAbled = new JLabel("Differently Abled");
		lblDifferentlyAbled.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblDifferentlyAbled.setBounds(97, 583, 116, 22);
		frame.getContentPane().add(lblDifferentlyAbled);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		rdbtnYes.setBounds(221, 582, 64, 25);
		frame.getContentPane().add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		rdbtnNo.setBounds(292, 582, 105, 25);
		frame.getContentPane().add(rdbtnNo);
		
		JLabel passshow = new JLabel("");
		passshow.setForeground(Color.RED);
		passshow.setBounds(220, 65, 288, 16);
		frame.getContentPane().add(passshow);
		
		JLabel nameshow = new JLabel("");
		nameshow.setForeground(Color.RED);
		nameshow.setBounds(220, 152, 236, 16);
		frame.getContentPane().add(nameshow);
		
		JLabel numbershow = new JLabel("");
		numbershow.setForeground(Color.RED);
		numbershow.setBounds(226, 241, 274, 16);
		frame.getContentPane().add(numbershow);
		
		JLabel gendershow = new JLabel("");
		gendershow.setForeground(Color.RED);
		gendershow.setBounds(197, 287, 274, 10);
		frame.getContentPane().add(gendershow);
		
		ButtonGroup gend=new ButtonGroup();
		gend.add(rdbtnMale);
		gend.add(rdbtnFemale);
		gend.add(rdbtnOthers);
		
		ButtonGroup Marr=new ButtonGroup();
		Marr.add(rdbtnMarried);
		Marr.add(rdbtnUnmarried);
		
		ButtonGroup Diff=new ButtonGroup();
		Diff.add(rdbtnYes);
		Diff.add(rdbtnNo);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setEnabled(false);
		btnSubmit.setBounds(259, 616, 97, 25);
		frame.getContentPane().add(btnSubmit);
		
		JLabel usershow = new JLabel("");
		usershow.setFont(new Font("Bodoni MT", Font.BOLD, 10));
		usershow.setForeground(Color.RED);
		usershow.setBounds(220, 13, 184, 22);
		frame.getContentPane().add(usershow);
		
		JLabel marriedshow = new JLabel("");
		marriedshow.setForeground(Color.RED);
		marriedshow.setBounds(220, 431, 231, 16);
		frame.getContentPane().add(marriedshow);
		
		JLabel addressshow = new JLabel("");
		addressshow.setForeground(Color.RED);
		addressshow.setBounds(220, 479, 254, 16);
		frame.getContentPane().add(addressshow);
		
		JLabel diffshow = new JLabel("");
		diffshow.setForeground(Color.RED);
		diffshow.setBounds(220, 562, 244, 16);
		frame.getContentPane().add(diffshow);
		
		JLabel lblDateofbirth = new JLabel("DateOfBirth");
		lblDateofbirth.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblDateofbirth.setBounds(135, 216, 84, 22);
		frame.getContentPane().add(lblDateofbirth);
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, -6574);
		dt = c.getTime();
		
		Dob = new JDateChooser();
		Dob.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		Dob.setBounds(220, 216, 200, 22);
		frame.getContentPane().add(Dob);
		Dob.setMaxSelectableDate(dt);
		
		JLabel dobshow = new JLabel("");
		dobshow.setForeground(Color.RED);
		dobshow.setBounds(220, 198, 274, 16);
		frame.getContentPane().add(dobshow);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				new Login().frame.setVisible(true);
			}
		});
		btnBack.setBounds(426, 616, 97, 25);
		frame.getContentPane().add(btnBack);
		
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	
				try
				{
					String usern=user.getText();
					String passw=pass1.getText();
					String dobs=dateFormat.format(Dob.getDate());
					String fnam=fname.getText();
					String mnam=mname.getText();
					String lnam=lname.getText();
					char gen=((CharSequence) gend.getSelection()).charAt(0);
					String mnumb=extension.getText()+number.getText();
					String occup=occu.getSelectedItem();
					String reli=religion.getSelectedItem();
					String marr=((CharSequence)Marr.getSelection()).toString();
					String nati=national.getSelectedItem();
					String addr=address.getText();
					String pinc=pin.getText();
					String cit=city.getText(); 
					String sta=state.getText();
					char disab=((CharSequence) Diff.getSelection()).charAt(0);
					
					Class.forName("com.mysql.cj.jdbc.Driver");  
					Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar");  
					Statement stmt=con.createStatement();  
				
					stmt.executeUpdate("Insert into users"
							+ "Values('"+usern+"','"+passw+"','"+dobs+"','"+fnam+"','"+mnam+"','"+lnam+"','"+
							gen+"','"+mnumb+"','"+occup+"','"+reli+"','"+marr+"','"+nati+"','"+addr+"','"+pinc+"','"+
							cit+"','"+sta+"','"+disab+"')");
				}
				catch(Exception e)
				{
					System.out.print(e);
				}
			}
		});
		
		user.getDocument().addDocumentListener(new DocumentListener() {
			
			  public void checkuser()
			  {
				  try{  
						Class.forName("com.mysql.cj.jdbc.Driver");  
						Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/railways","root","simar");  
						Statement stmt=con.createStatement();  
						String u=user.getText();
						
						ResultSet rs=stmt.executeQuery("select username from users");  
							while (rs.next())
							{
						      String use= rs.getString("username");
						      if(use.compareTo(u)==0)
						      {
						    	  usershow.setText("The username Already exists.");
						    	  break;
						    	  
						      }
						      else if(u.length()<=5)
						      {
						    	  usershow.setText("Username too short.");
						      }
						      else
						      {
						    	  usershow.setText("");
						      }
						      
						    } 
						con.close();  
						}
					catch(Exception e){ System.out.println(e);}
			  }
			@Override
			public void changedUpdate(DocumentEvent arg0) 
			{
				checkuser();
				
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkuser();
				
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkuser();
				
			}
			});
		
		
		
		
		
		pass1.getDocument().addDocumentListener(new DocumentListener() {
			
			  public void checkpass()
			  {
				  try{  
						String p=pass1.getText();
						Boolean s=false,d=false,u=false,l=false;
						if(p.length()>=8)
						{
							l=true;
						}
					    Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
					    Matcher matcher = pattern.matcher(p);
					    if (!matcher.matches())
					    {
					    	s=true;
					    }
						for(int j=0;j<p.length();j++)
						{
							if(Character.isUpperCase(p.charAt(j)))
							{
								u=true;
							}
							if(Character.isDigit(p.charAt(j)))
							{
								d=true;
							}
						}
						
						if(!l)
						{
							passshow.setText("Must be 8 character long");
						}
					    
						else if(!s)
						{
							passshow.setText("There must be a speacial character");
						}
						
						else if(!d)
						{
							passshow.setText("There must be an integer value");
						}
						
						else if(!u)
						{
							passshow.setText("There must be an Uppercase character");
						}
						
						else
						{
							passshow.setText("");
						}
						
					}
					catch(Exception e){ System.out.println(e);}
			  }
			@Override
			public void changedUpdate(DocumentEvent arg0) 
			{
				checkpass();
				
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkpass();
				
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkpass();
				
			}
			});
		
		pass2.getDocument().addDocumentListener(new DocumentListener() {
			
			  public void checkpass2()
			  {
				  try{  
					  	if(pass1.getText().contentEquals(pass2.getText()))
					  	{
					  		passshow.setText("");
					  	}
					  	else
					  	{
					  		passshow.setText("Password doesn't match");
					  	}
						
					}
					catch(Exception e){ System.out.println(e);}
			  }
			@Override
			public void changedUpdate(DocumentEvent arg0) 
			{
				checkpass2();
				
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkpass2();
				
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkpass2();
				
			}
			});
		
		fname.getDocument().addDocumentListener(new DocumentListener() {
			
			  public void checkname()
			  {
				  try{  
					  	if(pass1.getText().contentEquals(""))
					  	{
					  		nameshow.setText("Please Enter First name and last name");
					  	}
					  	else
					  	{
					  		nameshow.setText("");
					  	}
						
					}
					catch(Exception e){ System.out.println(e);}
			  }
			@Override
			public void changedUpdate(DocumentEvent arg0) 
			{
				checkname();
				
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkname();
				
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkname();
				
			}
			});
		
		lname.getDocument().addDocumentListener(new DocumentListener() {
			
			  public void checkname2()
			  {
				  try{  
					  	if(pass1.getText().contentEquals(""))
					  	{
					  		nameshow.setText("Please Enter First name and last name");
					  	}
					  	else
					  	{
					  		nameshow.setText("");
					  	}
						
					}
					catch(Exception e){ System.out.println(e);}
			  }
			@Override
			public void changedUpdate(DocumentEvent arg0) 
			{
				checkname2();
				
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkname2();
				
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkname2();
				
			}
			});
		
		number.getDocument().addDocumentListener(new DocumentListener() {
			
			  public void checknum()
			  {
				  try{  
					  	if(number.getText().contentEquals(""))
					  	{
					  		numbershow.setText("Please Enter your Mobile Number");
					  	}
					  	else
					  	{
					  		numbershow.setText("");
					  	}
						
					}
					catch(Exception e){ System.out.println(e);}
			  }
			@Override
			public void changedUpdate(DocumentEvent arg0) 
			{
				checknum();
				
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checknum();
				
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checknum();
				
			}
			});
		
		
		
		
		
		address.getDocument().addDocumentListener(new DocumentListener() {
			
			public void checkadd()
			  {
				  try{  
					  	if(address.getText().contentEquals(""))
					  	{
					  		
							addressshow.setText("Please Enter your Full Address");
					  	}
					  	else
					  	{
					  		addressshow.setText("");
					  	}
						
					}
					catch(Exception e){ System.out.println(e);}
			  }	  
			@Override
			public void changedUpdate(DocumentEvent arg0) 
			{
				checkadd();
				
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkadd();
				
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkadd();
				
			}
			});
		
		city.getDocument().addDocumentListener(new DocumentListener() {
			
			public void checkadd()
			  {
				  try{  
					  	if(city.getText().contentEquals(""))
					  	{
					  		
							addressshow.setText("Please Enter your Full Address");
					  	}
					  	else
					  	{
					  		addressshow.setText("");
					  	}
						
					}
					catch(Exception e){ System.out.println(e);}
			  }
				  
			@Override
			public void changedUpdate(DocumentEvent arg0) 
			{
				checkadd();
				
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkadd();
				
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkadd();
				
			}
			});
		
		pin.getDocument().addDocumentListener(new DocumentListener() {
			public void checkadd()
			  {
				  try{  
					  	if(pin.getText().contentEquals(""))
					  	{
					  		
							addressshow.setText("Please Enter your Full Address");
					  	}
					  	else
					  	{
					  		addressshow.setText("");
					  	}
						
					}
					catch(Exception e){ System.out.println(e);}
			  }
			  
			@Override
			public void changedUpdate(DocumentEvent arg0) 
			{
				checkadd();
				
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkadd();
				
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkadd();
				
			}
			});
		
		state.getDocument().addDocumentListener(new DocumentListener() {
			public void checkadd()
			  {
				  try{  
					  	if(state.getText().contentEquals(""))
					  	{
					  		
							addressshow.setText("Please Enter your Full Address");
					  	}
					  	else
					  	{
					  		addressshow.setText("");
					  	}
						
					}
					catch(Exception e){ System.out.println(e);}
			  }
			  					
			  
			@Override
			public void changedUpdate(DocumentEvent arg0) 
			{
				checkadd();
				
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				checkadd();
				
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				checkadd();
				
			}
			});
		
		
		
		
		
		
	}
}

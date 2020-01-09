import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MenuOption {

	public JFrame frame;

	java.net.URL train = this.getClass().getClassLoader().getResource("images/train.png");
	ImageIcon I=new ImageIcon(train);
	java.net.URL info = this.getClass().getClassLoader().getResource("images/info.png");
	ImageIcon II=new ImageIcon(info);
	java.net.URL X = this.getClass().getClassLoader().getResource("images/X.png");
	ImageIcon III=new ImageIcon(X);
	java.net.URL del = this.getClass().getClassLoader().getResource("images/delete.png");
	ImageIcon IV=new ImageIcon(del);
	java.net.URL journey = this.getClass().getClassLoader().getResource("images/journey.png");
	ImageIcon V=new ImageIcon(journey);
	java.net.URL file = this.getClass().getClassLoader().getResource("images/file.png");
	ImageIcon VI=new ImageIcon(file);
	java.net.URL exit = this.getClass().getClassLoader().getResource("images/exit.png");
	ImageIcon VII=new ImageIcon(file);
	java.net.URL str = this.getClass().getClassLoader().getResource("images/smalltrain.png");
	ImageIcon VIII=new ImageIcon(str);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOption window = new MenuOption();
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
	public MenuOption() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Button.disabledShadow"));
		frame.setBounds(100, 100, 626, 556);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Login l=new Login();
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(112, 128, 144));
		panel.setBounds(1, 44, 213, 465);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnBookATrain = new JButton("Book a train");
		btnBookATrain.setHorizontalAlignment(SwingConstants.LEFT);
		btnBookATrain.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		btnBookATrain.setForeground(new Color(255, 255, 255));
		btnBookATrain.setBounds(12, 62, 189, 25);
		panel.add(btnBookATrain);
		btnBookATrain.setIcon(I);
		
		
		JButton btnTrainInfo = new JButton("Train info");
		btnTrainInfo.setHorizontalAlignment(SwingConstants.LEFT);
		btnTrainInfo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		btnTrainInfo.setForeground(new Color(255, 255, 255));
		btnTrainInfo.setBounds(13, 102, 188, 25);
		panel.add(btnTrainInfo);
		btnTrainInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new TrainInfo().frame.setVisible(true);
			}
		});
		btnTrainInfo.setContentAreaFilled(false);
		btnTrainInfo.setBorderPainted(false);
		btnTrainInfo.setFocusPainted(false);
		btnTrainInfo.setIcon(II);
		
		
		
		btnBookATrain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Login l=new Login();
				System.out.println(l.getUser());
				frame.setVisible(false);
				new Search().frame.setVisible(true);
			}
		});
		btnBookATrain.setContentAreaFilled(false);
		btnBookATrain.setBorderPainted(false);
		btnBookATrain.setFocusPainted(false);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeleteAccount.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		btnDeleteAccount.setForeground(new Color(255, 255, 255));
		btnDeleteAccount.setBounds(12, 182, 189, 25);
		panel.add(btnDeleteAccount);
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Delete().frame.setVisible(true);
			}
		});
		btnDeleteAccount.setContentAreaFilled(false);
		btnDeleteAccount.setBorderPainted(false);
		btnDeleteAccount.setFocusPainted(false);
		btnDeleteAccount.setIcon(IV);
		
		
		JButton btnUpdateDetails = new JButton("Cancelation");
		btnUpdateDetails.setHorizontalAlignment(SwingConstants.LEFT);
		btnUpdateDetails.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		btnUpdateDetails.setForeground(new Color(255, 255, 255));
		btnUpdateDetails.setBounds(12, 142, 189, 25);
		panel.add(btnUpdateDetails);
		btnUpdateDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Cancelation().frame.setVisible(true);
			}
		});
		btnUpdateDetails.setContentAreaFilled(false);
		btnUpdateDetails.setBorderPainted(false);
		btnUpdateDetails.setFocusPainted(false);
		btnUpdateDetails.setIcon(III);
		
		
		JButton btnJournies = new JButton("Journies");
		btnJournies.setHorizontalAlignment(SwingConstants.LEFT);
		btnJournies.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		btnJournies.setForeground(new Color(255, 255, 255));
		btnJournies.setBounds(12, 222, 189, 25);
		panel.add(btnJournies);
		btnJournies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
				new journey().frame.setVisible(true);
			}
		});
		btnJournies.setContentAreaFilled(false);
		btnJournies.setBorderPainted(false);
		btnJournies.setFocusPainted(false);
		btnJournies.setIcon(V);
		
		
		JButton btnTrainChart = new JButton("Train Chart");
		btnTrainChart.setHorizontalAlignment(SwingConstants.LEFT);
		btnTrainChart.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		btnTrainChart.setForeground(new Color(255, 255, 255));
		btnTrainChart.setBounds(12, 262, 189, 25);
		panel.add(btnTrainChart);
		btnTrainChart.setContentAreaFilled(false);
		btnTrainChart.setBorderPainted(false);
		btnTrainChart.setFocusPainted(false);
		btnTrainChart.setIcon(VI);
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.setHorizontalAlignment(SwingConstants.LEFT);
		btnExit.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBounds(12, 302, 189, 25);
		panel.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				new Login().frame.setVisible(true);
			}
		});
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setFocusPainted(false);
		btnExit.setIcon(VII);
		
		JLabel lblWelcome = new JLabel("Menu");
		lblWelcome.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 24));
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setBounds(65, 13, 136, 16);
		panel.add(lblWelcome);
		
		JLabel label = new JLabel("");
		label.setBounds(48, 0, 91, 51);
		frame.getContentPane().add(label);
		
		btnTrainChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
				new chart().frame.setVisible(true);
				
			}
		});
		label.setIcon(VIII);
		
		JLabel lblWelcome_1 = new JLabel("Welcome Back");
		lblWelcome_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 28));
		lblWelcome_1.setBounds(226, 57, 122, 35);
		frame.getContentPane().add(lblWelcome_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 28));
		label_1.setBounds(347, 57, 249, 35);
		frame.getContentPane().add(label_1);
		label_1.setText(l.getName());
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 250));
		panel_1.setBounds(0, 0, 608, 44);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRailwayReservationSystem = new JLabel("Railway Reservation System");
		lblRailwayReservationSystem.setFont(new Font("Tw Cen MT Condensed", Font.ITALIC, 38));
		lblRailwayReservationSystem.setBounds(235, 9, 342, 31);
		panel_1.add(lblRailwayReservationSystem);
		
		JTextArea txtrAboutUs = new JTextArea();
		txtrAboutUs.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		txtrAboutUs.setText("About us\r\nThis reservation model has 4 static tables:\r\nUser,Train,Station,Path.Each time the first\r\nreservation for a perticular date is made\r\nA table is dynamically created for the chart\r\ninfo which is deleted automatically once\r\nthe desired date passes.To search for trains\r\nwe acess path table where if both the stations\r\nare found in order, the train number is\r\nacessed and the information is taken from\r\ntrain table,station iformation is accesed from\r\nthe station table if the table is already\r\ncreated the reserved seat for any station\r\nwhich lies between both stations are loaded\r\nas unselectable.");
		txtrAboutUs.setRows(8);
		txtrAboutUs.setBounds(226, 90, 370, 405);
		frame.getContentPane().add(txtrAboutUs);
	}
}

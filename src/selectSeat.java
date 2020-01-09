import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class selectSeat implements ActionListener{

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
					selectSeat window = new selectSeat();
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
	public selectSeat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 946, 1456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JButton s1 = new JButton("");
		s1.setBounds(61, 140, 65, 45);
		frame.getContentPane().add(s1);
		s1.setContentAreaFilled(false);
		s1.setBorderPainted(false);
		s1.setFocusPainted(false); 
		s1.setIcon(I);
		s1.addActionListener((ActionListener) this);
		
		JButton s2 = new JButton("");
		s2.setBounds(127, 140, 65, 45);
		frame.getContentPane().add(s2);
		s2.setContentAreaFilled(false);
		s2.setBorderPainted(false);
		s2.setFocusPainted(false); 
		s2.setIcon(I);
		s2.addActionListener((ActionListener) this);
		
		JButton s3 = new JButton("");
		s3.setBounds(196, 140, 65, 45);
		frame.getContentPane().add(s3);
		s3.setContentAreaFilled(false);
		s3.setBorderPainted(false);
		s3.setFocusPainted(false); 
		s3.setIcon(I);
		s3.addActionListener((ActionListener) this);
		
		JButton s4 = new JButton("");
		s4.setBounds(63, 193, 65, 45);
		frame.getContentPane().add(s4);
		s4.setContentAreaFilled(false);
		s4.setBorderPainted(false);
		s4.setFocusPainted(false); 
		s4.setIcon(II);
		s4.addActionListener((ActionListener) this);
		
		JButton s5 = new JButton("");
		s5.setBounds(129, 193, 65, 45);
		frame.getContentPane().add(s5);
		s5.setContentAreaFilled(false);
		s5.setBorderPainted(false);
		s5.setFocusPainted(false); 
		s5.setIcon(II);
		s5.addActionListener((ActionListener) this);
		
		JButton s6 = new JButton("");
		s6.setBounds(198, 193, 65, 45);
		frame.getContentPane().add(s6);
		s6.setContentAreaFilled(false);
		s6.setBorderPainted(false);
		s1.setFocusPainted(false); 
		s6.setIcon(II);
		s6.addActionListener((ActionListener) this);
		
		JButton s9 = new JButton("");
		s9.setBounds(61, 244, 65, 45);
		frame.getContentPane().add(s9);
		s9.setContentAreaFilled(false);
		s9.setBorderPainted(false);
		s9.setFocusPainted(false); 
		s9.setIcon(I);
		s9.addActionListener((ActionListener) this);
		
		JButton s10 = new JButton("");
		s10.setBounds(127, 244, 65, 45);
		frame.getContentPane().add(s10);
		s10.setContentAreaFilled(false);
		s10.setBorderPainted(false);
		s10.setFocusPainted(false); 
		s10.setIcon(I);
		s10.addActionListener((ActionListener) this);
		
		JButton s11 = new JButton("");
		s11.setBounds(196, 244, 65, 45);
		frame.getContentPane().add(s11);
		s11.setContentAreaFilled(false);
		s11.setBorderPainted(false);
		s11.setFocusPainted(false); 
		s11.setIcon(I);
		s11.addActionListener((ActionListener) this);
		
		JButton s17 = new JButton("");
		s17.setBounds(61, 348, 65, 45);
		frame.getContentPane().add(s17);
		s17.setContentAreaFilled(false);
		s17.setBorderPainted(false);
		s17.setFocusPainted(false); 
		s17.setIcon(I);
		s17.addActionListener((ActionListener) this);
		
		JButton s18 = new JButton("");
		s18.setBounds(127, 348, 65, 45);
		frame.getContentPane().add(s18);
		s18.setContentAreaFilled(false);
		s18.setBorderPainted(false);
		s18.setFocusPainted(false); 
		s18.setIcon(I);
		s18.addActionListener((ActionListener) this);
		
		JButton s19 = new JButton("");
		s19.setBounds(196, 348, 65, 45);
		frame.getContentPane().add(s19);
		s19.setContentAreaFilled(false);
		s19.setBorderPainted(false);
		s19.setFocusPainted(false); 
		s19.setIcon(I);
		s19.addActionListener((ActionListener) this);
		
		JButton s14 = new JButton("");
		s14.setBounds(198, 297, 65, 45);
		frame.getContentPane().add(s14);
		s14.setContentAreaFilled(false);
		s14.setBorderPainted(false);
		s14.setFocusPainted(false); 
		s14.setIcon(II);
		s14.addActionListener((ActionListener) this);
		
		JButton s13 = new JButton("");
		s13.setBounds(129, 297, 65, 45);
		frame.getContentPane().add(s13);
		s13.setContentAreaFilled(false);
		s13.setBorderPainted(false);
		s13.setFocusPainted(false); 
		s13.setIcon(II);
		s13.addActionListener((ActionListener) this);
		
		JButton s12 = new JButton("");
		s12.setBounds(63, 297, 65, 45);
		frame.getContentPane().add(s12);
		s12.setContentAreaFilled(false);
		s12.setBorderPainted(false);
		s12.setFocusPainted(false); 
		s12.setIcon(II);
		s12.addActionListener((ActionListener) this);
		
		JButton s20 = new JButton("");
		s20.setBounds(63, 401, 65, 45);
		frame.getContentPane().add(s20);
		s20.setContentAreaFilled(false);
		s20.setBorderPainted(false);
		s20.setFocusPainted(false); 
		s20.setIcon(II);
		s20.addActionListener((ActionListener) this);
		
		JButton s21 = new JButton("");
		s21.setBounds(129, 401, 65, 45);
		frame.getContentPane().add(s21);
		s21.setContentAreaFilled(false);
		s21.setBorderPainted(false);
		s21.setFocusPainted(false); 
		s21.setIcon(II);
		s21.addActionListener((ActionListener) this);
		
		JButton s22 = new JButton("");
		s22.setBounds(198, 401, 65, 45);
		frame.getContentPane().add(s22);
		s22.setContentAreaFilled(false);
		s22.setBorderPainted(false);
		s22.setFocusPainted(false); 
		s22.setIcon(II);
		s22.addActionListener((ActionListener) this);
		
		JButton s25 = new JButton("");
		s25.setBounds(61, 453, 65, 45);
		frame.getContentPane().add(s25);
		s25.setContentAreaFilled(false);
		s25.setBorderPainted(false);
		s25.setFocusPainted(false); 
		s25.setIcon(I);
		s25.addActionListener((ActionListener) this);
		
		JButton s26 = new JButton("");
		s26.setBounds(127, 453, 65, 45);
		frame.getContentPane().add(s26);
		s26.setContentAreaFilled(false);
		s26.setBorderPainted(false);
		s26.setFocusPainted(false); 
		s26.setIcon(I);
		s26.addActionListener((ActionListener) this);
		
		JButton s27 = new JButton("");
		s27.setBounds(196, 453, 65, 45);
		frame.getContentPane().add(s27);
		s27.setContentAreaFilled(false);
		s27.setBorderPainted(false);
		s27.setFocusPainted(false); 
		s27.setIcon(I);
		s27.addActionListener((ActionListener) this);
		
		JButton s28 = new JButton("");
		s28.setBounds(63, 506, 65, 45);
		frame.getContentPane().add(s28);
		s28.setContentAreaFilled(false);
		s28.setBorderPainted(false);
		s28.setFocusPainted(false); 
		s28.setIcon(II);
		s28.addActionListener((ActionListener) this);
		
		JButton s29 = new JButton("");
		s29.setBounds(129, 506, 65, 45);
		frame.getContentPane().add(s29);
		s29.setContentAreaFilled(false);
		s29.setBorderPainted(false);
		s29.setFocusPainted(false); 
		s29.setIcon(II);
		s29.addActionListener((ActionListener) this);
		
		JButton s30 = new JButton("");
		s30.setBounds(198, 506, 65, 45);
		frame.getContentPane().add(s30);
		s30.setContentAreaFilled(false);
		s30.setBorderPainted(false);
		s30.setFocusPainted(false); 
		s30.setIcon(II);
		s30.addActionListener((ActionListener) this);
		
		JButton s33 = new JButton("");
		s33.setBounds(61, 558, 65, 45);
		frame.getContentPane().add(s33);
		s33.setContentAreaFilled(false);
		s33.setBorderPainted(false);
		s33.setFocusPainted(false); 
		s33.setIcon(I);
		s33.addActionListener((ActionListener) this);
		
		JButton s34 = new JButton("");
		s34.setBounds(127, 558, 65, 45);
		frame.getContentPane().add(s34);
		s34.setContentAreaFilled(false);
		s34.setBorderPainted(false);
		s34.setFocusPainted(false); 
		s34.setIcon(I);
		s34.addActionListener((ActionListener) this);
		
		JButton s35 = new JButton("");
		s35.setBounds(196, 558, 65, 45);
		frame.getContentPane().add(s35);
		s35.setContentAreaFilled(false);
		s35.setBorderPainted(false);
		s35.setFocusPainted(false); 
		s35.setIcon(I);
		s35.addActionListener((ActionListener) this);
		
		JButton s36 = new JButton("");
		s36.setBounds(63, 611, 65, 45);
		frame.getContentPane().add(s36);
		s36.setContentAreaFilled(false);
		s36.setBorderPainted(false);
		s36.setFocusPainted(false); 
		s36.setIcon(II);
		s36.addActionListener((ActionListener) this);
		
		JButton s37 = new JButton("");
		s37.setBounds(129, 611, 65, 45);
		frame.getContentPane().add(s37);
		s37.setContentAreaFilled(false);
		s37.setBorderPainted(false);
		s37.setFocusPainted(false); 
		s37.setIcon(II);
		s37.addActionListener((ActionListener) this);
		
		JButton s38 = new JButton("");
		s38.setBounds(198, 611, 65, 45);
		frame.getContentPane().add(s38);
		s38.setContentAreaFilled(false);
		s38.setBorderPainted(false);
		s38.setFocusPainted(false); 
		s38.setIcon(II);
		s38.addActionListener((ActionListener) this);
		
		JButton s41 = new JButton("");
		s41.setBounds(61, 664, 65, 45);
		frame.getContentPane().add(s41);
		s41.setContentAreaFilled(false);
		s41.setBorderPainted(false);
		s41.setFocusPainted(false); 
		s41.setIcon(I);
		s41.addActionListener((ActionListener) this);
		
		JButton s42 = new JButton("");
		s42.setBounds(127, 664, 65, 45);
		frame.getContentPane().add(s42);
		s42.setContentAreaFilled(false);
		s42.setBorderPainted(false);
		s42.setFocusPainted(false); 
		s42.setIcon(I);
		s42.addActionListener((ActionListener) this);
		
		JButton s43 = new JButton("");
		s43.setBounds(196, 664, 65, 45);
		frame.getContentPane().add(s43);
		s43.setContentAreaFilled(false);
		s43.setBorderPainted(false);
		s43.setFocusPainted(false); 
		s43.setIcon(I);
		s43.addActionListener((ActionListener) this);
		
		JButton s44 = new JButton("");
		s44.setBounds(63, 717, 65, 45);
		frame.getContentPane().add(s44);
		s44.setContentAreaFilled(false);
		s44.setBorderPainted(false);
		s44.setFocusPainted(false); 
		s44.setIcon(II);
		s44.addActionListener((ActionListener) this);
		
		JButton s45 = new JButton("");
		s45.setBounds(129, 717, 65, 45);
		frame.getContentPane().add(s45);
		s45.setContentAreaFilled(false);
		s45.setBorderPainted(false);
		s45.setFocusPainted(false); 
		s45.setIcon(II);
		s45.addActionListener((ActionListener) this);
		
		JButton s46 = new JButton("");
		s46.setBounds(198, 717, 65, 45);
		frame.getContentPane().add(s46);
		s46.setContentAreaFilled(false);
		s46.setBorderPainted(false);
		s46.setFocusPainted(false); 
		s46.setIcon(II);
		s46.addActionListener((ActionListener) this);
		
		JButton s49 = new JButton("");
		s49.setBounds(61, 769, 65, 45);
		frame.getContentPane().add(s49);
		s49.setContentAreaFilled(false);
		s49.setBorderPainted(false);
		s49.setFocusPainted(false); 
		s49.setIcon(I);
		s49.addActionListener((ActionListener) this);
		
		JButton s50 = new JButton("");
		s50.setBounds(127, 769, 65, 45);
		frame.getContentPane().add(s50);
		s50.setContentAreaFilled(false);
		s50.setBorderPainted(false);
		s50.setFocusPainted(false); 
		s50.setIcon(I);
		s50.addActionListener((ActionListener) this);
		
		JButton s51 = new JButton("");
		s51.setBounds(196, 769, 65, 45);
		frame.getContentPane().add(s51);
		s51.setContentAreaFilled(false);
		s51.setBorderPainted(false);
		s51.setFocusPainted(false); 
		s51.setIcon(I);
		s51.addActionListener((ActionListener) this);
		
		JButton s52 = new JButton("");
		s52.setBounds(63, 822, 65, 45);
		frame.getContentPane().add(s52);
		s52.setContentAreaFilled(false);
		s52.setIcon(II);
		s52.addActionListener((ActionListener) this);
		
		JButton s53 = new JButton("");
		s53.setBounds(129, 822, 65, 45);
		frame.getContentPane().add(s53);
		s53.setContentAreaFilled(false);
		s53.setBorderPainted(false);
		s53.setFocusPainted(false); 
		s53.setIcon(II);
		s53.addActionListener((ActionListener) this);
		
		JButton s54 = new JButton("");
		s54.setBounds(198, 822, 65, 45);
		frame.getContentPane().add(s54);
		s54.setContentAreaFilled(false);
		s54.setBorderPainted(false);
		s54.setFocusPainted(false); 
		s54.setIcon(II);
		s54.addActionListener((ActionListener) this);
		
		JButton s57 = new JButton("");
		s57.setBounds(61, 873, 65, 45);
		frame.getContentPane().add(s57);
		s57.setContentAreaFilled(false);
		s57.setBorderPainted(false);
		s57.setFocusPainted(false); 
		s57.setIcon(I);
		s57.addActionListener((ActionListener) this);
		
		JButton s58 = new JButton("");
		s58.setBounds(127, 873, 65, 45);
		frame.getContentPane().add(s58);
		s58.setContentAreaFilled(false);
		s58.setBorderPainted(false);
		s58.setFocusPainted(false); 
		s58.setIcon(I);
		s58.addActionListener((ActionListener) this);
		
		JButton s59 = new JButton("");
		s59.setBounds(196, 873, 65, 45);
		frame.getContentPane().add(s59);
		s59.setContentAreaFilled(false);
		s59.setIcon(I);
		s59.addActionListener((ActionListener) this);
		
		JButton s60 = new JButton("");
		s60.setBounds(63, 926, 65, 45);
		frame.getContentPane().add(s60);
		s60.setContentAreaFilled(false);
		s60.setBorderPainted(false);
		s60.setFocusPainted(false); 
		s60.setIcon(II);
		s60.addActionListener((ActionListener) this);
		
		JButton s61 = new JButton("");
		s61.setBounds(129, 926, 65, 45);
		frame.getContentPane().add(s61);
		s61.setContentAreaFilled(false);
		s61.setBorderPainted(false);
		s61.setFocusPainted(false); 
		s61.setIcon(II);
		s61.addActionListener((ActionListener) this);
		
		JButton s62 = new JButton("");
		s62.setBounds(198, 926, 65, 45);
		frame.getContentPane().add(s62);
		s62.setContentAreaFilled(false);
		s62.setBorderPainted(false);
		s62.setFocusPainted(false); 
		s62.setIcon(II);
		s62.addActionListener((ActionListener) this);
		
		JButton s7 = new JButton("");
		s7.setBounds(340, 140, 65, 45);
		frame.getContentPane().add(s7);
		s7.setContentAreaFilled(false);
		s7.setBorderPainted(false);
		s7.setFocusPainted(false); 
		s7.setIcon(I);
		s7.addActionListener((ActionListener) this);
		
		JButton s8 = new JButton("");
		s8.setBounds(343, 193, 65, 45);
		frame.getContentPane().add(s8);
		s8.setContentAreaFilled(false);
		s8.setBorderPainted(false);
		s8.setFocusPainted(false); 
		s8.setIcon(II);
		s8.addActionListener((ActionListener) this);
		
		JButton s15 = new JButton("");
		s15.setBounds(340, 244, 65, 45);
		frame.getContentPane().add(s15);
		s15.setContentAreaFilled(false);
		s15.setBorderPainted(false);
		s15.setFocusPainted(false); 
		s15.setIcon(I);
		s15.addActionListener((ActionListener) this);
		
		JButton s16 = new JButton("");
		s16.setBounds(343, 297, 65, 45);
		frame.getContentPane().add(s16);
		s16.setContentAreaFilled(false);
		s16.setBorderPainted(false);
		s16.setFocusPainted(false); 
		s16.setIcon(II);
		s16.addActionListener((ActionListener) this);
		
		JButton s31 = new JButton("");
		s31.setBounds(340, 452, 65, 45);
		frame.getContentPane().add(s31);
		s31.setContentAreaFilled(false);
		s31.setBorderPainted(false);
		s31.setFocusPainted(false); 
		s31.setIcon(I);
		s31.addActionListener((ActionListener) this);
		
		JButton s32 = new JButton("");
		s32.setBounds(343, 505, 65, 45);
		frame.getContentPane().add(s32);
		s32.setContentAreaFilled(false);
		s32.setBorderPainted(false);
		s32.setFocusPainted(false); 
		s32.setIcon(II);
		s32.addActionListener((ActionListener) this);
		
		JButton s23 = new JButton("");
		s23.setBounds(340, 348, 65, 45);
		frame.getContentPane().add(s23);
		s23.setContentAreaFilled(false);
		s23.setBorderPainted(false);
		s23.setFocusPainted(false); 
		s23.setIcon(I);
		s23.addActionListener((ActionListener) this);
		
		JButton s24 = new JButton("");
		s24.setBounds(343, 401, 65, 45);
		frame.getContentPane().add(s24);
		s24.setContentAreaFilled(false);
		s24.setBorderPainted(false);
		s24.setFocusPainted(false); 
		s24.setIcon(II);
		s24.addActionListener((ActionListener) this);
		
		JButton s47 = new JButton("");
		s47.setBounds(340, 662, 65, 45);
		frame.getContentPane().add(s47);
		s47.setContentAreaFilled(false);
		s47.setBorderPainted(false);
		s47.setFocusPainted(false); 
		s47.setIcon(I);
		s47.addActionListener((ActionListener) this);
		
		JButton s48 = new JButton("");
		s48.setBounds(343, 715, 65, 45);
		frame.getContentPane().add(s48);
		s48.setContentAreaFilled(false);
		s48.setBorderPainted(false);
		s48.setFocusPainted(false); 
		s48.setIcon(II);
		s48.addActionListener((ActionListener) this);
		
		JButton s39 = new JButton("");
		s39.setBounds(340, 558, 65, 45);
		frame.getContentPane().add(s39);
		s39.setContentAreaFilled(false);
		s39.setIcon(I);
		s39.addActionListener((ActionListener) this);
		
		JButton s40 = new JButton("");
		s40.setBounds(343, 611, 65, 45);
		frame.getContentPane().add(s40);
		s40.setContentAreaFilled(false);
		s40.setBorderPainted(false);
		s40.setFocusPainted(false); 
		s40.setIcon(II);
		s40.addActionListener((ActionListener) this);
		
		JButton s63 = new JButton("");
		s63.setBounds(340, 873, 65, 45);
		frame.getContentPane().add(s63);
		s63.setContentAreaFilled(false);
		s63.setBorderPainted(false);
		s63.setFocusPainted(false); 
		s63.setIcon(I);
		s63.addActionListener((ActionListener) this);
		
		JButton s64 = new JButton("");
		s64.setBounds(343, 926, 65, 45);
		frame.getContentPane().add(s64);
		s64.setContentAreaFilled(false);
		s64.setBorderPainted(false);
		s64.setFocusPainted(false); 
		s64.setIcon(II);
		s64.addActionListener((ActionListener) this);
		
		JButton s55 = new JButton("");
		s55.setBounds(340, 769, 65, 45);
		frame.getContentPane().add(s55);
		s55.setContentAreaFilled(false);
		s55.setBorderPainted(false);
		s55.setFocusPainted(false); 
		s55.setIcon(I);
		s55.addActionListener((ActionListener) this);
		
		JButton s56 = new JButton("");
		s56.setBounds(343, 822, 65, 45);
		frame.getContentPane().add(s56);
		s56.setContentAreaFilled(false);
		s56.setBorderPainted(false);
		s56.setFocusPainted(false); 
		s56.setIcon(II);
		s56.addActionListener((ActionListener) this);
		
		JLabel label = new JLabel("1");
		label.setBounds(91, 137, 16, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("2");
		label_1.setBounds(156, 137, 16, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("3");
		label_2.setBounds(225, 137, 16, 16);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("4");
		label_3.setBounds(91, 224, 16, 16);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("5");
		label_4.setBounds(157, 224, 16, 16);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("6");
		label_5.setBounds(226, 224, 16, 16);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("9");
		label_6.setBounds(91, 241, 16, 16);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("10");
		label_7.setBounds(153, 241, 16, 16);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("11");
		label_8.setBounds(222, 241, 16, 16);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("12");
		label_9.setBounds(87, 328, 16, 16);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("13");
		label_10.setBounds(153, 328, 16, 16);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("14");
		label_11.setBounds(222, 328, 16, 16);
		frame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("17");
		label_12.setBounds(87, 345, 16, 16);
		frame.getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("18");
		label_13.setBounds(153, 345, 16, 16);
		frame.getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("19");
		label_14.setBounds(222, 345, 16, 16);
		frame.getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("20");
		label_15.setBounds(87, 432, 16, 16);
		frame.getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("21");
		label_16.setBounds(153, 432, 16, 16);
		frame.getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel("22");
		label_17.setBounds(222, 432, 16, 16);
		frame.getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("25");
		label_18.setBounds(87, 450, 16, 16);
		frame.getContentPane().add(label_18);
		
		JLabel label_19 = new JLabel("26");
		label_19.setBounds(153, 450, 16, 16);
		frame.getContentPane().add(label_19);
		
		JLabel label_20 = new JLabel("27");
		label_20.setBounds(222, 450, 16, 16);
		frame.getContentPane().add(label_20);
		
		JLabel label_21 = new JLabel("28");
		label_21.setBounds(87, 537, 16, 16);
		frame.getContentPane().add(label_21);
		
		JLabel label_22 = new JLabel("29");
		label_22.setBounds(153, 537, 16, 16);
		frame.getContentPane().add(label_22);
		
		JLabel label_23 = new JLabel("30");
		label_23.setBounds(222, 537, 16, 16);
		frame.getContentPane().add(label_23);
		
		JLabel label_24 = new JLabel("33");
		label_24.setBounds(87, 555, 16, 16);
		frame.getContentPane().add(label_24);
		
		JLabel label_25 = new JLabel("34");
		label_25.setBounds(153, 555, 16, 16);
		frame.getContentPane().add(label_25);
		
		JLabel label_26 = new JLabel("35");
		label_26.setBounds(222, 555, 16, 16);
		frame.getContentPane().add(label_26);
		
		JLabel label_27 = new JLabel("36");
		label_27.setBounds(87, 642, 16, 16);
		frame.getContentPane().add(label_27);
		
		JLabel label_28 = new JLabel("37");
		label_28.setBounds(153, 642, 16, 16);
		frame.getContentPane().add(label_28);
		
		JLabel label_29 = new JLabel("38");
		label_29.setBounds(222, 642, 16, 16);
		frame.getContentPane().add(label_29);
		
		JLabel label_30 = new JLabel("41");
		label_30.setBounds(87, 661, 16, 16);
		frame.getContentPane().add(label_30);
		
		JLabel label_31 = new JLabel("42");
		label_31.setBounds(153, 661, 16, 16);
		frame.getContentPane().add(label_31);
		
		JLabel label_32 = new JLabel("43");
		label_32.setBounds(222, 661, 16, 16);
		frame.getContentPane().add(label_32);
		
		JLabel label_33 = new JLabel("44");
		label_33.setBounds(87, 748, 16, 16);
		frame.getContentPane().add(label_33);
		
		JLabel label_34 = new JLabel("45");
		label_34.setBounds(153, 748, 16, 16);
		frame.getContentPane().add(label_34);
		
		JLabel label_35 = new JLabel("46");
		label_35.setBounds(222, 748, 16, 16);
		frame.getContentPane().add(label_35);
		
		JLabel label_36 = new JLabel("49");
		label_36.setBounds(87, 766, 16, 16);
		frame.getContentPane().add(label_36);
		
		JLabel label_37 = new JLabel("50");
		label_37.setBounds(153, 766, 16, 16);
		frame.getContentPane().add(label_37);
		
		JLabel label_38 = new JLabel("51");
		label_38.setBounds(222, 766, 16, 16);
		frame.getContentPane().add(label_38);
		
		JLabel label_39 = new JLabel("52");
		label_39.setBounds(87, 853, 16, 16);
		frame.getContentPane().add(label_39);
		
		JLabel label_40 = new JLabel("53");
		label_40.setBounds(153, 853, 16, 16);
		frame.getContentPane().add(label_40);
		
		JLabel label_41 = new JLabel("54");
		label_41.setBounds(222, 853, 16, 16);
		frame.getContentPane().add(label_41);
		
		JLabel label_42 = new JLabel("57");
		label_42.setBounds(87, 870, 16, 16);
		frame.getContentPane().add(label_42);
		
		JLabel label_43 = new JLabel("58");
		label_43.setBounds(153, 870, 16, 16);
		frame.getContentPane().add(label_43);
		
		JLabel label_44 = new JLabel("59");
		label_44.setBounds(222, 870, 16, 16);
		frame.getContentPane().add(label_44);
		
		JLabel label_45 = new JLabel("60");
		label_45.setBounds(87, 957, 16, 16);
		frame.getContentPane().add(label_45);
		
		JLabel label_46 = new JLabel("61");
		label_46.setBounds(153, 957, 16, 16);
		frame.getContentPane().add(label_46);
		
		JLabel label_47 = new JLabel("62");
		label_47.setBounds(222, 957, 16, 16);
		frame.getContentPane().add(label_47);
		
		JLabel label_48 = new JLabel("7");
		label_48.setBounds(370, 137, 16, 16);
		frame.getContentPane().add(label_48);
		
		JLabel label_49 = new JLabel("8");
		label_49.setBounds(370, 224, 16, 16);
		frame.getContentPane().add(label_49);
		
		JLabel label_50 = new JLabel("15");
		label_50.setBounds(366, 241, 16, 16);
		frame.getContentPane().add(label_50);
		
		JLabel label_51 = new JLabel("16");
		label_51.setBounds(366, 328, 16, 16);
		frame.getContentPane().add(label_51);
		
		JLabel label_52 = new JLabel("23");
		label_52.setBounds(366, 345, 16, 16);
		frame.getContentPane().add(label_52);
		
		JLabel label_53 = new JLabel("24");
		label_53.setBounds(366, 432, 16, 16);
		frame.getContentPane().add(label_53);
		
		JLabel label_54 = new JLabel("31");
		label_54.setBounds(366, 450, 16, 16);
		frame.getContentPane().add(label_54);
		
		JLabel label_55 = new JLabel("32");
		label_55.setBounds(366, 537, 16, 16);
		frame.getContentPane().add(label_55);
		
		JLabel label_56 = new JLabel("39");
		label_56.setBounds(366, 555, 16, 16);
		frame.getContentPane().add(label_56);
		
		JLabel label_57 = new JLabel("40");
		label_57.setBounds(366, 642, 16, 16);
		frame.getContentPane().add(label_57);
		
		JLabel label_58 = new JLabel("47");
		label_58.setBounds(366, 661, 16, 16);
		frame.getContentPane().add(label_58);
		
		JLabel label_59 = new JLabel("48");
		label_59.setBounds(366, 748, 16, 16);
		frame.getContentPane().add(label_59);
		
		JLabel label_60 = new JLabel("55");
		label_60.setBounds(366, 766, 16, 16);
		frame.getContentPane().add(label_60);
		
		JLabel label_61 = new JLabel("56");
		label_61.setBounds(366, 853, 16, 16);
		frame.getContentPane().add(label_61);
		
		JLabel label_62 = new JLabel("63");
		label_62.setBounds(366, 870, 16, 16);
		frame.getContentPane().add(label_62);
		
		JLabel label_63 = new JLabel("64");
		label_63.setBounds(366, 957, 16, 16);
		frame.getContentPane().add(label_63);
		
		JLabel Tcoach = new JLabel("");
		Tcoach.setBounds(521, 182, 198, 29);
		frame.getContentPane().add(Tcoach);
		
		JLabel label_64 = new JLabel("Boarding Date & Time");
		label_64.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 21));
		label_64.setBounds(479, 365, 158, 25);
		frame.getContentPane().add(label_64);
		
		JLabel label_65 = new JLabel("Boarding Station");
		label_65.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 21));
		label_65.setBounds(479, 330, 158, 26);
		frame.getContentPane().add(label_65);
		
		JLabel label_66 = new JLabel("Name");
		label_66.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 21));
		label_66.setBounds(479, 295, 158, 16);
		frame.getContentPane().add(label_66);
		
		JLabel label_67 = new JLabel("Number");
		label_67.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 21));
		label_67.setBounds(479, 260, 158, 16);
		frame.getContentPane().add(label_67);
		
		JLabel Tname = new JLabel((String) null);
		Tname.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 21));
		Tname.setBounds(637, 295, 236, 16);
		frame.getContentPane().add(Tname);
		
		JLabel bdate = new JLabel("null null");
		bdate.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 21));
		bdate.setBounds(637, 365, 236, 16);
		frame.getContentPane().add(bdate);
		
		JLabel bstation = new JLabel((String) null);
		bstation.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 21));
		bstation.setBounds(637, 330, 236, 16);
		frame.getContentPane().add(bstation);
		
		JLabel tnumber = new JLabel((String) null);
		tnumber.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 21));
		tnumber.setBounds(637, 260, 236, 16);
		frame.getContentPane().add(tnumber);
		
		JLabel dstation = new JLabel("Destination Station");
		dstation.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 21));
		dstation.setBounds(637, 400, 236, 16);
		frame.getContentPane().add(dstation);
		
		JLabel lblDestinationStation = new JLabel("Destination Station");
		lblDestinationStation.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 21));
		lblDestinationStation.setBounds(479, 400, 158, 16);
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
		arr[22]=s23;
		arr[23]=s24;
		arr[24]=s25;
		arr[25]=s26;
		arr[26]=s27;
		arr[27]=s28;
		arr[28]=s29;
		arr[29]=s30;
		arr[30]=s31;
		arr[31]=s32;
		arr[32]=s33;
		arr[33]=s34;
		arr[34]=s35;
		arr[35]=s36;
		arr[36]=s37;
		arr[37]=s38;
		arr[38]=s39;
		arr[39]=s40;
		arr[40]=s41;
		arr[41]=s42;
		arr[42]=s43;
		arr[43]=s44;
		arr[44]=s45;
		arr[45]=s46;
		arr[46]=s47;
		arr[47]=s48;
		arr[48]=s49;
		arr[49]=s50;
		arr[50]=s51;
		arr[51]=s52;
		arr[52]=s53;
		arr[53]=s54;
		arr[54]=s55;
		arr[55]=s56;
		arr[56]=s57;
		arr[57]=s58;
		arr[58]=s59;
		arr[59]=s60;
		arr[60]=s61;
		arr[61]=s62;
		arr[62]=s63;
		arr[63]=s64;
		
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
			btnBook.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 21));
			btnBook.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					for(int i=0;i<64;i++) 
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
								
							}
							catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}  
						}
					}
					frame.setVisible(false);
    				new NameBook().frame.setVisible(true);
				}
			});
			btnBook.setBounds(493, 467, 97, 25);
			frame.getContentPane().add(btnBook);
			
			JButton btnBack = new JButton("Back");
			btnBack.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 21));
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					new Booktrain().frame.setVisible(true);
				}
			});
			btnBack.setBounds(645, 467, 97, 25);
			frame.getContentPane().add(btnBack);
			
			JPanel panel = new JPanel();
			panel.setForeground(new Color(255, 250, 250));
			panel.setBackground(new Color(255, 250, 250));
			panel.setBounds(38, 104, 379, 916);
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblRacLayout = new JLabel("RAC-3 Layout");
			lblRacLayout.setForeground(new Color(192, 192, 192));
			lblRacLayout.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 31));
			lblRacLayout.setHorizontalAlignment(SwingConstants.CENTER);
			lblRacLayout.setBounds(0, 8, 379, 25);
			panel.add(lblRacLayout);
			
			JLabel lblAisle = new JLabel("A");
			lblAisle.setHorizontalAlignment(SwingConstants.CENTER);
			lblAisle.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 74));
			lblAisle.setForeground(new Color(211, 211, 211));
			lblAisle.setBounds(230, 229, 67, 81);
			panel.add(lblAisle);
			
			JLabel lblI = new JLabel("I");
			lblI.setHorizontalAlignment(SwingConstants.CENTER);
			lblI.setForeground(new Color(211, 211, 211));
			lblI.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 74));
			lblI.setBounds(230, 319, 67, 81);
			panel.add(lblI);
			
			JLabel lblS = new JLabel("S");
			lblS.setHorizontalAlignment(SwingConstants.CENTER);
			lblS.setForeground(new Color(211, 211, 211));
			lblS.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 74));
			lblS.setBounds(230, 409, 67, 81);
			panel.add(lblS);
			
			JLabel lblL = new JLabel("L");
			lblL.setHorizontalAlignment(SwingConstants.CENTER);
			lblL.setForeground(new Color(211, 211, 211));
			lblL.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 74));
			lblL.setBounds(230, 499, 67, 81);
			panel.add(lblL);
			
			JLabel lblE = new JLabel("E");
			lblE.setHorizontalAlignment(SwingConstants.CENTER);
			lblE.setForeground(new Color(211, 211, 211));
			lblE.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 74));
			lblE.setBounds(230, 589, 67, 81);
			panel.add(lblE);
			
			JLabel label_68 = new JLabel("");
			label_68.setHorizontalAlignment(SwingConstants.CENTER);
			label_68.setBounds(220, 68, 88, 159);
			panel.add(label_68);
			label_68.setIcon(u);
			
			JLabel label_69 = new JLabel("");
			label_69.setHorizontalAlignment(SwingConstants.CENTER);
			label_69.setBounds(231, 696, 66, 128);
			panel.add(label_69);
			label_69.setIcon(d);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 250, 250));
			panel_1.setBounds(441, 224, 359, 230);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(255, 255, 240));
			panel_2.setBounds(0, 27, 928, 45);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblBookYourSeats = new JLabel("Book Your Seats");
			lblBookYourSeats.setHorizontalAlignment(SwingConstants.CENTER);
			lblBookYourSeats.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 36));
			lblBookYourSeats.setBounds(0, 0, 928, 45);
			panel_2.add(lblBookYourSeats);
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

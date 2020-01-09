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

public class selectSeatCC implements ActionListener {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectSeatCC window = new selectSeatCC();
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
	public selectSeatCC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 1021);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton s1 = new JButton("");
		s1.setBounds(61, 50, 65, 45);
		frame.getContentPane().add(s1);
		s1.setContentAreaFilled(false);
		s1.setBorderPainted(false);
		s1.setFocusPainted(false); 
		s1.setIcon(I);
		s1.addActionListener((ActionListener) this);
		
		JButton s2 = new JButton("");
		s2.setBounds(127, 50, 65, 45);
		frame.getContentPane().add(s2);
		s2.setContentAreaFilled(false);
		s2.setBorderPainted(false);
		s2.setFocusPainted(false); 
		s2.setIcon(I);
		s2.addActionListener((ActionListener) this);
		
		JButton s5 = new JButton("");
		s5.setBounds(63, 108, 65, 45);
		frame.getContentPane().add(s5);
		s5.setContentAreaFilled(false);
		s5.setBorderPainted(false);
		s5.setFocusPainted(false); 
		s5.setIcon(II);
		s5.addActionListener((ActionListener) this);
		
		JButton s6 = new JButton("");
		s6.setBounds(129, 108, 65, 45);
		frame.getContentPane().add(s6);
		s6.setContentAreaFilled(false);
		s6.setBorderPainted(false);
		s6.setFocusPainted(false); 
		s6.setIcon(II);
		s6.addActionListener((ActionListener) this);
		
		JButton s3 = new JButton("");
		s3.setBounds(319, 50, 65, 45);
		frame.getContentPane().add(s3);
		s3.setContentAreaFilled(false);
		s3.setBorderPainted(false);
		s3.setFocusPainted(false); 
		s3.setIcon(I);
		s3.addActionListener((ActionListener) this);
		
		JButton s8 = new JButton("");
		s8.setBounds(321, 108, 65, 45);
		frame.getContentPane().add(s8);
		s8.setContentAreaFilled(false);
		s8.setBorderPainted(false);
		s8.setFocusPainted(false); 
		s8.setIcon(II);
		s8.addActionListener((ActionListener) this);
		
		JButton s10 = new JButton("");
		s10.setBounds(61, 154, 65, 45);
		frame.getContentPane().add(s10);
		s10.setContentAreaFilled(false);
		s10.setBorderPainted(false);
		s10.setFocusPainted(false); 
		s10.setIcon(I);
		s10.addActionListener((ActionListener) this);
		
		JButton s11 = new JButton("");
		s11.setBounds(127, 154, 65, 45);
		frame.getContentPane().add(s11);
		s11.setContentAreaFilled(false);
		s11.setBorderPainted(false);
		s11.setFocusPainted(false); 
		s11.setIcon(I);
		s11.addActionListener((ActionListener) this);
		
		JButton s15 = new JButton("");
		s15.setBounds(63, 212, 65, 45);
		frame.getContentPane().add(s15);
		s15.setContentAreaFilled(false);
		s15.setBorderPainted(false);
		s15.setFocusPainted(false); 
		s15.setIcon(II);
		s15.addActionListener((ActionListener) this);
		
		JButton s16 = new JButton("");
		s16.setBounds(129, 212, 65, 45);
		frame.getContentPane().add(s16);
		s16.setContentAreaFilled(false);
		s16.setBorderPainted(false);
		s16.setFocusPainted(false); 
		s16.setIcon(II);
		s16.addActionListener((ActionListener) this);
		
		JButton s13 = new JButton("");
		s13.setBounds(319, 154, 65, 45);
		frame.getContentPane().add(s13);
		s13.setContentAreaFilled(false);
		s13.setBorderPainted(false);
		s13.setFocusPainted(false); 
		s13.setIcon(I);
		s13.addActionListener((ActionListener) this);
		
		JButton s18 = new JButton("");
		s18.setBounds(321, 212, 65, 45);
		frame.getContentPane().add(s18);
		s18.setContentAreaFilled(false);
		s18.setBorderPainted(false);
		s18.setFocusPainted(false); 
		s18.setIcon(II);
		s18.addActionListener((ActionListener) this);
		
		JButton s20 = new JButton("");
		s20.setBounds(61, 258, 65, 45);
		frame.getContentPane().add(s20);
		s20.setContentAreaFilled(false);
		s20.setBorderPainted(false);
		s20.setFocusPainted(false); 
		s20.setIcon(I);
		s20.addActionListener((ActionListener) this);
		
		JButton s21 = new JButton("");
		s21.setBounds(127, 258, 65, 45);
		frame.getContentPane().add(s21);
		s21.setContentAreaFilled(false);
		s21.setBorderPainted(false);
		s21.setFocusPainted(false); 
		s21.setIcon(I);
		s21.addActionListener((ActionListener) this);
		
		JButton s25 = new JButton("");
		s25.setBounds(63, 316, 65, 45);
		frame.getContentPane().add(s25);
		s25.setContentAreaFilled(false);
		s25.setBorderPainted(false);
		s25.setFocusPainted(false); 
		s25.setIcon(II);
		s25.addActionListener((ActionListener) this);
		
		JButton s26 = new JButton("");
		s26.setBounds(129, 316, 65, 45);
		frame.getContentPane().add(s26);
		s26.setContentAreaFilled(false);
		s26.setBorderPainted(false);
		s26.setFocusPainted(false); 
		s26.setIcon(II);
		s26.addActionListener((ActionListener) this);
		
		JButton s23 = new JButton("");
		s23.setBounds(319, 258, 65, 45);
		frame.getContentPane().add(s23);
		s23.setContentAreaFilled(false);
		s23.setBorderPainted(false);
		s23.setFocusPainted(false); 
		s23.setIcon(I);
		s23.addActionListener((ActionListener) this);
		
		JButton s28 = new JButton("");
		s28.setBounds(321, 316, 65, 45);
		frame.getContentPane().add(s28);
		s28.setContentAreaFilled(false);
		s28.setBorderPainted(false);
		s28.setFocusPainted(false); 
		s28.setIcon(II);
		s28.addActionListener((ActionListener) this);
		
		JButton s30 = new JButton("");
		s30.setBounds(61, 363, 65, 45);
		frame.getContentPane().add(s30);
		s30.setContentAreaFilled(false);
		s30.setBorderPainted(false);
		s30.setFocusPainted(false); 
		s30.setIcon(I);
		s30.addActionListener((ActionListener) this);
		
		JButton s31 = new JButton("");
		s31.setBounds(127, 363, 65, 45);
		frame.getContentPane().add(s31);
		s31.setContentAreaFilled(false);
		s31.setBorderPainted(false);
		s31.setFocusPainted(false); 
		s31.setIcon(I);
		s31.addActionListener((ActionListener) this);
		
		JButton s35 = new JButton("");
		s35.setBounds(63, 421, 65, 45);
		frame.getContentPane().add(s35);
		s35.setContentAreaFilled(false);
		s35.setBorderPainted(false);
		s35.setFocusPainted(false); 
		s35.setIcon(II);
		s35.addActionListener((ActionListener) this);
		
		JButton s36 = new JButton("");
		s36.setBounds(129, 421, 65, 45);
		frame.getContentPane().add(s36);
		s36.setContentAreaFilled(false);
		s36.setBorderPainted(false);
		s36.setFocusPainted(false); 
		s36.setIcon(II);
		s36.addActionListener((ActionListener) this);
		
		JButton s33 = new JButton("");
		s33.setBounds(319, 363, 65, 45);
		frame.getContentPane().add(s33);
		s33.setContentAreaFilled(false);
		s33.setBorderPainted(false);
		s33.setFocusPainted(false); 
		s33.setIcon(I);
		s33.addActionListener((ActionListener) this);
		
		JButton s38 = new JButton("");
		s38.setBounds(321, 421, 65, 45);
		frame.getContentPane().add(s38);
		s38.setContentAreaFilled(false);
		s38.setBorderPainted(false);
		s38.setFocusPainted(false); 
		s38.setIcon(II);
		s38.addActionListener((ActionListener) this);
		
		JButton s40 = new JButton("");
		s40.setBounds(61, 468, 65, 45);
		frame.getContentPane().add(s40);
		s40.setContentAreaFilled(false);
		s40.setBorderPainted(false);
		s40.setFocusPainted(false); 
		s40.setIcon(I);
		s40.addActionListener((ActionListener) this);
		
		JButton s41 = new JButton("");
		s41.setBounds(127, 468, 65, 45);
		frame.getContentPane().add(s41);
		s41.setContentAreaFilled(false);
		s41.setBorderPainted(false);
		s41.setFocusPainted(false); 
		s41.setIcon(I);
		s41.addActionListener((ActionListener) this);
		
		JButton s45 = new JButton("");
		s45.setBounds(63, 526, 65, 45);
		frame.getContentPane().add(s45);
		s45.setContentAreaFilled(false);
		s45.setBorderPainted(false);
		s45.setFocusPainted(false); 
		s45.setIcon(II);
		s45.addActionListener((ActionListener) this);
		
		JButton s46 = new JButton("");
		s46.setBounds(129, 526, 65, 45);
		frame.getContentPane().add(s46);
		s46.setContentAreaFilled(false);
		s46.setBorderPainted(false);
		s46.setFocusPainted(false); 
		s46.setIcon(II);
		s46.addActionListener((ActionListener) this);
		
		JButton s43 = new JButton("");
		s43.setBounds(319, 468, 65, 45);
		frame.getContentPane().add(s43);
		s43.setContentAreaFilled(false);
		s43.setBorderPainted(false);
		s43.setFocusPainted(false); 
		s43.setIcon(I);
		s43.addActionListener((ActionListener) this);
		
		JButton s48 = new JButton("");
		s48.setBounds(321, 526, 65, 45);
		frame.getContentPane().add(s48);
		s48.setContentAreaFilled(false);
		s48.setBorderPainted(false);
		s48.setFocusPainted(false); 
		s48.setIcon(II);
		s48.addActionListener((ActionListener) this);
		
		JButton s50 = new JButton("");
		s50.setBounds(61, 574, 65, 45);
		frame.getContentPane().add(s50);
		s50.setContentAreaFilled(false);
		s50.setBorderPainted(false);
		s50.setFocusPainted(false); 
		s50.setIcon(I);
		s50.addActionListener((ActionListener) this);
		
		JButton s51 = new JButton("");
		s51.setBounds(127, 574, 65, 45);
		frame.getContentPane().add(s51);
		s51.setContentAreaFilled(false);
		s51.setBorderPainted(false);
		s51.setFocusPainted(false); 
		s51.setIcon(I);
		s51.addActionListener((ActionListener) this);
		
		JButton s55 = new JButton("");
		s55.setBounds(63, 632, 65, 45);
		frame.getContentPane().add(s55);
		s55.setContentAreaFilled(false);
		s55.setBorderPainted(false);
		s55.setFocusPainted(false); 
		s55.setIcon(II);
		s55.addActionListener((ActionListener) this);
		
		JButton s56 = new JButton("");
		s56.setBounds(129, 632, 65, 45);
		frame.getContentPane().add(s56);
		s56.setContentAreaFilled(false);
		s56.setBorderPainted(false);
		s56.setFocusPainted(false); 
		s56.setIcon(II);
		s56.addActionListener((ActionListener) this);
		
		JButton s53 = new JButton("");
		s53.setBounds(319, 574, 65, 45);
		frame.getContentPane().add(s53);
		s53.setContentAreaFilled(false);
		s53.setBorderPainted(false);
		s53.setFocusPainted(false); 
		s53.setIcon(I);
		s53.addActionListener((ActionListener) this);
		
		JButton s58 = new JButton("");
		s58.setBounds(321, 632, 65, 45);
		frame.getContentPane().add(s58);
		s58.setContentAreaFilled(false);
		s58.setBorderPainted(false);
		s58.setFocusPainted(false); 
		s58.setIcon(II);
		s58.addActionListener((ActionListener) this);
		
		JButton s60 = new JButton("");
		s60.setBounds(61, 679, 65, 45);
		frame.getContentPane().add(s60);
		s60.setContentAreaFilled(false);
		s60.setBorderPainted(false);
		s60.setFocusPainted(false); 
		s60.setIcon(I);
		s60.addActionListener((ActionListener) this);
		
		JButton s61 = new JButton("");
		s61.setBounds(127, 679, 65, 45);
		frame.getContentPane().add(s61);
		s61.setContentAreaFilled(false);
		s61.setBorderPainted(false);
		s61.setFocusPainted(false); 
		s61.setIcon(I);
		s61.addActionListener((ActionListener) this);
		
		JButton s65 = new JButton("");
		s65.setBounds(63, 737, 65, 45);
		frame.getContentPane().add(s65);
		s65.setContentAreaFilled(false);
		s65.setIcon(II);
		s65.addActionListener((ActionListener) this);
		
		JButton s66 = new JButton("");
		s66.setBounds(129, 737, 65, 45);
		frame.getContentPane().add(s66);
		s66.setContentAreaFilled(false);
		s66.setBorderPainted(false);
		s66.setFocusPainted(false); 
		s66.setIcon(II);
		s66.addActionListener((ActionListener) this);
		
		JButton s63 = new JButton("");
		s63.setBounds(319, 679, 65, 45);
		frame.getContentPane().add(s63);
		s63.setContentAreaFilled(false);
		s63.setBorderPainted(false);
		s63.setFocusPainted(false); 
		s63.setIcon(I);
		s63.addActionListener((ActionListener) this);
		
		JButton s68 = new JButton("");
		s68.setBounds(321, 737, 65, 45);
		frame.getContentPane().add(s68);
		s68.setContentAreaFilled(false);
		s68.setBorderPainted(false);
		s68.setFocusPainted(false); 
		s68.setIcon(II);
		s68.addActionListener((ActionListener) this);
		
		JButton s70 = new JButton("");
		s70.setBounds(61, 783, 65, 45);
		frame.getContentPane().add(s70);
		s70.setContentAreaFilled(false);
		s70.setBorderPainted(false);
		s70.setFocusPainted(false); 
		s70.setIcon(I);
		s70.addActionListener((ActionListener) this);
		
		JButton s71 = new JButton("");
		s71.setBounds(127, 783, 65, 45);
		frame.getContentPane().add(s71);
		s71.setContentAreaFilled(false);
		s71.setBorderPainted(false);
		s71.setFocusPainted(false); 
		s71.setIcon(I);
		s71.addActionListener((ActionListener) this);
		
		JButton s75 = new JButton("");
		s75.setBounds(63, 841, 65, 45);
		frame.getContentPane().add(s75);
		s75.setContentAreaFilled(false);
		s75.setBorderPainted(false);
		s75.setFocusPainted(false); 
		s75.setIcon(II);
		s75.addActionListener((ActionListener) this);
		
		JButton s76 = new JButton("");
		s76.setBounds(129, 841, 65, 45);
		frame.getContentPane().add(s76);
		s76.setContentAreaFilled(false);
		s76.setBorderPainted(false);
		s76.setFocusPainted(false); 
		s76.setIcon(II);
		s76.addActionListener((ActionListener) this);
		
		JButton s73 = new JButton("");
		s73.setBounds(319, 783, 65, 45);
		frame.getContentPane().add(s73);
		s73.setContentAreaFilled(false);
		s73.setIcon(I);
		s73.addActionListener((ActionListener) this);
		
		JButton s77 = new JButton("");
		s77.setBounds(321, 841, 65, 45);
		frame.getContentPane().add(s77);
		s77.setContentAreaFilled(false);
		s77.setBorderPainted(false);
		s77.setFocusPainted(false); 
		s77.setIcon(II);
		s77.addActionListener((ActionListener) this);
		
		JLabel label = new JLabel("1");
		label.setBounds(91, 50, 16, 16);
		frame.getContentPane().add(label);
		
		
		JLabel label_1 = new JLabel("2");
		label_1.setBounds(156, 50, 16, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("3");
		label_2.setBounds(348, 50, 16, 16);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("5");
		label_3.setBounds(91, 137, 16, 16);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("6");
		label_4.setBounds(157, 137, 16, 16);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("8");
		label_5.setBounds(349, 137, 16, 16);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("10");
		label_6.setBounds(91, 154, 16, 16);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("11");
		label_7.setBounds(156, 154, 16, 16);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("13");
		label_8.setBounds(345, 154, 16, 16);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("15");
		label_9.setBounds(90, 241, 16, 16);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("16");
		label_10.setBounds(153, 241, 16, 16);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("18");
		label_11.setBounds(345, 241, 16, 16);
		frame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("20");
		label_12.setBounds(87, 258, 16, 16);
		frame.getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("21");
		label_13.setBounds(153, 258, 16, 16);
		frame.getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("23");
		label_14.setBounds(345, 258, 16, 16);
		frame.getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("25");
		label_15.setBounds(87, 345, 16, 16);
		frame.getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("26");
		label_16.setBounds(153, 345, 16, 16);
		frame.getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel("28");
		label_17.setBounds(345, 345, 16, 16);
		frame.getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("30");
		label_18.setBounds(87, 363, 16, 16);
		frame.getContentPane().add(label_18);
		
		JLabel label_19 = new JLabel("31");
		label_19.setBounds(153, 363, 16, 16);
		frame.getContentPane().add(label_19);
		
		JLabel label_20 = new JLabel("33");
		label_20.setBounds(345, 363, 16, 16);
		frame.getContentPane().add(label_20);
		
		JLabel label_21 = new JLabel("35");
		label_21.setBounds(87, 450, 16, 16);
		frame.getContentPane().add(label_21);
		
		JLabel label_22 = new JLabel("36");
		label_22.setBounds(153, 450, 16, 16);
		frame.getContentPane().add(label_22);
		
		JLabel label_23 = new JLabel("38");
		label_23.setBounds(345, 450, 16, 16);
		frame.getContentPane().add(label_23);
		
		JLabel label_24 = new JLabel("40");
		label_24.setBounds(87, 468, 16, 16);
		frame.getContentPane().add(label_24);
		
		JLabel label_25 = new JLabel("41");
		label_25.setBounds(153, 468, 16, 16);
		frame.getContentPane().add(label_25);
		
		JLabel label_26 = new JLabel("43");
		label_26.setBounds(345, 468, 16, 16);
		frame.getContentPane().add(label_26);
		
		JLabel label_27 = new JLabel("45");
		label_27.setBounds(87, 555, 16, 16);
		frame.getContentPane().add(label_27);
		
		JLabel label_28 = new JLabel("46");
		label_28.setBounds(153, 555, 16, 16);
		frame.getContentPane().add(label_28);
		
		JLabel label_29 = new JLabel("48");
		label_29.setBounds(345, 555, 16, 16);
		frame.getContentPane().add(label_29);
		
		JLabel label_30 = new JLabel("50");
		label_30.setBounds(87, 574, 16, 16);
		frame.getContentPane().add(label_30);
		
		JLabel label_31 = new JLabel("51");
		label_31.setBounds(153, 574, 16, 16);
		frame.getContentPane().add(label_31);
		
		JLabel label_32 = new JLabel("53");
		label_32.setBounds(345, 574, 16, 16);
		frame.getContentPane().add(label_32);
		
		JLabel label_33 = new JLabel("55");
		label_33.setBounds(87, 661, 16, 16);
		frame.getContentPane().add(label_33);
		
		JLabel label_34 = new JLabel("56");
		label_34.setBounds(153, 661, 16, 16);
		frame.getContentPane().add(label_34);
		
		JLabel label_35 = new JLabel("58");
		label_35.setBounds(345, 661, 16, 16);
		frame.getContentPane().add(label_35);
		
		JLabel label_36 = new JLabel("60");
		label_36.setBounds(87, 679, 16, 16);
		frame.getContentPane().add(label_36);
		
		JLabel label_37 = new JLabel("61");
		label_37.setBounds(153, 679, 16, 16);
		frame.getContentPane().add(label_37);
		
		JLabel label_38 = new JLabel("63");
		label_38.setBounds(345, 679, 16, 16);
		frame.getContentPane().add(label_38);
		
		JLabel label_39 = new JLabel("65");
		label_39.setBounds(87, 766, 16, 16);
		frame.getContentPane().add(label_39);
		
		JLabel label_40 = new JLabel("66");
		label_40.setBounds(153, 766, 16, 16);
		frame.getContentPane().add(label_40);
		
		JLabel label_41 = new JLabel("68");
		label_41.setBounds(345, 766, 16, 16);
		frame.getContentPane().add(label_41);
		
		JLabel label_42 = new JLabel("70");
		label_42.setBounds(87, 783, 16, 16);
		frame.getContentPane().add(label_42);
		
		JLabel label_43 = new JLabel("71");
		label_43.setToolTipText("");
		label_43.setBounds(153, 783, 16, 16);
		frame.getContentPane().add(label_43);
		
		JLabel label_44 = new JLabel("73");
		label_44.setBounds(345, 783, 16, 16);
		frame.getContentPane().add(label_44);
		
		JLabel label_45 = new JLabel("75");
		label_45.setBounds(87, 870, 16, 16);
		frame.getContentPane().add(label_45);
		
		JLabel label_46 = new JLabel("76");
		label_46.setBounds(153, 870, 16, 16);
		frame.getContentPane().add(label_46);
		
		JLabel label_63 = new JLabel("77");
		label_63.setBounds(345, 870, 16, 16);
		frame.getContentPane().add(label_63);
		
		JButton s4 = new JButton("");
		s4.setFocusPainted(false);
		s4.setContentAreaFilled(false);
		s4.setBorderPainted(false);
		s4.setBounds(396, 50, 65, 45);
		frame.getContentPane().add(s4);
		s4.setIcon(I);
		s4.addActionListener((ActionListener) this);
		
		JButton s9 = new JButton("");
		s9.setContentAreaFilled(false);
		s9.setBorderPainted(false);
		s9.setBounds(398, 108, 65, 45);
		frame.getContentPane().add(s9);
		s9.setIcon(II);
		s9.addActionListener((ActionListener) this);
		
		JButton s14 = new JButton("");
		s14.setFocusPainted(false);
		s14.setContentAreaFilled(false);
		s14.setBorderPainted(false);
		s14.setBounds(396, 154, 65, 45);
		frame.getContentPane().add(s14);
		s14.setIcon(I);
		s14.addActionListener((ActionListener) this);
		
		JButton s19 = new JButton("");
		s19.setFocusPainted(false);
		s19.setContentAreaFilled(false);
		s19.setBorderPainted(false);
		s19.setBounds(398, 212, 65, 45);
		frame.getContentPane().add(s19);
		s19.setIcon(II);
		s19.addActionListener((ActionListener) this);
		
		JButton s24 = new JButton("");
		s24.setFocusPainted(false);
		s24.setContentAreaFilled(false);
		s24.setBorderPainted(false);
		s24.setBounds(396, 258, 65, 45);
		frame.getContentPane().add(s24);
		s24.setIcon(I);
		s24.addActionListener((ActionListener) this);
		
		JButton s29 = new JButton("");
		s29.setFocusPainted(false);
		s29.setContentAreaFilled(false);
		s29.setBorderPainted(false);
		s29.setBounds(398, 316, 65, 45);
		frame.getContentPane().add(s29);
		s29.setIcon(II);
		s29.addActionListener((ActionListener) this);
		
		JButton s34 = new JButton("");
		s34.setFocusPainted(false);
		s34.setContentAreaFilled(false);
		s34.setBorderPainted(false);
		s34.setBounds(396, 363, 65, 45);
		frame.getContentPane().add(s34);
		s34.setIcon(I);
		s34.addActionListener((ActionListener) this);
		
		JButton s39 = new JButton("");
		s39.setFocusPainted(false);
		s39.setContentAreaFilled(false);
		s39.setBorderPainted(false);
		s39.setBounds(398, 421, 65, 45);
		frame.getContentPane().add(s39);
		s39.setIcon(II);
		s39.addActionListener((ActionListener) this);
		
		JButton s44 = new JButton("");
		s44.setFocusPainted(false);
		s44.setContentAreaFilled(false);
		s44.setBorderPainted(false);
		s44.setBounds(396, 468, 65, 45);
		frame.getContentPane().add(s44);
		s44.setIcon(I);
		s44.addActionListener((ActionListener) this);
		
		JButton s49 = new JButton("");
		s49.setFocusPainted(false);
		s49.setContentAreaFilled(false);
		s49.setBorderPainted(false);
		s49.setBounds(398, 526, 65, 45);
		frame.getContentPane().add(s49);
		s49.setIcon(II);
		s49.addActionListener((ActionListener) this);
		
		JButton s54 = new JButton("");
		s54.setFocusPainted(false);
		s54.setContentAreaFilled(false);
		s54.setBorderPainted(false);
		s54.setBounds(396, 574, 65, 45);
		frame.getContentPane().add(s54);
		s54.setIcon(I);
		s54.addActionListener((ActionListener) this);
		
		JButton s59 = new JButton("");
		s59.setFocusPainted(false);
		s59.setContentAreaFilled(false);
		s59.setBorderPainted(false);
		s59.setBounds(398, 632, 65, 45);
		frame.getContentPane().add(s59);
		s59.setIcon(II);
		s59.addActionListener((ActionListener) this);
		
		JButton s64 = new JButton("");
		s64.setFocusPainted(false);
		s64.setContentAreaFilled(false);
		s64.setBorderPainted(false);
		s64.setBounds(396, 679, 65, 45);
		frame.getContentPane().add(s64);
		s64.setIcon(I);
		s64.addActionListener((ActionListener) this);
		
		JButton s69 = new JButton("");
		s69.setFocusPainted(false);
		s69.setContentAreaFilled(false);
		s69.setBorderPainted(false);
		s69.setBounds(398, 737, 65, 45);
		frame.getContentPane().add(s69);
		s69.setIcon(II);
		s69.addActionListener((ActionListener) this);
		
		JButton s74 = new JButton("");
		s74.setContentAreaFilled(false);
		s74.setBounds(396, 783, 65, 45);
		frame.getContentPane().add(s74);
		s74.setIcon(I);
		s74.addActionListener((ActionListener) this);
		
		JButton s78 = new JButton("");
		s78.setFocusPainted(false);
		s78.setContentAreaFilled(false);
		s78.setBorderPainted(false);
		s78.setBounds(398, 841, 65, 45);
		frame.getContentPane().add(s78);
		s78.setIcon(II);
		s78.addActionListener((ActionListener) this);
		
		JLabel label_47 = new JLabel("4");
		label_47.setBounds(425, 50, 16, 16);
		frame.getContentPane().add(label_47);
		
		JLabel label_48 = new JLabel("9");
		label_48.setBounds(426, 137, 16, 16);
		frame.getContentPane().add(label_48);
		
		JLabel label_49 = new JLabel("14");
		label_49.setBounds(422, 154, 16, 16);
		frame.getContentPane().add(label_49);
		
		JLabel label_50 = new JLabel("19");
		label_50.setBounds(422, 241, 16, 16);
		frame.getContentPane().add(label_50);
		
		JLabel label_51 = new JLabel("24");
		label_51.setBounds(422, 258, 16, 16);
		frame.getContentPane().add(label_51);
		
		JLabel label_52 = new JLabel("29");
		label_52.setBounds(422, 345, 16, 16);
		frame.getContentPane().add(label_52);
		
		JLabel label_53 = new JLabel("34");
		label_53.setBounds(422, 363, 16, 16);
		frame.getContentPane().add(label_53);
		
		JLabel label_54 = new JLabel("39");
		label_54.setBounds(422, 450, 16, 16);
		frame.getContentPane().add(label_54);
		
		JLabel label_55 = new JLabel("44");
		label_55.setBounds(422, 468, 16, 16);
		frame.getContentPane().add(label_55);
		
		JLabel label_56 = new JLabel("49");
		label_56.setBounds(422, 555, 16, 16);
		frame.getContentPane().add(label_56);
		
		JLabel label_57 = new JLabel("54");
		label_57.setBounds(422, 574, 16, 16);
		frame.getContentPane().add(label_57);
		
		JLabel label_58 = new JLabel("59");
		label_58.setBounds(422, 661, 16, 16);
		frame.getContentPane().add(label_58);
		
		JLabel label_59 = new JLabel("64");
		label_59.setBounds(422, 679, 16, 16);
		frame.getContentPane().add(label_59);
		
		JLabel label_60 = new JLabel("69");
		label_60.setBounds(422, 766, 16, 16);
		frame.getContentPane().add(label_60);
		
		JLabel label_61 = new JLabel("74");
		label_61.setBounds(422, 783, 16, 16);
		frame.getContentPane().add(label_61);
		
		JLabel label_62 = new JLabel("78");
		label_62.setBounds(422, 870, 16, 16);
		frame.getContentPane().add(label_62);
		
		JButton s7 = new JButton("");
		s7.setContentAreaFilled(false);
		s7.setBorderPainted(false);
		s7.setBounds(184, 108, 65, 45);
		frame.getContentPane().add(s7);
		s7.setIcon(II);
		s7.addActionListener((ActionListener) this);
		
		JButton s12 = new JButton("");
		s12.setFocusPainted(false);
		s12.setContentAreaFilled(false);
		s12.setBorderPainted(false);
		s12.setBounds(182, 154, 65, 45);
		frame.getContentPane().add(s12);
		s12.setIcon(I);
		s12.addActionListener((ActionListener) this);
		
		JButton s17 = new JButton("");
		s17.setFocusPainted(false);
		s17.setContentAreaFilled(false);
		s17.setBorderPainted(false);
		s17.setBounds(184, 212, 65, 45);
		frame.getContentPane().add(s17);
		s17.setIcon(II);
		s17.addActionListener((ActionListener) this);
		
		JButton s22 = new JButton("");
		s22.setFocusPainted(false);
		s22.setContentAreaFilled(false);
		s22.setBorderPainted(false);
		s22.setBounds(182, 258, 65, 45);
		frame.getContentPane().add(s22);
		s22.setIcon(I);
		s22.addActionListener((ActionListener) this);
		
		JButton s27 = new JButton("");
		s27.setFocusPainted(false);
		s27.setContentAreaFilled(false);
		s27.setBorderPainted(false);
		s27.setBounds(184, 316, 65, 45);
		frame.getContentPane().add(s27);
		s27.setIcon(II);
		s27.addActionListener((ActionListener) this);
		
		JButton s32 = new JButton("");
		s32.setFocusPainted(false);
		s32.setContentAreaFilled(false);
		s32.setBorderPainted(false);
		s32.setBounds(182, 363, 65, 45);
		frame.getContentPane().add(s32);
		s32.setIcon(I);
		s32.addActionListener((ActionListener) this);
		
		JButton s37 = new JButton("");
		s37.setFocusPainted(false);
		s37.setContentAreaFilled(false);
		s37.setBorderPainted(false);
		s37.setBounds(184, 421, 65, 45);
		frame.getContentPane().add(s37);
		s37.setIcon(II);
		s37.addActionListener((ActionListener) this);
		
		JButton s42 = new JButton("");
		s42.setFocusPainted(false);
		s42.setContentAreaFilled(false);
		s42.setBorderPainted(false);
		s42.setBounds(182, 468, 65, 45);
		frame.getContentPane().add(s42);
		s42.setIcon(I);
		s42.addActionListener((ActionListener) this);
		
		JButton s47 = new JButton("");
		s47.setFocusPainted(false);
		s47.setContentAreaFilled(false);
		s47.setBorderPainted(false);
		s47.setBounds(184, 526, 65, 45);
		frame.getContentPane().add(s47);
		s47.setIcon(II);
		s47.addActionListener((ActionListener) this);
		
		JButton s52 = new JButton("");
		s52.setFocusPainted(false);
		s52.setContentAreaFilled(false);
		s52.setBorderPainted(false);
		s52.setBounds(182, 574, 65, 45);
		frame.getContentPane().add(s52);
		s52.setIcon(I);
		s52.addActionListener((ActionListener) this);
		
		JButton s57 = new JButton("");
		s57.setFocusPainted(false);
		s57.setContentAreaFilled(false);
		s57.setBorderPainted(false);
		s57.setBounds(184, 632, 65, 45);
		frame.getContentPane().add(s57);
		s57.setIcon(II);
		s57.addActionListener((ActionListener) this);
		
		JButton s62 = new JButton("");
		s62.setFocusPainted(false);
		s62.setContentAreaFilled(false);
		s62.setBorderPainted(false);
		s62.setBounds(182, 679, 65, 45);
		frame.getContentPane().add(s62);
		s62.setIcon(I);
		s62.addActionListener((ActionListener) this);
		
		JButton s67 = new JButton("");
		s67.setFocusPainted(false);
		s67.setContentAreaFilled(false);
		s67.setBorderPainted(false);
		s67.setBounds(184, 737, 65, 45);
		frame.getContentPane().add(s67);
		s67.setIcon(II);
		s67.addActionListener((ActionListener) this);
		
		JButton s72 = new JButton("");
		s72.setContentAreaFilled(false);
		s72.setBounds(182, 783, 65, 45);
		frame.getContentPane().add(s72);
		s72.setIcon(I);
		s72.addActionListener((ActionListener) this);
		
		JLabel label_65 = new JLabel("7");
		label_65.setBounds(212, 137, 16, 16);
		frame.getContentPane().add(label_65);
		
		JLabel label_66 = new JLabel("12");
		label_66.setBounds(208, 154, 16, 16);
		frame.getContentPane().add(label_66);
		
		JLabel label_67 = new JLabel("17");
		label_67.setBounds(208, 241, 16, 16);
		frame.getContentPane().add(label_67);
		
		JLabel label_68 = new JLabel("22");
		label_68.setBounds(208, 258, 16, 16);
		frame.getContentPane().add(label_68);
		
		JLabel label_69 = new JLabel("27");
		label_69.setBounds(208, 345, 16, 16);
		frame.getContentPane().add(label_69);
		
		JLabel label_70 = new JLabel("32");
		label_70.setBounds(208, 363, 16, 16);
		frame.getContentPane().add(label_70);
		
		JLabel label_71 = new JLabel("37");
		label_71.setBounds(208, 450, 16, 16);
		frame.getContentPane().add(label_71);
		
		JLabel label_72 = new JLabel("42");
		label_72.setBounds(208, 468, 16, 16);
		frame.getContentPane().add(label_72);
		
		JLabel label_73 = new JLabel("47");
		label_73.setBounds(208, 555, 16, 16);
		frame.getContentPane().add(label_73);
		
		JLabel label_74 = new JLabel("52");
		label_74.setBounds(208, 574, 16, 16);
		frame.getContentPane().add(label_74);
		
		JLabel label_75 = new JLabel("57");
		label_75.setBounds(208, 661, 16, 16);
		frame.getContentPane().add(label_75);
		
		JLabel label_76 = new JLabel("62");
		label_76.setBounds(208, 679, 16, 16);
		frame.getContentPane().add(label_76);
		
		JLabel label_77 = new JLabel("67");
		label_77.setBounds(208, 766, 16, 16);
		frame.getContentPane().add(label_77);
		
		JLabel label_78 = new JLabel("72");
		label_78.setBounds(208, 783, 16, 16);
		frame.getContentPane().add(label_78);
		
		JLabel Tcoach = new JLabel("");
		Tcoach.setBounds(479, 50, 198, 29);
		frame.getContentPane().add(Tcoach);
		
		JLabel label_64 = new JLabel("Boarding Date & Time");
		label_64.setBounds(479, 191, 139, 16);
		frame.getContentPane().add(label_64);
		
		JLabel label_90 = new JLabel("Boarding Station");
		label_90.setBounds(479, 162, 104, 16);
		frame.getContentPane().add(label_90);
		
		JLabel label_91 = new JLabel("Name");
		label_91.setBounds(479, 133, 56, 16);
		frame.getContentPane().add(label_91);
		
		JLabel label_92 = new JLabel("Number");
		label_92.setBounds(479, 104, 56, 16);
		frame.getContentPane().add(label_92);
		
		JLabel Tname = new JLabel((String) null);
		Tname.setBounds(641, 137, 139, 16);
		frame.getContentPane().add(Tname);
		
		JLabel bdate = new JLabel("null null");
		bdate.setBounds(649, 191, 189, 16);
		frame.getContentPane().add(bdate);
		
		JLabel bstation = new JLabel((String) null);
		bstation.setBounds(649, 162, 189, 16);
		frame.getContentPane().add(bstation);
		
		JLabel tnumber = new JLabel((String) null);
		tnumber.setBounds(649, 104, 56, 16);
		frame.getContentPane().add(tnumber);
		
		JLabel dstation = new JLabel("Destination Station");
		dstation.setBounds(619, 229, 118, 16);
		frame.getContentPane().add(dstation);
		
		JLabel lblDestinationStation = new JLabel("Destination Station");
		lblDestinationStation.setBounds(489, 229, 118, 16);
		frame.getContentPane().add(lblDestinationStation);
		
		JButton arr[]=new JButton[78];
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
		arr[64]=s65;
		arr[65]=s66;
		arr[66]=s67;
		arr[67]=s68;
		arr[68]=s69;
		arr[69]=s70;
		arr[70]=s71;
		arr[71]=s72;
		arr[72]=s73;
		arr[73]=s74;
		arr[74]=s75;
		arr[75]=s76;
		arr[76]=s77;
		arr[77]=s78;
		
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
			btnBook.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					for(int i=0;i<78;i++) 
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
			btnBook.setBounds(489, 294, 97, 25);
			frame.getContentPane().add(btnBook);
			
			JButton Back = new JButton("Back");
			Back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					new Booktrain().frame.setVisible(true);
				}
			});
			Back.setBounds(619, 294, 97, 25);
			frame.getContentPane().add(Back);
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

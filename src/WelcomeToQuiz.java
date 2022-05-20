import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.Subject;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class WelcomeToQuiz extends LoginForm {
	// DATA MEMBERS 
	JLabel header,subject_HL,subject_DLD,subject_OS,subject_MATH;
	JButton HL,DLD,OS,Mathematics;
	JPanel p1;
	JLabel logo;
	ImageIcon logopic;
	
	//MEMEORY ALLOCATION
	WelcomeToQuiz(){
		header = new JLabel();
		HL = new JButton();
		DLD = new JButton();
		OS = new JButton();
		Mathematics = new JButton();
		subject_HL = new JLabel();
		subject_DLD = new JLabel();
		subject_OS = new JLabel();
		subject_MATH = new JLabel();
		p1 = new JPanel();
		
		logo = new JLabel();
		logopic = new ImageIcon("D:\\Quiz Management System\\picture\\pic1.png");
}
	
	// welcome to quiz where you select your subject
	public  void  open() {
		
		add(p1);
		p1.setBounds(0,0,70,70);
		p1.setLayout(null);
		p1.add(logo);
		logo.setIcon(logopic);
		logo.setBounds(0, 0, 70, 70);
		
		header.setText("Welcome to Quiz");
		header.setBounds(170, 5, 300, 100);
		header.setFont(new Font("Arial",Font.BOLD,30));
		add(header);
		
		ImageIcon j = new ImageIcon("D:\\Quiz Management System\\picture\\Java-icon.png");
		HL.setIcon(j);
		HL.setBounds(140,120,120,120);
		add(HL);
		
		subject_HL.setText("JAVA");
		subject_HL.setBounds(165,235,50,50);
		subject_HL.setFont(new Font("Arial",Font.BOLD,20));
		add(subject_HL);
		
		
		ImageIcon d = new ImageIcon("D:\\Quiz Management System\\picture\\dld.png");
		DLD.setIcon(d);
		DLD.setBackground(Color.white);
		DLD.setBounds(330,120,120,120);
		add(DLD);
		DLD.setBackground(Color.white);
		 
	
		subject_DLD.setText("DLD");
		subject_DLD.setBounds(365,235,50,50);
		subject_DLD.setFont(new Font("Arial",Font.BOLD,20));
		add(subject_DLD);
		
		ImageIcon o = new ImageIcon("D:\\Quiz Management System\\picture\\window.png");
		OS.setIcon(o);
		OS.setBounds(140,300,120,120);
		add(OS);
        
		subject_OS.setText("OS");
		subject_OS.setBounds(170,415,50,50);
		subject_OS.setFont(new Font("Arial",Font.BOLD,20));
		add(subject_OS);
		
		ImageIcon pic = new ImageIcon("D:\\Quiz Management System\\picture\\math.png");
		Mathematics.setIcon(pic);
		Mathematics.setBounds(330,300,120,120);
		add(Mathematics);
		Mathematics.setBackground(Color.white);
		
		subject_MATH.setText("Math");
		subject_MATH.setBounds(365,415,50,50);
		subject_MATH.setFont(new Font("Arial",Font.BOLD,20));
		add(subject_MATH);
	}
	
	//Action perform after choosing
	public void HLaction() {
		HL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JavaQuiz j1 = new JavaQuiz();
				j1.frame(600,550,360,120);
				j1.logo();
				j1.Q1("1. Who invented Java Programming?");
				j1.option1("Guido van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup");
				j1.Q2("2. Which one of the following is not an access modifier");
				j1.option2("Protected", "Void","Public","Private");
				j1.answer();
			
			}
		});
	}
	public void DLDaction() {
		DLD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DLD_Page1 d1 = new DLD_Page1();
				d1.frame(600,550,360,120);
				d1.logo();
				d1.Q1("1. BCD to 7 segment is");
				d1.option1("Decoder", "Encoder", "Multiplexer", "Demultiplexer");
				d1.Q2("2. One that is a universal gate");
				d1.option2("AND", "NAND","OR","NOT");
				d1.answer();
			
			}
		});
	}
	public void OSaction() {
		OS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"No Question Availabe Right Now", "OS",JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
		public void Mathaction() {
			Mathematics.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null,"No Question Availabe Right Now", "Math",JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
	public static void main(String[] args) {


}
}

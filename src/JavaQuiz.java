import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.border.Border;

public class JavaQuiz extends LoginForm{
	//Data Member of Quiz
	JPanel p1,p2,p3,p4;
	JButton btn1,btn2;
	JLabel l1,l2,l3;
	JRadioButton r1,r2,r3,r4,r5,r6,r7,r8;
	ButtonGroup Radiobutton_group1,Radiobutton_group2;
	static int marks = 0;

	JavaQuiz(){
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		
		btn1 = new JButton("Submit");
		btn2 = new JButton();
		
		l1 = new JLabel();
		l2 = new JLabel();
		l3 = new JLabel();
		
		
		r1= new JRadioButton();
		r2= new JRadioButton()
				;
		r3= new JRadioButton();
		r4= new JRadioButton();
		r5= new JRadioButton();
		r6= new JRadioButton();
		r7= new JRadioButton();
		r8= new JRadioButton();
		
		Radiobutton_group1 = new ButtonGroup();
		Radiobutton_group2 = new ButtonGroup();
		
	}
	public void logo() {
		add(p4);
		p4.setBounds(250,0, 70, 70);
		ImageIcon im = new ImageIcon("C:\\Users\\samsung\\Downloads\\javaIcon.png");
		l3.setIcon(im);
		p4.add(l3);
	}
	public void Q1(String a) {
		add(p1);
		p1.setBackground(null);
		p1.setLayout(null);
		p1.setBounds(0, 50,450, 200);
		p1.add(l1);
		l1.setText(a);
		l1.setBounds(20,40,440,30);
	
}
	public void option1(String op1,String op2,String op3,String op4) {
		r1.setText(op1);
		r2.setText(op2);
		r3.setText(op3);
		r4.setText(op4);
		
		p1.add(r1);
		p1.add(r2);
		p1.add(r3);
		p1.add(r4);
		r1.setBounds(30,70, 160, 40);
		r2.setBounds(30,100, 160, 40);
		r3.setBounds(30,130, 160, 40);
		r4.setBounds(30,160, 160, 40);
		
		Radiobutton_group1.add(r1);
		Radiobutton_group1.add(r2);
		Radiobutton_group1.add(r3);
		Radiobutton_group1.add(r4);
		
	}
	public void Q2(String b) {
		
		
		add(p2); 
		p2.setBackground(null);
		p2.setLayout(null);
		p2.setBounds(0, 251,450, 200);
		p2.add(l2);
		l2.setText(b);
		l2.setBounds(20,40,400,30);
		
}
	public void option2(String op1,String op2,String op3,String op4) {
		r5.setText(op1);
		r6.setText(op2);
		r7.setText(op3);
		r8.setText(op4);
		
		p2.add(r5);
		p2.add(r6);
		p2.add(r7);
		p2.add(r8);
		r5.setBounds(30,70, 150, 40);
		r6.setBounds(30,100, 150, 40);
		r7.setBounds(30,130, 150, 40);
		r8.setBounds(30,160, 150, 40);
		
		Radiobutton_group2.add(r5);
		Radiobutton_group2.add(r6);
		Radiobutton_group2.add(r7);
		Radiobutton_group2.add(r8);
		
	}
	public void warning() {
		JOptionPane.showMessageDialog(null,"select radiobutton", "title",JOptionPane.INFORMATION_MESSAGE);
	}
	public void answer() {
		add(p3);
		p3.setBackground(Color.green);
		p3.setLayout(null);
		p3.setBounds(410,470,100,30);
		p3.add(btn1);
		btn1.setBounds(0,0,100,30);
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Radiobutton_group1.isSelected(null) || Radiobutton_group2.isSelected(null)) {
					warning();
				}
				else {
				if(r2.isSelected() == true) {
					marks++;
					if(r6.isSelected() == true) {
						marks++;
					}
				}
				else if(r2.isSelected() == true) {
					marks++;
				}
				else if(r6.isSelected() == true) {
					marks++;
				}
				question2 q2 = new question2();
				q2.frame(600,550,360,120);
				
				q2.logo();
				q2.Q1("3. Which exception is thrown when java is out of memory" );
				q2.option1("MemoryError", "OutOfMemoryError", "MemoryOutOfBoundsException","MemoryFullException");
				q2.Q2("4. What is the extension of compiled java classes");
				q2.option2(".txt" ,".js",".class", ".java");
				q2.answer();
				dispose();
			}
			}
		});
	}
		
}
	
    

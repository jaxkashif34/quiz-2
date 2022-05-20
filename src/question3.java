import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class question3 extends JavaQuiz {
	

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
				else{
				if(r3.isSelected() == true) {
					marks++;
					if(r6.isSelected() == true) {
						marks++;
					}
				}
				else if(r3.isSelected() == true) {
					marks++;
				}
				else if(r6.isSelected() == true) {
					marks++;
				}
				question4 q4 = new question4();
				q4.logo();
				q4.frame(600,550,360,120);
				q4.Q1("7. On which platforms Java runs");
				q4.option1("Windows" , "Mac OS" , "UNIX", "All of these");
				q4.Q2("8. Number of primitive data types in Java are");
				q4.option2("6","7", "8", "9");
				q4.answer();
				dispose();
			}
			}
		});
}
}

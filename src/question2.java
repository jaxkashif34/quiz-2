import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class question2 extends JavaQuiz {
	
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
					if(r8.isSelected() == true) {
						marks++;
					}
				}
				else if(r2.isSelected() == true) {
					marks++;
				}
				else if(r8.isSelected() == true) {
					marks++;
				}
				question3 q3 = new question3();
				q3.frame(600,550,360,120);
				q3.logo();
				q3.Q1("5. Which component is used to compile, debug and execute the java programs");
				q3.option1("JRE",  "JIT",  "JDK", "JVM");
				q3.Q2("6.  Which one of the following is not a Java feature");
				q3.option2("Object-oriented", "Use of pointers","Portable","Dynamic and Extensible");
				q3.answer();
				dispose();
				}
			}
		});
	}

}

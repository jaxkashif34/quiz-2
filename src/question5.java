import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class question5 extends JavaQuiz {
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
				ImageIcon ic  =new ImageIcon();
				if(Radiobutton_group1.isSelected(null)  || Radiobutton_group2.isSelected(null)) {
					warning();
				}
				else {
				if(r1.isSelected() == true) {
					marks++;
					if(r5.isSelected() == true) {
						marks++;
					}
				}
				else if(r1.isSelected() == true) {
					marks++;
				}
				else if(r5.isSelected() == true) {
					marks++;
				}
				String Value = "";
				if(marks <=10 && marks>=8) {
					Value = "(Excellent)";
					ic = new ImageIcon("C:\\Users\\samsung\\Downloads\\icons8-exam-64.png");
				}
				else if(marks<=7 && marks>=5) {
					Value = "(Good)";
					ic = new ImageIcon("C:\\Users\\samsung\\Downloads\\icons8-ok-48.png");
				}
				else {
					Value = "(BAD)";
					ic = new ImageIcon("C:\\Users\\samsung\\Downloads\\icons8-emoji-64.png");
				}
				
				JOptionPane.showMessageDialog(null,"you got "+marks+" marks "+Value, "Java",JOptionPane.INFORMATION_MESSAGE,ic);
				marks = 0;
				dispose();
			}
			}
		});

}

}

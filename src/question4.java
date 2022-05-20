import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class question4 extends JavaQuiz {

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
				if(r4.isSelected() == true) {
					marks++;
					if(r7.isSelected() == true) {
						marks++;
					}
				}
				else if(r4.isSelected() == true) {
					marks++;
				}
				else if(r7.isSelected() == true) {
					marks++;
				}
				question5 q5 = new question5();
				q5.frame(600,550,360,120);
				q5.logo();
				q5.frame(600,550,360,120);
				q5.Q1("9. Which of these have highest precedence");
				q5.option1("()", "++", "*", ">>");
				q5.Q2("10. Java language was initially called as ________");
				q5.option2("Oak", "Sumatra","J++", "Pine");
				q5.answer();
				dispose();
			}
			}
		});

}
}

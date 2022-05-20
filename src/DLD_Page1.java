import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DLD_Page1 extends JavaQuiz {
	public void logo() {
		add(p4);
		p4.setBounds(250,0, 80, 80);
		ImageIcon im = new ImageIcon("C:\\Users\\samsung\\Downloads\\circuit6.png");
		l3.setIcon(im);
		p4.add(l3);
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
				else{
				{
				if(r1.isSelected() == true) {
					marks++;
					if(r6.isSelected() == true) {
						marks++;
					}
				}
				else if(r1.isSelected() == true) {
					marks++;
				}
				else if(r6.isSelected() == true) {
					marks++;
				}
				DLD_Page2 d2 = new DLD_Page2();
				d2.logo();
				d2.frame(600,550,360,120);
				d2.Q1("3. 3x8 decoder will have");
				d2.option1("4inputs", "3inputs", "5inputs", "6inputs");
				d2.Q2("4. Adding 1001 and 0010 gives output of");
				d2.option2("1011", "1111", "0", "1010");
				d2.answer();
				dispose();
			}
			}
			}
		});

}
}

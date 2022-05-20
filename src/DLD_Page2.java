import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DLD_Page2 extends DLD_Page1 {
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
				if(r2.isSelected() == true) {
					marks++;
					if(r5.isSelected() == true) {
						marks++;
					}
				}
				else if(r3.isSelected() == true) {
					marks++;
				}
				else if(r2.isSelected() == true) {
					marks++;
				}
				
				JOptionPane.showMessageDialog(null,"you got "+marks+" marks", "DLD",JOptionPane.INFORMATION_MESSAGE);
				marks = 0;
				dispose();
				
			}
			}
				
			}
		});

}
}

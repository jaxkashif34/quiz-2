import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.sql.PreparedStatement;

public class Registration extends LoginForm {
	// DATA MEMBERS OF REGISTRATION CLASS
	
	JLabel fullname,Gender,Reg;
	JTextField Tfullname;
	JButton btn1;
	JPanel panel1,panel2,panel3;
	JLabel icon;
	JRadioButton radio_male,radio_female;
	
	ButtonGroup btngroup_gender;
	JTextField Gender_Text;
	// CONSTRUCTOR TO ALLOCATE MEMORY
	
	Registration(){
		// LABELS
		fullname = new JLabel();
		Reg = new JLabel();
     	//TEXTFIELD
		Tfullname = new JTextField();
		
		btn1 = new JButton();
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		Gender = new JLabel();
		icon = new JLabel();
		
		radio_male = new JRadioButton();
		radio_female = new JRadioButton();
		
		btngroup_gender = new ButtonGroup();
		
		Gender_Text = new JTextField();
	}

	public void Design_Registration() {
		add(panel1);
		panel1.setLayout(null);
		panel1.setBounds(160, 10, 160, 80);
		panel1.setBackground(null);		
		panel1.add(icon);
		
		ImageIcon regicon = new ImageIcon("C:\\Users\\samsung\\Downloads\\register.png");
		icon.setIcon(regicon);
		icon.setBounds(12,-20, 128, 128);
		panel1.add(icon);
		
		add(panel2);
		panel2.setBounds(150,100,400,300);
		panel2.setBackground(null);
		
		panel2.setLayout(null);
		fullname.setText("Full Name");
		panel2.add(fullname);
		fullname.setBounds(5, 5, 100, 30);
		fullname.setOpaque(true);
		panel2.add(Tfullname);
		Tfullname.setBounds(5, 35, 200, 30);
		
		username.setText("Username");
		panel2.add(username);
		username.setBounds(5, 70, 100, 30);
		username.setOpaque(true);
		panel2.add(Tusername);
		Tusername.setBounds(5, 100, 200, 30);
		
		password.setText("Password");
		panel2.add(password);
		password.setBounds(5, 135, 100, 30);
		password.setOpaque(true);
		panel2.add(Tpassword);
		Tpassword.setBounds(5, 165, 200, 30);
		
		Gender.setText("Gender");
		panel2.add(Gender);
		Gender.setBounds(5, 200, 100, 30);
		Gender.setOpaque(true);
		
		radio_male.setText("Male");
		radio_male.setBounds(40, 250, 70, 20);
		panel2.add(radio_male);
		
		radio_female.setText("Female");
		radio_female.setBounds(120, 250, 70, 20);
		panel2.add(radio_female);
		
		btngroup_gender.add(radio_male);
		btngroup_gender.add(radio_female);
		
		
		
		add(panel3);
		panel3.setLayout(null);
		panel3.setBounds(150, 410, 200, 30);
		panel3.setBackground(null);
		panel3.add(btn1);
		btn1.setBounds(0, 0, 200, 30);
		btn1.setText("Register");
		
	}
	
	public void database() {
		try {
			
	        Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs", "root", "");
	        System.out.println("Connected!");
	    } 
		catch (CommunicationsException ex) {
	        System.out.println("Database Server link down");
	    }catch (SQLException ex) {
	        System.out.println("Error" + ex);
	    }catch (ClassNotFoundException e) {
	    	   throw new Error("Class not Found Error ", e);
		}
		try {
			
			PreparedStatement st = con.prepareStatement("INSERT INTO students(Full_Name, Username, Password,Gender) VALUES (?,?,?,?)");
			st.setString(1, Tfullname.getText());
			st.setString(2, Tusername.getText());
			st.setString(3, Tpassword.getText());
			st.setString(4, Gender_Text.getText());
			if(st.executeUpdate() == 1) {
				ImageIcon ic = new ImageIcon("C:\\Users\\samsung\\Downloads\\a.png");
				JOptionPane.showMessageDialog(null,"You registered for quiz successfully", "Registration",JOptionPane.INFORMATION_MESSAGE,ic);
			}
			
			else {
				JOptionPane.showMessageDialog(null,"Failed to Registered", "Registration",JOptionPane.ERROR_MESSAGE);
			}
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error", "Registration",JOptionPane.ERROR_MESSAGE);
        }		
	}
	public void registrationForm() {	
		
		
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(radio_male.isSelected()) {
					Gender_Text.setText(radio_male.getText()); 
				}
				else if(radio_female.isSelected()) {
					Gender_Text.setText(radio_female.getText());
				}
				database();
				dispose();
			}
		});
		
		
	}
}



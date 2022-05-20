import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;
import java.sql.Statement;
public class LoginForm extends JFrame {
	
	// DATA MEMEBERS OF LOGIN CLASS
	 JLabel Login,username,password,icon;
	 JTextField Tusername;
	 JPasswordField Tpassword;
	 JButton btnLogin,btnRegistration;
	 Font font;
	 Connection con;
	 
	 //USED CONSTRUCTOR TO ALLOCATE MEMORY 
	 LoginForm(){
		 Login = new JLabel();
		 username = new JLabel();
		 password = new JLabel();
		 Login = new JLabel();
		 icon = new JLabel();
		 
		 Tusername = new JTextField();
		 Tpassword = new JPasswordField();
		 
		 btnLogin = new JButton();
		 btnRegistration = new JButton();
		 
		 font = new Font("Arial",Font.BOLD,20);
		 Connection con1;
	 }
	 
	 // FRAME FUNCTION WHICH PERFORM FRAME RELETED PROPERTIES
	 public void frame(int width,int height,int x,int y) {
		 // frame properties define 
		 setTitle("Quiz Management Application");
		 setSize(width,height);
		 setLayout(null);
		 setLocation(x,y);
		 setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		 setVisible(true);	 
		 setResizable(false);
		 ImageIcon framepic = new ImageIcon("C:\\Users\\samsung\\Downloads\\a.png");
		 setIconImage(framepic.getImage());
		 
	 }
	 
	 //DESIGN THE LOGIN FORM INSIDE "DESIGN FUNCTION"
	 public void Desgin() {
		 //icon setup
		 add(icon);
		 ImageIcon c1 = new ImageIcon("D:\\Quiz Management System\\picture\\.png");
		 icon.setIcon(c1);
		 icon.setBounds(20, 10,100,100);
		 
		 //login Label
		 ImageIcon im = new ImageIcon("D:\\Quiz Management System\\picture\\profile1.png");
		Login.setIcon(im);
		add(Login);
		Login.setBounds(230, 5,128,128);
		Login.setFont(font);

		//User_name and textfield_for_username
		username.setText("Username");
		add(username);
		username.setBounds(80, 100,100,100);
		username.setFont(font);
		
		add(Tusername);
		Tusername.setBounds(210, 135,180,30);
		Tusername.setFont(new Font("Arial",Font.BOLD,15));
		
		
		//password and text_field password
		password.setText("Password");
		add(password);
		password.setBounds(80, 150,100,100);
		password.setFont(font);
		
		add(Tpassword);
		Tpassword.setBounds(210, 185,180,30);
		
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
				
				
				PreparedStatement st = con.prepareStatement("SELECT * FROM students where Username=? and Password=?");
				st.setString(1, Tusername.getText());
				st.setString(2, Tpassword.getText());
				
				ResultSet  set = st.executeQuery();
				if(set.next()) {
					System.out.println("match");
					WelcomeToQuiz quiz = new WelcomeToQuiz();
					quiz.frame(600,550,360,120);
					quiz.open();
					quiz.HLaction();
					quiz.DLDaction();
					quiz.OSaction();
					quiz.Mathaction();

				}else {
					JOptionPane.showMessageDialog(null,"Enter the correct Login Details", "Login",JOptionPane.ERROR_MESSAGE);
				}
			}catch (SQLException ex) {
				JOptionPane.showMessageDialog(null,"ERROR", "Login",JOptionPane.WARNING_MESSAGE);
	        }		
		}
	 
	// BUTTON FUNCTON PERFORM ACTION
	public void button() {
		
		// Login Button
		add(btnLogin);
		btnLogin.setText("Login");
		btnLogin.setBounds(180, 280,100,40);
		btnLogin.setFont(font);
		btnLogin.setBackground(new Color(32,178,170));
		btnLogin.setForeground(Color.white);
		btnLogin.setBorder(null);
		
		//Logic on LOGIN button
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				database();
							}
		});

		// Registration Button
		add(btnRegistration);
		btnRegistration.setText("Registration");
		btnRegistration.setBounds(300, 280,130,40);
		btnRegistration.setFont(font);
		btnRegistration.setBackground(new Color(32,178,170));
		btnRegistration.setForeground(Color.white);
		btnRegistration.setBorder(null);
		
		//Logic on Registration Button
		btnRegistration.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Registration  r1 = new Registration();
				
				r1.frame(520,500,400,150);
				r1.registrationForm();
				r1.Design_Registration();
			}
		});
		
}
	public static void main(String[] args) {
		LoginForm l1 = new LoginForm();
		l1.frame(500,400,400,150);
		l1.Desgin();
		l1.button();
		
}
}
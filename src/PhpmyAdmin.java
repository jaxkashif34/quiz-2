import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

public class PhpmyAdmin {
	private Connection con;
	private String url;
	private String username;
	private String password;
	private String first;
	private String last;
	private int year;
	public PhpmyAdmin() {
		username = "root";
		password = "";
		url = "jdbc:mysql://localhost:3306/books";
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
	        System.out.println("Connected!");
	    } 
		catch (CommunicationsException ex) {
	        System.out.println("Database Server link down");
	    }catch (SQLException ex) {
	        System.out.println("Error" + ex);
	    }catch (ClassNotFoundException e) {
	    	   throw new Error("Class not Found Error ", e);
		}
	}
	public void closeDb() {
		try {
			if (con != null) {
				con.close();
			}
	        } catch (SQLException ex) {
	            System.out.println("Error" + ex);
	        }
	}
	public void insetRecord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the firtname");
		first = sc.nextLine();
		System.out.println("Enter the lastname");
		last = sc.nextLine();
		System.out.println("Enter the year born");
		year = Integer.parseInt(sc.nextLine());
		try {
			PreparedStatement st = con.prepareStatement("INSERT INTO authors (FirstName, LastName, YearBorn)"
					+ " VALUES (?,?,?)");
			st.setString(1, first);
			st.setString(2, last);
			st.setInt(3, year);
			if(st.executeUpdate() == 1) {
				System.out.println("Insert record successfully");
			}else {
				System.out.println("Failed Query");
			}
		}catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
	}
	public void updateRecord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id to updated");
		int id = Integer.parseInt(sc.nextLine());
		try {
			PreparedStatement st = con.prepareStatement("UPDATE authors SET FirstName = ?, LastName = ?,"
					+ " YearBorn = ? WHERE AuthorId = ?");
					
			st.setString(1, "Umar");
			st.setString(2, "Latif");
			st.setInt(3, 1980);
			st.setInt(4, id);
			if(st.executeUpdate() == 1) {
				System.out.println("Update record successfully");
			}else {
				System.out.println("Failed Query");
			}
		}catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
	}
	public void deleteRecord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id to delete");
		int id = Integer.parseInt(sc.nextLine());
		try {
			PreparedStatement st = con.prepareStatement("DELETE FROM authors WHERE AuthorID = ?");
			st.setInt(1, id);
			if(st.executeUpdate() == 1) {
				System.out.println("Delete record successfully");
			}else {
				System.out.println("Failed Query");
			}
		}catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
	}
	public void showRecords() {
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM authors");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString(1)+"      ");
				System.out.print(rs.getString(2)+"      ");
				System.out.print(rs.getString(3)+"      ");
				System.out.println(rs.getInt(4)+"      ");
			}
			st.close();
		}catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
	}
	public static void main(String args[]) {
		PhpmyAdmin i = new PhpmyAdmin();
		i.insetRecord();
		i.showRecords();
		//i.updateRecord();
		//i.deleteRecord();
		i.closeDb();
	}
}
package project;

import java.sql.*;
public class AccountantDaoImpl_JDBC implements AccountantDao {

	String dbURL = "jdbc:mysql://localhost/fee_report";
	String username = "root";
	String password = "Pranav@123";
	
	@Override
	public String addAccountant(Accountant accountant) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			
			String sql = "insert into accountant(Accountant_id, Name, Password, Email, Contact) values(?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, accountant.getId());
			pstmt.setString(2, accountant.getName());
			pstmt.setString(3, accountant.getPassword());
			pstmt.setString(4, accountant.getEmail());
			pstmt.setString(5, accountant.getContact());
			
			pstmt.executeUpdate();
			System.out.println("Accontant with name "+ accountant.getName()+ " added Sucessfully!");
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String line = "Accontant with name "+ accountant.getName()+ " added Sucessfully!";
		return line;
	}

	@Override
	public void viewAccountant() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			
			String sql = "Select * from accountant";
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				System.out.println("\n"+"Accountant ID : " + rs.getInt(1) + " Accountant Name : "+ rs.getString(2)+ " Password : "
						+ rs.getString(3)+ " Email : "+ rs.getString(4)+ " Conatact : "+ rs.getString(5));
			}
			
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean accountantLogin(String name, String Password) {
		boolean f = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			
			String sql = "Select Name, Password from accountant";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				if((rs.getNString(1).equals(name)) && (rs.getString(2).equals(Password)) )
				f = true;
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(f) {
			return true;
		}
		else {
			return false;
		}
	}

}

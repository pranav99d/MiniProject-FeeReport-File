package project;
import java.sql.*;
import connectionProvider.*;

public class AccountantDaoImpl_JDBC implements AccountantDao {
	Connection conn = null;
	@Override
	public String addAccountant(Accountant accountant) {
		try {
			conn = ConnectionProvider.getConn();
			
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String line = "Accontant with name "+ accountant.getName()+ " added Sucessfully!";
		return line;
	}

	@Override
	public void viewAccountant() {
		try {
			conn = ConnectionProvider.getConn();
			
			String sql = "Select * from accountant";
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				System.out.println("\n"+"Accountant ID : " + rs.getInt(1) + " Accountant Name : "+ rs.getString(2)+ " Password : "
						+ rs.getString(3)+ " Email : "+ rs.getString(4)+ " Conatact : "+ rs.getString(5));
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean accountantLogin(String name, String Password) {
		boolean f = false;
		try {
			conn = ConnectionProvider.getConn();
			
			String sql = "Select Name, Password from accountant";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				if((rs.getNString(1).equals(name)) && (rs.getString(2).equals(Password)) )
				f = true;
			}
			conn.close();
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

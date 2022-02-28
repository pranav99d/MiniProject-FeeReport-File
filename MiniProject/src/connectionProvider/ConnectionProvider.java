package connectionProvider;
import java.sql.*;

public class ConnectionProvider {
	
	static Connection conn;
	
	public static Connection getConn() {
			try {
			
			    String dbURL = "jdbc:mysql://localhost/fee_report";
			    String username = "root";
			    String password = "Pranav@123";
			    
			    Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(dbURL,username,password);
				
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		return conn;
	}

}

package student;
import java.sql.*;
import connectionProvider.*;

public class StudentDaoImpl_JDBC implements StudentDao{
	Connection conn = null;
	@Override
	public String addStudent(Student student) {
		try {
			
			conn = ConnectionProvider.getConn();
			PreparedStatement psmt = conn.prepareStatement("insert into student(roll_no, Name, Email, Course, Total_Fees,"
					+ " Fees_Paid, Due_Fees, Address, City, State, Country, Contact) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			psmt.setString(1, student.getRollNo());
			psmt.setString(2, student.getName());
			psmt.setString(3, student.getEmail());
			psmt.setString(4, student.getCourse());
			psmt.setInt(5, student.getFee());
			psmt.setInt(6,student.getPaid());
			psmt.setInt(7, student.getDue());
			psmt.setString(8, student.getAddress());
			psmt.setString(9, student.getCity());
			psmt.setString(10, student.getState());
			psmt.setString(11, student.getCountry());
			psmt.setString(12, student.getContact());
			
			psmt.executeUpdate();
			String line = "\nStudent with roll no. "+ student.getRollNo() + " added sucessfully.";
			System.out.println(line);
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String line = "\nRecords added Sucessfully.";
		return line;
	}

	@Override
	public void viewStudent() {
		try {
			conn = ConnectionProvider.getConn();
			
			Statement stmt = conn.createStatement();
			String sql = "Select * from student";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				
				System.out.println("\n"+"Roll no.: "+ rs.getString(1)+" Name: "+ rs.getString(2)+" Email: "+rs.getString(3)+
						" Course: "+ rs.getString(4)+" Fees: "+ rs.getInt(5)+" Paid Fees: "+ rs.getInt(6)+" Due Fees: "+
						rs.getInt(7)+" Address: "+ rs.getString(8)+" City: "+ rs.getString(9)+ " State: "+rs.getString(10)+
						" Country: "+ rs.getString(11)+ " Contact: "+ rs.getString(12));
				System.out.println("\n");
			}
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String editStudent(Student student1) {
		try {
			conn = ConnectionProvider.getConn();
			
			String sql = "update student set Name = ?, Email = ?, Course = ?, Total_Fees = ?, Fees_Paid = ?, Due_Fees = ?,"
					+ "Address = ?, City = ?, State = ?, Country = ?, Contact = ? where roll_no = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, student1.getName());
			pstmt.setString(2, student1.getEmail());
			pstmt.setString(3, student1.getCourse());
			pstmt.setInt(4, student1.getFee());
			pstmt.setInt(5, student1.getPaid());
			pstmt.setInt(6, student1.getDue());
			pstmt.setString(7, student1.getAddress());
			pstmt.setString(8, student1.getCity());
			pstmt.setString(9, student1.getState());
			pstmt.setString(10, student1.getCountry());
			pstmt.setString(11, student1.getContact());
			pstmt.setString(12, student1.getRollNo());
			
			pstmt.executeUpdate();
			
			System.out.println("\nStudent with Roll no. " + student1.getRollNo() + " Updated Sucessfully! " );
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		String line = "\nRecords Updated Sucessfully!";
		return line;
	}

	@Override
	public String loadRecord(String rollno) {
		try {
			conn = ConnectionProvider.getConn();
			
			String sql = "select * from student where roll_no = '"+ rollno+"'";
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
            while(rs.next()){
				
				System.out.println("\n"+"Roll no.: "+ rs.getString(1)+" Name: "+ rs.getString(2)+" Email: "+rs.getString(3)+
						" Course: "+ rs.getString(4)+" Fees: "+ rs.getInt(5)+" Paid Fees: "+ rs.getInt(6)+" Due Fees: "+
						rs.getInt(7)+" Address: "+ rs.getString(8)+" City: "+ rs.getString(9)+ " State: "+rs.getString(10)+
						" Country: "+ rs.getString(11)+ " Contact: "+ rs.getString(12));
				System.out.println("\n");
			}
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		String line = "\nStudent with "+ rollno + " have above record.";
		return line;
	}

	@Override
	public void dueFees() {
		try {
			conn = ConnectionProvider.getConn();
			
			Statement stmt = conn.createStatement();
			String sql = "Select * from student where Due_Fees != 0";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				
				System.out.println("\n"+"Roll no.: "+ rs.getString(1)+" Name: "+ rs.getString(2)+" Email: "+rs.getString(3)+
						" Course: "+ rs.getString(4)+" Fees: "+ rs.getInt(5)+" Paid Fees: "+ rs.getInt(6)+" Due Fees: "+
						rs.getInt(7)+" Address: "+ rs.getString(8)+" City: "+ rs.getString(9)+ " State: "+rs.getString(10)+
						" Country: "+ rs.getString(11)+ " Contact: "+ rs.getString(12));
				System.out.println("\n");
			}
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String deleteRecord(String rollno) {
		try {
			conn = ConnectionProvider.getConn();
			
			String sql = "Delete from student where roll_no = '"+ rollno+"'";
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);
			
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		String line = "\nRecord of student with roll no "+ rollno + " deleted sucessfully!";
		return line;
	}

}

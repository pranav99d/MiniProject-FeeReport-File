package student;

public interface StudentDao {
	
	public String addStudent(Student student);
	public void viewStudent();
	public String editStudent(Student student);
	public String loadRecord(String rollno);
	public void dueFees();
	public String deleteRecord(String rollno);

}

package student;
import java.awt.Desktop;
import java.io.*;

public class StudentDaoImpl implements StudentDao {
	
	public String addStudent(Student student) {
		File input = new File("StudentDetails.csv");
		try {
			if(input.createNewFile())
			{
				System.out.println(input.getName() + " File Created Sucessfully!");
			}
			else
				System.out.println("\nFile Already exists.");
		String line = ("\n"+student.getRollNo() +"\t" +student.getName()+"\t"+student.getEmail()+"\t"+student.getCourse()
        +"\t"+student.getFee()+"\t"+student.getPaid()+"\t"+student.getDue()+"\t"
        + student.getAddress()+"\t"+ student.getCity()+"\t"+student.getState()+"\t"+student.getCountry()+"\t"+student.getContact());
		
			FileWriter fw = new FileWriter(input, true);
		    BufferedWriter bw = new BufferedWriter(fw);
			bw.write(line);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str = "Student Added Sucessfully!";
		System.out.println("\n" + str);
		return str;
	}

	public void viewStudent() {
		try {
			File view = new File("StudentDetails.csv");
			if(!Desktop.isDesktopSupported())  
			{  
			System.out.println("not supported");  
			return;  
			}  
			Desktop desktop = Desktop.getDesktop();  
			if(view.exists())           
			desktop.open(view);  
		}
		catch(Exception e)  
		{  
			e.printStackTrace();  
		} 
		
	}

	public String editStudent(Student student1) {
		try {
		File input = new File("StudentDetails.csv");
		String line = ("\n"+student1.getRollNo() +"\t" +student1.getName()+"\t"+student1.getEmail()+"\t"+student1.getCourse()
        +"\t"+student1.getFee()+"\t"+student1.getPaid()+"\t"+student1.getDue()+"\t"
        + student1.getAddress()+"\t"+ student1.getCity()+"\t"+student1.getState()+"\t"+student1.getCountry()+"\t"+student1.getContact());
		
			FileWriter fw = new FileWriter(input, true);
		    BufferedWriter bw = new BufferedWriter(fw);
			bw.write(line);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String str = "Student with roll number " + student1.getRollNo() +" gets Updated";
		System.out.println("\n"+ str);
		return str;
	}

	public void dueFees() {
		try {
			File view = new File("StudentDetails.csv");
			if(!Desktop.isDesktopSupported())  
			{  
			System.out.println("not supported");  
			return;  
			}  
			Desktop desktop = Desktop.getDesktop();  
			if(view.exists())           
			desktop.open(view);  
		}
		catch(Exception e)  
		{  
			e.printStackTrace();  
		} 
	}



	public String loadRecord(String rollno) {
		String line = null;
		try {
		FileReader fr1 = new FileReader("StudentDetails.csv");
		BufferedReader br1 = new BufferedReader(fr1);
		
		while((line = br1.readLine()) != null) {
			
			 if(line.startsWith(rollno)) {
				 System.out.println(line);;
			 }
		}
		fr1.close();
		br1.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return line;
	}

	@Override
	public String deleteRecord(String rollno) {
		
		String line1 = null;
		try {
			FileReader fr1 = new FileReader("StudentDetails.csv");
			BufferedReader br1 = new BufferedReader(fr1);
			
			while((line1 = br1.readLine()) != null) {
				
				 if(line1.startsWith(rollno)) {
					StringBuffer sb = new StringBuffer(line1);
					int end = line1.length();
					sb.delete(0, end);
				 }
			}
			fr1.close();
			br1.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String str = "Data Deleted Sucessfully";
		System.out.println("\n" + str);
		return str;
	}

}

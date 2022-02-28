package project;
import java.util.*;
import java.io.*;
import student.*;
public class FeeReport {
		
	@SuppressWarnings("resource")
	public static void main(String[] args) {	
		
		Scanner sc = new Scanner(System.in);
		Admin adm_log = new Admin();
		AccountantDao acc_log = new AccountantDaoImpl();
		AccountantDao acc_log1 = new AccountantDaoImpl_JDBC();
		StudentDao std = new StudentDaoImpl();
		StudentDao std1 = new StudentDaoImpl_JDBC();
		
	System.out.println("You are viewing \"Fee Report\" page" + "\n" );
	System.out.println("For Admin Login type 1" +"\n"
	                  +"For Accountant Login type 2\n"
			          +"For Exit type 3");
	
	int a = sc.nextInt();
	
/* ------------------------------- Admin Login & Section ------------------------------------*/	
	
	if(a == 1) 
	{
        System.out.println("\nYou are viewing \"Admin Login\" page" + "\n");
		
		System.out.println("Enter your name: ");
		String name = sc.next();
		
		System.out.println("Enter Password: ");
		String password = sc.next();
		
		boolean login = false;
		try {
			login = adm_log.adminLogin(name, password);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(login) {
			System.out.println("\n Login Sucessfully ");
			
			System.out.println("\nYou are viewing \"Admin Section\" page" + "\n" );
			System.out.println("For \"Add Accountant\" type 1" +"\n"
	                  +"For \" View Accountant\" type 2" + "\n"
					  + "For \"Logout\" type 3");
			int b = sc.nextInt();
			switch(b) {
			case 1:
				System.out.println("\nYou are viewing \"Add Accountant\" page" + "\n");
				Accountant accountant = new Accountant();
				System.out.println("Enter Accountant ID: ");
				accountant.setId(sc.nextInt());
				System.out.println("Enter Name: ");
				accountant.setName(sc.next());
				System.out.println("Enter Password: ");
				accountant.setPassword(sc.next());
				System.out.println("Enter Email: ");
				accountant.setEmail(sc.next());
				System.out.println("Enter Contact No.: ");
				accountant.setContact(sc.next());
				
				//Accountant accountant = new Accountant(id, name1, password1, email, contact);
				System.out.println("\nType 1 to Add Accountant in File System OR Type 2 to Add Accountant in Database");
				int i = sc.nextInt();
				if(i == 1)
				    acc_log.addAccountant(accountant);
				else if(i == 2)
					acc_log1.addAccountant(accountant);
				else
					System.out.println("\nInvalid Key");
				
				break;
				
			case 2:
				System.out.println("\nType 1 to Veiw Accountant from File System OR Type 2 to View Accountant from Database");
				int i1 = sc.nextInt();
				if(i1 == 1)
				    acc_log.viewAccountant();
				else if(i1 == 2)
					acc_log1.viewAccountant();
				else
					System.out.println("\nInvalid Key!");
				break;
			case 3:
				System.out.println("\nLogout Sucessfully.");
				break;
			default:
				System.out.println("\nInvalid Key");
				break;
			}
		}
		else
			System.out.println("\n Invalid Admin Login!!! ");
	}
	
/* ------------------------------- Accountant Login & Section ------------------------------------*/		
	
	if(a == 2) {
		
		System.out.println("\nYou are viewing \"Accountant login\" page" + "\n");
		
		System.out.println("Enter Name: ");
		String n = sc.next();
		
		System.out.println("Enter Password: ");
		String p = sc.next(); 
		
		boolean accLogin = false;
		System.out.println("\nType 1 to Login Accountant using File System OR Type 2 to Login Accountant using Database");
		int i3 = sc.nextInt();
		if(i3 == 1)
		    accLogin = acc_log.accountantLogin(n, p);
		else if(i3 == 2)
			accLogin = acc_log1.accountantLogin(n, p);
		else
			System.out.println("\nInvaild Key!");
		
		if(accLogin) {
			
			System.out.println("\nLogin Sucessfully");
			
			System.out.println("\nYou are viewing \"Accountant Section\" page" + "\n");
			System.out.println("For \"Add Student\" type 1" +"\n"
	                +"For \" View Student\" type 2" + "\n"
					  + "For \"Edit Student\" type 3" + "\n"
					  + "For \"Due Fees\" type 4" + "\n"
					  + "For \"Logout\" type 5");
			
			int i = sc.nextInt();
			switch(i) {
			case 1:
				System.out.println("\nYou are viewing \"Add Student\" page" + "\n");
				
				Student student = new Student();
				System.out.println("Enter RollNo: ");
				student.setRollNo(sc.next());
				System.out.println("Enter Name: ");
				student.setName(sc.next());
				System.out.println("Enter Email: ");
				student.setEmail(sc.next());
				System.out.println("Enter Course: ");
				student.setCourse(sc.next());
				System.out.println("Enter Fee: ");
				student.setFee(sc.nextInt());
				System.out.println("Enter Fees Paid: ");
				student.setPaid(sc.nextInt());
				System.out.println("Enter Due Fees: ");
				student.setDue(sc.nextInt());
				System.out.println("Enter Address: ");
				student.setAddress(sc.next());
				System.out.println("Enter City: ");
				student.setCity(sc.next());
				System.out.println("Enter State: ");
				student.setState(sc.next());
				System.out.println("Enter Country: ");
				student.setCountry(sc.next());
				System.out.println("Enter Contact No.: ");
				student.setContact(sc.next());
				
				//Student student = new Student(rollno, name, email, course, fee, paid, due, address, city, state, country, contact);
				
				System.out.println("Type 1 to add student in File System OR Type 2 to add student in Database.");
				int j = sc.nextInt();
				if(j == 1)
				    std.addStudent(student);
				else if(j == 2)
					std1.addStudent(student);
				else
					System.out.println("\nInvalid key");
				break;
			case 2:
				System.out.println("\nYou are viewing \"View Student\" page\n");
				
				System.out.println("Type 1 to View student from File System OR Type 2 to View student from Database.");
				int j1 = sc.nextInt();
				if(j1 == 1)
				    std.viewStudent();
				else if(j1 == 2)
					std1.viewStudent();
				else
					System.out.println("\nInvalid key");
				break;
			case 3:
				System.out.println("\nYou are viewing \"Edit Student\" page\n");
				Student student1 = new Student();
				System.out.println("Enter the roll number to Update: ");
				student1.setRollNo(sc.next());
				System.out.println("Type 1 to Edit student in File System OR Type 2 to Edit student in Database.");
				int j3 = sc.nextInt();
				if(j3 == 1) {
				    std.loadRecord(student1.getRollNo());
				    std.deleteRecord(student1.getRollNo());
				}
				else if(j3 == 2) {
					std1.loadRecord(student1.getRollNo());
				}
				else
					System.out.println("\nInvalid Key");
				
				
				System.out.println("Enter Name: ");
				student1.setName(sc.next());
				System.out.println("Enter Email: ");
				student1.setEmail(sc.next());
				System.out.println("Enter Course: ");
				student1.setCourse(sc.next());
				System.out.println("Enter Fee: ");
				student1.setFee(sc.nextInt());
				System.out.println("Enter Fees Paid: ");
				student1.setPaid(sc.nextInt());
				System.out.println("Enter Due Fees: ");
				student1.setDue(sc.nextInt());
				System.out.println("Enter Address: ");
				student1.setAddress(sc.next());
				System.out.println("Enter City: ");
				student1.setCity(sc.next());
				System.out.println("Enter State: ");
				student1.setState(sc.next());
				System.out.println("Enter Country: ");
			    student1.setCountry(sc.next());
				System.out.println("Enter Contact No.: ");
			    student1.setContact(sc.next());
				
				//Student student1 = new Student(rollNo, name1, email1, course1, fee1, paid1, due1, address1, city1, state1, country1, contact1);
				if(j3 == 1)
				    std.editStudent(student1);
				else if(j3 == 2)
					std1.editStudent(student1);
				else 
					System.out.println("\nInvalid Key");
				break;
			case 4:
				System.out.println("\nYou are viewing \"Due Fees\" page\n");
				
				System.out.println("Type 1 to View Due Fees of student from File System OR Type 2 to View Due Fees of student from Database.");
				int j4 = sc.nextInt();
				if(j4 == 1)
				    std.dueFees();
				else if(j4 == 2)
					std1.dueFees();
				break;
			case 5:
				System.out.println("Logout Sucessfully!");
				break;
			default:
				System.out.println("\nInvalid Key!!!");
				break;
			}
		}
		else
			System.out.println("\nInvalid Accountant Login!!");
	}
/*------------------------------------ Exit Code --------------------------------------------*/	
	
	if(a == 3)
		System.out.println("\nThank You!");
				
    } 

}		

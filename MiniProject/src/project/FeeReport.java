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
				
				System.out.println("Enter Accountant ID: ");
				int ID = sc.nextInt();
				System.out.println("Enter Name: ");
				String Name = sc.next();
				System.out.println("Enter Password: ");
				String Password = sc.next();
				System.out.println("Enter Email: ");
				String Email = sc.next();
				System.out.println("Enter Contact No.: ");
				String Contact = sc.next();
				
				Accountant accountant = new Accountant(ID, Name, Password, Email, Contact);
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
		String N = sc.next();
		
		System.out.println("Enter Password: ");
		String P = sc.next(); 
		
		boolean accLogin = false;
		System.out.println("\nType 1 to Login Accountant using File System OR Type 2 to Login Accountant using Database");
		int i3 = sc.nextInt();
		if(i3 == 1)
		    accLogin = acc_log.accountantLogin(N, P);
		else if(i3 == 2)
			accLogin = acc_log1.accountantLogin(N, P);
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
				
				System.out.println("Enter RollNo: ");
				String rollno = sc.next();
				System.out.println("Enter Name: ");
				String name = sc.next();
				System.out.println("Enter Email: ");
				String email = sc.next();
				System.out.println("Enter Course: ");
				String course = sc.next();
				System.out.println("Enter Fee: ");
				int fee = sc.nextInt();
				System.out.println("Enter Fees Paid: ");
				int paid = sc.nextInt();
				int due = fee - paid;
				System.out.println("Enter Address: ");
				String address = sc.next();
				System.out.println("Enter City: ");
				String city = sc.next();
				System.out.println("Enter State: ");
				String state = sc.next();
				System.out.println("Enter Country: ");
				String country = sc.next();
				System.out.println("Enter Contact No.: ");
				String contact = sc.next();
				
				Student student = new Student(rollno, name, email, course, fee, paid, due, address, city, state, country, contact);
				
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
				
				System.out.println("Enter the roll number to Update: ");
				String rollNo = sc.next();
				System.out.println("Type 1 to Edit student in File System OR Type 2 to Edit student in Database.");
				int j3 = sc.nextInt();
				if(j3 == 1) {
				    std.loadRecord(rollNo);
				    std.deleteRecord(rollNo);
				}
				else if(j3 == 2) {
					std1.loadRecord(rollNo);
				}
				else
					System.out.println("\nInvalid Key");
				System.out.println("Enter Name: ");
				String name1 = sc.next();
				System.out.println("Enter Email: ");
				String email1 = sc.next();
				System.out.println("Enter Course: ");
				String course1 = sc.next();
				System.out.println("Enter Fee: ");
				int fee1 = sc.nextInt();
				System.out.println("Enter Fees Paid: ");
				int paid1 = sc.nextInt();
				int due1 = fee1 - paid1;
				System.out.println("Enter Address: ");
				String address1 = sc.next();
				System.out.println("Enter City: ");
				String city1 = sc.next();
				System.out.println("Enter State: ");
				String state1 = sc.next();
				System.out.println("Enter Country: ");
				String country1 = sc.next();
				System.out.println("Enter Contact No.: ");
				String contact1 = sc.next();
				
				Student student1 = new Student(rollNo, name1, email1, course1, fee1, paid1, due1, address1, city1, state1, country1, contact1);
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

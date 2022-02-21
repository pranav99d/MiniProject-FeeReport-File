package project;
import java.util.*;
import java.io.*;
import student.*;
public class FeeReport {
		
	@SuppressWarnings("resource")
	public static void main(String[] args) {	
		
		Scanner sc = new Scanner(System.in);
		Admin adm_log = new Admin();
		AccountantSection acc_log = new AccountantSection();
		StudentDao std = new StudentDaoImpl();
		
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
				
				acc_log.addAccountant(accountant);
				
				break;
				
			case 2:
				try {
					acc_log.viewAccountant();
				} catch (IOException e) {
					e.printStackTrace();
				}
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
		try {
			accLogin = acc_log.accountantLogin(N, P);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
				
				std.addStudent(student);
				break;
			case 2:
				System.out.println("\nYou are viewing \"View Student\" page\n");
				
				std.viewStudent();
				break;
			case 3:
				System.out.println("\nYou are viewing \"Edit Student\" page\n");
				
				System.out.println("Enter the roll number to Update: ");
				String rollNo = sc.next();
				std.loadRecord(rollNo);
				std.deleteRecord(rollNo);
				
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
				
				std.editStudent(student1);
				break;
			case 4:
				System.out.println("\nYou are viewing \"Due Fees\" page\n");
				
				std.dueFees();
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

package project;
import java.io.IOException;

public class Admin {

	public boolean adminLogin(String name, String password) throws IOException {
		
		String validName = "admin";
		String validPassword = "admin123";
		boolean check1 = name.equals(validName);
		boolean check2 = password.endsWith(validPassword);
		if(check1 && check2) 
			return true;
		else
			return false;
		   	
	}
    
}

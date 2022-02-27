package project;
import java.awt.Desktop;
import java.io.*;

public class AccountantDaoImpl implements AccountantDao {
	
public String addAccountant(Accountant accountant)  {
		
		try {
				File input = new File("AccountantDetails.txt");
				if(input.createNewFile()) {
					System.out.println(input.getName() + " File Created Sucessfully!");
				}
				else
					System.out.println("\nFile Already exists");
				FileWriter fw = new FileWriter(input, true);
				BufferedWriter bw = new BufferedWriter(fw);
				String line=("\n"+accountant.getId() +"\t\t" +accountant.getName()+"\t\t"+accountant.getPassword()
				             +"\t\t"+accountant.getEmail()+"\t\t"+accountant.getContact());    
	            bw.write(line);
	            bw.close();
	            fw.close();
		}
			catch (IOException e) {
		  	      System.out.println("An error occurred.");
		  	      e.printStackTrace();
			}
		String s = "Accountant " + accountant.getName() + " added Sucessfully";
		System.out.println("\n"+s);
		return	s;
			
		}
		
	public void viewAccountant() {

		System.out.println("You are viewing \"View Accountant\" page" + "\n");
		try {
			File view = new File("AccountantDetails.txt");
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
	
    public boolean accountantLogin(String name, String password) {
		
		String str;
		boolean f = false;
		FileReader file;
		try {
			file = new FileReader("AccountantDetails.txt");
		    BufferedReader br = new BufferedReader(file);
			while((str = br.readLine()) != null ) {
				
				if((str.indexOf(name) != -1) && (str.indexOf(password) != -1)) {
					f = true;
				    }
				}
			br.close();
		}
	    catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
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

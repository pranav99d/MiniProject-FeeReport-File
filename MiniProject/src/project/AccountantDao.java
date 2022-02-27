package project;

public interface AccountantDao {

	public String addAccountant(Accountant accountant);
	public void viewAccountant();
	public boolean accountantLogin(String name, String Password);
}

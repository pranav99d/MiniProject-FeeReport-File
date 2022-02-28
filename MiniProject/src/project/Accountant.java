package project;

public class Accountant {
	
	private int id;
	private String name,password,email,contact;
	
	public Accountant() {}
/*	public Accountant(int id, String name, String password, String email, String contact) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.password = password;
//		this.email = email;
//		this.contact = contact;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	

}
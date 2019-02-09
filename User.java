package kosta.lunch;

public abstract class User {
	String name;
	String id;
	String pw;
	String phoneNo;
	
	public User() {}
	
	public User(String name, String id, String pw, String phoneNo) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phoneNo = phoneNo;
	}

	public abstract int showMenu();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	

}

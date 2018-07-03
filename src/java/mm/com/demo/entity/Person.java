package mm.com.demo.entity;

public class Person {
	int id;
	String firstName;
	String lastName;
	String nrc;
	String email;
	String phoneNo;

	public Person() {
		super();
		clearProperties();
	}

	public Person(int id, String firstName, String lastName, String nrc,
			String email, String phoneNo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nrc = nrc;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void clearProperties() {
		this.id = 0;
		this.firstName = "";
		this.lastName = "";
		this.nrc = "";
		this.email = "";
		this.phoneNo = "";
	}

}

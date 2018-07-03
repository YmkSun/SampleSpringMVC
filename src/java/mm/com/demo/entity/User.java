package mm.com.demo.entity;

public class User extends Person {
	
	long uid;
	String code;
	
	public User() {
		super();
		clearProperties();
	}
	
	public User(long uid, String code) {
		this.uid = uid;
		this.code = code;
	}
	
	public User(int id, String firstName, String lastName, String nrc,
			String email, String phoneNo, long uid, String code) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nrc = nrc;
		this.email = email;
		this.phoneNo = phoneNo;
		this.uid = uid;
		this.code = code;
	}
	
	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void clearProperties() {
		this.uid = 0l;
		this.code = "";		
	}

}

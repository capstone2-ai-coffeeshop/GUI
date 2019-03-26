package bean;

public class Customer {
	private String id;
	private String fullname;
	private String email;
	private String gender;
	private String dateOfBirth;
	private String phone;

	public Customer() {
		super();
	}

	public Customer(String id, String fullname, String email, String gender, String dateOfBirth, String phone) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}

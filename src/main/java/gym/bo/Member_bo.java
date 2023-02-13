package gym.bo;

public class Member_bo {
	
	private int id;
	private String name;
	private String email;
	private String phone;
	private String dob;
	private String doj;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public Member_bo( String name, String email, String phone, String dob, String doj) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.doj = doj;
	}
	@Override
	public String toString() {
		return "Member_bo [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", dob=" + dob
				+ ", doj=" + doj + "]";
	}
	public Member_bo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	
	

	
}

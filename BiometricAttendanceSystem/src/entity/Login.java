package entity;

public class Login {
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setAdminPassword(String password) {
		this.password = password;
	}
	private Integer id;
    private String email;
    private String password;
}

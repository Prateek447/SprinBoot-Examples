package myCodeBook.entities;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginData {

	@NotBlank(message="Username is mandatory !")
	@Size(min=4,max=10,message="Username must be between 4 and 10 length")
	private String userName;
	
	
	public boolean isAgree() {
		return agree;
	}
	public void setAgree(boolean agree) {
		this.agree = agree;
	}
	@AssertTrue(message ="Must agree term and condition")
	private boolean agree;
	
	@Pattern(regexp= "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$\r\n" , message = "Invalid Password !!")
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginData(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	
}

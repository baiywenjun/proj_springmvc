package com.test.excel;

public class UserInfoTest {

	private String userName;
	private String userAge;
	private String userPhone;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public UserInfoTest(String userName, String userAge, String userPhone) {
		super();
		this.userName = userName;
		this.userAge = userAge;
		this.userPhone = userPhone;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
}

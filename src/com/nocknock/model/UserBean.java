package com.nocknock.model;

public class UserBean {
	
	private long sk_member_id;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String userPhone;
	private String userConfirmPassword;
	private String otp;
	private String Signup_status;
	private String Signin_status;


	public String getSignin_status() {
		return Signin_status;
	}
	public void setSignin_status(String signin_status) {
		Signin_status = signin_status;
	}
	public String getSignup_status() {
		return Signup_status;
	}
	public String setSignup_status(String signup_status) {
		return Signup_status = signup_status;
	}
	public long getSk_member_id() {
		return sk_member_id;
	}
	public Long setSk_member_id(long l) {
		return this.sk_member_id = l;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserConfirmPassword() {
		return userConfirmPassword;
	}
	public void setUserConfirmPassword(String userConfirmPassword) {
		this.userConfirmPassword = userConfirmPassword;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	

}

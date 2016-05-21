package com.model;

public class User {
	private int userid;
	private String loginname;
	private String loginpassword;
	private String nickname;
	
	/**
	 * @param userid
	 * @param loginname
	 * @param loginpassword
	 * @param nickname
	 * @return 
	 */
	public void user(int userid, String loginname, String loginpassword,
			String nickname) {
		this.userid = userid;
		this.loginname = loginname;
		this.loginpassword = loginpassword;
		this.nickname = nickname;
	}
	public void user(){
		
	}
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpassword() {
		return loginpassword;
	}
	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}

package com.fengf.wms.pojo;

public class User {
	private int user_id;
	private String user_name;
	private String user_password;
	private String user_phone;
	private int user_aut;
	private UserDict userDict;
	
	public User() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public User(int user_id, String user_name, String user_password, String user_phone, int user_aut,
			UserDict userDict) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_phone = user_phone;
		this.user_aut = user_aut;
		this.userDict = userDict;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public int getUser_aut() {
		return user_aut;
	}

	public void setUser_aut(int user_aut) {
		this.user_aut = user_aut;
	}

	public UserDict getUserDict() {
		return userDict;
	}

	public void setUserDict(UserDict userDict) {
		this.userDict = userDict;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", user_phone=" + user_phone + ", user_aut=" + user_aut + ", userDict=" + userDict + "]\n";
	}
	
	
	
}
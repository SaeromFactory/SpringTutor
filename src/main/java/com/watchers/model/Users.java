package com.watchers.model;

import java.sql.Timestamp;

public class Users {
	
	private String id;
	private String gender;
	private String pw;
	private Long type;
	private String email;
	private String userEnum;
	private Timestamp connect;
	private String name;
	private String token;
	private Timestamp createdAt;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public long getType() {
		return type;
	}
	public void setType(long type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_enum() {
		return userEnum;
	}
	public void setUser_enum(String user_enum) {
		this.userEnum = user_enum;
	}
	public Timestamp getConnect() {
		return connect;
	}
	public void setConnect(Timestamp connect) {
		this.connect = connect;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "id : " + id + "gender : " + gender + " type : " + type + "email : " + email;
	}
}

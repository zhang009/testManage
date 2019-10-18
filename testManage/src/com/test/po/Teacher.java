package com.test.po;

public class Teacher {
private Integer t_id;//教师id
private String t_name;//教师用户名
private String t_pass;//教师密码
private String t_email;//教师邮件



public Teacher(Integer t_id, String t_name, String t_pass, String t_email) {
	super();
	this.t_id = t_id;
	this.t_name = t_name;
	this.t_pass = t_pass;
	this.t_email = t_email;
}

public Teacher() {
	super();
	// TODO Auto-generated constructor stub
}

public Teacher(String t_name, String t_pass, String t_email) {
	super();
	this.t_name = t_name;
	this.t_pass = t_pass;
	this.t_email = t_email;
}

public Teacher(String t_name, String t_email) {
	super();
	this.t_name = t_name;
	this.t_email = t_email;
}

public Integer getT_id() {
	return t_id;
}
public void setT_id(Integer t_id) {
	this.t_id = t_id;
}
public String getT_name() {
	return t_name;
}
public void setT_name(String t_name) {
	this.t_name = t_name;
}
public String getT_pass() {
	return t_pass;
}
public void setT_pass(String t_pass) {
	this.t_pass = t_pass;
}
public String getT_email() {
	return t_email;
}
public void setT_email(String t_email) {
	this.t_email = t_email;
}

@Override
public String toString() {
	return "Teacher [t_id=" + t_id + ", t_name=" + t_name + ", t_pass=" + t_pass + ", t_email=" + t_email + "]";
}


}

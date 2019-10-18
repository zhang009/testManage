package com.test.po;

public class ChapterTitle {

	public ChapterTitle(String ct_name, Integer ct_c_id, Integer ct_num) {
		super();
		this.ct_name = ct_name;
		this.ct_c_id = ct_c_id;
		this.ct_num = ct_num;
	}
	private Integer ct_id;
	private String ct_name;
	private Integer ct_c_id;
	private Integer ct_num;
	
	public ChapterTitle(Integer ct_id, String ct_name, Integer ct_c_id,
			Integer ct_num) {
		super();
		this.ct_id = ct_id;
		this.ct_name = ct_name;
		this.ct_c_id = ct_c_id;
		this.ct_num = ct_num;
	}
	public Integer getCt_id() {
		return ct_id;   
	}
	public void setCt_id(Integer ct_id) {
		this.ct_id = ct_id;
	}
	public String getCt_name() {
		return ct_name;
	}
	public void setCt_name(String ct_name) {
		this.ct_name = ct_name;
	}
	@Override
	public String toString() {
		return "ChapterTitle [ct_id=" + ct_id + ", ct_name=" + ct_name
				+ ", ct_c_id=" + ct_c_id + ", ct_num=" + ct_num + "]";
	}
	
	public Integer getCt_c_id() {
		return ct_c_id;
	}
	public void setCt_c_id(Integer ct_c_id) {
		this.ct_c_id = ct_c_id;
	}
	public Integer getCt_num() {
		return ct_num;
	}
	public void setCt_num(Integer ct_num) {
		this.ct_num = ct_num;
	}
}

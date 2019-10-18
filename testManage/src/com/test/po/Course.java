package com.test.po;

public class Course {

	Integer c_id;
	String c_name;
	Integer c_chapter_num;
	public Course(Integer c_id, String c_name, Integer c_chapter_num,
			Integer c_s_id) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_chapter_num = c_chapter_num;
		this.c_s_id = c_s_id;
	}

	Integer c_s_id;

	public Integer getc_id() {
		return c_id;
	}

	public void setc_id(Integer c_id) {
		this.c_id = c_id;
	}

	public String getc_name() {
		return c_name;
	}

	public void setc_name(String c_name) {
		this.c_name = c_name;
	}

	public Integer getc_chapter_num() {
		return c_chapter_num;
	}

	public void setc_chapter_num(Integer c_chapter_num) {
		this.c_chapter_num = c_chapter_num;
	}

	public Integer getc_s_id() {
		return c_s_id;
	}

	public void setc_s_id(Integer c_s_id) {
		this.c_s_id = c_s_id;
	}

	@Override
	public String toString() {
		return "Course [c_id=" + c_id + ", c_name=" + c_name
				+ ", c_chapter_num=" + c_chapter_num + ", c_s_id=" + c_s_id
				+ "]";
	}

	public Course(String c_name, Integer c_chapter_num, Integer c_s_id) {
		super();
		this.c_name = c_name;
		this.c_chapter_num = c_chapter_num;
		this.c_s_id = c_s_id;
	}

	
	
	
}

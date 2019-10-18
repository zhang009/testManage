package com.test.pojo;

public class CourseData {

	Integer c_id;
	String c_name;
	
	Integer c_chapter_num;
	String c_chapter_headers;
	Integer c_s_id;
	
	
	public CourseData() {
		super();
	}
	public CourseData(String c_name, Integer c_chapter_num,
			String c_chapter_headers, Integer c_s_id) {
		super();
		this.c_name = c_name;
		this.c_chapter_num = c_chapter_num;
		this.c_chapter_headers = c_chapter_headers;
		this.c_s_id = c_s_id;
	}
	@Override
	public String toString() {
		return "CourseData [c_id=" + c_id + ", c_name=" + c_name
				+ ", c_chapter_num=" + c_chapter_num
				+ ", c_chapter_headers=" + c_chapter_headers + ", c_s_id="
				+ c_s_id + "]";
	}
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
	public String getc_chapter_headers() {
		return c_chapter_headers;
	}
	public void setc_chapter_headers(String c_chapter_headers) {
		this.c_chapter_headers = c_chapter_headers;
	}
	public Integer getc_s_id() {
		return c_s_id;
	}
	public void setc_s_id(Integer c_s_id) {
		this.c_s_id = c_s_id;
	}
}

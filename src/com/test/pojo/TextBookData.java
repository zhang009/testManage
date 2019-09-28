package com.test.pojo;

public class TextBookData {

	Integer tb_id;
	String tb_name;
	
	Integer tb_chapter_num;
	String tb_chapter_headers;
	Integer tb_s_id;
	
	
	public TextBookData() {
		super();
	}
	public TextBookData(String tb_name, Integer tb_chapter_num,
			String tb_chapter_headers, Integer tb_s_id) {
		super();
		this.tb_name = tb_name;
		this.tb_chapter_num = tb_chapter_num;
		this.tb_chapter_headers = tb_chapter_headers;
		this.tb_s_id = tb_s_id;
	}
	@Override
	public String toString() {
		return "TextBookData [tb_id=" + tb_id + ", tb_name=" + tb_name
				+ ", tb_chapter_num=" + tb_chapter_num
				+ ", tb_chapter_headers=" + tb_chapter_headers + ", tb_s_id="
				+ tb_s_id + "]";
	}
	public Integer getTb_id() {
		return tb_id;
	}
	public void setTb_id(Integer tb_id) {
		this.tb_id = tb_id;
	}
	public String getTb_name() {
		return tb_name;
	}
	public void setTb_name(String tb_name) {
		this.tb_name = tb_name;
	}
	public Integer getTb_chapter_num() {
		return tb_chapter_num;
	}
	public void setTb_chapter_num(Integer tb_chapter_num) {
		this.tb_chapter_num = tb_chapter_num;
	}
	public String getTb_chapter_headers() {
		return tb_chapter_headers;
	}
	public void setTb_chapter_headers(String tb_chapter_headers) {
		this.tb_chapter_headers = tb_chapter_headers;
	}
	public Integer getTb_s_id() {
		return tb_s_id;
	}
	public void setTb_s_id(Integer tb_s_id) {
		this.tb_s_id = tb_s_id;
	}
}

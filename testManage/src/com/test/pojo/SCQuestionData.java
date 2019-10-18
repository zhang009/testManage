package com.test.pojo;

public class SCQuestionData {

	
	private Integer sc_subject;
	private String sc_point;
	private String sc_stem;
	private String sc_option;
	private String sc_answer;
	private String sc_analysis;
	private Integer sc_c_id;
	private Integer sc_ct_id;
	
	public Integer getSc_subject() {
		return sc_subject;
	}
	public void setSc_subject(Integer sc_subject) {
		this.sc_subject = sc_subject;
	}
	public String getSc_point() {
		return sc_point;
	}
	public void setSc_point(String sc_point) {
		this.sc_point = sc_point;
	}
	public String getSc_stem() {
		return sc_stem;
	}
	public void setSc_stem(String sc_stem) {
		this.sc_stem = sc_stem;
	}
	public String getSc_option() {
		return sc_option;
	}
	public void setSc_option(String sc_option) {
		this.sc_option = sc_option;
	}
	public String getSc_answer() {
		return sc_answer;
	}
	public void setSc_answer(String sc_answer) {
		this.sc_answer = sc_answer;
	}
	public String getSc_analysis() {
		return sc_analysis;
	}
	public void setSc_analysis(String sc_analysis) {
		this.sc_analysis = sc_analysis;
	}
	public Integer getSc_c_id() {
		return sc_c_id;
	}
	public void setSc_c_id(Integer sc_c_id) {
		this.sc_c_id = sc_c_id;
	}
	public Integer getSc_ct_id() {
		return sc_ct_id;
	}
	public void setSc_ct_id(Integer sc_ct_id) {
		this.sc_ct_id = sc_ct_id;
	}
	public SCQuestionData(Integer sc_subject, String sc_point, String sc_stem,
			String sc_option, String sc_answer, String sc_analysis,
			Integer sc_c_id, Integer sc_ct_id) {
		
		this.sc_subject = sc_subject;
		this.sc_point = sc_point;
		this.sc_stem = sc_stem;
		this.sc_option = sc_option;
		this.sc_answer = sc_answer;
		this.sc_analysis = sc_analysis;
		this.sc_c_id = sc_c_id;
		this.sc_ct_id = sc_ct_id;
	}
	public SCQuestionData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SCQuestionData [sc_subject=" + sc_subject + ", sc_point="
				+ sc_point + ", sc_stem=" + sc_stem + ", sc_option="
				+ sc_option + ", sc_answer=" + sc_answer + ", sc_analysis="
				+ sc_analysis + ", sc_c_id=" + sc_c_id + ", sc_ct_id="
				+ sc_ct_id + "]";
	}
	
	
}

package com.test.po;

/**
 * @description 单选题
 * @author zhangyifang
 * @date 2019-6-11
 */
public class SCQuestion {

	private Integer sc_id;//试题id
	private Integer sc_subject;//所属科目id;
	private String sc_point;//涉及到的知识点
	private String sc_stem;//题干
	private String sc_option;//选项
	private String sc_answer;//答案
	private String sc_analysis;//解析
	private String sc_t_name;//出题人
	private Integer sc_c_id;//课程编号
	private Integer sc_ct_id;//章节编号
	
	
	public SCQuestion(Integer sc_subject, String sc_point, String sc_stem,
			String sc_option, String sc_answer, String sc_analysis,
			String sc_t_name, Integer sc_c_id, Integer sc_ct_id) {
		super();
		this.sc_subject = sc_subject;
		this.sc_point = sc_point;
		this.sc_stem = sc_stem;
		this.sc_option = sc_option;
		this.sc_answer = sc_answer;
		this.sc_analysis = sc_analysis;
		this.sc_t_name = sc_t_name;
		this.sc_c_id = sc_c_id;
		this.sc_ct_id = sc_ct_id;
	}

	
	public SCQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "SCQuestion [sc_id=" + sc_id + ", sc_subject=" + sc_subject
				+ ", sc_point=" + sc_point + ", sc_stem=" + sc_stem
				+ ", sc_option=" + sc_option + ", sc_answer=" + sc_answer
				+ ", sc_analysis=" + sc_analysis + ", sc_t_name=" + sc_t_name
				+ ", sc_c_id=" + sc_c_id + ", sc_ct_id=" + sc_ct_id + "]";
	}


	public SCQuestion(Integer sc_id, Integer sc_subject, String sc_point,
			String sc_stem, String sc_option, String sc_answer,
			String sc_analysis, String sc_t_name, Integer sc_c_id,
			Integer sc_ct_id) {
		super();
		this.sc_id = sc_id;
		this.sc_subject = sc_subject;
		this.sc_point = sc_point;
		this.sc_stem = sc_stem;
		this.sc_option = sc_option;
		this.sc_answer = sc_answer;
		this.sc_analysis = sc_analysis;
		this.sc_t_name = sc_t_name;
		this.sc_c_id = sc_c_id;
		this.sc_ct_id = sc_ct_id;
	}


	public Integer getSc_id() {
		return sc_id;
	}


	public void setSc_id(Integer sc_id) {
		this.sc_id = sc_id;
	}


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


	public String getSc_t_name() {
		return sc_t_name;
	}


	public void setSc_t_name(String sc_t_name) {
		this.sc_t_name = sc_t_name;
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


	


	
	
	
}

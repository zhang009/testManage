package com.test.po;

/**
 * @description 判断题
 * @author zhangyifang
 * @date 2019-6-11
 */
public class TFQuestion {

	public TFQuestion(Integer tf_id, Integer tf_subject, String tf_point,
			String tf_stem, String tf_answer, String tf_analysis,
			String tf_t_name, Integer tf_c_id, Integer tf_ct_id) {
		super();
		this.tf_id = tf_id;
		this.tf_subject = tf_subject;
		this.tf_point = tf_point;
		this.tf_stem = tf_stem;
		this.tf_answer = tf_answer;
		this.tf_analysis = tf_analysis;
		this.tf_t_name = tf_t_name;
		this.tf_c_id = tf_c_id;
		this.tf_ct_id = tf_ct_id;
	}
	private Integer tf_id;//试题id
	
	private Integer tf_subject;//所属科目id;
	private String tf_point;//涉及到的知识点
	private String tf_stem;//题干
	private String tf_answer;//答案
	private String tf_analysis;//解析
	private String tf_t_name;//出题人
	private Integer tf_c_id;//课程编号
	private Integer tf_ct_id;//章节编号
	
	
	public TFQuestion(Integer tf_subject, String tf_point, String tf_stem,
			String tf_answer, String tf_analysis, Integer tf_c_id,
			Integer tf_ct_id) {
		super();
		this.tf_subject = tf_subject;
		this.tf_point = tf_point;
		this.tf_stem = tf_stem;
		this.tf_answer = tf_answer;
		this.tf_analysis = tf_analysis;
		this.tf_c_id = tf_c_id;
		this.tf_ct_id = tf_ct_id;
	}
	public Integer getTf_id() {
		return tf_id;
	}
	public void setTf_id(Integer tf_id) {
		this.tf_id = tf_id;
	}
	public Integer getTf_subject() {
		return tf_subject;
	}
	public void setTf_subject(Integer tf_subject) {
		this.tf_subject = tf_subject;
	}
	public String getTf_point() {
		return tf_point;
	}
	public void setTf_point(String tf_point) {
		this.tf_point = tf_point;
	}
	public String getTf_stem() {
		return tf_stem;
	}
	public void setTf_stem(String tf_stem) {
		this.tf_stem = tf_stem;
	}
	public String getTf_answer() {
		return tf_answer;
	}
	public void setTf_answer(String tf_answer) {
		this.tf_answer = tf_answer;
	}
	public String getTf_analysis() {
		return tf_analysis;
	}
	public void setTf_analysis(String tf_analysis) {
		this.tf_analysis = tf_analysis;
	}
	
	public Integer getTf_c_id() {
		return tf_c_id;
	}
	public void setTf_c_id(Integer tf_c_id) {
		this.tf_c_id = tf_c_id;
	}
	public Integer getTf_ct_id() {
		return tf_ct_id;
	}
	public void setTf_ct_id(Integer tf_ct_id) {
		this.tf_ct_id = tf_ct_id;
	}
	@Override
	public String toString() {
		return "TFQuestion [tf_id=" + tf_id + ", tf_subject=" + tf_subject
				+ ", tf_point=" + tf_point + ", tf_stem=" + tf_stem
				+ ", tf_answer=" + tf_answer + ", tf_analysis=" + tf_analysis
				+ ", tf_t_name=" + tf_t_name + ", tf_c_id=" + tf_c_id
				+ ", tf_ct_id=" + tf_ct_id + "]";
	}
	public String getTf_t_name() {
		return tf_t_name;
	}
	public void setTf_t_name(String tf_t_name) {
		this.tf_t_name = tf_t_name;
	}
	
	
	
	

}

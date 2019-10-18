package com.test.dao;


import java.util.List;

import com.test.po.TFQuestion;

public interface TFQuestionDao {

	public int saveTFQuestion(TFQuestion tfQuestion);
	
	
	/**
	 * Description  通过科目id获取所有单选题
	 * @param tf_subject
	 * @return
	 */
	public List<TFQuestion> getTFQuestionsBySub(Integer tf_subject);


	public int deleteById(Integer tf_id);


	public int updateById(Integer tf_id);
}

package com.test.dao;

import java.util.List;

import com.test.po.MCQuestion;

public interface MCQuestionDao {

	public int saveMCQuestion(MCQuestion mcQuestion);
	
	/**
	 * Description  通过科目id获取所有多选题
	 * @param mc_subject
	 * @return
	 */
	public List<MCQuestion> getMCQuestionsBySub(Integer mc_subject);

	/**
	 * Description TODO
	 * @param mc_id
	 * @return
	 */
	public int deleteById(Integer mc_id);

	public int updateById(Integer mc_id);

	public MCQuestion selectById(Integer mc_id);
}

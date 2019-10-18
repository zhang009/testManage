package com.test.dao;

import java.util.List;

import com.test.po.QAQuestion;

public interface QAQuestionDao {

	public int saveQAQuestion(QAQuestion qaQuestion);

	public List<QAQuestion> getQAQuestionsBySub(Integer qa_subject);

	public int deleteById(Integer qa_id);

	public int updateById(Integer qa_id);
}

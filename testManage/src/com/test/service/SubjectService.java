package com.test.service;

import java.util.List;

import com.test.po.SCQuestion;
import com.test.po.Subject;




public interface SubjectService {

	/**
	 * Description 得到所有的科目
	 * @return
	 */
	public List<Subject> getAllSubjects();

	/**
	 * Description 通过选择科目的id获取单选题
	 * @param sid
	 * @return
	 */
	public List<SCQuestion> getSCQuestionsBySub(String sid);
	
}

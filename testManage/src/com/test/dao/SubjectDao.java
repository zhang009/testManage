package com.test.dao;

import java.util.List;

import com.test.po.Subject;

public interface SubjectDao {
	
	/**
	 * Description 获取数据库中所有的科目
	 * @return
	 */
	public List<Subject> getAllSubjects();

	
	
}

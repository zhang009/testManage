package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.SCQuestionDao;
import com.test.dao.SubjectDao;
import com.test.po.SCQuestion;
import com.test.po.Subject;
import com.test.service.SubjectService;


@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	SubjectDao subjectDao;
	
	@Autowired
	SCQuestionDao scQuestionDao;
	@Override
	public List<Subject> getAllSubjects() {
		
		List<Subject> list=subjectDao.getAllSubjects();
		System.out.println("subjectservice:"+list.toString());
		return list;
	}
	
	@Override
	public List<SCQuestion> getSCQuestionsBySub(String sid) {
		
		Integer sc_id=Integer.valueOf(sid);//½«id×ª»»ÎªInteger	
		
		return scQuestionDao.getSCQuestionsBySub(sc_id);
	}

	
}

package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.ChapterTitleDao;
import com.test.po.ChapterTitle;
import com.test.service.ChapterService;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

	
	
	@Autowired 
	ChapterTitleDao chapterTitleDao;
	
	@Override
	public List<ChapterTitle> getChapterByTBid(String id) {
		
		Integer c_id=Integer.valueOf(id);
		System.out.println("c_id:"+c_id);
		List<ChapterTitle> list=chapterTitleDao.getChaptersByTBid(c_id);
		
		return list;
	}

}

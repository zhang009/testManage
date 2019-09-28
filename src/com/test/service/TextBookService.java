package com.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.po.TextBook;
import com.test.pojo.TextBookData;

@Service
public interface TextBookService {
	
	/**
	 * 根据Subject科目的id查询所有的教科书
	 */
	public List<TextBook> getTextBooksBySid(String s_id);
	
	/**
	 * 根据TextBookData添加TextBook数据
	 */
	public boolean addTextBookByBookData(TextBookData textBookData);
}

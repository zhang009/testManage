package com.test.dao;

import java.util.List;

import com.test.po.TextBook;


/**
 * @description ¿Î±¾dao
 * @author zhangyifang
 * @date 2019-6-21
 */
public interface TextBookDao {

	List<TextBook> getTextBooksBySid(Integer s_id);

	boolean addTextBook(TextBook textBook);
	
	TextBook getTextBookByName(String tb_name);
}

package com.test.dao;

import java.util.List;

import com.test.po.TextBook;


/**
 * @description ¿Î±¾dao
 * @author zhangyifang
 * @date 2019-10-11
 */
public interface TextBookDao {

	List<TextBook> getTextBooksBySid(Integer s_id);

	boolean addTextBook(TextBook textBook);
	
	TextBook getTextBookByName(String tb_name);
}

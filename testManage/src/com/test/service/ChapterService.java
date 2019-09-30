package com.test.service;

import java.util.List;

import com.test.po.ChapterTitle;



public interface ChapterService {


	/**
	 * 根据科目的id获取该科目下的所有课本列表
	 */
	public List<ChapterTitle> getChapterByTBid(String tb_id);
}

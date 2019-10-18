package com.test.dao;

import java.util.List;

import com.test.po.ChapterTitle;

public interface ChapterTitleDao {

	boolean addChapterTitle(ChapterTitle chapterTitle);

	List<ChapterTitle> getChaptersByTBid(Integer c_id);
}

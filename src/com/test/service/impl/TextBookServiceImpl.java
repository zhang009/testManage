package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.test.dao.ChapterTitleDao;
import com.test.dao.TextBookDao;
import com.test.po.ChapterTitle;
import com.test.po.TextBook;
import com.test.pojo.TextBookData;
import com.test.service.TextBookService;
@Service
@Transactional
public class TextBookServiceImpl implements TextBookService{

	@Autowired
	TextBookDao textBookDao;
	
	@Autowired 
	ChapterTitleDao chapterTitleDao;
	@Override
	public List<TextBook> getTextBooksBySid(String sid) {

		Integer s_id=Integer.valueOf(sid);
		System.out.println("s_id:"+s_id);
		List<TextBook> list=textBookDao.getTextBooksBySid(s_id);
		return list;
	}

	/**
	 * 把TextBookData数据转化到TextBook表和Chapter_title表中
	 */
	@Override
	public boolean addTextBookByBookData(TextBookData textBookData) {
		
		
		String tb_name=textBookData.getTb_name();
		Integer tb_chapter_num=textBookData.getTb_chapter_num();
		Integer tb_s_id=textBookData.getTb_s_id();
		
		String chapter[]=textBookData.getTb_chapter_headers().split("@@");
		
		
		TextBook textBook=new TextBook(tb_name,tb_chapter_num,tb_s_id);
		//添加TextBook
		System.out.println(textBook.toString());
		boolean result=textBookDao.addTextBook(textBook);
		if(result==true){//如果课本添加成功
			
			TextBook teBook0=textBookDao.getTextBookByName(tb_name);
			Integer ct_tb_id=Integer.valueOf(teBook0.getTb_id());//获得添加成功的教科书编号
			System.out.println("tb_chapter_num:"+tb_chapter_num);
			System.out.println("chapter.length:"+chapter.length);
			if(tb_chapter_num==chapter.length){//如果分割的章节标题与章节数目对应，添加章节到数据库
				for(int i=0;i<tb_chapter_num;i++){
					/*tb_ct_id+=i+"@@";*/
					 ChapterTitle chapterTitle=new ChapterTitle(chapter[i], ct_tb_id,Integer.valueOf(i+1));
					 chapterTitleDao.addChapterTitle(chapterTitle);
				}
			}
			
			
			
		}
		
		
		return result;
	}

}

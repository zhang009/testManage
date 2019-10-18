package com.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.po.Course;
import com.test.pojo.CourseData;

@Service
public interface CourseService {
	
	/**
	 * 根据Subject科目的id查询所有的课程
	 */
	public List<Course> getCoursesBySid(String s_id);
	
	/**
	 * 根据CourseData添加Course数据
	 */
	public boolean addCourseByBookData(CourseData CourseData);
}

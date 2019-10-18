package com.test.dao;

import com.test.po.Teacher;


public interface TeacherDao {

	//注册
	public int addTeacher(Teacher teacher);
	//取数据(登录校验)
	public Teacher getTeacherByNameOrEmail(Teacher teacher);
	//修改用户信息
	public int updatePwd(Teacher teacher);
	//删除用户
//	public int deleteTeacher(int t_id,String t_name);
	//检查用户名或邮箱是否已经存在
	public Integer checkUNameOrEmail(Teacher teacher);
}

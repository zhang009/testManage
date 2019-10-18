package com.test.service;

import com.test.po.Teacher;

public interface TeacherService {
	//注册
	public int addTeacher(String t_name,String t_pass,String t_email);
	//登录校验
	public int loginExamine(String t_name,String t_pass,String t_email);
	//修改密码
	public int updatePwd(String t_name,String t_pass,String t_email);
	//注册校验用户名和邮箱
	public int checkUNameOrEmail(Teacher teacher);
}

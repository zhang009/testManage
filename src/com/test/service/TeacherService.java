package com.test.service;


public interface TeacherService {
	//×¢²á
	public int addTeacher(String t_name,String t_pass,String t_email);
	//µÇÂ¼Ğ£Ñé
	public int loginExamine(String t_name,String t_pass,String t_email);
	//ĞŞ¸ÄÃÜÂë
	public int updatePwd(String t_name,String t_pass,String t_email);
}

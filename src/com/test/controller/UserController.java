package com.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.service.TeacherService;

@Controller
public class UserController {
	// ²âÊÔºÏ²¢
	@Autowired
	private TeacherService teacherService;//²âÊÔpush
	
	//ÓÃ»§×¢²á
	@RequestMapping(value = "/addTeacher.action",method = RequestMethod.GET)
	@ResponseBody
	public void addUser(HttpServletRequest request,Model model){
		String t_name=request.getParameter("t_name");
		String t_pass=request.getParameter("t_pass");
		String t_email=request.getParameter("t_email");
		int status_code = teacherService.addTeacher(t_name, t_pass, t_email);
//		model.addAttribute("status_code", status_code);//·µ»Ø×´Ì¬Âë
	}
	//µÇÂ¼Ð£Ñé
	@RequestMapping(value = "/loginExamine.action",method = RequestMethod.GET)
	@ResponseBody
	public void loginExamine(HttpServletRequest request,Model model){
		String t_name=request.getParameter("t_name");
		String t_pass=request.getParameter("t_pass");
		String t_email=request.getParameter("t_email");
		int status_code = teacherService.loginExamine(t_name, t_pass, t_email);
		model.addAttribute("status_code", status_code);//·µ»Ø×´Ì¬Âë
		System.out.println("--loginExamine--"+status_code);
	}
	//ÐÞ¸ÄÃÜÂë
	@RequestMapping(value = "/updatePwd.action",method = RequestMethod.GET)
	@ResponseBody
	public void updatePwd(HttpServletRequest request,Model model){
		String t_name=request.getParameter("t_name");
		String t_pass=request.getParameter("t_pass");
		String t_email=request.getParameter("t_email");
		int status_code=teacherService.updatePwd(t_name, t_pass, t_email);
		model.addAttribute("status_code", status_code);//·µ»Ø×´Ì¬Âë
//		System.out.println("--updatePwd--"+status_code);
	}
}

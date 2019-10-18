package com.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.po.Teacher;
import com.test.service.TeacherService;
// Another
// Polaris
@Controller
public class UserController {
	@Autowired
	private TeacherService teacherService;//测试push
	
	//用户注册
	@RequestMapping(value = "/addTeacher.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> addUser(@RequestBody Teacher teacher){
		Map<String, String> map=new HashMap<String, String>();
		int result = teacherService.addTeacher(teacher.getT_name(), teacher.getT_pass(), teacher.getT_email());
		
		map.put("result",String.valueOf(result));
		return map;
		
	}
	//注册校验
	@RequestMapping(value = "/registerCheck.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> registerCheck(@RequestBody Teacher teacher){
		
		Map<String, String> map=new HashMap<String, String>();
		int result = teacherService.checkUNameOrEmail(teacher);
			
		map.put("result",String.valueOf(result));
		
		return map;
		
	}
	//登录校验
	@RequestMapping(value = "/loginExamine.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> loginExamine(@RequestBody Teacher teacher,HttpSession session,Model model){
		Map<String, String> map=new HashMap<String, String>();
		
		String t_name=teacher.getT_name();
		String t_email=teacher.getT_email();
		String t_pass=teacher.getT_pass();
	
		int status_code = teacherService.loginExamine(t_name, t_pass, t_email);
		System.out.println("--loginExamine--"+status_code);
		//model.addAttribute("status_code",status_code);
		if(status_code==1)//登录信息校验成功
		{
			session.setAttribute("TEACHER_SESSION", teacher);
		}
		map.put("status_code",String.valueOf(status_code));
		return map;
		
	}
	//修改密码
	@RequestMapping(value = "/updatePwd.action",method = RequestMethod.GET)
	@ResponseBody
	public void updatePwd(HttpServletRequest request,Model model){
		String t_name=request.getParameter("t_name");
		String t_pass=request.getParameter("t_pass");
		String t_email=request.getParameter("t_email");
		int status_code=teacherService.updatePwd(t_name, t_pass, t_email);
		model.addAttribute("status_code", status_code);//返回状态码
//		System.out.println("--updatePwd--"+status_code);
	}
}
